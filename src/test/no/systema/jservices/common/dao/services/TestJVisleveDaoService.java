package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VisleveDao;

public class TestJVisleveDaoService {

	ApplicationContext context = null;
	VisleveDaoService visleveDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		visleveDaoService = (VisleveDaoService) context.getBean("visleveDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = visleveDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levnr", 2010);
		int count = visleveDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<VisleveDao> list =  visleveDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levnr", 2010);
		List<VisleveDao> list =  visleveDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find 1 tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<VisleveDao> list =  visleveDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int levnr = 1;
		int syncda = 20180604;
		List<VisleveDao> list =  visleveDaoService.findAllInFirma(levnr, syncda);
		

		list.forEach(vk -> System.out.println(vk));
		
		assertNotNull(list);
	}	
	
	
	
	@Test
	public final void testExist() {
		VisleveDao dao = new VisleveDao();
		dao.setLevnr(2010);
		boolean exist = visleveDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getKundnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		VisleveDao dao = new VisleveDao();
		dao.setLevnr(2010);
		VisleveDao resultDao = visleveDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	@Test
	public final void testCreateAndDeleteSmall() {
		VisleveDao dao = getSmallDao();
		VisleveDao resultDao = visleveDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		visleveDaoService.delete(dao);
		resultDao = visleveDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}
	
	@Test
	public final void testCreateAndUpdateSmall() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 	
		VisleveDao dao = getSmallDao();
		VisleveDao resultDao = visleveDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		LocalDateTime now = LocalDateTime.now();
		String nowDate = now.format(dateFormatter);
		int syncDa = Integer.valueOf(nowDate);
		dao.setSyncda(syncDa);

		String syerro= "{ message : VismaId: b0727629-4a3b-4860-9e16-763794052c5d. Error inserting the customer. Error: Inserting 'Customer' record raised at least one error. Please review the errors.\r\nError: Terms 'TT' cannot be found in the system.\r\n}";
		dao.setSyerro(syerro);

		visleveDaoService.updateOnError(dao);
		
		resultDao = visleveDaoService.find(dao);
		assertEquals(syncDa,resultDao.getSyncda());
		assertEquals(syerro,resultDao.getSyerro());
		

		//Cleanup
		visleveDaoService.delete(dao);
		resultDao = visleveDaoService.find(dao);
		assertNull("Should not exist", resultDao);		
		
		
	}	
	
	@Test
	public final void testCreateAndDeleteBig() {
		VisleveDao dao = getBigDao();
		VisleveDao resultDao = visleveDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		visleveDaoService.delete(dao);
		resultDao = visleveDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	
	
	@Test
	public final void createBigCustomer() {
		VisleveDao dao = getBigDao();
		VisleveDao resultDao = visleveDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

	}
	
	private VisleveDao getSmallDao() {
		VisleveDao dao = new VisleveDao();
		dao.setFirma("SY");
		dao.setLevnr(2010);
		dao.setSyncda(20180611);
		
		return dao;
		
	}

	private VisleveDao getBigDao() {
		VisleveDao dao = new VisleveDao();
		dao.setFirma("SY"); //private String firma;
		dao.setLevnr(2); //private int kundnr; //key
		dao.setAktkod("A");  // private String aktkod;
		dao.setAdr1("adr1"); //;private String adr1;
		dao.setAdr2("adr2"); //private String adr2;
		dao.setPostnr(3333);  //private int postnr;
		dao.setAdr3("adr3"); //private String adr3;
		dao.setKpers("Fredrik"); //private String kpers;
		dao.setTlf("1111");//private String tlf;
		dao.setSonavn("sonavn"); //private String sonavn;
		dao.setValkod("NO"); //;private String valkod;
		dao.setSpraak("N"); //private String spraak;
		dao.setBankg("100");//private String bankg;
		dao.setPostg("200"); //private String postg;
		dao.setBetbet("14"); //private String betbet;
		dao.setBetmat("1"); //private String betmat;
		dao.setTfaxnr("9876"); //private String tfaxnr;
		dao.setAdr21("Gamle by"); //private String adr21;

		return dao;
		
	}
	
	
}
