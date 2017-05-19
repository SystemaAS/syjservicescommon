package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.TariDao;

public class TestJTariDaoService {

	ApplicationContext context = null;
	TariDaoService tariDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		tariDaoService = (TariDaoService) context.getBean("tariDaoService");
	}

	@Test
	public final void testCountAll() {
		int count = tariDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tatanr", 77);
		int count = tariDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tatanr", 77);
		List<TariDao> list = tariDaoService.findAll(params);
		System.out.println( ReflectionToStringBuilder.toString(list.get(0)) );
		assertNotNull(list);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<TariDao> list = tariDaoService.findAll(params);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		TariDao qDao = new TariDao();
		qDao.setTatanr(42022900);
		TariDao resultDao = tariDaoService.find(qDao);
		assertEquals("Tatanr should be the same.",42022900, resultDao.getTatanr());
	}		
	
	@Test
	public final void testExist() {
		TariDao qDao = new TariDao();
		qDao.setTatanr(77);

		boolean exist = tariDaoService.exist(qDao);
		assertTrue(qDao.getTatanr() + " should exist", exist);

		qDao.setTatanr(0);
		exist = tariDaoService.exist(qDao);
		assertTrue(qDao.getTatanr() + " should not exist", !exist);

	}

}
