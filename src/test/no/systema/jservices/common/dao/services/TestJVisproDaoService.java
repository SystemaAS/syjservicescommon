package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VisproDao;

public class TestJVisproDaoService {

	ApplicationContext context = null;
	VisproDaoService visproDaoService = null;
	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			visproDaoService = (VisproDaoService) context.getBean("visproDaoService");
	}

	@Test
	public final void testCreateAndDelete() {
		VisproDao dao = new VisproDao();
		dao.setSypro(77);
		dao.setSyncda(20180618);
		dao.setSyerro("error, error error, error error, error error, error");
		VisproDao resultDao = visproDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		try {
			resultDao = visproDaoService.create(dao);
			fail("Excepted duplicateexception");
		} catch (Exception e) {
			// expected
			e.printStackTrace();
		}
		
		//Cleanup
		visproDaoService.delete(dao);
		resultDao = visproDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	
	
	
}
