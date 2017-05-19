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

import no.systema.jservices.common.dao.Kodts7Dao;
import no.systema.jservices.common.dao.SadvareDao;

public class TestJKodts7DaoService {

	ApplicationContext context = null;
	Kodts7DaoService kodts7DaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodts7DaoService = (Kodts7DaoService) context.getBean("kodts7DaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodts7DaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks7uni", "S7");
		params.put("ks7vf", 1);
		
		int count  =  kodts7DaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks7uni", "S7");
		params.put("ks7vf", 1);
		List<Kodts7Dao> list =  kodts7DaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		Kodts7Dao qDao = new Kodts7Dao();
		qDao.setKs7uni("S7");
		qDao.setKs7vf(1);
		
		boolean exist =  kodts7DaoService.exist(qDao);
		assertTrue(qDao.getKs7vf() +" should exist",exist);
		
		qDao.setKs7vf(9);
		exist =  kodts7DaoService.exist(qDao);
		assertTrue(qDao.getKs7vf() +" should not exist",!exist);
		
	}
	
	@Test
	public final void testGetS7Koder() {
		List<Kodts7Dao> list = kodts7DaoService.getS7Koder();
		assertNotNull(list);
		
		
		
	}
	
}
