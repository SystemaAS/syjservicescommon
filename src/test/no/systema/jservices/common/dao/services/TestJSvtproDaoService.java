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

import no.systema.jservices.common.dao.SvtproDao;

public class TestJSvtproDaoService {

	ApplicationContext context = null;
	SvtproDaoService svtproDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svtproDaoService = (SvtproDaoService) context.getBean("svtproDaoService");
	}

	@Test
	public final void testFindAllWithoutParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SvtproDao> list = svtproDaoService.findAll(params);
		assertNotNull(list);
	}
	
	@Test
	public final void testExist() {
		boolean exist = svtproDaoService.svpr_prExist("1000");
		assertTrue("1000 should exist.", exist);
		
		exist = svtproDaoService.svpr_prExist("XXX");
		assertTrue("XXX should not exist.", !exist);	
		
	}		
	
}
