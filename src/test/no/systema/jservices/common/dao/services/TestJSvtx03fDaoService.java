package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.Svtx03fDao;
import no.systema.jservices.common.values.Svtx03fKodTyper;

public class TestJSvtx03fDaoService {

	ApplicationContext context = null;
	Svtx03fDaoService svtx03fDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svtx03fDaoService = (Svtx03fDaoService) context.getBean("svtx03fDaoService");
	}

	@Test
	public final void testCountAll() {
		int count = svtx03fDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svtx03_02", Svtx03fKodTyper.GCY);
		int count = svtx03fDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svtx03_03", "BO");
		List<Svtx03fDao> list = svtx03fDaoService.findAll(params);
		assertNotNull(list);
	}
	
	@Test
	public final void testFind() {
		Svtx03fDao qDao = new Svtx03fDao();
		qDao.setSvtx03_01("A");
		qDao.setSvtx03_02(Svtx03fKodTyper.GCY.toString());
		qDao.setSvtx03_03("BO");
		
		Svtx03fDao resultDao = svtx03fDaoService.find(qDao);
		assertEquals("Id should be the same.","BO", resultDao.getSvtx03_03());
	}		
	
	@Test
	public final void testExist() {
		Svtx03fDao qDao = new Svtx03fDao();
		qDao.setSvtx03_01("A");
		qDao.setSvtx03_02(Svtx03fKodTyper.GCY.toString());
		qDao.setSvtx03_03("BO");

		boolean exist = svtx03fDaoService.exist(qDao);
		assertTrue(qDao.getSvtx03_03() + " should exist", exist);

		qDao.setSvtx03_01("A");
		qDao.setSvtx03_02(Svtx03fKodTyper.GCY.toString());
		qDao.setSvtx03_03("BOSSE");
		exist = svtx03fDaoService.exist(qDao);
		assertTrue(qDao.getSvtx03_03() + " should not exist", !exist);

	}
	
	@Test
	public final void testGetLandKoder() {
		List<Svtx03fDao> list = svtx03fDaoService.getLandKoder();
		assertNotNull(list);	
	}	
	
	@Test
	public final void testGetEup2Koder() {
		List<Svtx03fDao> list = svtx03fDaoService.getEup2Koder();
		assertNotNull(list);	
	}		

	@Test
	public final void testGetKollislagKoder() {
		List<Svtx03fDao> list = svtx03fDaoService.getKollislagKoder();
		assertNotNull(list);	
	}		
	
	
	@Test
	public final void testLandKodeExist() {
		boolean exist = svtx03fDaoService.landKodeExist("BO");
		assertTrue("BO should exist", exist);

		exist = svtx03fDaoService.landKodeExist("XX");
		assertTrue("XX should NOT exist", !exist);
		
	}	
	
	@Test
	public final void testEup2Exist() {
		boolean exist = svtx03fDaoService.eup2Exist("A01");
		assertTrue("A01 should exist", exist);

		exist = svtx03fDaoService.eup2Exist("XX");
		assertTrue("XX should NOT exist", !exist);
		
	}	
	
	@Test
	public final void testKollislagExist() {
		boolean exist = svtx03fDaoService.kollislagExist("4C");
		assertTrue("4C should exist", exist);

		exist = svtx03fDaoService.kollislagExist("XX");
		assertTrue("XX should NOT exist", !exist);
		
	}	

}
