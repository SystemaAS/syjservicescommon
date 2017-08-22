package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.FirfbDao;

public class TestJFirfbDaoService {

	ApplicationContext context = null;
	FirfbDaoService firfbDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		firfbDaoService = (FirfbDaoService) context.getBean("firfbDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = firfbDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<FirfbDao> list =  firfbDaoService.findAll(null);
		assertNotNull(list);
	}

	@Test
	public final void testFind() {
		FirfbDao qDao = new FirfbDao();
		qDao.setFifirm("SY");
		FirfbDao resultDao =  firfbDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	
}
