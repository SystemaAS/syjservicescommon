package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.HeadfDao;

public class TestJDokufDaoService {

	ApplicationContext context = null;
	DokufDaoService dokufDaoService = null;
	TellDaoService tellDaoService = null;
	DokufDao qDao = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		dokufDaoService = (DokufDaoService) context.getBean("dokufDaoService");
		qDao = new DokufDao();
	}

	@Test
	public final void testCountAll() {
		int count = dokufDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dfavd", 1);
		int count = dokufDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dfavd", 1);
		List<DokufDao> list = dokufDaoService.findAll(params);
		assertNotNull(list);
	}
	
	@Test
	public final void testFindAllWithParams2() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dfavd", 1);
		params.put("dfsg", "JOV");
		List<DokufDao> list = dokufDaoService.findAll(params);
		assertNotNull(list);
	}	
	

	@Test
	public final void testFind() {
		qDao.setDfavd(1);
		qDao.setDfopd(52534);
		qDao.setDffbnr(1);
		DokufDao resultDao = dokufDaoService.find(qDao);
		assertNotNull(resultDao);
	}

	@Test
	public final void testExist() {
		qDao.setDfavd(1);
		qDao.setDfopd(52534);
		qDao.setDffbnr(1);
		boolean exist = dokufDaoService.exist(qDao);
		assertTrue(qDao.getDfavd() + ", " + qDao.getDfopd() + ", " +  qDao.getDffbnr() +" should exist", exist);

		qDao.setDfopd(0);
		exist = dokufDaoService.exist(qDao);
		assertTrue(qDao.getDfavd() + ", " + qDao.getDfopd() + ", " +  qDao.getDffbnr() +" should not exist", !exist);

	}

	@Test
	public final void testCreateAndDelete() {
		DokufDao dao = getBigDokufDao();
		DokufDao returnDao = dokufDaoService.create(dao);
		assertNotNull(returnDao);

		dokufDaoService.delete(dao);
		boolean exist = dokufDaoService.exist(dao);
		assertTrue(dao.getDfavd() + ", " + dao.getDfopd() + ", " +  dao.getDffbnr() +" should not exist", !exist);

	}	

	
	private DokufDao getBigDokufDao() {
		DokufDao dao = new DokufDao();
		dao.setDfavd(1); // key
		dao.setDfopd(999);// key
		dao.setDffbnr(1); //key
		dao.setDfnt(1);
		dao.setDfpro2("Prod tekst");
		dao.setDfm3(new BigDecimal(14.1));
		
		return dao;
	}	
	
}
