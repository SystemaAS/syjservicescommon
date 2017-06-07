package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SvewDao;
import no.systema.jservices.common.dao.SviwDao;
import no.systema.jservices.common.dao.TariDao;

public class TestJSvewDaoService {

	ApplicationContext context = null;
	SvewDaoService svewDaoService = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svewDaoService = (SvewDaoService) context.getBean("svewDaoService");
	}

	@Test
	public final void testCountAll() {
		int count = svewDaoService.countAll();
		assertNotNull(count);
	}

	@Test
	public final void testCountAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svew_knnr", 1);
		params.put("svew_knso", "Tarzan");		
		int count = svewDaoService.countAll(params);
		assertNotNull(count);
	}

	@Test
	public final void testFindAllWithParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svew_knnr", 1);
		params.put("svew_knso", "Tarzan");		
		List<SvewDao> list = svewDaoService.findAll(params);
		SvewDao dao = list.get(0);
		System.out.println("SvewDao="+ReflectionToStringBuilder.toString(dao));
		System.out.println("dao.getSvew_brut()"+dao.getSvew_brut());
		assertNotNull(list);
	}
	
	@Test
	public final void testFindAllWithoutParams() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<SvewDao> list = svewDaoService.findAll(params);
		assertNotNull(list);
	}	
	
	@Test
	public final void testFind() {
		SvewDao qDao = new SvewDao();
		qDao.setSvew_knnr(1);
		qDao.setSvew_knso ("Tarzan");
		SvewDao resultDao = svewDaoService.find(qDao);
		assertEquals("nr should be the same.",1, resultDao.getSvew_knnr());
		
		SvewDao resultDao2 = svewDaoService.find(1, "Tarzan");
		assertNotNull(resultDao2);
		assertEquals("nr should be the same.",resultDao2.getSvew_knnr(), resultDao.getSvew_knnr());		
		
		
		SvewDao resultDao3 = svewDaoService.find(1, "Jane");
		System.out.println("resultDao3="+ReflectionToStringBuilder.toString(resultDao3));
		System.out.println("getSvew_brut="+resultDao3.getSvew_brut());
		
	}		
	
	@Test
	public final void testExist() {
		SvewDao qDao = new SvewDao();
		qDao.setSvew_knnr(1);
		qDao.setSvew_knso ("Tarzan");

		boolean exist = svewDaoService.exist(qDao);
		assertTrue(qDao.getSvew_knnr() + "," + qDao.getSvew_knso()+" should exist", exist);

		qDao.setSvew_knnr(0);
		exist = svewDaoService.exist(qDao);
		assertTrue(qDao.getSvew_knnr() + "," + qDao.getSvew_knso()+"should not exist", !exist);

	}

}
