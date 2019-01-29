package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) FFR03F - child table for tradevision booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr03fDao implements IDao {
	
	private Integer f03rec = 0; //9,0 PAKKET - Rec.no/Trans ID.  
	private String f0311; 		//2 VARCHAR - Carrier Code
	private String f0312; 		//5 VARCHAR - Comp NE
	private Integer f0314 = 0;  //2,0 PAKKET - Sced. dep. Day
	
	private String f0315;  		//3 VARCHAR - Sced. dep. Month
	private String f0331;  		//3 VARCHAR - Dep. Airport code
	private String f0332;  		//3 VARCHAR - Arr. Airport code
	private String f035;  		//2 VARCHAR - Space alloc. code
	private String f0362;  		//14 VARCHAR - Allotment ID.
	
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("f03rec", f03rec);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
