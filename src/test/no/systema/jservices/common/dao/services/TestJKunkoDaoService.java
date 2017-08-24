package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KunkoDao;

public class TestJKunkoDaoService {

	ApplicationContext context = null;
	KunkoDaoService kunkoDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kunkoDaoService = (KunkoDaoService) context.getBean("kunkoDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = kunkoDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<KunkoDao> list =  kunkoDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		KunkoDao dao = new KunkoDao();
		dao.setKukun1(24);
		dao.setKukun2(24);
		dao.setKuvadr(2);
		boolean exist = kunkoDaoService.exist(dao );
		assertTrue(dao.getKukun1() +  " should exist", exist);
	}

	@Test
	public final void testFind() {
		KunkoDao dao = new KunkoDao();
		dao.setKukun1(24);
		dao.setKukun2(24);
		dao.setKuvadr(2);
		KunkoDao resultDao = kunkoDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
	
	@Test
	public final void testGet() {
		List<KunkoDao> resultDaolist = kunkoDaoService.getList(24);
		assertNotNull(resultDaolist.size());
	}		
	
}
