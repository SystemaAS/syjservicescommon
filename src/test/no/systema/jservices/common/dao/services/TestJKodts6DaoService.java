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
import no.systema.jservices.common.dao.Kodts6Dao;

public class TestJKodts6DaoService {

	ApplicationContext context = null;
	Kodts6DaoService kodts6DaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodts6DaoService = (Kodts6DaoService) context.getBean("kodts6DaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodts6DaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks6uni", "S6");
		params.put("ks6pre", "A");
		
		int count  =  kodts6DaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks6uni", "S6");
		params.put("ks6pre", "A");
		List<Kodts6Dao> list =  kodts6DaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		boolean exist =  kodts6DaoService.preKodeExist("A");
		assertTrue("A should exist",exist);
		
		exist =  kodts6DaoService.preKodeExist("X");
		assertTrue("X should not exist",!exist);
		
	}
	
	@Test
	public final void testGetS6Koder() {
		List<Kodts6Dao> list = kodts6DaoService.getS6Koder();
		assertNotNull(list);
		
		
		
	}
	
}
