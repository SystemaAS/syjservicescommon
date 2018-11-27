package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ViscrossrDao;
import no.systema.jservices.common.values.ViscrossrKoder;

public class TestJViscrossrDaoService {

	ApplicationContext context = null;
	ViscrossrDaoService viscrossrDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		viscrossrDaoService = (ViscrossrDaoService) context.getBean("viscrossrDaoService");
		
//		viscrossrDaoService.deleteAll(null);
		
//		createViscrossr();
			
	}

	private void createViscrossr() {
		ViscrossrDao dao = new ViscrossrDao();
		dao.setSvsysp("0");
		dao.setSvvism("0");
		dao.setSvtype(ViscrossrKoder.MVA_S.toString());

		
		viscrossrDaoService.create(dao);
	
		dao.setSvsysp("1");
		dao.setSvvism("1");
		dao.setSvtype(ViscrossrKoder.MK_NO.toString());	
		
		viscrossrDaoService.create(dao);
		
		dao.setSvsysp("3");
		dao.setSvvism("3");
		dao.setSvtype(ViscrossrKoder.MK.toString());	
		
		viscrossrDaoService.create(dao);		
		
	}	
	
	@Test
	public final void testCountAll() {
		int count = viscrossrDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<ViscrossrDao> list =  viscrossrDaoService.findAll(null);
		list.forEach(cr -> System.out.println("cr"+cr));
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testFind() {
		ViscrossrDao qDao = new ViscrossrDao();
		qDao.setSvsysp("1");
		qDao.setSvtype(ViscrossrKoder.MVA_S.toString());
		ViscrossrDao result =  viscrossrDaoService.find(qDao);
		assertNotNull(result);
	}		
	
	@Test
	public final void testGetVismaCodeId() {
		String result =  viscrossrDaoService.getVismaCodeId("0", ViscrossrKoder.MK_NO);
		assertNotNull(result);
	}	

	
}
