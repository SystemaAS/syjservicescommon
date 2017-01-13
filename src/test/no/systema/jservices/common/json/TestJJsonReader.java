package no.systema.jservices.common.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import no.systema.jservices.common.brreg.proxy.entities.Enhet;
import no.systema.jservices.common.brreg.proxy.entities.Postadresse;

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
		String jsonString = readFile("json.txt");
		assertNotNull(jsonString);

		JsonDtoContainer<Enhet> result =  (JsonDtoContainer<Enhet> )jsonReader.get(jsonString);

		Enhet rEnhet = (Enhet) result.getDtoList().get(0);
		
	}	
	
	@Test
	public final void testConvertValue() {
		JsonReader<Map> jsonReader = new JsonReader<Map>();
		jsonReader.set(new HashMap<String, Object>());

		Enhet enhet = new Enhet();
		enhet.setNavn("kalle anka");
		Postadresse pa = new Postadresse();
		pa.setPostnummer("111");
		pa.setPoststed("Oslo");
		enhet.setPostadresse(pa);

		Map<String, Object> enhetsMap = jsonReader.convertValue(enhet, Map.class);
		
		Iterator itKeys = enhetsMap.keySet().iterator();
		for (Iterator iterator = itKeys; iterator.hasNext();) {
			String prop = (String) iterator.next();
			System.out.println("key=" + prop + ", value=" + enhetsMap.get(prop));
		}
				
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
