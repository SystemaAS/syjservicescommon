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

import no.systema.jservices.common.dao.FirmvisDao;

public class TestJFirmvisDaoService {

	ApplicationContext context = null;
	FirmvisDaoService firmvisDaoService = null;
	String firmaColumnName = "vifirm";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		firmvisDaoService = (FirmvisDaoService) context.getBean("firmvisDaoService");
		
		if (firmvisDaoService.countAll() == 0) {
			createFirmalt();
		}
		
			
	}

	private void createFirmalt() {
		FirmvisDao dao = new FirmvisDao();

		dao.setVifirm("SY");
		dao.setVibapa("https://integration.visma.net/API");
		dao.setViapty("Visma.net Financials");
//		dao.setViacto(TO BE SET AUTOMAGISKT);  AUTHORIZATION_CODE
//		dao.setViauco(TO BE SET AUTOMAGISKT);  ACCESSTOKEN
		dao.setViclid("systema_as_test_hf6sjf9");
		dao.setViclse("cd81dbac-7bcb-40f1-8f6b-5fd781483250");
		
		FirmvisDao result = firmvisDaoService.create(dao);
	}	
	
	@Test
	public final void testCountAll() {
		int count = firmvisDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testFindAll() {
		List<FirmvisDao> list =  firmvisDaoService.findAll(null);
		list.forEach(firma -> System.out.println("firma"+firma));
		assertNotNull(list);
	}		
	
	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("vicoid", "1684147");
		List<FirmvisDao> list =  firmvisDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find only one tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<FirmvisDao> list =  firmvisDaoService.findAllInFirma(null, firmaColumnName);
		list.forEach(firma -> System.out.println("firma"+firma));
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		FirmvisDao dao = new FirmvisDao();
//		dao.setVicoid("1684147");
		boolean exist = firmvisDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getVifirm() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		FirmvisDao dao = new FirmvisDao();
//		dao.setVicoid("1684147");
		FirmvisDao resultDao = firmvisDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	@Test
	public final void testGet() {
		FirmvisDao resultDao = firmvisDaoService.get();
		assertNotNull(resultDao);
	}	

	
}
