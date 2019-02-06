package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;
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

import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dao.KostbDao;

public class TestJKostbDaoService {

	ApplicationContext context = null;
	KostbDaoService kostbDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kostbDaoService = (KostbDaoService) context.getBean("kostbDaoService");
	}


	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kbbnr", 2001068);
		List<KostbDao> list = kostbDaoService.findAll(params);
		assertNotNull(list);
		System.out.println("list.size="+list.size());
		assertTrue("list should be = 1",list.size() == 1);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		List<KostbDao> list = kostbDaoService.findAll(null);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		KostbDao qDao = new KostbDao();
		qDao.setRrn(2);
		KostbDao resultDao = kostbDaoService.find(qDao);
		assertNotNull(resultDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		assertEquals("kbbnr should be the same.",2001068, resultDao.getKbbnr());
	}		

	@Test
	public final void testFindByKabnr() {
		List<KostbDao> resultDao = kostbDaoService.findByKbbnr(2001075);
		assertNotNull(resultDao);

		resultDao.forEach(kb -> {
			assertNotNull(kb.getRrn());
			System.out.println("rrn="+kb.getRrn());
			
		});
		
	}		

	
	@Test
	public final void testFindByRNN() {
		KostbDao resultDao = kostbDaoService.findByRRN(2);
		assertNotNull(resultDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
	}		
	
	@Test
	public final void testFindKbbnrAndByRNN() {
		List<KostbDao> resultDaoList = kostbDaoService.findByKbbnr(2001075);
		assertNotNull(resultDaoList);	

		resultDaoList.forEach(kb -> {
			assertNotNull(kb.getRrn());
	
			KostbDao resultDao = kostbDaoService.findByRRN(kb.getRrn());
			assertNotNull(resultDao);
			
			assertEquals(kb.getKbblhb(), resultDao.getKbblhb());
			assertEquals(kb.getKbavd(), resultDao.getKbavd());
			assertEquals(kb.getKbkkey(), resultDao.getKbkkey());
			
		});		
		
	}		
	
	@Test
	public final void testCalcFordelt() {
		List<KostbDao> resultDao = kostbDaoService.findByKbbnr(2001114);
		assertNotNull(resultDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		
		double fordelt  = kostbDaoService.getFordelt(2001114);

		System.out.println("fordelt="+fordelt);
		
	}	
	
}
