package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) validate user
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class LocfDao implements IDao {
	private String loid; 		//17 VARCHAR  
	private String loneta; 		//35 VARCHAR
	private String lonam; 		//35 VARCHAR
	private String lodefa;  	//17 VARCHAR
	
	private String lopaqa;  	//4 VARCHAR
	private String losita;  	//7 VARCHAR
	private String loprt;  		//10 VARCHAR
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("loid", loid);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
