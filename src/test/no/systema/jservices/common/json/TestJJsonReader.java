package no.systema.jservices.common.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

import no.systema.jservices.common.brreg.proxy.entities.Enhet;

public class TestJJsonReader {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public final void testJsonDtoContainerInstance() throws Exception{
		JsonResponseWriter2<Enhet> jsonWriter = new JsonResponseWriter2<Enhet>();
		JsonReader<JsonDtoContainer<Enhet>> jsonReader = new JsonReader<JsonDtoContainer<Enhet>>();
		jsonReader.set(new JsonDtoContainer<Enhet>());
		Enhet enhet = new Enhet();
		enhet.setNavn("kalle");
		String jsonString = jsonWriter.setJsonResult_Common_GetComposite("user", enhet);
		assertNotNull(jsonString);

		JsonDtoContainer<Enhet> result =  (JsonDtoContainer<Enhet> )jsonReader.get(jsonString);

		Enhet rEnhet = (Enhet) result.getDtoList().get(0);
		assertEquals("Should be kalle", rEnhet.getNavn(), enhet.getNavn());
		
	}
	

	
	@Test
	public final void testJsonDtoContainerFile() throws Exception{
		JsonReader<JsonDtoContainer<Enhet>> jsonReader = new JsonReader<JsonDtoContainer<Enhet>>();
		jsonReader.set(new JsonDtoContainer<Enhet>());
		Enhet enhet = new Enhet();
		enhet.setNavn("kalle");
		String jsonString = readFile("json.txt");
		assertNotNull(jsonString);

		JsonDtoContainer<Enhet> result =  (JsonDtoContainer<Enhet> )jsonReader.get(jsonString);

		Enhet rEnhet = (Enhet) result.getDtoList().get(0);
		assertEquals("Should be kalle", rEnhet.getNavn(), enhet.getNavn());
		
	}	
	
	

	private String readFile(String jsonFile) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		InputStream input = classLoader.getResourceAsStream("no/systema/jservices/common/json/" + jsonFile);
		StringBuilder builder = new StringBuilder();
		int ch;
		while ((ch = input.read()) != -1) {
			builder.append((char) ch);
		}

		return builder.toString();

	}	



}
