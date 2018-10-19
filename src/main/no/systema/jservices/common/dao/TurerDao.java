package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * This is a Dao light version since we only need a simple select in godsregistrering
 * Feel free to complete with all other columns if you need.
 * 
 * @author oscardelatorre
 * @date Oct 2018
 * 
 */
@Data
public class TurerDao implements IDao {
	private String tupro; 		//? VARCHAR  
	private String tubiln; 		//5 VARCHAR
	
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
