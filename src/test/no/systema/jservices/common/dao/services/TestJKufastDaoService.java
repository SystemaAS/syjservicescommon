package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KufastDao;
import no.systema.jservices.common.values.FasteKoder;

public class TestJKufastDaoService {

	ApplicationContext context = null;
	KufastDaoService kufastDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kufastDaoService = (KufastDaoService) context.getBean("kufastDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kufastDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KufastDao> list =  kufastDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		KufastDao dao = new KufastDao();
		dao.setKftyp(FasteKoder.PRODTYPE.name());
		dao.setKfkod("L");
		boolean exist = kufastDaoService.exist(dao );
		assertTrue(dao.getKftyp() + "," +dao.getKfkod() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		KufastDao dao = new KufastDao();
		dao.setKftyp(FasteKoder.PRODTYPE.name());
		dao.setKfkod("L");
		KufastDao resultDao = kufastDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	@Test
	public final void testFind2() {
		KufastDao resultDao = kufastDaoService.find(FasteKoder.PRODTYPE, "L");
		assertNotNull(resultDao);
	}	
	
	@Test
	public final void testFind3() {
		List<KufastDao> resultDaolist = kufastDaoService.getList(FasteKoder.PRODTYPE);
		assertNotNull(resultDaolist.size());
	}		
	
}
