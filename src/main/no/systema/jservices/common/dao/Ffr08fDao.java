package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) FFR08F - child table for tradevision- Dimensions booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr08fDao implements IDao {
	
	private Integer f08rec = 0; //9,0 PAKKET - Rec.no/Trans ID.  
	private String f0831; 		//1 VARCHAR - Weight Code
	private BigDecimal f0832 = new BigDecimal(0); 		//8,1 PAKKET - Weight
	private String f0851;  		//3 VARCHAR - Measurem. Unit code 
	private Integer f0852 = 0;  //5,0 PAKKET -  Lenght Dim.
	private Integer f0854 = 0;  //5,0 PAKKET -  Width Dim.
	private Integer f0856 = 0;  //5,0 PAKKET -  Height Dim.
	private Integer f0857 = 0;  //4,0 PAKKET -  No. of Pieces
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("f08rec", f08rec);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
