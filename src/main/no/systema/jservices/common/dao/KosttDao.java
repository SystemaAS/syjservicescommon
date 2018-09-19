package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Teller for misc in Kostnadsföring
 * 
 * @author fredrikmoller
 * @dato 2018-09-19
 */
@Data
public class KosttDao implements IDao {

	private String ktna;
	private int ktnr;
	private String kttyp; //key
	
	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("kttyp", kttyp);
		return keys;
	}

}
