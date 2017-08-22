package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dao.TellDao;
import no.systema.jservices.common.dto.ArktxtDto;
import no.systema.jservices.common.dto.HeadfDto;
import no.systema.jservices.common.json.JsonDtoContainer;
import no.systema.jservices.common.json.JsonReader;
import no.systema.jservices.common.json.JsonResponseWriter2;

public class TestJHeadfDaoService {

	ApplicationContext context = null;
	HeadfDaoService headfDaoService = null;
	TellDaoService tellDaoService = null;
	HeadfDto qDao = null;
	HeadfDao dao = null;
	int VERY_MANY_DAYS = 20*365;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		headfDaoService = (HeadfDaoService) context.getBean("headfDaoService");
		qDao = new HeadfDto();
		dao = new HeadfDao();
		qDao.setDftdg(VERY_MANY_DAYS);
		tellDaoService = (TellDaoService) context.getBean("tellDaoService");
	}

	@Test
	public final void testCountAll() {
		int count = headfDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("heavd", 1);
		int count = headfDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("heavd", 1);
		List<HeadfDao> list = headfDaoService.findAll(params);
		assertNotNull(list);
	}

	@Test
	public final void testGetListAvdDato() {
		qDao.setHeavd(2);
		qDao.setHedtop(20000210);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many, is="+resultDaoList.size(), resultDaoList.size() > 100);
	}

	@Test
	public final void testGetListAvd() {
		qDao.setHeavd(2);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many, is="+resultDaoList.size(), resultDaoList.size() > 100);
	}
	
	@Test
	public final void testGetListAvsenderMottaker() {
		qDao.setHenas("%DATA%");
		qDao.setHenak("THAR%");
		qDao.setHedtop(20000101);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 1, resultDaoList.size());
	}	
	
	@Test
	public final void testGetListSign() {
		qDao.setHeavd(1);
		qDao.setHenas("%DATA%");
		qDao.setHesg("%JOV%");
		qDao.setHedtop(20000101);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 1, resultDaoList.size());
	}	
	
	
	@Test
	public final void testDftdg() {
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many", resultDaoList.size() > 1000);
		
		qDao.setDftdg(10);
		resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 3, resultDaoList.size());		
		
	}
	
	@Test
	public final void testHeavdHeopd() {
		qDao.setHeavd(80);
		qDao.setHeopd(201602);
		
		qDao.setHenas("%DATA%");//ignored
		qDao.setHesg("%JOV%");//ignored
		qDao.setHedtop(20000101);	//ignored
		qDao.setDftdg(10);//ignored
		
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertEquals("Should be the same", 1, resultDaoList.size());		
		
	}	
	
	
	
	@Test
	public final void testDato() {
		qDao.setDftdg(10);
		qDao.setHedtop(20130101);
		List<HeadfDto> resultDaoList = headfDaoService.get(qDao);
		assertTrue("Should be many, is="+resultDaoList.size(), resultDaoList.size() > 100);
	}	
	
	@Test
	public final void testExist() {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(1);
		qDao.setHeopd(773587);
		boolean exist = headfDaoService.exist(qDao);
		assertTrue(qDao.getHeavd() + ":" + qDao.getHeopd() + " should exist", exist);

		qDao.setHeavd(0);
		qDao.setHeopd(1);
		exist = headfDaoService.exist(qDao);
		assertTrue(qDao.getHeavd() + ":" + qDao.getHeopd() + " should not exist", !exist);

	}

	@Test
	public final void testCreateAndDelete() {
		dao = getBigHeadfDao();
		HeadfDao returnDao = headfDaoService.create(dao);
		assertNotNull(returnDao);

		headfDaoService.delete(dao);
		boolean exist = headfDaoService.exist(dao);
		assertTrue(dao.getHeavd() + ", " + dao.getHeopd() + " should not exist", !exist);

	}	

	
	@Test
	public final void testCreateUpdateAndDelete() {
		String updHenas = "Updated namn";
		dao = getBigHeadfDao();
		HeadfDao returnDao = headfDaoService.create(dao);
		HeadfDao updateDao = null;
		assertNotNull(returnDao);

		returnDao.setHenas(updHenas);
		updateDao = headfDaoService.update(returnDao);
		assertTrue("Name should be update", returnDao.getHenas().equals(updHenas));
		
		headfDaoService.delete(updateDao);
		boolean exist = headfDaoService.exist(updateDao);
		assertTrue(updateDao.getHeavd() + ", " + updateDao.getHeopd() + " should not exist", !exist);

	}		
	

	@SuppressWarnings("unused")
	@Test
	public final void testCreateAndDeleteRollbackCheck() {
		dao = getBigHeadfDao();
		dao.setHesg("JOV_AND_THE LONG_HORNS_SHOULD_GENERATE_EXCEPTION");
		
		TellDao tellqDao = new TellDao();
		tellqDao.setTeavd(dao.getHeavd());
		TellDao tellDao =  tellDaoService.find(tellqDao);		
		int before = tellDao.getTeopdn();
		
		try {
			HeadfDao returnDao = headfDaoService.create(dao);
			assertTrue("Exception should have been thrown", false);
		} catch (Exception e) {
			assertTrue("RuntimeException should have been thrown",e instanceof RuntimeException );
		}

		tellDao =  tellDaoService.find(tellqDao);		
		int after = tellDao.getTeopdn();
		assertEquals("Update of teopdn should have been rolledback",before, after); 
		
	}	

	@Test
	public final void testAsJsonObject() {
		dao = getBigHeadfDao();
		HeadfDao record = new HeadfDao();
		//writer
		JsonResponseWriter2<HeadfDao> jsonWriter = new JsonResponseWriter2<HeadfDao>();
		//reader
		JsonReader<JsonDtoContainer<HeadfDao>> jsonReader = new JsonReader<JsonDtoContainer<HeadfDao>>();
		jsonReader.set(new JsonDtoContainer<HeadfDao>());

		//****Returned from tror-service****/
		String json = jsonWriter.setJsonResult_Common_GetComposite("OSCAR", dao);	
		//**********************************/
		System.out.println("json="+json);
		assertNotNull(json);
		JsonDtoContainer<HeadfDao> container = (JsonDtoContainer<HeadfDao>) jsonReader.get(json);
		if (container != null) {
			for (HeadfDao dao : container.getDtoList()) {
				record = dao;
				assertNotNull(record.getHeopd());
			}
		}
		
	}
	
	private HeadfDao getBigHeadfDao() {
		HeadfDao dao = new HeadfDao();
		dao.setHeavd(1); // key
		dao.setHeopd(999);// key
		dao.setHesg("JOV");
		dao.setHeank(1);
		dao.setHehbre(new BigDecimal(14.1));
		
		return dao;
	}	
	
}
