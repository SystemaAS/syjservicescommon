package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.FratxtDao;

public class TestJFratxtDaoService {

	ApplicationContext context = null;
	FratxtDaoService fratxtDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			fratxtDaoService = (FratxtDaoService) context.getBean("fratxtDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  fratxtDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fxknr", 0);
		params.put("fxlnr", 100);
		params.put("delsys", "A");		
		int count  =  fratxtDaoService.countAll(params);  
		assertNotNull(count);
	}		

	
	@Test
	public final void testGetDelsys() {
		String fxknr = "24";
		String delsys = "A";
		List<FratxtDao> list =  fratxtDaoService.getDelsys(fxknr, delsys);  
		assertNotNull(list);
	}		
	
	
	
	@Test
	public final void testExist() {
		FratxtDao dao = new FratxtDao();
		dao.setFxknr("0");
		dao.setFxlnr("99");
		dao.setDelsys("A");		

		boolean exist =  fratxtDaoService.exist(dao);		
		assertTrue("24, 99 should not exist",!exist);
	}
	
	@Test
	public final void testCreateAndDelete() {
		FratxtDao dao = getFratxtDao();
		FratxtDao returnDao =  fratxtDaoService.create(dao);
		assertNotNull(returnDao);

		fratxtDaoService.delete(dao);
		boolean exist =  fratxtDaoService.exist(dao);
		assertTrue(dao.getFxknr()+" 99 should not exist",!exist);
		
	}	
	
	@Test
	public final void testUpdate() {
		FratxtDao getDao =  getFratxtDao();
		
		boolean exist =  fratxtDaoService.exist(getDao);
		assertTrue(getDao.getFxknr()+ " should not exist",!exist);		
		
		FratxtDao createDao = fratxtDaoService.create(getDao);
		createDao.setFxtxt("Kilroy was here.");
		
		FratxtDao updateDao = fratxtDaoService.update(createDao);
		assertNotNull(updateDao);
		assertEquals("Dao have been updated.", updateDao.getFxtxt(), createDao.getFxtxt());
		
		fratxtDaoService.delete(getDao); //Clean DB
		exist =  fratxtDaoService.exist(getDao);
		assertTrue(getDao.getFxknr()+" 99 should not exist",!exist);		
	}
	
	@Test
	public final void testDeleteAll() {
		FratxtDao getDao1 =  getFratxtDao();
		FratxtDao getDao2 =  getFratxtDao();
		getDao2.setFxlnr("98");
		
		fratxtDaoService.create(getDao1);
		fratxtDaoService.create(getDao2);
		
		fratxtDaoService.delete(getDao1); //Clean DB
		fratxtDaoService.delete(getDao2); //Clean DB
		
		boolean exist =  fratxtDaoService.exist(getDao1);
		assertTrue(getDao1.getFxknr()+" 99 should not exist",!exist);	
		exist =  fratxtDaoService.exist(getDao2);
		assertTrue(getDao2.getFxknr()+" 99 should not exist",!exist);		
		
	}
	
	
	
	private FratxtDao getFratxtDao() {
		FratxtDao dao = new FratxtDao();
		dao.setFxknr("0");
		dao.setFxlnr("99");
		dao.setDelsys("A");
		dao.setFxtxt("txt");
		dao.setFxdt("0");
		return dao;
	}
	
	
}
