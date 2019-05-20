package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dto.SvlthDto;
import no.systema.jservices.common.values.EventTypeEnum;

public class TestJSvlthDaoService {

	ApplicationContext context = null;
	SvlthDaoService svlthDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svlthDaoService = (SvlthDaoService) context.getBean("svlthDaoService");
		
	}

	@Test
	public final void testCountAll() {
		int count = svlthDaoService.countAll();
		assertNotNull(count);
	}

	
	@Test
	public final void testExistMrn() {
		String mrn = "123456789012345678";
		
		boolean exist = svlthDaoService.existMrn(EventTypeEnum.INLAGG, mrn);
		assertTrue(exist);
	
		mrn = "xyz";
		exist = svlthDaoService.existMrn(EventTypeEnum.INLAGG,mrn);
		assertFalse(exist);	
	
	}	

	@Test
	public final void testExist() {
		String godsnummer = "BJO18-323";
		String position = "1";
		
		boolean exist = svlthDaoService.exist(EventTypeEnum.INLAGG, godsnummer, position);
		assertTrue(exist);
	
		godsnummer = "xyz";
		exist = svlthDaoService.existMrn(EventTypeEnum.INLAGG,godsnummer);
		assertFalse(exist);	
	
	}		
	
	@Test
	public final void testFindAll() {
		String mrn = "123456789012345678";
		Integer arrivalDate = 20190401;
		
		
		List<SvlthDto> list = svlthDaoService.getAll("I", null,null, mrn ,null,null ,null,null, null, null);
		assertNotNull(list);

//		list = svlthDaoService.getAll("I", null ,mrn , null, null, null, null);
//		assertNotNull(list);		
		
	
	}		
	

	@Test(expected=IllegalAccessError.class)
	public final void testExistOrg() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_h("I");
		boolean exist = svlthDaoService.exist(dao );
	}

	@Test(expected=IllegalAccessError.class)
	public final void testFind() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_h("I");
		SvlthDao resultDao = svlthDaoService.find(dao);
	}

	@Test(expected=IllegalAccessError.class)
	public final void testDelete() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_h("I");
		svlthDaoService.delete(dao);
	}	
	
	
	@Test
	public final void testCreate() {
		SvlthDao dao = new SvlthDao();
		dao.setSvlth_irn("12345678901234xyz");
		dao.setSvlth_ibr("34,345");
		dao.setSvlth_h("U");
		dao.setSvlth_irn("1NO444");
		SvlthDao resultDao = svlthDaoService.create(dao);
		
		assertNotNull(resultDao);
	}	


	@Test
	public final void testGetAllAndCalcSaldo() {
		String godsLokalkod = "BJO";
		String godsNummer = "BJO18-323"; //BJO18-323, BJO19-389
		String position = "1";

		Integer id2F = 20190502;
		Integer id2T = 20190502;
		
		List<SvlthDto> list= svlthDaoService.getAll(EventTypeEnum.INLAGG.getValue(),godsLokalkod,godsNummer,position, null, id2F,id2T, null , null, null);
		assertTrue(list.isEmpty());
		
		list= svlthDaoService.getAll(EventTypeEnum.INLAGG.getValue(),godsLokalkod,godsNummer,position,null, id2F,id2T, null , null, null);


		id2F = null;
		id2T = null;
		
		list= svlthDaoService.getAll(EventTypeEnum.INLAGG.getValue(),godsLokalkod,godsNummer,position,null, id2F,id2T, null , null, null);
		assertFalse(list.isEmpty());
		
		list.forEach(dto -> {
			System.out.println("dto.getSaldo="+dto.getSaldo());
			
		});
		
		
	}	
	
	@Test
	public final void testValidUttagQuanty() {
		Integer uttagAntal = 1;
		String godsNummer = "BJO19-389"; //BJO18-323
		String position = "1";

		boolean valid = svlthDaoService.validUttagQuantity(uttagAntal,  godsNummer, position );
		System.out.println("valid="+valid);

		assertTrue(valid);
	}	
	
	
}
