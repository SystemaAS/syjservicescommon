package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ViskulogDao;
import no.systema.jservices.common.dao.ViskundeDao;
import no.systema.jservices.common.dao.VissyskunDao;

public class TestJViskulogDaoService {

	ApplicationContext context = null;
	ViskulogDaoService viskulogDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		viskulogDaoService = (ViskulogDaoService) context.getBean("viskulogDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = viskulogDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testFindAll() {
		List<ViskulogDao> list =  viskulogDaoService.findAll(null);
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<ViskulogDao> list =  viskulogDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<ViskulogDao> list =  viskulogDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}
	
	
	
	
	
	@Test
	public final void testCreateAndDelete() {
		ViskulogDao dao = new ViskulogDao();
		dao.setFirma("SY");
		dao.setKundnr(11);
		dao.setKnavn("junit test");
		dao.setSyerro("error, error error, error error, error error, error");
		ViskulogDao resultDao = viskulogDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = viskulogDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		viskulogDaoService.delete(dao);
		resultDao = viskulogDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void createSome() {
		ViskulogDao dao = new ViskulogDao();
		dao.setFirma("SY");
		dao.setKundnr(110);
		dao.setKnavn("knavn");
		dao.setStatus("P");
		dao.setSyncda(20180518);
		dao.setSyerro("some long error text....");
		
		viskulogDaoService.create(dao);
		
		ViskulogDao dao2 = new ViskulogDao();
		dao2.setFirma("SY");
		dao2.setKundnr(210);
		dao2.setKnavn("knavn 210");
		dao.setStatus("E");
		dao.setSyncda(20180518);
		dao2.setSyerro("some long even longer, error text....");
		
		
		viskulogDaoService.create(dao2);
		
		
	}
}
