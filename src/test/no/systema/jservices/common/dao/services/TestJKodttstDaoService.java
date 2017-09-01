package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodttstDao;

public class TestJKodttstDaoService {

	ApplicationContext context = null;
	KodttstDaoService kodttstDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kodttstDaoService = (KodttstDaoService) context.getBean("kodttstDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kodttstDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KodttstDao> list =  kodttstDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testExist() {
		KodttstDao dao = new KodttstDao();
		dao.setKtskod(19);
		boolean exist = kodttstDaoService.exist(dao );
		assertTrue(dao.getKtskod()  +" should exist", exist);

	}

	@Test
	public final void testFind() {
		KodttstDao dao = new KodttstDao();
		dao.setKtskod(19);
		KodttstDao resultDao = kodttstDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
}
