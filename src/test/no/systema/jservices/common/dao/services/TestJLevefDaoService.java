package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KodtsfDao;
import no.systema.jservices.common.dao.LevefDao;

public class TestJLevefDaoService {

	ApplicationContext context = null;
	LevefDaoService levefDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		levefDaoService = (LevefDaoService) context.getBean("levefDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = levefDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levnr", 44);
		int count = levefDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<LevefDao> list =  levefDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levnr", 44);
		List<LevefDao> list =  levefDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find 1 tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<LevefDao> list =  levefDaoService.findAllInFirma(null, firmaColumnName);
		
//		list.forEach(vk -> System.out.println(vk));
		
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		LevefDao dao = new LevefDao();
		dao.setLevnr(44);
		boolean exist = levefDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getKundnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		LevefDao dao = new LevefDao();
		dao.setLevnr(44);
		LevefDao resultDao = levefDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	@Test
	public final void testFindByLike() {
		String lnavn = "transport";

		List<LevefDao> resultList = levefDaoService.findByLike(lnavn);
		
		resultList.forEach(dao -> System.out.println("dao.getLnavn()="+dao.getLnavn()));
		
		assertFalse(resultList.isEmpty());
	}	
	
	
	
}
