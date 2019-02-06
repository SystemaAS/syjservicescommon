package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) CNFF - Issuing carrier file for tradevision. 
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
@Data
public class IsufDao implements IDao {
	
	private Integer isprf = 0; 	//3,0 PAKKET - Prefix
	private String iscode; 		//3 VARCHAR - Code
	private String ispart; 		//17 VARCHAR - Participant ID
		
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("isprf", isprf);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
