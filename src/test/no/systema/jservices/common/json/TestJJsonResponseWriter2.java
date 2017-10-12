package no.systema.jservices.common.json;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestJJsonResponseWriter2 {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public final void testJsonNoContainer() throws Exception{
		JsonResponseWriter2<WrapperDto<TestDto>> jsonWriter = new JsonResponseWriter2<WrapperDto<TestDto>>();
		JsonReader<JsonDtoContainer<TestDto>> jsonReader = new JsonReader<JsonDtoContainer<TestDto>>();
		jsonReader.set(new JsonDtoContainer<TestDto>());
		TestDto testDto = new TestDto();
		testDto.setString("kalle");
		testDto.setInte(10);
		testDto.setBd(new BigDecimal(20));
		
		TestDto testDto2 = new TestDto();
		testDto2.setString("pelle");
		testDto2.setInte(100);
		testDto2.setBd(new BigDecimal(200));		
		
		List<TestDto> testDtolist = new ArrayList<TestDto>();
		testDtolist.add(testDto);
		testDtolist.add(testDto2);
		WrapperDto<TestDto> wDto = new WrapperDto<TestDto>();
		wDto.setDtoList(testDtolist);
		
		String jsonString = jsonWriter.setJsonResult_Common_GetComposite_No_Container(wDto);
		assertNotNull(jsonString);
	
		System.out.println("jsonString="+jsonString);		
		
	}

}
