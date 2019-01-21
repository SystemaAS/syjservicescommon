package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class VispnrDao implements IDao {

	private String vilk;  //key
	private String vilkna; 
	private String viponr; //key
	private String viregi;
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("vilk", vilk);
		keys.put("viponr", viponr);
		return keys;
	}

}
