package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.TellgeDao;
import no.systema.jservices.common.values.FasteKoder;

public class TestJTellgeDaoService {

	ApplicationContext context = null;
	TellgeDaoService tellgeDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			tellgeDaoService = (TellgeDaoService) context.getBean("tellgeDaoService");
	}

	@Test
	public final void testExist() {
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(FasteKoder.SYPAR.toString());
		
		boolean exist =  tellgeDaoService.exist(qDao);
		assertTrue(qDao.getGeco() +" should exist",exist);
		
	}	
	
	@Test
	public final void testGetGenoAndIncrement() {
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(FasteKoder.SYPAR.toString());
		
		TellgeDao resultDao =  tellgeDaoService.find(qDao);
		
		int geno = tellgeDaoService.getGenoAndIncrement("SYPAR");
		int genoUpdated = Integer.parseInt(resultDao.getGeno()) + 1;
		assertEquals("Should have been incremented with 1", genoUpdated, geno);
		
		//Clean db
		tellgeDaoService.substractGeno("SYPAR");
		resultDao =  tellgeDaoService.find(qDao);
		genoUpdated = Integer.parseInt(resultDao.getGeno());
		assertEquals("Should have been substracted with 1", genoUpdated, geno -1);
		
	}

	
}
