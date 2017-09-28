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
	public final void testGetStats2() {
		FortollingDto qDto = new FortollingDto();
		qDto.setRegistreringsdato("20170000");
		qDto.setAvdeling(1);
		qDto.setSignatur("YBC");
		qDto.setMottaker(176);
		
		List<FortollingDto> list  =  fortollingDaoService.getStats(qDto);
		System.out.println("list.size()="+list.size());
		assertNotNull(list.size());
	}		
	
	
}
