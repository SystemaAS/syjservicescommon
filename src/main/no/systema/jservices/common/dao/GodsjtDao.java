package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;


@Data
public class GodsjtDao implements IDao {
	private String gtgn; 		//15 VARCHAR  
	private String gttrnr; 		//20 VARCHAR
	private String gtpos1; 		//7 VARCHAR
	private Integer gtpos2 = 0;  	//4 INTEGER
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("gtgn", gtgn);
		keys.put("gttrnr", gttrnr);
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
