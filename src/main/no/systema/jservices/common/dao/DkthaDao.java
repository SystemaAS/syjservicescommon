package no.systema.jservices.common.dao;
import java.io.Serializable;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
/**
 * All variables must be initialized to empty strings and NOT to NULL values
 * This is because the db-inserts that will be done in all fields of the db-table
 * 
 * @author oscardelatorre
 * @date Mar 21, 2017
 * 
 */
public class DkthaDao implements IDao {

	private String dkth_sysg = "";                                
	public void setDkth_sysg (String value){ this.dkth_sysg = value;   }   
	public String getDkth_sysg (){ return this.dkth_sysg;   }  
	
	private String dkth_namn = ""; 
	public void setDkth_namn (String value){ this.dkth_namn = value;   }   
	public String getDkth_namn (){ return this.dkth_namn;   }              

	private String dkth_usid = "";
	public void setDkth_usid (String value){ this.dkth_usid = value;   }   
	public String getDkth_usid (){ return this.dkth_usid;   }              

	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("dkth_sysg", dkth_sysg); 
		return keys;
	}
	
}
