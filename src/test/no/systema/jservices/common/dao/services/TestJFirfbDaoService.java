package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

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
		FirfbDao dao = list.get(0);
		assertNotNull(dao);
	}

	@Test
	public final void testFind() {
		FirfbDao qDao = new FirfbDao();
		qDao.setFifirm("SY");
		FirfbDao resultDao =  firfbDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	
	@Test
	public final void testGetSendningsnummer() {
		List<FirfbDao> list =  firfbDaoService.findAll(null);
		FirfbDao dao = list.get(0);
		int prevFirecn = dao.getFirecn();
		
		String sendningsNr = firfbDaoService.getSendningsnr();
		System.out.println("sendningsNr="+sendningsNr);

		List<FirfbDao> list2 =  firfbDaoService.findAll(null);
		FirfbDao dao2= list2.get(0);	
		
		int updateFirecn = dao2.getFirecn();
		
		assertTrue(updateFirecn == (prevFirecn + 1));
		
		//Remmeber to update table back to org.
		
	}	
	
	
}
