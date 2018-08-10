package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ViscrossrDao implements IDao {

	private String svsysp;
	private String svvism;	
	private String svtype;
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svsysp", svsysp);
		keys.put("svtype", svtype);
		return keys;
	}

}
