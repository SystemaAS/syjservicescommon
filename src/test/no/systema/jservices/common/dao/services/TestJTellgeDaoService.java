package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.TellDao;

public class TestJTellgeDaoService {

	ApplicationContext context = null;
	TellDaoService tellDaoService = null;
	int teavd = 1;
	TellDao qDao = new TellDao();

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			tellDaoService = (TellDaoService) context.getBean("tellDaoService");
			qDao.setTeavd(teavd);
	}

	@Test
	public final void testExist() {
		boolean exist =  tellDaoService.exist(qDao);
		assertTrue(qDao.getTeavd() +" should exist",exist);
		
	}	
	
	@Test
	public final void testGetExistingTeopdnAndIncrement() {
		int existingTeopdn = tellDaoService.getExistingTeopdnAndIncrement(teavd);
		TellDao resultDao =  tellDaoService.find(qDao);
		int incrementedTeopdn = resultDao.getTeopdn();
		
		assertEquals("Should have been incremented with 1, updatedTeopdn="+incrementedTeopdn+",existingTeopdn="+existingTeopdn, 1, incrementedTeopdn - existingTeopdn);
		
		//Clean db
		tellDaoService.substractTeopdn(teavd);
		resultDao =  tellDaoService.find(qDao);
		int subtractedTeopdn = resultDao.getTeopdn();
		assertEquals("Should have been substracted with 1", existingTeopdn, subtractedTeopdn);
		
	}
	
	
}
