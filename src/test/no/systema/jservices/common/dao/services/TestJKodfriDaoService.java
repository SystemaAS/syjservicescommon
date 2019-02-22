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

import no.systema.jservices.common.dao.FriskkDao;
import no.systema.jservices.common.dao.KodfriDao;

public class TestJKodfriDaoService {

	ApplicationContext context = null;
	KodfriDaoService kodfriDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodfriDaoService = (KodfriDaoService) context.getBean("kodfriDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodfriDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfsoko", "CON");  
		
		int count  =  kodfriDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfsoko", "FRI");
		List<KodfriDao> list =  kodfriDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		KodfriDao qDao = new KodfriDao();
		qDao.setKfsoko("MOD");
		
		boolean exist =  kodfriDaoService.exist(qDao);
		assertTrue(qDao.getKfsoko() +" should exist",exist);
		
	}

	@Test
	public final void testFindByLike() {
		List<KodfriDao> list =  kodfriDaoService.findByLike("MO");
		assertNotNull(list);
	}	
	
	
}
