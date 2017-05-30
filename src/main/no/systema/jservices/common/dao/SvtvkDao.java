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
 * @date Maj 19, 2017
 * 
 */
public class SvtvkDao implements IDao  {

	private String svvk_kd = "";                                
	public void setSvvk_kd (String value){ this.svvk_kd = value;   }   
	public String getSvvk_kd (){ return this.svvk_kd;   }  
	
	private String svvk_dts = ""; 
	public void setSvvk_dts (String value){ this.svvk_dts = value;   }   
	public String getSvvk_dts (){ return this.svvk_dts;   }              

	private String svvk_dte = "";
	public void setSvvk_dte (String value){ this.svvk_dte = value;   }   
	public String getSvvk_dte (){ return this.svvk_dte;   }              

	private String svvk_omr = "";
	public void setSvvk_omr (String value){ this.svvk_omr = value;   }   
	public String getSvvk_omr (){ return this.svvk_omr;   }              

	private String svvk_krs = ""; 
	public void setSvvk_krs (String value){ this.svvk_krs = value;   }   
	public String getSvvk_krs (){ return this.svvk_krs;   }              

	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svvk_kd", svvk_kd);
		
		return keys;
	}
	
}
