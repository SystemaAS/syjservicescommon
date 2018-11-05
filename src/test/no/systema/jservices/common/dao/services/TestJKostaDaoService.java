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
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dao.KosttDao;
import no.systema.jservices.common.dto.KostaDto;

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
		qDao.setKabnr(2001072);
		KostaDao resultDao = kostaDaoService.find(qDao);
		System.out.println("resultDao="+ReflectionToStringBuilder.toString(resultDao));
		assertEquals("kabnr should be the same.",Integer.valueOf(2001072), resultDao.getKabnr());
	}		

	@Test
	public final void testFindAllComplex() {
		KostaDto qDto = new KostaDto();
		qDto.setKabnr(2001073);
		qDto.setKabnr2(0);
		qDto.setKbrekl("");
		qDto.setFskode("URG");
		qDto.setFssok("FREDRIK");
		qDto.setKasg("FM");
		qDto.setKafnr("12345689");
		qDto.setKabdt(20181004);
		List<KostaDao> resultList = kostaDaoService.findAllComplex(qDto);
		resultList.forEach(dao -> {
			System.out.println("resultDao="+ReflectionToStringBuilder.toString(dao));
		});
		assertEquals("Should be size 1",1, resultList.size());
		assertEquals("kabnr should be the same.",Integer.valueOf(2001073), resultList.get(0).getKabnr());
		
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
	
	
	
}
