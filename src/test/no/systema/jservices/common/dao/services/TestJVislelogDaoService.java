package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VislelogDao;

public class TestJVislelogDaoService {

	ApplicationContext context = null;
	VislelogDaoService vislelogDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vislelogDaoService = (VislelogDaoService) context.getBean("vislelogDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vislelogDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testFindAll() {
		List<VislelogDao> list =  vislelogDaoService.findAll(null);
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VislelogDao> list =  vislelogDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<VislelogDao> list =  vislelogDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}
	
	
	@Test
	public final void testCreateAndDelete() {
		VislelogDao dao = new VislelogDao();
		dao.setFirma("SY");
		dao.setLevnr(22);
		dao.setLnavn("junit test");
		dao.setSyerro("error, error error, error error, error error, error");
		VislelogDao resultDao = vislelogDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = vislelogDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		vislelogDaoService.delete(dao);
		resultDao = vislelogDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void createSome() {
		VislelogDao dao = new VislelogDao();
		dao.setFirma("SY");
		dao.setLevnr(220);
		dao.setLnavn("lnavn");
		dao.setStatus("ER");
		dao.setSyncda(20180518);
		dao.setSyerro("some long error text....");
		
		vislelogDaoService.create(dao);
		
		VislelogDao dao2 = new VislelogDao();
		dao2.setFirma("SY");
		dao2.setLevnr(310);
		dao2.setLnavn("knavn 310");
		dao.setStatus("ER");
		dao.setSyncda(20180518);
		dao2.setSyerro("some long even longer, error text....");
		
		
		vislelogDaoService.create(dao2);
		
		
	}
}
