package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtsaDao;

public class TestJKodtsaDaoService {

	ApplicationContext context = null;
	KodtsaDaoService kodtsaDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtsaDaoService = (KodtsaDaoService) context.getBean("kodtsaDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtsaDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ksakd", "BE");
		
		int count  =  kodtsaDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ksakd", "BE");
		List<KodtsaDao> list =  kodtsaDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		KodtsaDao qDao = new KodtsaDao();
		qDao.setKsakd("BE");
		
		boolean exist =  kodtsaDaoService.exist(qDao);
		assertTrue(qDao.getKsakd() +" should exist",exist);
		
		qDao.setKsakd("xx");
		exist =  kodtsaDaoService.exist(qDao);
		assertTrue(qDao.getKsakd() +" should not exist",!exist);
		
	}
	
}
