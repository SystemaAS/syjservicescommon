package no.systema.jservices.common.dao.services;

import static org.junit.Assert.assertEquals;

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
		FortollingDto qDto = new FortollingDto();
		qDto.setRegistreringsdato("20171000");
		//qDto.getAvdelingList().add(1);
		//qDto.getSignaturList().add("YBC");
		//qDto.setMottaker(1);
		
		List<FortollingDto> list  =  fortollingDaoService.getStats(qDto);
		
		assertEquals(14, list.size());  //no init
	}		
	
	
}
