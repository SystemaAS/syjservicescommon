package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtlkDao;
import no.systema.jservices.common.dao.ValufDao;

public class TestJKodtlkDaoService {

	ApplicationContext context = null;
	KodtlkDaoService kodtlkDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtlkDaoService = (KodtlkDaoService) context.getBean("kodtlkDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  kodtlkDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("klkuni", "LK");
		params.put("klklk", "NO");
		int count  =  kodtlkDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("klkuni", "LK");
		params.put("klklk", "NO");
		List<KodtlkDao> list =  kodtlkDaoService.findAll(params);
		assertNotNull(list);
		assertEquals(1, list.size());
	}	
	
	@Test
	public final void testExist() {
		KodtlkDao qDao = new KodtlkDao();
		qDao.setKlklk("NO");
		qDao.setKlkuni("LK");
		boolean exist =  kodtlkDaoService.exist(qDao);
		assertTrue("NO should exist",exist);
		
		qDao.setKlkuni("KALLE");
		exist =  kodtlkDaoService.exist(qDao);
		assertTrue("KALLE should not exist",!exist);
		
	}		

	@Test
	public final void testGetLandKoder() {
		List<KodtlkDao> list =  kodtlkDaoService.getLandKoder();
		assertNotNull(list);
	}	
	
	@Test
	public final void testLandKodeExist() {
		boolean exist =  kodtlkDaoService.landKodeExist("NO");
		assertTrue("NO should exist",exist);
		
		exist =  kodtlkDaoService.landKodeExist("KALLE");
		assertTrue("KALLE should not exist",!exist);
		
	}		
	
	
}
