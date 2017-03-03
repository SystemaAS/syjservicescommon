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
 * @date Mar 03, 2017
 * 
 */
public class DktseDao implements IDao {

	private String dkse_knr = "";                                
	public void setDkse_knr (String value){ this.dkse_knr = value;   }   
	public String getDkse_knr (){ return this.dkse_knr;   }  
	
	private String dkse_331 = ""; 
	public void setDkse_331 (String value){ this.dkse_331 = value;   }   
	public String getDkse_331 (){ return this.dkse_331;   }              

	private String dkse_34 = "";
	public void setDkse_34 (String value){ this.dkse_34 = value;   }   
	public String getDkse_34 (){ return this.dkse_34;   }              

	private String dkse_4421 = "";
	public void setDkse_4421 (String value){ this.dkse_4421 = value;   }   
	public String getDkse_4421 (){ return this.dkse_4421;   }              

	private String dkse_442A = ""; 
	public void setDkse_442A (String value){ this.dkse_442A = value;   }   
	public String getDkse_442A (){ return this.dkse_442A;   }              

	
	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("dkse_knr", dkse_knr); 
		keys.put("dkse_331", dkse_331); 
		return keys;
	}
	
}
