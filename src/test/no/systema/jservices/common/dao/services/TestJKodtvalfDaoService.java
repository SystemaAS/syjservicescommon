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

import no.systema.jservices.common.dao.Kodts6Dao;
import no.systema.jservices.common.dao.KodtvalfDao;

public class TestJKodtvalfDaoService {

	ApplicationContext context = null;
	KodtvalfDaoService kodtvalfDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtvalfDaoService = (KodtvalfDaoService) context.getBean("kodtvalfDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtvalfDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kvauni", "VA");
		params.put("kvakod", "AED");
		
		int count  =  kodtvalfDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kvauni", "VA");
		params.put("kvakod", "AED");
		
		List<KodtvalfDao> list =  kodtvalfDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		boolean exist =  kodtvalfDaoService.kvaKodeExist("AED");
		assertTrue("AED should exist",exist);
		
		exist =  kodtvalfDaoService.kvaKodeExist("X");
		assertTrue("X should not exist",!exist);
		
	}
	
	@Test
	public final void testGetVAKoder() {
		List<KodtvalfDao> list = kodtvalfDaoService.getVAKoder();
		assertNotNull(list);
		
		
		
	}
	
}
