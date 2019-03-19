package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;
import no.systema.jservices.common.dao.KodafDao;


public class TestJKodafDaoService {

	ApplicationContext context = null;
	KodafDaoService kodafDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kodafDaoService = (KodafDaoService) context.getBean("kodafDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kodafDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("betbet", "10");
		int count = kodafDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("betbet", "10");
		List<KodafDao> list =  kodafDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find only one tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		String firmaColumn = "firma";
		List<KodafDao> list =  kodafDaoService.findAllInFirma(null, firmaColumn);
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		KodafDao dao = new KodafDao();
		dao.setBetbet("14");
		boolean exist = kodafDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getBetbet() + " should exist", exist);
		
		dao.setBetbet("XX");
		exist = kodafDaoService.existInFirma(dao, firmaColumnName );
		assertFalse(dao.getBetbet() + " should NOT exist", exist);

		
	}

	@Test
	public final void testFind() {
		KodafDao dao = new KodafDao();
		dao.setBetbet("10");
		KodafDao resultDao = kodafDaoService.find(dao);
		assertNotNull(dao.getBetbet() + " should exist",resultDao);
	}
	
	@Test
	public final void testFindAll() {
		List<KodafDao> list =  kodafDaoService.findAll(null);

		list.forEach(dao -> {
			System.out.println("dao="+dao.getBetbet());
		});
		
		
		
		assertNotNull(list);
	}		
	
}
