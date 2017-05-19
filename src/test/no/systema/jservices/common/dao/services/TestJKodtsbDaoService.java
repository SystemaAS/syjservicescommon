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

import no.systema.jservices.common.dao.KodtsbDao;

public class TestJKodtsbDaoService {

	ApplicationContext context = null;
	KodtsbDaoService kodtsbDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtsbDaoService = (KodtsbDaoService) context.getBean("kodtsbDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtsbDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ksbkd", "BE");
		
		int count  =  kodtsbDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ksbkd", "B3");
		List<KodtsbDao> list =  kodtsbDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		KodtsbDao qDao = new KodtsbDao();
		qDao.setKsbkd("B3");
		
		boolean exist =  kodtsbDaoService.exist(qDao);
		assertTrue(qDao.getKsbkd() +" should exist",exist);
		
		qDao.setKsbkd("xx");
		exist =  kodtsbDaoService.exist(qDao);
		assertTrue(qDao.getKsbkd() +" should not exist",!exist);
		
	}
	
}
