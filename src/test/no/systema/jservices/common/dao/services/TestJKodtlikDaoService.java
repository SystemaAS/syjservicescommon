package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtlikDao;

public class TestJKodtlikDaoService {

	ApplicationContext context = null;
	KodtlikDaoService kodtlikDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtlikDaoService = (KodtlikDaoService) context.getBean("kodtlikDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtlikDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		int count  =  kodtlikDaoService.countAll(null);  //where-clause hardwired in Dao
		assertNotNull(count);
	}		
	
	
	@Test
	public final void testExist() {
		KodtlikDao qDao = new KodtlikDao();
		qDao.setKlikod("F");
		boolean exist =  kodtlikDaoService.exist(qDao);
		assertTrue("F should exist",exist);
		
		qDao.setKlikod("KALLE");
		exist =  kodtlikDaoService.exist(qDao);
		assertTrue("KALLE should not exist",!exist);
		
	}		

	
}
