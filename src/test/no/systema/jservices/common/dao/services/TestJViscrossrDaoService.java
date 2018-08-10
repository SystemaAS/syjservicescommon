package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ViscrossrDao;

public class TestJViscrossrDaoService {

	ApplicationContext context = null;
	ViscrossrDaoService viscrossrDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		viscrossrDaoService = (ViscrossrDaoService) context.getBean("viscrossrDaoService");
		
		if (viscrossrDaoService.countAll() == 0) {
			createViscrossr();
		}
			
	}

	private void createViscrossr() {
		ViscrossrDao dao = new ViscrossrDao();
		dao.setSvsysp("1");
		dao.setSvvism("3");
		dao.setSvtype("CODE");

		
		ViscrossrDao result = viscrossrDaoService.create(dao);
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
		qDao.setSvtype("CODE");
		ViscrossrDao result =  viscrossrDaoService.find(qDao);
		assertNotNull(result);
	}		
	


	
}
