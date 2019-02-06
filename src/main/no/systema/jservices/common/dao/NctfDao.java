package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) NCTF - Not-valid city codes for tradevision. 
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
@Data
public class NctfDao implements IDao {
	
	private String nccicd; 		//3 VARCHAR - City code
	private String nctext; 		//30 VARCHAR - City name
		
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("nccicd", nccicd);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
