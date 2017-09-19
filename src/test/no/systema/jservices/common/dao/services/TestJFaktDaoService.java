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

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dto.FaktDto;

public class TestJFaktDaoService {

	ApplicationContext context = null;
	FaktDaoService faktDaoService = null;
	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			faktDaoService = (FaktDaoService) context.getBean("faktDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  faktDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCount2017() {
		List<FaktDao> list  =  faktDaoService.getYear(2017);
		assertNotNull(list.size());
	}		
	
	@Test
	public final void testCountOnService() {
		int year = 2017;
		List<FaktDto> list  =  faktDaoService.getYearSumGroupAvdOpdDato(year);
		System.out.println("list.size()="+list.size());
		assertNotNull(list.size());
	}		
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("faavd", 1);
		int count  =  faktDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("faavd", 1);
		List<FaktDao> list =  faktDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAll() {
		List<FaktDao> list =  faktDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFind() {
		FaktDao qDao = new FaktDao();
		qDao.setFaavd(1);
		qDao.setFali(1);
		qDao.setFaopd(773587);
		FaktDao resultDao=  faktDaoService.find(qDao);
		assertNotNull(resultDao);
	}	
	
	@Test
	public final void testExist() {
		FaktDao qDao = new FaktDao();
		qDao.setFaavd(1);
		qDao.setFali(1);
		qDao.setFaopd(773587);
		boolean exist =  faktDaoService.exist(qDao);
		assertTrue(qDao.getFaavd()+":"+qDao.getFali()+":"+qDao.getFaopd()+" should exist",exist);
		
		qDao.setFaavd(0);
		qDao.setFali(0);
		qDao.setFaopd(1);
		exist =  faktDaoService.exist(qDao);
		assertTrue(qDao.getFaavd()+":"+qDao.getFali()+":"+qDao.getFaopd()+" should not exist",!exist);
		
	}	
	
	
}
