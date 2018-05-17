package no.systema.jservices.common.dao.services;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.CundfDao;

public class TestJCundfDaoService {

	ApplicationContext context = null;
	CundfDaoService cundfDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		cundfDaoService = (CundfDaoService) context.getBean("cundfDaoService");
		
	}

	
	@Test
	public final void testFindAllInFirma() {
		List<CundfDao> list =  cundfDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindAllInFirmaWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", "1");
		List<CundfDao> list =  cundfDaoService.findAllInFirma(params);
		assertEquals(1, list.size());
	}		

}
