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

import no.systema.jservices.common.dao.DktseDao;

public class TestJDktseDaoService {

	ApplicationContext context = null;
	DktseDaoService dktseDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			dktseDaoService = (DktseDaoService) context.getBean("dktseDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  dktseDaoService.countAll();
		assertNotNull(count);
		
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dkse_knr", "0");
		//params.put("dkse_331", "6505059090");	
		int count  =  dktseDaoService.countAll(params);  
		assertNotNull(count);
		System.out.println(count);
	}		

	
	
	@Test
	public final void testExist() {
		DktseDao dao = new DktseDao();
		dao.setDkse_knr("0");
		//dao.setDkse_331("6505059090");	

		boolean exist =  dktseDaoService.exist(dao);
		//System.out.println(exist);
		assertTrue("XXX",!exist);
	}
	
	@Test
	public final void testCreateAndDelete() {
		DktseDao dao = getDktseDao();
		DktseDao returnDao =  dktseDaoService.create(dao);
		assertNotNull(returnDao);

		dktseDaoService.delete(dao);
		boolean exist =  dktseDaoService.exist(dao);
		assertTrue(dao.getDkse_knr()+" should not exist",!exist);
		
	}	
	
	@Test
	public final void testUpdate() {
		DktseDao getDao =  new DktseDao();
		
		boolean exist =  dktseDaoService.exist(getDao);
		assertTrue(getDao.getDkse_knr()+ " should not exist",!exist);		
		
		DktseDao createDao = dktseDaoService.create(getDao);
		createDao.setDkse_knr("99");
		
		DktseDao updateDao = dktseDaoService.update(createDao);
		assertNotNull(updateDao);
		assertEquals("Dao have been updated.", updateDao.getDkse_knr(), createDao.getDkse_331());
		
		dktseDaoService.delete(getDao); //Clean DB
		exist =  dktseDaoService.exist(getDao);
		assertTrue(getDao.getDkse_knr()+" 99 should not exist",!exist);		
	}
	
	@Test
	public final void testDeleteAll() {
		DktseDao getDao =  getDktseDao();
		getDao.setDkse_knr("99");
		
		dktseDaoService.create(getDao);
		dktseDaoService.delete(getDao); //Clean DB
		
		boolean exist =  dktseDaoService.exist(getDao);
		assertTrue(getDao.getDkse_knr()+" Should not exist",!exist);	
	
		
	}
	
	private DktseDao getDktseDao() {
		DktseDao dao = new DktseDao();
		dao.setDkse_knr("99");
		dao.setDkse_331("7701000077");
		dao.setDkse_34("NO");
		dao.setDkse_4421("Y900");
		dao.setDkse_442A("XXXX");
		return dao;
	}
	
	
}
