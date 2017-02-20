package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtlkDao;
import no.systema.jservices.common.dao.KodtotyDao;

public class TestJKodtotyDaoService {

	ApplicationContext context = null;
	KodtotyDaoService kodtotyDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtotyDaoService = (KodtotyDaoService) context.getBean("kodtotyDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtotyDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		
//		KO1UNI='OTY' och KO1KOD=Oppdragstype  "EX"
		
		
		params.put("ko1uni", "OTY");
		params.put("ko1kod", "EX");
		int count  =  kodtotyDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ko1uni", "OTY");
		params.put("ko1kod", "EX");
		List<KodtotyDao> list =  kodtotyDaoService.findAll(params);
		assertNotNull(list);
		assertEquals(1, list.size());
	}	
	
	@Test
	public final void testExist() {
		KodtotyDao qDao = new KodtotyDao();
		qDao.setKo1uni("OTY");
		qDao.setKo1kod("EX");
		boolean exist =  kodtotyDaoService.exist(qDao);
		assertTrue("NO should exist",exist);
		
		qDao.setKo1kod("KALLE");
		exist =  kodtotyDaoService.exist(qDao);
		assertTrue("KALLE should not exist",!exist);
		
	}		

	@Test
	public final void testGetOppdragstyper() {
		List<KodtotyDao> list =  kodtotyDaoService.getOppdragstyper();
		assertNotNull(list);
	}	


	
	@Test
	public final void testOppdragsTypeExist() {
		boolean exist =  kodtotyDaoService.oppdragsTypeExist("EX");
		assertTrue("EX should exist",exist);
		
		exist =   kodtotyDaoService.oppdragsTypeExist("KALLE");
		assertTrue("KALLE should not exist",!exist);
		
	}	
	
	
}
