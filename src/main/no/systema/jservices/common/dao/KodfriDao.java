package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class KodfriDao implements IDao {

	private String kfsodk;
	private String kfsoko; //key
	private String kfsotx;
	private String kfsttu;	
	
	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("kfsoko", kfsoko);
		return keys;
	}

}
