package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dto.FortollingDto;

public class TestJFortollingDaoService {

	ApplicationContext context = null;
	FortollingDaoService fortollingDaoService = null;
	
	@Before
	public void setUp() throws Exception {
			context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
			fortollingDaoService = (FortollingDaoService) context.getBean("fortollingDaoService");
	}

	@Test
	public final void testGetStats() {
		int year = 2016;
		List<FortollingDto> list  =  fortollingDaoService.getStats(year);
		System.out.println("list.size()="+list.size());
		assertNotNull(list.size());
	}		
	
}
