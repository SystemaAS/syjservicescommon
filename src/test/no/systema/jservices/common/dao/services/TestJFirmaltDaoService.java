package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
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

/*
	//localhost:8080 SY
	private void createFirmalt() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SY");
		dao.setAiorg("810514442");  //BAREK OG YTTERV...
		dao.setAipwd("KRw16s7XVQuyA3ed"); //BAREK OG YTTERV...
		dao.setAipath("/usr/local/Cellar/tomcat/8.0.33/libexec/webapps/altinn-proxy/WEB-INF/resources/files/");
		dao.setAiapi("D26F6857-3ADF-46D4-81DD-F5C87978C807");  //systema test
		dao.setAiuser("kalleanka1");  //BAREK OG YTTERV...
		dao.setAiupwd("kalleanka2");  //BAREK OG YTTERV...
		dao.setAihost("tt02.altinn.no"); 
		dao.setAiauur("/api/authentication/authenticatewithpassword");
		
		FirmaltDao result = firmaltDaoService.create(dao);
	}
*/	
	

	//gw.systema.no:8080 SY
	private void createFirmalt() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SY");
		dao.setAiorg("810514442");  //BAREK OG YTTERV...
		dao.setAipwd("KRw16s7XVQuyA3ed"); //BAREK OG YTTERV...
		dao.setAipath("/SYSPED/ALTINN/DAGSOPPGJOR/"); 
		dao.setAiapi("D26F6857-3ADF-46D4-81DD-F5C87978C807");  //Systema test
		dao.setAiuser("kalleanka1");  //BAREK OG YTTERV...
		dao.setAiupwd("kalleanka2");  //BAREK OG YTTERV...
		dao.setAihost("tt02.altinn.no"); 
		dao.setAiauur("/api/authentication/authenticatewithpassword");
		
		FirmaltDao result = firmaltDaoService.create(dao);
	}	
	
	
	
/*
	//gw.systema.no:8787 
	private void createFirmalt() {
		FirmaltDao dao = new FirmaltDao();
		dao.setAifirm("SS");
		dao.setAiorg("936809219");   //SYSTEMA AS
		dao.setAipwd("todo"); 
		dao.setAipath("/SYSPED/ALTINN/DAGSOPPGJOR/"); 
		dao.setAiapi("todo");  
		dao.setAiuser("ECSystemaAS");  
		dao.setAiupwd("todo");  
		dao.setAihost("www.altinn.no"); 
		dao.setAiauur("/api/authentication/authenticatewithpassword");
		
		FirmaltDao result = firmaltDaoService.create(dao);
	}	
*/	
	

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
//		list.forEach(firma -> System.out.println("firma"+firma));
		assertTrue("Should find only one tuple.", list.size() == 1);
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
	
	@Test
	public final void testGet() {
		List<FirmaltDao> resultDaos = firmaltDaoService.get();
		resultDaos.forEach(dao -> System.out.println(ReflectionToStringBuilder.toString(dao)));
		assertNotNull(resultDaos);
	}	
	
	@Test
	public final void testFindXXX() {	
    List<String> DHL_ORGNR = Arrays.asList("936972403","972871400", "971959266", "972211222", "810514442");
    
    List<FirmaltDao> list =  firmaltDaoService.findAll(null);
//   String orgnSSS = "810514442";
//   String orgnSSS = dao.getAiorg().trim();
	list.forEach(dao -> {
		 System.out.println("dao="+ReflectionToStringBuilder.toString(dao));
//	String orgnSSS = dao.getAiorg().trim();
		 String orgnSSS = "810514442";
//		 String orgnSSS = dao.getAiorg().trim();
//		 String orgnSSS = new String(dao.getAiorg().trim());
		System.out.println("orgnSSS="+orgnSSS);
		System.out.println("orgnSSD="+dao.getAiorg().trim());
//		Predicate<String> filterPredicate = filter -> filter == dao.getAiorg().trim();
		Predicate<String> filterPredicate = filter -> filter == orgnSSS;

		boolean isDHL = DHL_ORGNR.stream().filter(filterPredicate).anyMatch(filterPredicate);		
		System.out.println("isDHL="+isDHL);
	});
	
	

	}
	
	
	@Test
	public final void testFindXXXZZZZ() {	
//    List<String> DHL_ORGNR = Arrays.asList("936972403","972871400", "971959266", "972211222", "810514442");
    List<String> DHL_ORGNR = Arrays.asList("936972403","972871400", "971959266", "972211222");
    
    List<FirmaltDao> list =  firmaltDaoService.findAll(null);

    boolean isDHL = false;
    for (Iterator iterator = DHL_ORGNR.iterator(); iterator.hasNext();) {
		String string = (String) iterator.next();
		for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
			FirmaltDao firmaltDao = (FirmaltDao) iterator2.next();
			if (firmaltDao.getAiorg().equals(string)) {
				isDHL = true;
			}
		}
	}
    
	System.out.println("isDHL="+isDHL);

    
	
	

	}	
	
	
	
	
	
}
