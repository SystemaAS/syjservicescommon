package no.systema.jservices.common.cgi.dto;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import no.systema.jservices.common.json.JsonReader;

public class TestJInitResponseDto {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testParsePayLoad() {

		JsonReader<InitResponseDto> jsonReader = new JsonReader<InitResponseDto>();
		jsonReader.set(new InitResponseDto());
		InitResponseDto testDto = new InitResponseDto();
		testDto.setUser("CB");
	
		String payLoad = "{\"user\" : \"CB\", \"dtfra\" : \"20100101\", \"dttil\" : \"20171231\", \"errMsg\" : \"Invalid user\" } ";
		
		InitResponseDto dto = (InitResponseDto) jsonReader.get(payLoad);		
		
		assertNotNull(dto);
		
		
		
	}

}
