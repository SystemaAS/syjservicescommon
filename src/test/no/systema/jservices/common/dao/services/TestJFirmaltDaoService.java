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

import no.systema.jservices.common.dao.FirmaltDao;

public class TestJFirmaltDaoService {

	ApplicationContext context = null;
	FirmaltDaoService firmaltDaoService = null;
	String firmaColumnName = "aifirm";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		firmaltDaoService = (FirmaltDaoService) context.getBean("firmaltDaoService");
		
		if (firmaltDaoService.countAll() == 0) {
			createFirmalt();
		}
		
			
	}

	private void createFirmalt() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SY");
		dao.setAiorg("810514442");  //BAREK OG YTTERV...
		dao.setAipwd("KRw16s7XVQuyA3ed"); //BAREK OG YTTERV...
		dao.setAipath("/usr/local/Cellar/tomcat/8.0.33/libexec/webapps/syjservicestn/WEB-INF/resources/files/");
		dao.setAiapi("D26F6857-3ADF-46D4-81DD-F5C87978C807");  //systema test
		dao.setAiuser("kalleanka1");  //BAREK OG YTTERV...
		dao.setAiupwd("kalleanka2");  //BAREK OG YTTERV...
		
		FirmaltDao result = firmaltDaoService.create(dao);
	}

	@Test
	public final void testCountAll() {
		int count = firmaltDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<FirmaltDao> list =  firmaltDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("aifirm", "SY");
		List<FirmaltDao> list =  firmaltDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find only one tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<FirmaltDao> list =  firmaltDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SY");
		boolean exist = firmaltDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getAifirm() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SY");
		FirmaltDao resultDao = firmaltDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
}
