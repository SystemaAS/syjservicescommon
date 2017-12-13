package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SadkaaDao;

public class TestJSadkaaDaoService {

	ApplicationContext context = null;
	SadkaaDaoService sadkaaDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		sadkaaDaoService = (SadkaaDaoService) context.getBean("sadkaaDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = sadkaaDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<SadkaaDao> list =  sadkaaDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		SadkaaDao dao = new SadkaaDao();
		dao.setSadkaa02("XV");
		boolean exist = sadkaaDaoService.exist(dao );
		assertTrue(dao.getSadkaa02() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		SadkaaDao dao = new SadkaaDao();
		dao.setSadkaa02("XV");
		SadkaaDao resultDao = sadkaaDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
}
