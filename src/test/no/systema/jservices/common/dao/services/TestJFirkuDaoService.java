package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.FirkuDao;

public class TestJFirkuDaoService {

	ApplicationContext context = null;
	FirkuDaoService firkuDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		firkuDaoService = (FirkuDaoService) context.getBean("firkuDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = firkuDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<FirkuDao> list =  firkuDaoService.findAll(null);
		FirkuDao dao = list.get(0);
		assertNotNull(dao);
	}

	@Test
	public final void testFind() {
		FirkuDao qDao = new FirkuDao();
		qDao.setFifirm("SY");
		FirkuDao resultDao =  firkuDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	@Test
	public final void testGet() {
		FirkuDao resultDao =  firkuDaoService.get();
		assertNotNull(resultDao);
	}		
	
}
