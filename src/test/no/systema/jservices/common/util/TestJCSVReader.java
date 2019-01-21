package no.systema.jservices.common.util;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.VispnrDao;
import no.systema.jservices.common.dao.services.VispnrDaoService;
import no.systema.jservices.common.dto.SingleValueDto;

public class TestJCSVReader {

	ApplicationContext context = null;
	VispnrDaoService vispnrDaoService = null;	
	
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vispnrDaoService = (VispnrDaoService) context.getBean("vispnrDaoService");
		
	}
	
	
	@Test
	public void testGetFile() throws Exception {
		String filePath = "no/systema/jservices/common/util/value.csv";
		Map<String, String> mappedNames = new HashMap<String, String>();
		mappedNames.put("value", "valueCSV");
		
		CSVReader<SingleValueDto> cvsReader = new CSVReader<SingleValueDto>(mappedNames);
		Reader reader = getReader(filePath);

		List<SingleValueDto> list = cvsReader.getList(SingleValueDto.class, reader);
		
		list.forEach(dto -> {
			System.out.println("dto="+ReflectionToStringBuilder.toString(dto));
		});

	}
	
	@Test
	public void testGetPostnrAndInsertIntoVispnr() throws Exception {
		String filePath = "no/systema/jservices/common/util/postnr.csv";

		//"Land,Postnr.,Kommune/region,Sted  -> vilk, viponr, viregi, vilkna"
		Map<String, String> mappedNames = new HashMap<String, String>();
		mappedNames.put("vilk", "Land");		
		mappedNames.put("viponr", "Postnr.");		
		mappedNames.put("viregi", "Kommune/region");		
		mappedNames.put("vilkna", "Sted");		
		
		CSVReader<VispnrDao> cvsReader = new CSVReader<VispnrDao>(mappedNames);

		Reader reader = getReader(filePath);
		List<VispnrDao> list = cvsReader.getList(VispnrDao.class, reader);
		
		list.forEach(dto -> {
			System.out.println("exist="+vispnrDaoService.exist(dto));
			vispnrDaoService.create(dto);
			System.out.println("dto, created="+ReflectionToStringBuilder.toString(dto));
			System.out.println("exist="+vispnrDaoService.exist(dto));

		});		
		
	}	
	
	private Reader getReader(String path) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		URL url = classLoader.getResource(path);		
		System.out.println("url="+url);
		
		Reader reader =  Files.newBufferedReader(Paths.get(url.getPath()));

		return reader;

	}	
	
	
}
