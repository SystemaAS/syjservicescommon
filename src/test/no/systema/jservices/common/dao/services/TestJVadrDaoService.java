package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KunkoDao;
import no.systema.jservices.common.dao.VadrDao;

public class TestJVadrDaoService {

	ApplicationContext context = null;
	VadrDaoService vadrDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vadrDaoService = (VadrDaoService) context.getBean("vadrDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = vadrDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<VadrDao> list =  vadrDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		VadrDao dao = new VadrDao();
		dao.setFirma("SY");
		dao.setKundnr(600006);
		dao.setVadrnr(1);
		boolean exist = vadrDaoService.exist(dao );
		assertTrue(dao.getKundnr() +  " should exist", exist);
	}

	@Test
	public final void testFind() {
		VadrDao dao = new VadrDao();
		dao.setFirma("SY");
		dao.setKundnr(600006);
		dao.setVadrnr(1);
		VadrDao resultDao = vadrDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
	
	@Test
	public final void testGet() {
		List<VadrDao> resultDaolist = vadrDaoService.getList(600006);
		assertNotNull(resultDaolist.size());
	}		
	
}
