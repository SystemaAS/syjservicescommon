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

import no.systema.jservices.common.dao.Kodts5Dao;

public class TestJKodts5DaoService {

	ApplicationContext context = null;
	Kodts5DaoService kodts5DaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodts5DaoService = (Kodts5DaoService) context.getBean("kodts5DaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodts5DaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks5uni", "S5");
		params.put("ks5tln", "E");
		
		int count  =  kodts5DaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks5uni", "S5");
		params.put("ks5tln", "E");
		List<Kodts5Dao> list =  kodts5DaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		Kodts5Dao qDao = new Kodts5Dao();
		qDao.setKs5uni("S5");
		qDao.setKs5tln("E");
		
		boolean exist =  kodts5DaoService.exist(qDao);
		assertTrue(qDao.getKs5tln() +" should exist",exist);
		
		qDao.setKs5tln("xx");
		exist =  kodts5DaoService.exist(qDao);
		assertTrue(qDao.getKs5tln() +" should not exist",!exist);
		
	}
	
	@Test
	public final void testGetS2Koder() {
		List<Kodts5Dao> list = kodts5DaoService.getS5Koder();
		assertNotNull(list);
		
		
		
	}
	
}
