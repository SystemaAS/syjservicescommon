package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtfrDao;

public class TestJKodtfrDaoService {

	ApplicationContext context = null;
	KodtfrDaoService kodtfrDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kodtfrDaoService = (KodtfrDaoService) context.getBean("kodtfrDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kodtfrDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KodtfrDao> list =  kodtfrDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		KodtfrDao dao = new KodtfrDao();
		dao.setKfrkod("FOB");
		boolean exist = kodtfrDaoService.exist(dao );
		assertTrue(dao.getKfrkod() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		KodtfrDao dao = new KodtfrDao();
		dao.setKfrkod("FOB");
		KodtfrDao resultDao = kodtfrDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
}
