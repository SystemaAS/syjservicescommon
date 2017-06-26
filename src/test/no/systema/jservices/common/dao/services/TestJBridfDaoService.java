package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.BridfDao;

public class TestJBridfDaoService {

	ApplicationContext context = null;
	BridfDaoService bridfDaoService = null;
	String firmaColumnName = "arcfir";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		bridfDaoService = (BridfDaoService) context.getBean("bridfDaoService");
		
	}

	@Test
	public final void testExist() {
		BridfDao dao = new BridfDao();
		dao.setBibrid("FREDRIK");
		boolean exist = bridfDaoService.exist(dao);
		assertTrue(dao.getBibrid() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		BridfDao dao = new BridfDao();
		dao.setBibrid("FREDRIK");
		BridfDao resultDao = bridfDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	@Test
	public final void testGetUserName() {
		String name = "FREDRIK";
		String username = bridfDaoService.getUserName("FREDRIK");
		assertSame("Should be same", username, name);
	}
		
	
}
