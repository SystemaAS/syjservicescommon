package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ibm.as400.access.AS400SecurityException;

import no.systema.jservices.common.dao.Sted2Dao;

public class TestJSted2DaoService {

	ApplicationContext context = null;
	Sted2DaoService sted2DaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		sted2DaoService = (Sted2DaoService) context.getBean("sted2DaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = sted2DaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<Sted2Dao> list =  sted2DaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		Sted2Dao dao = new Sted2Dao();
		dao.setSt2kod("8000");
		dao.setSt2lk("NO");
		boolean exist = sted2DaoService.exist(dao );
		assertTrue(dao.getSt2kod() + ", " + dao.getSt2lk() + " should exist", exist);

		dao.setSt2lk("DK");
		exist = sted2DaoService.exist(dao );
		assertTrue(dao.getSt2kod() + ", " + dao.getSt2lk() + " should exist", exist);

		
	}

	@Test
	public final void testFind() {
		Sted2Dao dao = new Sted2Dao();
		dao.setSt2kod("8000");
		dao.setSt2lk("NO");
		Sted2Dao resultDao = sted2DaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	@Test
	public final void testFindByLike() {
		List<Sted2Dao> list = sted2DaoService.findByLike("1");
		assertNotNull(list);
		assertTrue(list.size() > 1);
		
		list = sted2DaoService.findByLike("8000");
		assertNotNull(list);
		assertEquals(4, list.size());		
		
	}
	
	@Test
	public final void testFindByLike2() {
		List<Sted2Dao> list = sted2DaoService.findByLike("00");
		assertNotNull(list);
		assertTrue(list.size() > 1);
		
	}	
	
	
	
	
}
