package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;


@Data
public class GodsjfDao implements IDao {
	private String gogn;   
	private String gomott; 
	private String gobiln; 
	private String goavg;  
	private String gotrnr; 
	private int gotrdt;  
	private String gorei1;  
	private String gorei2;  
	private String gorei3;  
	private String gorei4;  
	private String gogren;  
	private int gogrdt;  
	private int gogrkl;  
	private String golsen;  
	private int golsdt;  
	private int golskl; 
	private String gotype; 
	private String goturn;
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("gogn", gogn);
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
