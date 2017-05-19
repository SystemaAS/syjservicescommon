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

import no.systema.jservices.common.dao.Kodts7Dao;
import no.systema.jservices.common.dao.Kodts8Dao;

public class TestJKodts8DaoService {

	ApplicationContext context = null;
	Kodts8DaoService kodts8DaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodts8DaoService = (Kodts8DaoService) context.getBean("kodts8DaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodts8DaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks8avg", "BE");
		params.put("ks8skv", "210");
		
		int count  =  kodts8DaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks8avg", "BE");
		params.put("ks8skv", "210");
		
		List<Kodts8Dao> list =  kodts8DaoService.findAll(params);
		assertTrue("Should contain one tuple", list.size() == 1);
	}		
	
	
	@Test
	public final void testExist() {
		Kodts8Dao qDao = new Kodts8Dao();
		qDao.setKs8avg("BE");
		qDao.setKs8skv("210");
		
		boolean exist =  kodts8DaoService.exist(qDao);
		assertTrue(qDao.getKs8avg()+":"+qDao.getKs8skv() +" should exist",exist);
		
		qDao.setKs8skv("999");
		exist =  kodts8DaoService.exist(qDao);
		assertTrue(qDao.getKs8avg()+":"+qDao.getKs8skv() +" should not exist",!exist);
		
	}
	
	
	@Test
	public final void testGetKoder() {
		List<Kodts8Dao> koder = kodts8DaoService.getKoder();
		assertNotNull(koder);
		
	}
	
}
