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

import no.systema.jservices.common.dao.Cum3lmDao;

public class TestJCum3lmDaoService {

	ApplicationContext context = null;
	Cum3lmDaoService cum3lmDaoService = null;
	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			cum3lmDaoService = (Cum3lmDaoService) context.getBean("cum3lmDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  cum3lmDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("m3firm", "SY");
		int count  =  cum3lmDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("m3firm", "SY");
		List<Cum3lmDao> list =  cum3lmDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAll() {
		List<Cum3lmDao> list =  cum3lmDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFind() {
		Cum3lmDao qDao = new Cum3lmDao();
		qDao.setM3firm("SY");
		qDao.setM3kund(1);
		Cum3lmDao resultDao=  cum3lmDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	@Test
	public final void testExist() {
		Cum3lmDao qDao = new Cum3lmDao();
		qDao.setM3firm("SY");
		qDao.setM3kund(1);
		boolean exist =  cum3lmDaoService.exist(qDao);
		assertTrue("1 should exist",exist);
		
		qDao.setM3kund(0);
		exist =  cum3lmDaoService.exist(qDao);
		assertTrue("0 should not exist",!exist);
		
	}		
	
}
