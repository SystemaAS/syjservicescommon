package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * This class holds transactionlog-value for hovedboks lines.
 *  
 * @author fredrikmoller
 *
 */
@Data
public class VistrloghDao implements IDao {

	private String firma;
	private int bilnr; //key  fakturanummer
	private int bilaar; 
	private int bilmnd;
	private int bildag; 
	private String status;
	private int syncda; //key
	private int synctm; //key
	private String syerro;	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("bilnr", bilnr);
		keys.put("syncda", syncda);
		keys.put("synctm", synctm);
		return keys;
	}

}
