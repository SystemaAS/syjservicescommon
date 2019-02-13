package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Flyfraktbrev (flyeksport) RATCDF - Rate Class Codes
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
@Data
public class RatcdfDao implements IDao {
	
	private String rast; //1 VARCHAR - Status  
	private String raracd; 		//1 VARCHAR - Rate Class Code
	private String rabesk; 		//30  VARCHAR - Rate description	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("raracd", raracd);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
