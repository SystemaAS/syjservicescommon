package no.systema.jservices.common.json;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * This class takes an object an created a Json string based on it.
 * Using Jackson
 * 
 * @author Fredrik Möller
 * @date Dec 5, 2016
 *
 */
public class JsonReader<T> {
	private ObjectMapper mapper = new ObjectMapper();
	private T t;

	public void set(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	/**
	 * Return a Json string based on object provided in constructor. Client is
	 * responsible for casting to specific object.
	 * 
	 * @param payLoad,
	 *            String
	 * @return Json string
	 */
	@SuppressWarnings("unchecked")
	public T get(String payLoad) {
		T result = null;
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {

			result = (T) mapper.readValue(payLoad.getBytes(), t.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Convert an Object into wanted class type using Jackson.
	 * 
	 * @param fromValue
	 * @param toValueType
	 * @return a object
	 */
	public T convertValue(Object fromValue, Class<T> toValueType ) {
		return mapper.convertValue(fromValue, toValueType);
	}
	
	
}
