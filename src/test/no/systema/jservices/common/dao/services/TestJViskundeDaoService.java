package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.ViskundeDao;

public class TestJViskundeDaoService {

	ApplicationContext context = null;
	ViskundeDaoService viskundeDaoService = null;
	String firmaColumnName = "firma";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		viskundeDaoService = (ViskundeDaoService) context.getBean("viskundeDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = viskundeDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", 2010);
		int count = viskundeDaoService.countAll(params);
		assertNotNull(count);
	}
	
	@Test
	public final void testFindAll() {
		List<ViskundeDao> list =  viskundeDaoService.findAll(null);
		assertNotNull(list);
	}		

	@Test
	public final void testFindUnique() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", 2010);
		List<ViskundeDao> list =  viskundeDaoService.findAllInFirma(params, firmaColumnName);
		assertTrue("Should find 1 tuple.", list.size() == 1);
	}		
			
	
	@Test
	public final void testFindAllInFirma() {
		List<ViskundeDao> list =  viskundeDaoService.findAllInFirma(null, firmaColumnName);
		assertNotNull(list);
	}		
	

	@Test
	public final void testExist() {
		ViskundeDao dao = new ViskundeDao();
		dao.setKundnr(2010);
		boolean exist = viskundeDaoService.existInFirma(dao, firmaColumnName );
		assertTrue(dao.getKundnr() + " should exist", exist);
	}

	@Test
	public final void testFind() {
		ViskundeDao dao = new ViskundeDao();
		dao.setKundnr(2010);
		ViskundeDao resultDao = viskundeDaoService.find(dao);
		assertNotNull("Should exist", resultDao);
	}

	@Test
	public final void testFindOnKundnr() {
		ViskundeDao resultDao = viskundeDaoService.find("2010");
		assertNotNull("Should exist", resultDao);
	}	
	
	@Test
	public final void testCreateAndDeleteSmall() {
		ViskundeDao dao = getSmallDao();
		ViskundeDao resultDao = viskundeDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		viskundeDaoService.delete(dao);
		resultDao = viskundeDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}

	@Test
	public final void testCreateAndDeleteBig() {
		ViskundeDao dao = getBigDao();
		ViskundeDao resultDao = viskundeDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

		//Cleanup
		viskundeDaoService.delete(dao);
		resultDao = viskundeDaoService.find(dao);
		assertNull("Should not exist", resultDao);
		
	}	
	
	@Test
	public final void createBigCustomer_10() {
		ViskundeDao dao = getBigDao();
		ViskundeDao resultDao = viskundeDaoService.create(dao);
		assertNotNull("Should exist", resultDao);

	}
	
	private ViskundeDao getSmallDao() {
		ViskundeDao dao = new ViskundeDao();
		dao.setFirma("SY");
		dao.setKundnr(2010);
		
		return dao;
		
	}

	private ViskundeDao getBigDao() {
		ViskundeDao dao = new ViskundeDao();
		dao.setFirma("SY"); //private String firma;
		dao.setKundnr(10); //private int kundnr; //key
		dao.setAktkod("A");  // private String aktkod;
		dao.setDkund("d"); //private String dkund;
		dao.setKnavn("knavn"); //;private String knavn;
		dao.setAdr1("adr1"); //;private String adr1;
		dao.setAdr2("adr2"); //private String adr2;
		dao.setPostnr(3333);  //private int postnr;
		dao.setAdr3("adr3"); //private String adr3;
		dao.setKpers("kpers"); //private String kpers;
		dao.setTlf("tlf");//private String tlf;
		dao.setSonavn("sonavn"); //private String sonavn;
		dao.setValkod("vkd"); //;private String valkod;
		dao.setSpraak("s"); //private String spraak;
		dao.setBankg("bankg");//private String bankg;
		dao.setPostg("postg"); //private String postg;
		dao.setFmot(100); //private int fmot;
		dao.setBetbet("bt"); //private String betbet;
		dao.setBetmat("b"); //private String betmat;
		dao.setSfakt("s"); //private String sfakt;
		dao.setKgrens(999);  //private int kgrens;
		dao.setTfaxnr("tfaxnr"); //private String tfaxnr;
		dao.setSyregn(444); //private int syregn;
		dao.setSykont(111); //private int sykont;
		dao.setSylikv("s"); //private String sylikv;
		dao.setSyopdt("sy"); //private String syopdt;
		dao.setSyminu(new BigDecimal(1.1)); //;private BigDecimal syminu = new BigDecimal(0);
		dao.setSyutlp(new BigDecimal(2.2)); //private BigDecimal syutlp = new BigDecimal(0);
		dao.setSyrg("123456"); //private String syrg;
		dao.setSypoge("sypoge"); //private String sypoge;
		dao.setSystat("sys"); //private String systat;
		dao.setSyland("sy"); //private String syland;
		dao.setSyselg("sys"); //private String syselg;
		dao.setSyiat1(888); //private int syiat1;
		dao.setSyiat2(88); //private int syiat2;
		dao.setSycoty("s"); //private String sycoty;
		dao.setSyfr01("s"); //private String syfr01;
		dao.setSyfr02("s"); //private String syfr02;
		dao.setSyfr03("sy"); //private String syfr03;
		dao.setSyfr04("sy"); //private String syfr04;
		dao.setSyfr05("syf"); //private String syfr05;
		dao.setSyfr06("syf"); //private String syfr06;
		dao.setSysalu(2); //private int sysalu;
		dao.setSyepos("syepos"); //private String syepos;
		dao.setAknrku(400); //;private int aknrku;
		dao.setVatkku("vatkku"); //private String vatkku;
		dao.setXxbre(new BigDecimal(5.5)); //private BigDecimal xxbre = new BigDecimal(0);
		dao.setXxlen(new BigDecimal(6.6)); //private BigDecimal xxlen = new BigDecimal(0);
		dao.setXxinm3(new BigDecimal(7.7)); //private BigDecimal xxinm3 = new BigDecimal(0);
		dao.setXxinlm(new BigDecimal(8.8)); //private BigDecimal xxinlm = new BigDecimal(0);
		dao.setRnraku("rnraku"); //private String rnraku;
		dao.setGolk("golk"); //private String golk;
		dao.setKundgr("ku"); //private String kundgr;
		dao.setPnpbku("pnpbku"); //private String pnpbku;
		dao.setAdr21("adr21"); //private String adr21;
		dao.setEori("eori"); //private String eori;
		dao.setSymvjn("J"); //private String symvjn;
		dao.setSymvsp("J"); //private String symvsp;
		
		return dao;
		
	}
	
	
}
