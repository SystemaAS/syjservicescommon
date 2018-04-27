package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VissyskunDao;

public class TestJVissyskunDaoService {

	ApplicationContext context = null;
	VissyskunDaoService vissyskunDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vissyskunDaoService = (VissyskunDaoService) context.getBean("vissyskunDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vissyskunDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", 1);
		int count = vissyskunDaoService.countAll(params);
		assertTrue("Should be  1",count == 1);
	}
	
	@Test
	public final void testFindAll() {
		List<VissyskunDao> list =  vissyskunDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", 1);
		List<VissyskunDao> list =  vissyskunDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find 1 tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<VissyskunDao> list =  vissyskunDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		VissyskunDao dao = new VissyskunDao();
		dao.setKundnr(1);
		boolean exist = vissyskunDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getKundnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		VissyskunDao dao = new VissyskunDao();
		dao.setKundnr(1);
		VissyskunDao resultDao = vissyskunDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}


	
	@Test
	public final void testFindOnSyspedKundnr() {
		VissyskunDao resultDao = vissyskunDaoService.findBySyspedKundnr(1);
		assertNotNull("Should exist", resultDao);
	}	
	
	@Test
	public final void testFindOnSyspedKundnrNoExist() {
		VissyskunDao resultDao = vissyskunDaoService.findBySyspedKundnr(111);
		assertNull("Should NOT exist", resultDao);
	}	
	
	
	@Test
	public final void testFindOnVismaKundnr() {
		VissyskunDao resultDao = vissyskunDaoService.findByVismaKundnr(10010);
		assertNotNull("Should exist", resultDao);
	}	
	
	@Test
	public final void testFindOnVismaKundnrNoExist() {
		VissyskunDao resultDao = vissyskunDaoService.findByVismaKundnr(999);
		assertNull("Should NOT exist", resultDao);
	}	
	
	
	@Test
	public final void testCreateAndDelete() {
		VissyskunDao dao = new VissyskunDao();
		dao.setFirma("SY");
		dao.setKundnr(11);
		dao.setVisknr(11111111);
		VissyskunDao resultDao = vissyskunDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = vissyskunDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		vissyskunDaoService.delete(dao);
		resultDao = vissyskunDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	
}
