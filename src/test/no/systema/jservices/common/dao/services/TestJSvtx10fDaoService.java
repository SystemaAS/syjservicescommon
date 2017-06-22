package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.Svtx10fDao;

public class TestJSvtx10fDaoService {

	ApplicationContext context = null;
	Svtx10fDaoService svtx10fDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svtx10fDaoService = (Svtx10fDaoService) context.getBean("svtx10fDaoService");
	}

	@Test
	public final void testGetTaricExportNumber() {
		List<Svtx10fDao> list = svtx10fDaoService.getTaricExportNumbers();
		assertNotNull(list);
	}		
	
	@Test
	public final void testExportNrExist() {
		boolean exist = svtx10fDaoService.tariExportNrExist("01012100");
		assertTrue("01012100 should exist.", exist);
		
		exist = svtx10fDaoService.tariExportNrExist("0102295919");
		assertTrue("0102295919 should not exist.", !exist);	
		
		
	}		
	
	@Test
	public final void testImportNrExist() {
		boolean exist = svtx10fDaoService.taricImportNrExist("0102295919");
		assertTrue("0102295919 should exist.", exist);
		
		exist = svtx10fDaoService.tariExportNrExist("999");
		assertTrue("999 should not exist.", !exist);	
		
		
	}		
	
}
