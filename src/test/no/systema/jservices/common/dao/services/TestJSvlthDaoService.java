package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.values.EventTypeEnum;

public class TestJSvlthDaoService {

	ApplicationContext context = null;
	SvlthDaoService svlthDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svlthDaoService = (SvlthDaoService) context.getBean("svlthDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = svlthDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testExist() {
		String mrn = "1NO123456789012345";
		int arrivalDate = 20190401;
		
		boolean exist = svlthDaoService.exist(EventTypeEnum.INLAGG, mrn , arrivalDate);
		assertTrue(exist);
	
		mrn = "xyz";
		exist = svlthDaoService.exist(EventTypeEnum.INLAGG,mrn , arrivalDate);
		assertFalse(exist);	
	
	}	
	

	@Test(expected=IllegalAccessError.class)
	public final void testExistOrg() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_h("I");
		boolean exist = svlthDaoService.exist(dao );
	}

	@Test(expected=IllegalAccessError.class)
	public final void testFind() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_h("I");
		SvlthDao resultDao = svlthDaoService.find(dao);
	}
	
	
}
