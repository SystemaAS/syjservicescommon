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

import no.systema.jservices.common.dao.Kodts2Dao;
import no.systema.jservices.common.dao.Kodts7Dao;

public class TestJKodts2DaoService {

	ApplicationContext context = null;
	Kodts2DaoService kodts2DaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodts2DaoService = (Kodts2DaoService) context.getBean("kodts2DaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodts2DaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks2uni", "S2");
		params.put("ks2lk", "AF");
		
		int count  =  kodts2DaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks2uni", "S2");
		params.put("ks2lk", "AF");
		List<Kodts2Dao> list =  kodts2DaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		Kodts2Dao qDao = new Kodts2Dao();
		qDao.setKs2uni("S2");
		qDao.setKs2lk("AF");
		
		boolean exist =  kodts2DaoService.exist(qDao);
		assertTrue(qDao.getKs2lk() +" should exist",exist);
		
		qDao.setKs2lk("xx");
		exist =  kodts2DaoService.exist(qDao);
		assertTrue(qDao.getKs2lk() +" should not exist",!exist);
		
	}
	
	@Test
	public final void testGetS2Koder() {
		List<Kodts2Dao> list = kodts2DaoService.getS2Koder();
		assertNotNull(list);
		
		
		
	}
	
}
