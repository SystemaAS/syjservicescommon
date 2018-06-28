package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VistrlogkDao;
import no.systema.jservices.common.dao.VistrloglDao;

public class TestJVistrloglDaoService {

	ApplicationContext context = null;
	VistrloglDaoService vistrloglDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistrloglDaoService = (VistrloglDaoService) context.getBean("vistrloglDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistrloglDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testFindAll() {
		List<VistrloglDao> list =  vistrloglDaoService.findAll(null);
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistrloglDao> list =  vistrloglDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<VistrloglDao> list =  vistrloglDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}
	
	@Test
	public final void testCreateAndDelete() {
		VistrloglDao dao = new VistrloglDao();
		dao.setFirma("SY");
		dao.setBilnr(00001);
		dao.setBilaar(2018);
		dao.setSyerro("error, error error, error error, error error, error");
		VistrloglDao resultDao = vistrloglDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = vistrloglDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		vistrloglDaoService.delete(dao);
		resultDao = vistrloglDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void createSome() {
		VistrloglDao dao = new VistrloglDao();
		dao.setFirma("SY");
		dao.setBilnr(110);
		dao.setBilaar(2018);
		dao.setStatus("OK");
		dao.setSyncda(20180627);
		
		vistrloglDaoService.create(dao);
		
		VistrloglDao dao2 = new VistrloglDao();
		dao2.setFirma("SY");
		dao2.setBilnr(220);
		dao2.setBilaar(2018);
		dao2.setBilmnd(5);
		dao2.setBildag(28);
		dao.setStatus("ER");
		dao.setSyncda(20180627);
		dao2.setSyerro("some long even longer, error text in VISTRLOGL....");
		
		
		vistrloglDaoService.create(dao2);
		
		
	}
}
