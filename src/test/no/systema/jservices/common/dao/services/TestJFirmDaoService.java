package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.FirmDao;

public class TestJFirmDaoService {

	ApplicationContext context = null;
	FirmDaoService firmDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		firmDaoService = (FirmDaoService) context.getBean("firmDaoService");
	}


	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fifirm", "SY");
		List<FirmDao> list = firmDaoService.findAll(params);
		assertNotNull(list);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<FirmDao> list = firmDaoService.findAll(params);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		FirmDao qDao = new FirmDao();
		qDao.setFifirm("SY");
		FirmDao resultDao = firmDaoService.find(qDao);
		assertEquals("fifirma should be the same.","SY", resultDao.getFifirm());
	}		
	
}
