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
 * @date Maj 08, 2017
 * 
 */
public class SvthaDao implements IDao {
	
	private String svth_sysg = "";                                
	public void setSvth_sysg (String value){ this.svth_sysg = value;   }   
	public String getSvth_sysg (){ return this.svth_sysg;   }  
	
	private String svth_namn = "";                                
	public void setSvth_namn (String value){ this.svth_namn = value;   }   
	public String getSvth_namn (){ return this.svth_namn;   }  
	
	private String svth_usid = "";                                
	public void setSvth_usid (String value){ this.svth_usid = value;   }   
	public String getSvth_usid (){ return this.svth_usid;   }  
	
	private String svth_ann = "";                                
	public void setSvth_ann (String value){ this.svth_ann = value;   }   
	public String getSvth_ann (){ return this.svth_ann;   }  
	
	private String svth_annn = "";                                
	public void setSvth_annn (String value){ this.svth_annn = value;   }   
	public String getSvth_annn (){ return this.svth_annn;   }  
	
	private String svth_sms = "";                                
	public void setSvth_sms (String value){ this.svth_sms = value;   }   
	public String getSvth_sms (){ return this.svth_sms;   }  
	
	private String svth_pwd = "";                                
	public void setSvth_pwd (String value){ this.svth_pwd = value;   }   
	public String getSvth_pwd (){ return this.svth_pwd;   }  
	
	private String svth_pwdd = "";                                
	public void setSvth_pwdd (String value){ this.svth_pwdd = value;   }   
	public String getSvth_pwdd (){ return this.svth_pwdd;   }  
	
	private String svth_lock = "";                                
	public void setSvth_lock (String value){ this.svth_lock = value;   }   
	public String getSvth_lock (){ return this.svth_lock;   }  
	
	private String svth_tlf = "";                                
	public void setSvth_tlf (String value){ this.svth_tlf = value;   }   
	public String getSvth_tlf (){ return this.svth_tlf;   }  
	
	
	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svth_sysg", svth_sysg); //Only implicit key?
		return keys;
	}
	
}
