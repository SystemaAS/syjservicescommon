package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		headfDaoService = (HeadfDaoService) context.getBean("headfDaoService");
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
	public final void testFindAll() {
		List<HeadfDao> list = headfDaoService.findAll(null);
		assertNotNull(list);
	}

	@Test
	public final void testFind() {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(1);
		qDao.setHeopd(773587);
		HeadfDao resultDao = headfDaoService.find(qDao);
		assertNotNull(resultDao);
	}

	@Test
	public final void testGetListAvdDato() {
		HeadfDto qDao = new HeadfDto();
		qDao.setHeavd(2);
		qDao.setHedtop(20000210);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 7, resultDaoList.size());
	}

	@Test
	public final void testGetListAvd() {
		HeadfDto qDao = new HeadfDto();
		qDao.setHeavd(2);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 4635, resultDaoList.size());
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

}
