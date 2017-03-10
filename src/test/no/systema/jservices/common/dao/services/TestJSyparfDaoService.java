package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SyparfDao;
import no.systema.jservices.common.dao.TellgeDao;
import no.systema.jservices.common.values.FasteKoder;

public class TestJSyparfDaoService {

	ApplicationContext context = null;
	SyparfDaoService syparfDaoService = null;
	TellgeDaoService tellgeDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		syparfDaoService = (SyparfDaoService) context.getBean("syparfDaoService");
		tellgeDaoService = (TellgeDaoService) context.getBean("tellgeDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = syparfDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sykunr", 1);
		params.put("syrecn", 15);
		int count = syparfDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testExist() {
		SyparfDao dao = getSyparfDao();
		boolean exist = syparfDaoService.exist(dao);
		assertTrue(dao.getSykunr() + ", " + dao.getSyrecn() + " should not exist", !exist);
	}

	@Test
	public final void testCreateAndDelete() {
		SyparfDao dao = getSyparfDao();
		SyparfDao returnDao = syparfDaoService.create(dao);
		assertNotNull(returnDao);

		syparfDaoService.delete(dao);
		boolean exist = syparfDaoService.exist(dao);
		assertTrue(dao.getSykunr() + ", " + dao.getSyrecn() + " should not exist", !exist);

	}

	@Test
	public final void testUpdate() {
		SyparfDao getDao = getSyparfDao();
		boolean exist = syparfDaoService.exist(getDao);
		assertTrue(getDao.getSykunr() + ", " + getDao.getSyrecn() + " should not exist", !exist);

		SyparfDao createDao = syparfDaoService.create(getDao);
		createDao.setSyvrda("Kilroy was here.");

		SyparfDao updateDao = syparfDaoService.update(createDao);
		assertNotNull(updateDao);
		assertEquals("Dao have been updated.", updateDao.getSyvrda(), createDao.getSyvrda());

		// Clean DB
		syparfDaoService.delete(getDao); 
		exist = syparfDaoService.exist(getDao);
		assertTrue(getDao.getSykunr() + ", " + getDao.getSyrecn() + " should not exist", !exist);
	}
	
	@Test
	public final void testFindAll() {
		String sykunr = "1";
		List<SyparfDao> daoList = syparfDaoService.findAll(sykunr);
		assertNotNull(daoList);
		
	}	
	
	@Test
	public final void testFind() {
		String sykunr = "1";
		String syrecn = "14";
		SyparfDao dao = syparfDaoService.find(sykunr,syrecn);
		assertNotNull(dao);
	}	
	
	@SuppressWarnings("unused")
	@Test
	public final void testCreateAndDeleteRollbackCheck() {
		SyparfDao dao = getSyparfDao();
		dao.setSykunr("KALLE");  
		
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(FasteKoder.SYPAR.toString());
		TellgeDao tellgeDao =  tellgeDaoService.find(qDao);		
		int before = Integer.parseInt(tellgeDao.getGeno());
		
		try {
			SyparfDao returnDao = syparfDaoService.create(dao);
			assertTrue("Exception should have been thrown", false);
		} catch (Exception e) {
			assertTrue("RuntimeException should have been thrown",e instanceof RuntimeException );
		}

		tellgeDao =  tellgeDaoService.find(qDao);		
		int after = Integer.parseInt(tellgeDao.getGeno());
		assertEquals("Update of geco should have been rolledback",before, after); 
		
	}	
		
	private SyparfDao getSyparfDao() {
		SyparfDao dao = new SyparfDao();
		dao.setSykunr("0"); // key
		dao.setSyrecn("99");// key
		return dao;
	}

}
