package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dao.KosttDao;
import no.systema.jservices.common.dto.KostaDto;
import no.systema.jservices.common.util.DateTimeManager;

public class TestJKostaDaoService {

	ApplicationContext context = null;
	KostaDaoService kostaDaoService = null;
	KosttDaoService kosttDaoService = null;

	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kostaDaoService = (KostaDaoService) context.getBean("kostaDaoService");
		kosttDaoService = (KosttDaoService) context.getBean("kosttDaoService");
	}


	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kabnr", 2000972);
		List<KostaDao> list = kostaDaoService.findAll(params);
		assertNotNull(list);
		System.out.println("list.size="+list.size());
		assertTrue("list should be = 1",list.size() == 1);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		List<KostaDao> list = kostaDaoService.findAll(null);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		KostaDao qDao = new KostaDao();
		qDao.setKabnr(2001068);
		KostaDao resultDao = kostaDaoService.find(qDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		System.out.println("kast="+ resultDao.getKast());

		assertEquals("kabnr should be the same.",Integer.valueOf(2001068), resultDao.getKabnr());
	}		

	@Test
	public final void testFindAllComplex() {
		KostaDao qDao = new KostaDao();
		Integer kabnr = new Integer(2001087);
		Integer kabnr2 = new Integer(0);
		Integer kalnr = new Integer(1);
	
//		String kabnr = "2001087";
//		String kabnr2 = null;
//		String kalnr = "1";

		
		qDao.setKabnr(kabnr);
		qDao.setKabnr2(kabnr2);
		qDao.setKafnr("123");
		qDao.setKalnr(kalnr);
		qDao.setKasg(null);
		qDao.setKatxt("gr");
		qDao.setKabdt(null);
//		qDao.setKbrekl(null);
		String reklamsjon = null;
		qDao.setKast(null);
//		qDao.setFskode(null);
		String fskode = null;
//		qDao.setFssok(null);
		String fssok = null;
		List<KostaDao> resultList = kostaDaoService.findAllComplex(qDao, reklamsjon, fskode, fssok);
		resultList.forEach(dao -> {
			System.out.println("resultDao="+ReflectionToStringBuilder.toString(dao));
		});
		assertEquals("Should be size 1",1, resultList.size());
		assertEquals("kabnr should be the same.",kabnr, resultList.get(0).getKabnr());
		
	}
	

	@Test
	public final void testUpdate() {
		KostaDao qDao = new KostaDao();
		qDao.setKabnr(2001072);
		KostaDao resultDao = kostaDaoService.find(qDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		assertEquals("kabnr should be the same.",Integer.valueOf(2001072), resultDao.getKabnr());
		
		KostaDao updateDao = resultDao; 
		updateDao.setKAPÅR(99);
		kostaDaoService.update(updateDao);
		
		resultDao = kostaDaoService.find(qDao);
		assertEquals("KAPÅR should be the same.",Integer.valueOf(99), resultDao.getKAPÅR());
		
	}		

	@Test
	public final void testtestDelete() {
		KostaDao dao = new KostaDao();
		dao.setKabnr(999);
		kostaDaoService.delete(dao);
	}	
	
	
	@Test
	public final void testCreateAndDelete() {
		KostaDao dao = new KostaDao();
		KosttDao qDao = new KosttDao();
		qDao.setKttyp("Å");
		KosttDao kosttDao = kosttDaoService.find(qDao);
		KostaDao resultDao = kostaDaoService.create(dao, kosttDao.getKttyp());
		System.out.println("kosttDao="+ReflectionToStringBuilder.toString(kosttDao));
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		//Sanity check, also tested in TestJKosttDaoService
		kosttDao = kosttDaoService.find(qDao);
		assertNotEquals("kabnr should NOT be the same.",resultDao.getKabnr(), kosttDao.getKtnr());
		//

		KostaDao updateDao = resultDao; 
		updateDao.setKAPÅR(99);
		updateDao.setKamva("x");
		updateDao.setKabl(new BigDecimal(-12.0));
		kostaDaoService.update(updateDao);
		
		resultDao = kostaDaoService.find(updateDao);
		assertEquals("KAPÅR should be the same.",Integer.valueOf(99), updateDao.getKAPÅR());
		
		//cleanup
		kostaDaoService.delete(updateDao);
		try {
			resultDao = kostaDaoService.find(updateDao);
			if (resultDao != null) {
				fail("Should have been deleted.");
			}
		} catch (Exception e) {
			// expected
		}
		
	}		
	
	@Test
	public final void testGetKosta() {
		KostaDao qDao = new KostaDao();
		qDao.setKabnr(2001102);
		KostaDao resultDao = kostaDaoService.find(qDao);
		System.out.println("resultDao.getKadte()="+resultDao.getKadte());
		System.out.println("resultDao.getKatxt()="+resultDao.getKatxt());
		
		KostaDto dto = KostaDto.get(resultDao);
		System.out.println("dto.getOpp_dato()="+dto.getOpp_dato());
		System.out.println("dto.getKatxt()="+dto.getKatxt());

		
		Assert.assertEquals(dto.getOpp_dato(), resultDao.getKadte());
		
		
		
	}
		
		
}
