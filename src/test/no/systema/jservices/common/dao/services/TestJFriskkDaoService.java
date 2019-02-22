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
import no.systema.jservices.common.dao.Kodts2Dao;

public class TestJFriskkDaoService {

	ApplicationContext context = null;
	FriskkDaoService friskkDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			friskkDaoService = (FriskkDaoService) context.getBean("friskkDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  friskkDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fskode", "CON");  
		
		int count  =  friskkDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fskode", "FRI");
		List<FriskkDao> list =  friskkDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		FriskkDao qDao = new FriskkDao();
		qDao.setFsbnr(600);
		qDao.setFskode("FAV");
		qDao.setFssok("TEST");
		
		boolean exist =  friskkDaoService.exist(qDao);
		assertTrue(qDao.getFsbnr() +" should exist",exist);
		
		qDao.setFsbnr(0);
		exist =  friskkDaoService.exist(qDao);
		assertTrue(qDao.getFsbnr() +" should not exist",!exist);
		
	}

	@Test
	public final void testFindByLike() {
		List<FriskkDao> list =  friskkDaoService.findByLike("MO");
		assertNotNull(list);
	}	
	
	
}
