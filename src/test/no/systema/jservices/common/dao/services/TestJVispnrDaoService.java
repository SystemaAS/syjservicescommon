package no.systema.jservices.common.dao.services;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;
import no.systema.jservices.common.dao.VispnrDao;

public class TestJVispnrDaoService {

	ApplicationContext context = null;
	VispnrDaoService vispnrDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vispnrDaoService = (VispnrDaoService) context.getBean("vispnrDaoService");

		
	}

	@Test
	public final void testCountAll() {
		int count = vispnrDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<VispnrDao> list =  vispnrDaoService.findAll(null);
		VispnrDao dao = list.get(0);
		assertNotNull(dao);
	}

	@Test
	public final void testFind() {
		VispnrDao qDao = new VispnrDao();
		qDao.setVilk("SE");
		qDao.setViponr("41871");
		VispnrDao resultDao =  vispnrDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	@Test
	public final void testLandKodeExist() {
		boolean exist =  vispnrDaoService.landKodeExist("SE");
		assertTrue(exist);
		
		exist =  vispnrDaoService.landKodeExist("XX");
		assertFalse(exist);
		
	}	
	
	@Test
	public final void testExist() {
		VispnrDao qDao = new VispnrDao();
		qDao.setVilk("SE");
		qDao.setViponr("41871");
		
		boolean exist =  vispnrDaoService.exist(qDao);
		assertTrue(exist);

		qDao.setVilk("NO");
		qDao.setViponr("4373");

		exist =  vispnrDaoService.exist(qDao);
		assertTrue(exist);
		
		
		
		
		
	}	

	
	
}
