package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
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
import no.systema.jservices.common.dto.KostaDto;

public class TestJKostaDaoService {

	ApplicationContext context = null;
	KostaDaoService kostaDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		kostaDaoService = (KostaDaoService) context.getBean("kostaDaoService");
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
		qDto.setKabnr(2001072);
		qDto.setKbrekl("");
		List<KostaDao> resultList = kostaDaoService.findAllComplex(qDto);
		resultList.forEach(dao -> {
			System.out.println("resultDao="+ReflectionToStringBuilder.toString(dao));
		});
		assertEquals("Should be size 2",2, resultList.size());
		assertEquals("kabnr should be the same.",Integer.valueOf(2001072), resultList.get(0).getKabnr());
		
	}	
	
	
	
}
