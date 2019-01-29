package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) FFR11F - child table for tradevision-Consignee booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr11fDao implements IDao {
	
	private Integer f11rec = 0; //9,0 PAKKET - Rec.no/Trans ID.  
	private String f1182; 		//3 VARCHAR - Contact ID
	private String f1184; 		//25 VARCHAR - Contact No
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("f11rec", f11rec);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
