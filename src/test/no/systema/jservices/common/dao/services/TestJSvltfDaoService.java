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
	
	
	
	@Test
	public final void testExistingGodsnummerAndIncrement() {
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl("BJO");
		SvltfDao resultDao =  svltfDaoService.find(qDao);
		
		SvltfDao resultDao2 = svltfDaoService.getExistingSvltf_numAndIncrement(resultDao.getSvltf_igl());
		System.out.println("godsnummer existing="+resultDao.getSvltf_num());
		assertEquals("Should be the same", resultDao2.getSvltf_num(), resultDao.getSvltf_num());

		resultDao =  svltfDaoService.find(qDao);
		System.out.println("godsnummer incremented="+resultDao.getSvltf_num());
		Integer incrementedgodsnummer  = resultDao2.getSvltf_num() + 1;
		assertEquals("Should have been incremented with 1", incrementedgodsnummer, resultDao.getSvltf_num());
		
		//Clean db
		resultDao.setSvltf_num(resultDao2.getSvltf_num());
		svltfDaoService.update(resultDao);
		resultDao =  svltfDaoService.find(qDao);
		System.out.println("godsnummer substracted="+resultDao.getSvltf_num());
		
		Integer substractedGodsnummer = resultDao2.getSvltf_num();
		assertEquals("Should have been substracted with 1", substractedGodsnummer, resultDao.getSvltf_num());
		
	}
	
	
	@Test
	public final void justAdjustGodsnummer() {
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl("BJO");
		SvltfDao resultDao =  svltfDaoService.find(qDao);
		
		resultDao.setSvltf_num(1);
		svltfDaoService.update(resultDao);
		resultDao =  svltfDaoService.find(qDao);
		System.out.println("godsnummer adjusted="+resultDao.getSvltf_num());
		
		
	}
	

	
}
