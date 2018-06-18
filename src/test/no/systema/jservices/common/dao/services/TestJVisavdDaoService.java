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

import no.systema.jservices.common.dao.VisavdDao;
import no.systema.jservices.common.dao.VistrlogkDao;

public class TestJVisavdDaoService {

	ApplicationContext context = null;
	VisavdDaoService visavdDaoService = null;
	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			visavdDaoService = (VisavdDaoService) context.getBean("visavdDaoService");
	}

	@Test
	public final void testCreateAndDelete() {
		VisavdDao dao = new VisavdDao();
		dao.setSyavd(22);
		dao.setKoanvn("beskrivelse av avd");
		dao.setSyncda(20180618);
		dao.setSyerro("error, error error, error error, error error, error");
		VisavdDao resultDao = visavdDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = visavdDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		visavdDaoService.delete(dao);
		resultDao = visavdDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	
	
	
	
	
}
