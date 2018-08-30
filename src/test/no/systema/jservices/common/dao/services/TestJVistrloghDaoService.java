package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VistrloghDao;
import no.systema.jservices.common.dao.VistrloglDao;

public class TestJVistrloghDaoService {

	ApplicationContext context = null;
	VistrloghDaoService vistrloghDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistrloghDaoService = (VistrloghDaoService) context.getBean("vistrloghDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistrloghDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testFindAll() {
		List<VistrloghDao> list =  vistrloghDaoService.findAll(null);
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistrloghDao> list =  vistrloghDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<VistrloghDao> list =  vistrloghDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}
	
	@Test
	public final void testCreateAndDelete() {
		VistrloghDao dao = new VistrloghDao();
		dao.setFirma("SY");
		dao.setBilnr(00001);
		dao.setBilaar(2018);
		dao.setSyerro("error, error error, error error, error error, error");
		VistrloghDao resultDao = vistrloghDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = vistrloghDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		vistrloghDaoService.delete(dao);
		resultDao = vistrloghDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void createSome() {
		VistrloghDao dao = new VistrloghDao();
		dao.setFirma("SY");
		dao.setBilnr(110);
		dao.setBilaar(2018);
		dao.setStatus("OK");
		dao.setSyncda(20180627);
		
		vistrloghDaoService.create(dao);
		
		VistrloghDao dao2 = new VistrloghDao();
		dao2.setFirma("SY");
		dao2.setBilnr(220);
		dao2.setBilaar(2018);
		dao2.setBilmnd(5);
		dao2.setBildag(28);
		dao.setStatus("ER");
		dao.setSyncda(20180627);
		dao2.setSyerro("some long even longer, error text in VISTRLOGH....");
		
		
		vistrloghDaoService.create(dao2);
		
		
	}
}
