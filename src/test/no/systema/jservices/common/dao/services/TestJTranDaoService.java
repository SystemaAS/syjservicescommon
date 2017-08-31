package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.TranDao;

public class TestJTranDaoService {

	ApplicationContext context = null;
	TranDaoService tranDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		tranDaoService = (TranDaoService) context.getBean("tranDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = tranDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<TranDao> list =  tranDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testExist() {
		TranDao dao = new TranDao();
		dao.setVmtran(96);
		dao.setVmtrku(24);
		dao.setVmtrle(1);
		boolean exist = tranDaoService.exist(dao );
		assertTrue(dao.getVmtran() + ", " + dao.getVmtrku() + "," + dao.getVmtrle() +" should exist", exist);

	}

	@Test
	public final void testFind() {
		TranDao dao = new TranDao();
		dao.setVmtran(96);
		dao.setVmtrku(24);
		dao.setVmtrle(1);
		TranDao resultDao = tranDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
}
