package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtsfDao;

public class TestJKodtsfDaoService {

	ApplicationContext context = null;
	KodtsfDaoService kodtsfDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kodtsfDaoService = (KodtsfDaoService) context.getBean("kodtsfDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kodtsfDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KodtsfDao> list =  kodtsfDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		KodtsfDao dao = new KodtsfDao();
		dao.setKosfsi("JOV");
		boolean exist = kodtsfDaoService.exist(dao );
		assertTrue(dao.getKosfsi() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		KodtsfDao dao = new KodtsfDao();
		dao.setKosfsi("JOV");
		KodtsfDao resultDao = kodtsfDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
}
