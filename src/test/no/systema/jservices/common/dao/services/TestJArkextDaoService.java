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

import no.systema.jservices.common.dao.ArkextDao;

public class TestJArkextDaoService {

	ApplicationContext context = null;
	ArkextDaoService arkextDaoService = null;
	String firmaColumnName = "arcfir";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		arkextDaoService = (ArkextDaoService) context.getBean("arkextDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = arkextDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("arcext", "E1");
		int count = arkextDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<ArkextDao> list =  arkextDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("arcext", "E1");
		List<ArkextDao> list =  arkextDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find only one tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		String firmaColumn = "arcfir";
		List<ArkextDao> list =  arkextDaoService.findAllInFirma(null, firmaColumn);
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		ArkextDao dao = new ArkextDao();
		dao.setArcext("E1");
		boolean exist = arkextDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getArcext() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		ArkextDao dao = new ArkextDao();
		dao.setArcext("E1");
		ArkextDao resultDao = arkextDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
	
	
}
