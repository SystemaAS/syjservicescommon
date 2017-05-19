package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SadvareDao;
import no.systema.jservices.common.dao.SyparfDao;

public class TestJSadvareDaoService {

	ApplicationContext context = null;
	SadvareDaoService sadvareDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			sadvareDaoService = (SadvareDaoService) context.getBean("sadvareDaoService");
	}

	@Test
	public final void testCountAll() {
		int count  =  sadvareDaoService.countAll();
		assertNotNull(count);
	}	
	
	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levenr", "1");
		int count  =  sadvareDaoService.countAll(params);
		assertNotNull(count);
	}		
	
	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levenr", "1");
		List<SadvareDao> list =  sadvareDaoService.findAll(params);
		assertNotNull(list);
	}		
	
	
	@Test
	public final void testExist() {
		SadvareDao qDao = new SadvareDao();
		qDao.setLevenr("1");
		qDao.setVarenr("9004901000");
		
		boolean exist =  sadvareDaoService.exist(qDao);
		assertTrue(qDao.getVarenr() +" should exist",exist);
		
		qDao.setVarenr("999999999");
		exist =  sadvareDaoService.exist(qDao);
		assertTrue(qDao.getVarenr() +" should not exist",!exist);
		
	}
	
	
	@Test
	public final void testCreateAndDelete() {
		SadvareDao dao = getBigSadvareDao();
		SadvareDao returnDao = sadvareDaoService.create(dao);
		assertNotNull(returnDao);

		sadvareDaoService.delete(dao);
		boolean exist = sadvareDaoService.exist(dao);
		assertTrue(dao.getLevenr() + ", " + dao.getVarenr() + " should not exist", !exist);

	}

	@Test
	public final void testUpdate() {
		SadvareDao getDao = getSadvareDao();
		boolean exist = sadvareDaoService.exist(getDao);
		assertTrue(getDao.getLevenr() + ", " + getDao.getVarenr() + " should not exist", !exist);

		SadvareDao createDao = sadvareDaoService.create(getDao);
		createDao.setVarebe("Kilroy was here.");

		SadvareDao updateDao = sadvareDaoService.update(createDao);
		assertNotNull(updateDao);
		assertEquals("Dao have been updated.", updateDao.getVarenr(), createDao.getVarenr());

		// Clean DB
		sadvareDaoService.delete(getDao); 
		exist = sadvareDaoService.exist(getDao);
		assertTrue(getDao.getLevenr() + ", " + getDao.getVarenr() + " should not exist", !exist);
	}	

	
	@Test
	public final void testFindAll() {
		String levenr = "1";
		List<SadvareDao> daoList = sadvareDaoService.findAll(levenr);
		assertNotNull(daoList);
		
	}	
	
	@Test
	public final void testFind() {
		String levenr = "1";
		String varenr = "9004901000";
		SadvareDao dao = sadvareDaoService.find(levenr,varenr);
		assertNotNull(dao);
	}		
	
	private SadvareDao getSadvareDao() {
		SadvareDao dao = new SadvareDao();
		dao.setLevenr("1"); // key
		dao.setVarenr("999999999");// key
		
		return dao;
	}	
	

	private SadvareDao getBigSadvareDao() {
		SadvareDao dao = new SadvareDao();
		dao.setLevenr("1"); // key
		dao.setVarenr("999999999");// key
		dao.setVarebe("varebesk");
		dao.setW2belt("0");
		dao.setW2vktb("0");
		dao.setW2vktn("0");
		dao.setW2ntm("0");
		dao.setW2as("0");
		dao.setW2asa1("0");
		dao.setW2agr1("0");
		dao.setW2abl1("0");
		dao.setW2bel("0");
		dao.setW2asa2("0");
		dao.setW2agr2("0");
		dao.setW2abl2("0");
		dao.setW2pros("0");
		dao.setW2asa3("0");
		dao.setW2agr3("0");
		dao.setW2abl3("0");
		dao.setW2asa4("0");
		dao.setW2agr4("0");
		dao.setW2abl4("0");
		dao.setW2beln("0");
		dao.setW2asa5("0");
		dao.setW2agr5("0");
		dao.setW2abl5("0");
		dao.setW2asa6("0");
		dao.setW2agr6("0");
		dao.setW2abl6("0");
		dao.setW2asa7("0");
		dao.setW2agr7("0");
		dao.setW2abl7("0");
		dao.setW2asa8("0");
		dao.setW2agr8("0");
		dao.setW2nt02("0");
		dao.setW2nt03("0");
		dao.setW2nt04("0");
		dao.setW2nt05("0");
		dao.setW2nt06("0");
		dao.setW2nt07("0");
		dao.setW2vf(null);
		dao.setW2tn(null);

		dao.setW2lk("");
		dao.setW2vnti("");
		dao.setW2pre("");
		dao.setW2pva("");
		dao.setW2mfr("");
		dao.setW2akd1("");
		dao.setW2akd1("");
		dao.setW2asv1("");
		dao.setW2akd2("");
		dao.setW2asv2("");
		dao.setW2akd3("");
		dao.setW2asv3("");
		dao.setW2val("");
		dao.setW2akd4("");
		dao.setW2asv4("");
		dao.setW2akd5("");
		dao.setW2asv5("");
		dao.setW2akd6("");
		dao.setW2asv6("");
		dao.setW2akd7("");
		dao.setW2asv7("");
		dao.setW2akd8("");
		dao.setW2asv8("");
		dao.setW2abl8("0"); 
		dao.setW2ft01("");
		dao.setW2nt01("0"); 
		dao.setW2eh01("");
		dao.setW2vt01("");
		dao.setW2ft02("");
		dao.setW2eh02("");
		dao.setW2vt02("");
		dao.setW2ft03("");
		dao.setW2eh03("");
		dao.setW2vt03("");
		dao.setW2ft04("");
		dao.setW2eh04("");
		dao.setW2vt04("");
		dao.setW2ft05("");
		dao.setW2eh05("");
		dao.setW2vt05("");
		dao.setW2ft06("");
		dao.setW2eh06("");
		dao.setW2ft07("");
		dao.setW2eh07("");

		return dao;
	}		
	
	
}
