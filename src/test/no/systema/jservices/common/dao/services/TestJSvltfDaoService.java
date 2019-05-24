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
	public final void testGenerateGodsnummer() {
		SvltfDao qDao = new SvltfDao();
		qDao.setSvltf_igl("BJO");
		SvltfDao resultDao =  svltfDaoService.find(qDao);
		
		String genNumber = svltfDaoService.getGenerateGodsnummer(resultDao.getSvltf_igl());
		System.out.println("godsnummer existing="+genNumber);

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
