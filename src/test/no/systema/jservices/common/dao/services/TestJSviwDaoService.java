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

import no.systema.jservices.common.dao.SviwDao;

public class TestJSviwDaoService {

	ApplicationContext context = null;
	SviwDaoService sviwDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		sviwDaoService = (SviwDaoService) context.getBean("sviwDaoService");
	}

	@Test
	public final void testCountAll() {
		int count = sviwDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sviw_knnr", 1);
		params.put("sviw_knso", "Elfenben");		
		int count = sviwDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sviw_knnr", 1);
		params.put("sviw_knso", "Elfenben");		
		List<SviwDao> list = sviwDaoService.findAll(params);
		assertNotNull(list);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SviwDao> list = sviwDaoService.findAll(params);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		SviwDao qDao = new SviwDao();
		qDao.setSviw_knnr(1);
		qDao.setSviw_knso("Elfenben");
		SviwDao resultDao = sviwDaoService.find(qDao);
		assertNotNull(resultDao);
		assertEquals("nr should be the same.",1, resultDao.getSviw_knnr());
		
		
		SviwDao resultDao2 = sviwDaoService.find(1, "Elfenben");
		assertNotNull(resultDao2);
		assertEquals("nr should be the same.",resultDao2.getSviw_knnr(), resultDao.getSviw_knnr());
		
		
	}		
	
	@Test
	public final void testExist() {
		SviwDao qDao = new SviwDao();
		qDao.setSviw_knnr(1);
		qDao.setSviw_knso("Elfenben");

		boolean exist = sviwDaoService.exist(qDao);
		assertTrue(qDao.getSviw_knnr() + "," + qDao.getSviw_knso()+" should exist", exist);

		qDao.setSviw_knnr(0);
		exist = sviwDaoService.exist(qDao);
		assertTrue(qDao.getSviw_knnr() + "," + qDao.getSviw_knso()+"should not exist", !exist);

	}
	
}
