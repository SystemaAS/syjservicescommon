package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.KosttDao;
import no.systema.jservices.common.dao.SvltfDao;
import no.systema.jservices.common.values.KosttTyper;

public class TestJSvltfDaoService {

	ApplicationContext context = null;
	SvltfDaoService svltfDaoService = null;

	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			svltfDaoService = (SvltfDaoService) context.getBean("svltfDaoService");
	}

	@Test
	public final void testExist() {
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl("BJO");
		
//		//create
//		SvltfDao dao = getSvltfDao();
//		SvltfDao returnDao  = svltfDaoService.create(dao);
		
		//exist
		boolean exist =  svltfDaoService.exist(qDao);
		assertTrue(qDao.getSvltf_igl() +" should exist",exist);
		
		
	}	
	
	SvltfDao getSvltfDao() {
		SvltfDao dao = new SvltfDao();
		dao.setSvltf_igl("BJO");
		dao.setSvltf_txt("Jönköping");
		
		return dao;
		
	}
	
	
	
//	@Test
//	public final void testExistingKtnrAndIncrement() {
//		KosttDao qDao = new KosttDao();
//		qDao.setKttyp(KosttTyper.Ø.toString());
//		KosttDao resultDao =  svltfDaoService.find(qDao);
//		
//		Integer ktnr = svltfDaoService.getExistingKtnrAndIncrement(KosttTyper.Ø.toString());
//		System.out.println("ktnr existing="+ktnr);
//		assertEquals("Should be the same", ktnr, resultDao.getKtnr());
//
//		resultDao =  svltfDaoService.find(qDao);
//		System.out.println("ktnr incremented="+resultDao.getKtnr());
//		Integer incrementedKtnr  = ktnr + 1;
//		assertEquals("Should have been incremented with 1", incrementedKtnr, resultDao.getKtnr());
//		
//		//Clean db
//		svltfDaoService.substractKtnr(KosttTyper.Ø.toString());
//		resultDao =  svltfDaoService.find(qDao);
//		System.out.println("ktnr substracted="+resultDao.getKtnr());
//		
//		Integer substractedKtnr = ktnr;
//		assertEquals("Should have been substracted with 1", substractedKtnr, resultDao.getKtnr());
//		
//	}

//	@Test
//	public final void testFindByLike() {
//		String ktna = "REserVERT";
//		List<KosttDao> resultList =  svltfDaoService.findByLike(ktna);	
//		
////		resultList.forEach(dao -> {
////			System.out.println(ReflectionToStringBuilder.toString(dao));
////		});
//		
//	}
	

	
}
