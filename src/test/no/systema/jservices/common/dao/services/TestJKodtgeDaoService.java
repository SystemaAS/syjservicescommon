package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtfrDao;
import no.systema.jservices.common.dao.KodtgeDao;

public class TestJKodtgeDaoService {

	ApplicationContext context = null;
	KodtgeDaoService kodtgeDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kodtgeDaoService = (KodtgeDaoService) context.getBean("kodtgeDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kodtgeDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KodtgeDao> list =  kodtgeDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		KodtgeDao dao = new KodtgeDao();
		dao.setKgekod("ADV");
		boolean exist = kodtgeDaoService.exist(dao );
		assertTrue(dao.getKgekod() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		KodtgeDao dao = new KodtgeDao();
		dao.setKgekod("ADV");
		KodtgeDao resultDao = kodtgeDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
}
