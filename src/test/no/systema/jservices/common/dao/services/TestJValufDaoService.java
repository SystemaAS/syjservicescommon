package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ValufDao;

public class TestJValufDaoService {

	ApplicationContext context = null;
	ValufDaoService valufDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("applicationContextTest.xml");
			valufDaoService = (ValufDaoService) context.getBean("valufDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  valufDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firma", "SY");
		int count  =  valufDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firma", "SY");
		List<ValufDao> list =  valufDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
}
