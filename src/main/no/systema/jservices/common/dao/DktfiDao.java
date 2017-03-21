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
 * @date Mar 14, 2017
 * 
 */
public class DktfiDao implements IDao {

	private String dktf_0004t = "";                                
	public void setDktf_0004t (String value){ this.dktf_0004t = value;   }   
	public String getDktf_0004t (){ return this.dktf_0004t;   }  
	
	private String dktf_0010t = "";                                
	public void setDktf_0010t (String value){ this.dktf_0010t = value;   }   
	public String getDktf_0010t (){ return this.dktf_0010t;   }  
	
	private String dktf_0022t = "";                                
	public void setDktf_0022t (String value){ this.dktf_0022t = value;   }   
	public String getDktf_0022t (){ return this.dktf_0022t;   }  
	
	private String dktf_0031t = "";                                
	public void setDktf_0031t (String value){ this.dktf_0031t = value;   }   
	public String getDktf_0031t (){ return this.dktf_0031t;   }  
	
	private String dktf_ftipt = "";                                
	public void setDktf_ftipt (String value){ this.dktf_ftipt = value;   }   
	public String getDktf_ftipt (){ return this.dktf_ftipt;   }  
	
	private String dktf_ftust = "";                                
	public void setDktf_ftust (String value){ this.dktf_ftust = value;   }   
	public String getDktf_ftust (){ return this.dktf_ftust;   }  
	
	private String dktf_ftpwt = "";                                
	public void setDktf_ftpwt (String value){ this.dktf_ftpwt = value;   }   
	public String getDktf_ftpwt (){ return this.dktf_ftpwt;   }  
	
	//PROD
	private String dktf_0004p = "";                                
	public void setDktf_0004p (String value){ this.dktf_0004p = value;   }   
	public String getDktf_0004p (){ return this.dktf_0004p;   }  
	
	private String dktf_0010p = "";                                
	public void setDktf_0010p (String value){ this.dktf_0010p = value;   }   
	public String getDktf_0010p (){ return this.dktf_0010p;   }  
	
	private String dktf_0022p = "";                                
	public void setDktf_0022p (String value){ this.dktf_0022p = value;   }   
	public String getDktf_0022p (){ return this.dktf_0022p;   }  
	
	private String dktf_0031p = "";                                
	public void setDktf_0031p (String value){ this.dktf_0031p = value;   }   
	public String getDktf_0031p (){ return this.dktf_0031p;   }  
	
	private String dktf_ftipp = "";                                
	public void setDktf_ftipp (String value){ this.dktf_ftipp = value;   }   
	public String getDktf_ftipp (){ return this.dktf_ftipp;   }  
	
	private String dktf_ftusp = "";                                
	public void setDktf_ftusp (String value){ this.dktf_ftusp = value;   }   
	public String getDktf_ftusp (){ return this.dktf_ftusp;   }  
	
	private String dktf_ftpwp = "";                                
	public void setDktf_ftpwp (String value){ this.dktf_ftpwp = value;   }   
	public String getDktf_ftpwp (){ return this.dktf_ftpwp;   }  
	
	private String dktf_lsli = "";                                
	public void setDktf_lsli (String value){ this.dktf_lsli = value;   }   
	public String getDktf_lsli (){ return this.dktf_lsli;   }  
	
	
	
	Map<String, Object> keys = new HashMap<String, Object>();
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("dktf_0004t", dktf_0004t); //No keys in this table 
		return keys;
	}
	
}
