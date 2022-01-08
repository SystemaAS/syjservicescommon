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

import org.slf4j.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VistranshDao;
import no.systema.jservices.common.dao.VistranslDao;

public class TestJVistranshDaoService {

	ApplicationContext context = null;
	VistranshDaoService vistranshDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistranshDaoService = (VistranshDaoService) context.getBean("vistranshDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistranshDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("posnr", 1);
		int count = vistranshDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<VistranshDao> list =  vistranshDaoService.findAll(null);
		
		//list.forEach(vt -> Logger.getRootLogger().info("vt bilnr"+vt.getBilnr()));
		
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistranshDao> list =  vistranshDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int bilnr = 0;
		int syncda = 20180530;
		List<VistranshDao> list =  vistranshDaoService.findAllInFirma(bilnr, syncda);
		assertNotNull(list);
	}	
	
	
	
	@Test
	public final void testExist() {
		VistranshDao dao = new VistranshDao();
		dao.setPosnr(1);
		boolean exist = vistranshDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getPosnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		VistranshDao dao = new VistranshDao();
		dao.setPosnr(1);
		VistranshDao resultDao = vistranshDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	
	@Test
	public final void testCreateAndDeleteSmall() {
		VistranshDao dao = getSmallDao();
		VistranshDao resultDao = vistranshDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranshDaoService.delete(dao);
		resultDao = vistranshDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}
	
	@Test
	public final void testCreateAndUpdateSmall() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 	
		VistranshDao dao = getSmallDao();
		VistranshDao resultDao = vistranshDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(dateFormatter);
		int syncDa = Integer.valueOf(nowDate);
		dao.setSyncda(syncDa);
		dao.setSyerro("Some error in the system");

		vistranshDaoService.updateOnError(dao);
		
		resultDao = vistranshDaoService.find(dao);
		assertEquals(syncDa,resultDao.getSyncda());
		assertEquals("Some error in the system",resultDao.getSyerro());
		

		//Cleanup
		vistranshDaoService.delete(dao);
		resultDao = vistranshDaoService.find(dao);
		assertNull("Should not exist", resultDao);		
		
		
	}	
	
	

	@Test
	public final void testCreateAndDeleteBig() {
		VistranshDao dao = getBigDao();
		VistranshDao resultDao = vistranshDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranshDaoService.delete(dao);
		resultDao = vistranshDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	

	@Test
	public final void testCreateAndDeleteOnBilnr() {

		//Clean
		vistranshDaoService.deleteAll(null);
		
		//Create Dao's
		getList().forEach((vtk) -> {
			vistranshDaoService.create(vtk);
		});
		
		//Delete on bilnr
		vistranshDaoService.deleteAll("SY", 100);
		
		//Assert on left
		List<VistranshDao> leftList= vistranshDaoService.findAll(null);
		assertEquals("Should not 1 left.", 1,leftList.size());
		
	}		

	private VistranshDao getSmallDao() {
		VistranshDao dao = new VistranshDao();
		dao.setFirma("SY");
		dao.setResnr(111);
		dao.setPosnr(1);
		dao.setSyncda(20180829);
		
		return dao;
		
	}

	private VistranshDao getBigDao() {
		VistranshDao dao = new VistranshDao();
		dao.setFirma("SY"); 
		dao.setResnr(222);
		dao.setPosnr(1); 
		dao.setAktkod("A");  
		dao.setValkod("vkd"); 
		dao.setSyncda(20180829);
		
		return dao;
		
	}
	
	private List<VistranshDao> getList() {
		List<VistranshDao> list = new ArrayList<VistranshDao>();

		VistranshDao dao = new VistranshDao();
		dao.setFirma("SY"); 
		dao.setBilnr(100);
		dao.setPosnr(1); 
		dao.setBiltxt("Byxa");
		dao.setResnr(222);
		dao.setAktkod("A");  
		dao.setValkod("NOK"); 
		dao.setSyncda(20180829);	
	
		VistranshDao dao2 = new VistranshDao();
		dao2.setFirma("SY"); 
		dao2.setBilnr(100);		
		dao2.setPosnr(2); 
		dao2.setBiltxt("Sko");		
		dao2.setResnr(222);
		dao2.setAktkod("A");  
		dao2.setValkod("NOK"); 
		dao2.setSyncda(20180829);			
	
		VistranshDao dao3 = new VistranshDao();
		dao3.setFirma("SY"); 
		dao3.setBilnr(140);		
		dao3.setPosnr(1); 
		dao3.setBiltxt("Fisk");		
		dao3.setResnr(333);
		dao3.setAktkod("A");  
		dao3.setValkod("NOK"); 
		dao3.setSyncda(20180829);	
		
		list.add(dao);
		list.add(dao2);
		list.add(dao3);
		
		return list;
		
	}
	
}
