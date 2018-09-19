package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KosttDao;
import no.systema.jservices.common.values.KosttTyper;

public class TestJKosttDaoService {

	ApplicationContext context = null;
	KosttDaoService kosttDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kosttDaoService = (KosttDaoService) context.getBean("kosttDaoService");
	}

	@Test
	public final void testExist() {
		KosttDao qDao = new KosttDao();
		qDao.setKttyp(KosttTyper.Å.toString());
		
		boolean exist =  kosttDaoService.exist(qDao);
		assertTrue(qDao.getKttyp() +" should exist",exist);
		
	}	
	
	@Test
	public final void testExistingKtnrAndIncrement() {
		KosttDao qDao = new KosttDao();
		qDao.setKttyp(KosttTyper.Ø.toString());
		KosttDao resultDao =  kosttDaoService.find(qDao);
		
		int ktnr = kosttDaoService.getExistingKtnrAndIncrement(KosttTyper.Ø.toString());
		assertEquals("Should be the same", ktnr, resultDao.getKtnr());

		resultDao =  kosttDaoService.find(qDao);
		assertEquals("Should have been incremented with 1", ktnr + 1, resultDao.getKtnr());
		
		//Clean db
		kosttDaoService.substractKtnr(KosttTyper.Ø.toString());
		resultDao =  kosttDaoService.find(qDao);
		assertEquals("Should have been substracted with 1", ktnr, resultDao.getKtnr());
		
	}


	
}
