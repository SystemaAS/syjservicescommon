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
 * @date Maj 02, 2017
 * 
 */
public class SvtfiDao implements IDao {
	
	private String svtf_sigm = "";                                
	public void setSvtf_sigm (String value){ this.svtf_sigm = value;   }   
	public String getSvtf_sigm (){ return this.svtf_sigm;   }  
	
	private String svtf_0004 = "";                                
	public void setSvtf_0004 (String value){ this.svtf_0004 = value;   }   
	public String getSvtf_0004 (){ return this.svtf_0004;   }  
	
	private String svtf_0008 = "";                                
	public void setSvtf_0008 (String value){ this.svtf_0008 = value;   }   
	public String getSvtf_0008 (){ return this.svtf_0008;   }  
	
	private String svtf_0010 = "";                                
	public void setSvtf_0010 (String value){ this.svtf_0010 = value;   }   
	public String getSvtf_0010 (){ return this.svtf_0010;   }  
	
	private String svtf_0014 = "";                                
	public void setSvtf_0014 (String value){ this.svtf_0014 = value;   }   
	public String getSvtf_0014 (){ return this.svtf_0014;   }  
	
	private String svtf_0022 = "";                                
	public void setSvtf_0022 (String value){ this.svtf_0022 = value;   }   
	public String getSvtf_0022 (){ return this.svtf_0022;   }  
	
	private String svtf_0035 = "";                                
	public void setSvtf_0035 (String value){ this.svtf_0035 = value;   }   
	public String getSvtf_0035 (){ return this.svtf_0035;   }  
	
	private String svtf_pref = "";                                
	public void setSvtf_pref (String value){ this.svtf_pref = value;   }   
	public String getSvtf_pref (){ return this.svtf_pref;   }  
	
	private String svtf_numb = "";                                
	public void setSvtf_numb (String value){ this.svtf_numb = value;   }   
	public String getSvtf_numb (){ return this.svtf_numb;   }  
	
	private String svtf_kval = "";                                
	public void setSvtf_kval (String value){ this.svtf_kval = value;   }   
	public String getSvtf_kval (){ return this.svtf_kval;   }  
	
	private String svtf_sec1 = "";                                
	public void setSvtf_sec1 (String value){ this.svtf_sec1 = value;   }   
	public String getSvtf_sec1 (){ return this.svtf_sec1;   }  
	
	private String svtf_sec2 = "";                                
	public void setSvtf_sec2 (String value){ this.svtf_sec2 = value;   }   
	public String getSvtf_sec2 (){ return this.svtf_sec2;   }  
	
	
	private String svtf_cer1 = "";                                
	public void setSvtf_cer1 (String value){ this.svtf_cer1 = value;   }   
	public String getSvtf_cer1 (){ return this.svtf_cer1;   }  
	
	private String svtf_cer2 = "";                                
	public void setSvtf_cer2 (String value){ this.svtf_cer2 = value;   }   
	public String getSvtf_cer2 (){ return this.svtf_cer2;   }  
		
	
	
	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		//keys.put("svtf_?", svtf_?); //No keys in this table 
		return keys;
	}
	
}
