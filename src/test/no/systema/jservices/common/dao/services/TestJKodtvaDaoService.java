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

import no.systema.jservices.common.dao.KodtvaDao;
import no.systema.jservices.common.dao.KodtvalfDao;

public class TestJKodtvaDaoService {

	ApplicationContext context = null;
	KodtvaDaoService kodtvaDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtvaDaoService = (KodtvaDaoService) context.getBean("kodtvaDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtvaDaoService.countAll();
		assertNotNull(count);
	}	
	
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kvauni", "VA");
		params.put("kvakod", "AED");
		
		List<KodtvaDao> list =  kodtvaDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testFindAll() {
		List<KodtvaDao> list = kodtvaDaoService.findAll(null);
		assertNotNull(list);
		
	}
	
}
