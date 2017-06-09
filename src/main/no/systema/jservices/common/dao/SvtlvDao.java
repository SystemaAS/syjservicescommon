package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *@author oscardelatorre
 *@date Jun 3 2017
 */
public class SvtlvDao implements IDao {

	private String svlv_kd = "";      //key                        
	public void setSvlv_kd (String value){ this.svlv_kd = value;   }   
	public String getSvlv_kd (){ return this.svlv_kd;   }  
	
	private String svlv_tr = "";                                
	public void setSvlv_tr (String value){ this.svlv_tr = value;   }   
	public String getSvlv_tr (){ return this.svlv_tr;   }  
	
	private String svlv_tr2 = "";                                
	public void setSvlv_tr2 (String value){ this.svlv_tr2 = value;   }   
	public String getSvlv_tr2 (){ return this.svlv_tr2;   }  
	
	private String svlv_fs = "";                                
	public void setSvlv_fs (String value){ this.svlv_fs = value;   }   
	public String getSvlv_fs (){ return this.svlv_fs;   }  
	
	private String svlv_fsp = "";                                
	public void setSvlv_fsp (String value){ this.svlv_fsp = value;   }   
	public String getSvlv_fsp (){ return this.svlv_fsp;   }  
	
	private String svlv_fs2 = "";                                
	public void setSvlv_fs2 (String value){ this.svlv_fs2 = value;   }   
	public String getSvlv_fs2 (){ return this.svlv_fs2;   }  
	
	private String svlv_fs2p = "";                                
	public void setSvlv_fs2p (String value){ this.svlv_fs2p = value;   }   
	public String getSvlv_fs2p (){ return this.svlv_fs2p;   }  
	
	private String svlv_ok = "";                                
	public void setSvlv_ok (String value){ this.svlv_ok = value;   }   
	public String getSvlv_ok (){ return this.svlv_ok;   }  
	
	private String svlv_kr = "";                                
	public void setSvlv_kr (String value){ this.svlv_kr = value;   }   
	public String getSvlv_kr (){ return this.svlv_kr;   }  
	
	private String svlv_ar = "";                                
	public void setSvlv_ar (String value){ this.svlv_ar = value;   }   
	public String getSvlv_ar (){ return this.svlv_ar;   }  
	
	
	Map<String, Object> keys = new HashMap<String, Object>();	
	public void setKeys(Map<String, Object> keys) { this.keys = keys; }
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svlv_kd", svlv_kd);
		return keys;
	}

}
