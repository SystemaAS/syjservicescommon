package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class VislelogDao implements IDao {

	private String firma;
	private int levnr; //key
	private String lnavn;
	private String status;
	private int syncda; //key
	private int synctm; //key
	private String syerro;

	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("levnr", levnr);
		keys.put("syncda", syncda);
		keys.put("synctm", synctm);
		return keys;
	}

}
