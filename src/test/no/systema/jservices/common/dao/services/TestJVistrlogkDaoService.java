package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ViskulogDao;
import no.systema.jservices.common.dao.VistrlogkDao;

public class TestJVistrlogkDaoService {

	ApplicationContext context = null;
	VistrlogkDaoService vistrlogkDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vistrlogkDaoService = (VistrlogkDaoService) context.getBean("vistrlogkDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vistrlogkDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testFindAll() {
		List<VistrlogkDao> list =  vistrlogkDaoService.findAll(null);
		assertNotNull(list);
	}		

	
	@Test
	public final void testFindAllInFirma() {
		List<VistrlogkDao> list =  vistrlogkDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		int kundnr = 1;
		int syncda = 20180530;
		List<VistrlogkDao> list =  vistrlogkDaoService.findAllInFirma(kundnr, syncda);
		assertNotNull(list);
	}
	
	@Test
	public final void testCreateAndDelete() {
		VistrlogkDao dao = new VistrlogkDao();
		dao.setFirma("SY");
		dao.setBilnr(00001);
		dao.setBilaar(2018);
		dao.setSyerro("error, error error, error error, error error, error");
		VistrlogkDao resultDao = vistrlogkDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = vistrlogkDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		vistrlogkDaoService.delete(dao);
		resultDao = vistrlogkDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void createSome() {
		VistrlogkDao dao = new VistrlogkDao();
		dao.setFirma("SY");
		dao.setBilnr(110);
		dao.setBilaar(2018);
		dao.setStatus("OK");
		dao.setSyncda(20180528);
		
		vistrlogkDaoService.create(dao);
		
		VistrlogkDao dao2 = new VistrlogkDao();
		dao2.setFirma("SY");
		dao2.setBilnr(110);
		dao2.setBilaar(2018);
		dao2.setBilmnd(5);
		dao2.setBildag(28);
		dao.setStatus("EE");
		dao.setSyncda(20180528);
		dao2.setSyerro("some long even longer, error text....");
		
		
		vistrlogkDaoService.create(dao2);
		
		
	}
}
