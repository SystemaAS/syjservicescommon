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

import no.systema.jservices.common.dao.VistranskDao;
import no.systema.jservices.common.dao.VistranslDao;

public class TestJVistranslDaoService {

	ApplicationContext context = null;
	VistranslDaoService vistranslDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistranslDaoService = (VistranslDaoService) context.getBean("vistranslDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistranslDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("posnr", 1);
		int count = vistranslDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<VistranslDao> list =  vistranslDaoService.findAll(null);
		
		//list.forEach(vt -> LogManager.getRootLogger().info("vt resnr"+vt.getResnr()));
		
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistranslDao> list =  vistranslDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int levnr = 1;
		int bilnr = 0;
		int syncda = 20180530;
		List<VistranslDao> list =  vistranslDaoService.findAllInFirma(levnr,bilnr, syncda);
		assertNotNull(list);
	}	
	
	
	
	@Test
	public final void testExist() {
		VistranslDao dao = new VistranslDao();
		dao.setPosnr(1);
		boolean exist = vistranslDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getPosnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		VistranslDao dao = new VistranslDao();
		dao.setPosnr(1);
		VistranslDao resultDao = vistranslDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	
	@Test
	public final void testCreateAndDeleteSmall() {
		VistranslDao dao = getSmallDao();
		VistranslDao resultDao = vistranslDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranslDaoService.delete(dao);
		resultDao = vistranslDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}
	
	@Test
	public final void testCreateAndUpdateSmall() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 	
		VistranslDao dao = getSmallDao();
		VistranslDao resultDao = vistranslDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(dateFormatter);
		int syncDa = Integer.valueOf(nowDate);
		dao.setSyncda(syncDa);
		dao.setSyerro("Some error in the system");

		vistranslDaoService.updateOnError(dao);
		
		resultDao = vistranslDaoService.find(dao);
		assertEquals(syncDa,resultDao.getSyncda());
		assertEquals("Some error in the system",resultDao.getSyerro());
		

		//Cleanup
		vistranslDaoService.delete(dao);
		resultDao = vistranslDaoService.find(dao);
		assertNull("Should not exist", resultDao);		
		
		
	}	
	
	

	@Test
	public final void testCreateAndDeleteBig() {
		VistranslDao dao = getBigDao();
		VistranslDao resultDao = vistranslDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		vistranslDaoService.delete(dao);
		resultDao = vistranslDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	

	@Test
	public final void testCreateAndDeleteOnBilnr() {

		//Clean
		vistranslDaoService.deleteAll(null);
		
		//Create Dao's
		getList().forEach((vtk) -> {
			vistranslDaoService.create(vtk);
		});
		
		//Delete on bilnr
		vistranslDaoService.deleteAll("SY", 100);
		
		//Assert on left
		List<VistranslDao> leftList= vistranslDaoService.findAll(null);
		assertEquals("Should not 1 left.", 1,leftList.size());
		
	}		

	private VistranslDao getSmallDao() {
		VistranslDao dao = new VistranslDao();
		dao.setFirma("SY");
		dao.setResnr(111);
		dao.setPosnr(1);
		dao.setSyncda(20180611);
		
		return dao;
		
	}

	private VistranslDao getBigDao() {
		VistranslDao dao = new VistranslDao();
		dao.setFirma("SY"); 
		dao.setResnr(222);
		dao.setPosnr(1); 
		dao.setAktkod("A");  
		dao.setValkod("vkd"); 
		dao.setSyncda(20180611);
		
		return dao;
		
	}
	
	private List<VistranslDao> getList() {
		List<VistranslDao> list = new ArrayList<VistranslDao>();

		VistranslDao dao = new VistranslDao();
		dao.setFirma("SY"); 
		dao.setBilnr(100);
		dao.setPosnr(1); 
		dao.setBiltxt("Byxa");
		dao.setResnr(222);
		dao.setAktkod("A");  
		dao.setValkod("NOK"); 
		dao.setSyncda(20180611);	
	
		VistranslDao dao2 = new VistranslDao();
		dao2.setFirma("SY"); 
		dao2.setBilnr(100);		
		dao2.setPosnr(2); 
		dao2.setBiltxt("Sko");		
		dao2.setResnr(222);
		dao2.setAktkod("A");  
		dao2.setValkod("NOK"); 
		dao2.setSyncda(20180530);			
	
		VistranslDao dao3 = new VistranslDao();
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
