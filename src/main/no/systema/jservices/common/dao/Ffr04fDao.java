package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) FFR04F - child table for tradevision-ULD booking
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class Ffr04fDao implements IDao {
	
	private Integer f04rec = 0; //9,0 PAKKET - Rec.no/Trans ID.  
	private String f0451a; 		//3 VARCHAR - ULD Type
	private String f0452a; 		//4 VARCHAR - ULD serial no.
	private String f0453a;  	//2 VARCHAR - ULD Owner code
	private String f0462a;  	//1 VARCHAR - ULD Loading ind.
	private String f0472a;  	//1 VARCHAR - ULD Weight code
	private BigDecimal f0473a = new BigDecimal(0);  	//8,1 PAKKET - ULD Weight
	
	private String f0451b;  	//3 VARCHAR - ULD type
	private String f0452b;  	//4 VARCHAR - ULD serial no.
	private String f0453b;  	//2 VARCHAR - ULD owner code
	private String f0462b;  	//1 VARCHAR - ULD Loading ind.
	private String f0472b;  	//1 VARCHAR - ULD Weight code
	private BigDecimal f0473b = new BigDecimal(0);  	//8,1 PAKKET - ULD Weight code
	
	private String f0451c;  	//3 VARCHAR - ULD type
	private String f0452c;  	//4 VARCHAR - ULD serial no.
	private String f0453c;  	//2 VARCHAR - ULD owner code
	private String f0462c;  	//1 VARCHAR - ULD Loading ind.
	private String f0472c;  	//1 VARCHAR - ULD Weight code
	private BigDecimal f0473c = new BigDecimal(0);  	//8,1 PAKKET - ULD Weight code
	
	
	
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("f04rec", f04rec);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
