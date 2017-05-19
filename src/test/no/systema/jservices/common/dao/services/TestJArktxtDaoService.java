package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ArktxtDao;

public class TestJArktxtDaoService {

	ApplicationContext context = null;
	ArktxtDaoService arktxtDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		arktxtDaoService = (ArktxtDaoService) context.getBean("arktxtDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = arktxtDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("artype", "fa");
		int count = arktxtDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<ArktxtDao> list =  arktxtDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	

	@Test
	public final void testExist() {
		ArktxtDao dao = new ArktxtDao();
		dao.setArtype("XX");
		boolean exist = arktxtDaoService.exist(dao);
		assertTrue(dao.getArtype() + " should not exist", !exist);
	}

	@Test
	public final void testUpdate() {
		ArktxtDao qDao = new ArktxtDao();
		qDao.setArtype("fa");;
		ArktxtDao resultDao = arktxtDaoService.find(qDao);
	
		boolean exist = arktxtDaoService.exist(resultDao);
		assertTrue(qDao.getArtype() + " should  exist", exist);				
				
		int arkdagBefore, arkdagAfter;

		arkdagBefore=resultDao.getArkdag();
		resultDao.setArkdag(22);
		ArktxtDao updatedDao = arktxtDaoService.update(resultDao);
		arkdagAfter=updatedDao.getArkdag();
		assertTrue("Arkdag should have been updated.", arkdagBefore == arkdagAfter);
		
	}

	@Test
	public final void testGetAllUploadbane() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("arsban", "NOT");
		List<ArktxtDao> listAll = arktxtDaoService.findAll(null);
		List<ArktxtDao> listUpload = arktxtDaoService.getAllUploadbane();
		assertTrue("listAll should contains more objects",listAll.size() > listUpload.size());		
		
	}
	
}
