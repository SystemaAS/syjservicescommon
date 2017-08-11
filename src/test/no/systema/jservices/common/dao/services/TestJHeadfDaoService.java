package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public class TestJHeadfDaoService {

	ApplicationContext context = null;
	HeadfDaoService headfDaoService = null;
	HeadfDto qDao = null;
	int VERY_MANY_DAYS = 20*365;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		headfDaoService = (HeadfDaoService) context.getBean("headfDaoService");
		 qDao = new HeadfDto();
		 qDao.setDftdg(VERY_MANY_DAYS);
	}

	@Test
	public final void testCountAll() {
		int count = headfDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("heavd", 1);
		int count = headfDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("heavd", 1);
		List<HeadfDao> list = headfDaoService.findAll(params);
		assertNotNull(list);
	}

	@Test
	public final void testGetListAvdDato() {
		qDao.setHeavd(2);
		qDao.setHedtop(20000210);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 7, resultDaoList.size());
	}

	@Test
	public final void testGetListAvd() {
		qDao.setHeavd(2);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many", resultDaoList.size() > 1000);
	}
	
	@Test
	public final void testGetListAvsenderMottaker() {
		qDao.setHenas("%DATA%");
		qDao.setHenak("THAR%");
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 1, resultDaoList.size());
	}	
	
	@Test
	public final void testGetListSign() {
		qDao.setHeavd(1);
		qDao.setHenas("%DATA%");
		qDao.setHesg("%JOV%");
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 2, resultDaoList.size());
	}	
	
	
	@Test
	public final void testDftdg() {
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many", resultDaoList.size() > 1000);
		
		qDao.setDftdg(10);
		resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 3, resultDaoList.size());		
		
	}
	
	@Test
	public final void testExist() {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(1);
		qDao.setHeopd(773587);
		boolean exist = headfDaoService.exist(qDao);
		assertTrue(qDao.getHeavd() + ":" + qDao.getHeopd() + " should exist", exist);

		qDao.setHeavd(0);
		qDao.setHeopd(1);
		exist = headfDaoService.exist(qDao);
		assertTrue(qDao.getHeavd() + ":" + qDao.getHeopd() + " should not exist", !exist);

	}

	@Test
	public final void testCreateAndDelete() {
		HeadfDao dao = getBigHeadfDao();
		HeadfDao returnDao = headfDaoService.create(dao);
		assertNotNull(returnDao);

		headfDaoService.delete(dao);
		boolean exist = headfDaoService.exist(dao);
		assertTrue(dao.getHeavd() + ", " + dao.getHeopd() + " should not exist", !exist);

	}	

	
	@Test
	public final void testCreateUpdateAndDelete() {
		String updHenas = "Updated namn";
		HeadfDao dao = getBigHeadfDao();
		HeadfDao returnDao = headfDaoService.create(dao);
		HeadfDao updateDao = null;
		assertNotNull(returnDao);

		returnDao.setHenas(updHenas);
		updateDao = headfDaoService.update(returnDao);
		assertTrue("Name should be update", returnDao.getHenas().equals(updHenas));
		
		headfDaoService.delete(updateDao);
		boolean exist = headfDaoService.exist(updateDao);
		assertTrue(updateDao.getHeavd() + ", " + updateDao.getHeopd() + " should not exist", !exist);

	}		
	
	
	private HeadfDao getBigHeadfDao() {
		HeadfDao dao = new HeadfDao();
		dao.setHeavd(1); // key
		dao.setHeopd(999);// key
		dao.setHesg("JOV");
		dao.setHeank(1);
		dao.setHehbre(new BigDecimal(14.1));
		
		return dao;
	}	
	
}
