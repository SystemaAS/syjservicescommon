package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SadhDao;

public class TestJSadhDaoService {

	ApplicationContext context = null;
	SadhDaoService sadhDaoService = null;
	SadhDao dao = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		sadhDaoService = (SadhDaoService) context.getBean("sadhDaoService");
		dao = new SadhDao();
	}

	@Test
	public final void testExist() {
		dao.setSiavd(1);
		dao.setSitdn(54946);
		boolean exist = sadhDaoService.exist(dao );
		assertTrue(dao.getSiopd() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		dao.setSiavd(1);
		dao.setSitdn(54946);
		SadhDao resultDao = sadhDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
}
