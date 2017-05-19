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

import no.systema.jservices.common.dao.KodtftDao;
import no.systema.jservices.common.dao.KodtsbDao;

public class TestJKodtftDaoService {

	ApplicationContext context = null;
	KodtftDaoService kodtftDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			kodtftDaoService = (KodtftDaoService) context.getBean("kodtftDaoService");
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfttyp", "AA");
		
		int count  =  kodtftDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfttyp", "AA");
		List<KodtftDao> list =  kodtftDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		KodtftDao qDao = new KodtftDao();
		qDao.setKfttyp("AA");
		qDao.setKftln(1);
		
		boolean exist =  kodtftDaoService.exist(qDao);
		assertTrue(qDao.getKfttyp() +" should exist",exist);
		
		qDao.setKfttyp("xx");
		exist =  kodtftDaoService.exist(qDao);
		assertTrue(qDao.getKfttyp() +" should not exist",!exist);
		
	}
	
	public final void testKfttypExist() {
		boolean exist =  kodtftDaoService.kfttypExist("AA");
		assertTrue("AA should exist",exist);
		
		exist =  kodtftDaoService.kfttypExist("xx");
		assertTrue("xx should not exist",!exist);
		
	}	
	
}
