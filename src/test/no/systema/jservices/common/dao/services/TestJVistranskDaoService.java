package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VistranskDao;

public class TestJVistranskDaoService {

	ApplicationContext context = null;
	VistranskDaoService vistranskDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistranskDaoService = (VistranskDaoService) context.getBean("vistranskDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistranskDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("posnr", 1);
		int count = vistranskDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<VistranskDao> list =  vistranskDaoService.findAll(null);
		
		list.forEach(vt -> Logger.getRootLogger().info("vt recnr"+vt.getRecnr()));
		
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistranskDao> list =  vistranskDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<VistranskDao> list =  vistranskDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}	
	
	
	
	@Test
	public final void testExist() {
		VistranskDao dao = new VistranskDao();
		dao.setPosnr(1);
		boolean exist = vistranskDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getPosnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		VistranskDao dao = new VistranskDao();
		dao.setPosnr(1);
		VistranskDao resultDao = vistranskDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	
	@Test
	public final void testCreateAndDeleteSmall() {
		VistranskDao dao = getSmallDao();
		VistranskDao resultDao = vistranskDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranskDaoService.delete(dao);
		resultDao = vistranskDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}
	
	@Test
	public final void testCreateAndUpdateSmall() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 	
		VistranskDao dao = getSmallDao();
		VistranskDao resultDao = vistranskDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(dateFormatter);
		int syncDa = Integer.valueOf(nowDate);
		dao.setSyncda(syncDa);
		dao.setSyerro("Some error in the system");

		vistranskDaoService.updateOnError(dao);
		
		resultDao = vistranskDaoService.find(dao);
		assertEquals(syncDa,resultDao.getSyncda());
		assertEquals("Some error in the system",resultDao.getSyerro());
		

		//Cleanup
		vistranskDaoService.delete(dao);
		resultDao = vistranskDaoService.find(dao);
		assertNull("Should not exist", resultDao);		
		
		
	}	
	
	

	@Test
	public final void testCreateAndDeleteBig() {
		VistranskDao dao = getBigDao();
		VistranskDao resultDao = vistranskDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranskDaoService.delete(dao);
		resultDao = vistranskDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	
	
	@Test
	public final void createBig() {
		VistranskDao dao = getBigDao();
		VistranskDao resultDao = vistranskDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

	}
	
	private VistranskDao getSmallDao() {
		VistranskDao dao = new VistranskDao();
		dao.setFirma("SY");
		dao.setRecnr(111);
		dao.setPosnr(1);
		dao.setSyncda(20180522);
		
		return dao;
		
	}

	private VistranskDao getBigDao() {
		VistranskDao dao = new VistranskDao();
		dao.setFirma("SY"); 
		dao.setRecnr(222);
		dao.setPosnr(1); 
		dao.setAktkod("A");  
		dao.setValkod("vkd"); 
		dao.setSyncda(20180522);
		
		return dao;
		
	}
	
	
}
