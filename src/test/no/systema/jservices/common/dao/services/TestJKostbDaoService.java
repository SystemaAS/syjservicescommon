package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
	

	@Test
	public final void testCreateUpdateDelete() {
		//create
		KostbDao dao = kostbDaoService.create(getKostbDao());
		List<KostbDao> resultDaoList = kostbDaoService.findByKbbnr(dao.getKbbnr());
		KostbDao getDao = resultDaoList.get(0);		
		
		KostbDao resultDao = kostbDaoService.findByRRN(getDao.getRrn());
		assertNotNull(resultDao);
		
		//update
		resultDao.setKbfree("Fredrik was here.");
		KostbDao updatedDao = kostbDaoService.update(resultDao);
		assertNotNull(updatedDao);
		assertTrue(updatedDao.getKbfree().equals("Fredrik was here."));

		//delete
		resultDaoList = kostbDaoService.findByKbbnr(dao.getKbbnr());
		getDao = resultDaoList.get(0);		
		
		resultDao = kostbDaoService.findByRRN(getDao.getRrn());
		assertNotNull(resultDao);
		int rrn = updatedDao.getRrn();
		assertTrue(rrn > 0);
		kostbDaoService.delete(getDao);
		try {
			getDao = kostbDaoService.findByRRN(rrn);
			if (getDao != null) {
				fail("Should have been deleted.");
			}
		} catch (Exception e) {
			// expected
		}		
		
		
	}
	
	
	private KostbDao getKostbDao() {
		KostbDao dao = new KostbDao();
		dao.setKbbnr(666);
		dao.setKbblhb(new BigDecimal(50));
		dao.setKbkkey("0053483");
		dao.setKbblf(new BigDecimal(20.00));
		dao.setKbbuds(new BigDecimal(0.00));
		dao.setKbfree("TO_BE_DELETED");
		dao.setKbgeby(1);
		dao.setKbavd(1);
		dao.setKbkdm(1);
		dao.setKbkdmv("J");
		dao.setKbkdpf("P");
		dao.setKbkn(91);
		dao.setKBNØKK(1);
		dao.setKbopd(53483);
		dao.setKBPÅR(19);
		dao.setKbpcc(20);
		dao.setKbpmn(1);
		dao.setKbvk("FRA");
		
		dao.setKbbilt("x");
		dao.setKbbval("x");
		dao.setKbgod("x");
		dao.setKbrefa("x");
		dao.setKbrefb("x");		
		dao.setKbrefc("x");		
		dao.setKbrekl("x");
		dao.setKbsg("x");
		dao.setKbsgg("x");
		
		return dao;
		
	}
	
	public KostbDao getMiniKostbDao() {
		
		KostbDao dao = new KostbDao();
		
		dao.setKbfree("TO_BE_REMOVED");
		
		return dao;
		
	}
	
	
	
}
