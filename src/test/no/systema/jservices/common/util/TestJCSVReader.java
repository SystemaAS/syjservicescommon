package no.systema.jservices.common.util;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import no.systema.jservices.common.dao.SvlthDao;
import no.systema.jservices.common.dao.VispnrDao;
import no.systema.jservices.common.dao.services.SvlthDaoService;
import no.systema.jservices.common.dao.services.VispnrDaoService;
import no.systema.jservices.common.dto.SingleValueDto;
import no.systema.jservices.common.values.EventTypeEnum;

public class TestJCSVReader {

	ApplicationContext context = null;
	VispnrDaoService vispnrDaoService;	
	SvlthDaoService svlthDaoService;		
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("syjservicescommon-data-service-test.xml");
		vispnrDaoService = (VispnrDaoService) context.getBean("vispnrDaoService");
		svlthDaoService = (SvlthDaoService) context.getBean("svlthDaoService");
		
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
	public void testParseDacher201808() throws Exception {
		String filePath = "no/systema/jservices/common/util/dachser-2018-08.csv";

		Map<String, String> mappedNames = new HashMap<String, String>();
		mappedNames.put("svlth_ign", "Godsnummer");		
		mappedNames.put("svlth_int", "Antal");		
		mappedNames.put("svlth_irn", "MRN");		
		mappedNames.put("svlth_unt", "Uttag");		
		mappedNames.put("svlth_uti", "Tullid");		
		mappedNames.put("svlth_iex", "Sandningsnummer");		
	
		
		CSVReader<SvlthMigrationDto> cvsReader = new CSVReader<SvlthMigrationDto>(mappedNames,CSVFormat.EXCEL.withDelimiter(';'));

		Reader reader = getReader(filePath);
		List<SvlthMigrationDto> list = cvsReader.getList(SvlthMigrationDto.class, reader);

		final int[] dato = DateTimeManager.getNowDato();		
		
		final String godslokalkod = "BJO";
		
		
		list.forEach(dto -> {
			SvlthDao inlaggDao = new SvlthDao();
			SvlthDao uttagDao = new SvlthDao();

			inlaggDao.setSvlth_h(EventTypeEnum.INLAGG.getValue());
			inlaggDao.setSvlth_igl(godslokalkod);
			inlaggDao.setSvlth_ign(godslokalkod + dto.getSvlth_ign());
			inlaggDao.setSvlth_irn(dto.getSvlth_irn());
			if (!dto.getSvlth_iex().isEmpty()) {
				if (dto.getSvlth_iex().length() > 15) {
					inlaggDao.setSvlth_iex(dto.getSvlth_iex().substring(0,15));
				} else {
					inlaggDao.setSvlth_iex(dto.getSvlth_iex());
				}
			}			
			inlaggDao.setSvlth_id1(dato[0]);
			inlaggDao.setSvlth_im1(dato[1]);
			inlaggDao.setSvlth_id2(dato[0]);
			inlaggDao.setSvlth_int(Integer.parseInt(dto.getSvlth_int()));
			inlaggDao.setSvlth_isl("AA");
			inlaggDao.setSvlth_ivb("varubeskrivning");
			inlaggDao.setSvlth_ibr("200");
			
			if (!dto.getSvlth_unt().isEmpty()) {
				uttagDao.setSvlth_h(EventTypeEnum.UTTAG.getValue());

				uttagDao.setSvlth_igl(godslokalkod);
				uttagDao.setSvlth_ign(godslokalkod + dto.getSvlth_ign());
				uttagDao.setSvlth_irn(dto.getSvlth_irn());
				if (!dto.getSvlth_iex().isEmpty()) {
					if (dto.getSvlth_iex().length() > 15) {
						uttagDao.setSvlth_iex(dto.getSvlth_iex().substring(0,15));
					} else {
						uttagDao.setSvlth_iex(dto.getSvlth_iex());
					}
				}			
				uttagDao.setSvlth_id1(dato[0]);
				uttagDao.setSvlth_im1(dato[1]);
				uttagDao.setSvlth_id2(dato[0]);
				uttagDao.setSvlth_int(Integer.parseInt(dto.getSvlth_int()));
				uttagDao.setSvlth_isl("AA");
				uttagDao.setSvlth_ivb("varubeskrivning");
				uttagDao.setSvlth_ibr("200");
				
				uttagDao.setSvlth_ud1(dato[0]);
				uttagDao.setSvlth_unt(Integer.parseInt(dto.getSvlth_unt()));
				if (!dto.getSvlth_uti().isEmpty() ) {
					if (dto.getSvlth_uti().length() > 10) {
						uttagDao.setSvlth_uti(dto.getSvlth_uti().substring(0,10));
					} else {
						uttagDao.setSvlth_uti(dto.getSvlth_uti());
					}
				}	
			}
			
			svlthDaoService.create(inlaggDao);
			svlthDaoService.create(uttagDao);
				
			
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
		//	vispnrDaoService.create(dto);
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
