package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		
		list.forEach(vt -> Logger.getRootLogger().info("vt resnr"+vt.getResnr()));
		
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
		int bilnr = 0;
		int syncda = 20180530;
		List<VistranskDao> list =  vistranskDaoService.findAllInFirma(kundnr,bilnr, syncda);
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
	public final void testCreateAndDeleteOnBilnr() {

		//Clean
		vistranskDaoService.deleteAll(null);
		
		//Create Dao's
		getList().forEach((vtk) -> {
			vistranskDaoService.create(vtk);
		});
		
		//Delete on bilnr
		vistranskDaoService.deleteAll("SY", 100);
		
		//Assert on left
		List<VistranskDao> leftList= vistranskDaoService.findAll(null);
		assertEquals("Should not 1 left.", 1,leftList.size());
		
	}		

	private VistranskDao getSmallDao() {
		VistranskDao dao = new VistranskDao();
		dao.setFirma("SY");
		dao.setResnr(111);
		dao.setPosnr(1);
		dao.setSyncda(20180522);
		
		return dao;
		
	}

	private VistranskDao getBigDao() {
		VistranskDao dao = new VistranskDao();
		dao.setFirma("SY"); 
		dao.setResnr(222);
		dao.setPosnr(1); 
		dao.setAktkod("A");  
		dao.setValkod("vkd"); 
		dao.setSyncda(20180522);
		
		return dao;
		
	}
	
	private List<VistranskDao> getList() {
		List<VistranskDao> list = new ArrayList<VistranskDao>();

		VistranskDao dao = new VistranskDao();
		dao.setFirma("SY"); 
		dao.setBilnr(100);
		dao.setPosnr(1); 
		dao.setBiltxt("Byxa");
		dao.setResnr(222);
		dao.setAktkod("A");  
		dao.setValkod("NOK"); 
		dao.setSyncda(20180530);	
	
		VistranskDao dao2 = new VistranskDao();
		dao2.setFirma("SY"); 
		dao2.setBilnr(100);		
		dao2.setPosnr(2); 
		dao2.setBiltxt("Sko");		
		dao2.setResnr(222);
		dao2.setAktkod("A");  
		dao2.setValkod("NOK"); 
		dao2.setSyncda(20180530);			
	
		VistranskDao dao3 = new VistranskDao();
		dao3.setFirma("SY"); 
		dao3.setBilnr(140);		
		dao3.setPosnr(1); 
		dao3.setBiltxt("Fisk");		
		dao3.setResnr(333);
		dao3.setAktkod("A");  
		dao3.setValkod("NOK"); 
		dao3.setSyncda(20180530);	
		
		list.add(dao);
		list.add(dao2);
		list.add(dao3);
		
		return list;
		
	}
	
}
