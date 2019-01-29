package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) FFR10F - child table for tradevision-Shipper booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr10fDao implements IDao {
	
	private Integer f10rec = 0; //9,0 PAKKET - Rec.no/Trans ID.  
	private String f1082; 		//3 VARCHAR - Contact ID
	private String f1084; 		//25 VARCHAR - Contact No
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("f10rec", f10rec);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
