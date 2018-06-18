package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class VisproDao implements IDao {

	private int sypro;
	private String syerro;
	private int syncda;
	
	private Map<String, Object> keys = new HashMap<String, Object>();		
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("sypro", sypro);
		return keys;
	}

}
