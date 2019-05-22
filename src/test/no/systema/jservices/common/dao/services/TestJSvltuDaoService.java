package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SvltuDao;

public class TestJSvltuDaoService {

	ApplicationContext context = null;
	SvltuDaoService svltuDaoService = null;
	String firmaColumnName = "arcfir";

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		svltuDaoService = (SvltuDaoService) context.getBean("svltuDaoService");
		
	}

	
	@Test
	public final void testFindAll() {
		List<SvltuDao> list =  svltuDaoService.findAll(null);
		assertNotNull(list);
	}		
	
	@Test
	public final void testExist() {
		SvltuDao dao = getSvltuDao();

		boolean exist = svltuDaoService.exist(dao );
		assertTrue(dao + " should exist", exist);
	}

	@Test
	public final void testFind() {
		SvltuDao dao = new SvltuDao();
		SvltuDao resultDao = svltuDaoService.find(dao);
		assertNotNull(resultDao);
	}
	
	
	private SvltuDao getSvltuDao() {
		SvltuDao dao = new SvltuDao();
		dao.setSvltu_igl("BJO");
		dao.setSvltu_ign("BJO19-003");
		dao.setSvltu_pos("1");
		
		return dao;
		
		
	}
	
}
