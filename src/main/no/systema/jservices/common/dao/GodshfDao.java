package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;


@Data
public class GodshfDao implements IDao {
	private String gogn; 		//15 VARCHAR
	private String gotrnr; 		//20 VARCHAR
	private String gohpgm; 		//8 VARCHAR
	private Integer gohdat; 		//8 SONET
	private Integer gohtim; 		//8 SONET
	private String gohusr; 		//10 VARCHAR
	private String gohkod; 		//1 VARCHAR (E=Endret, N=ny)
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("gogn", gogn);
		keys.put("gotrnr", gotrnr);
		keys.put("gohdat", gohdat);
		keys.put("gohtim", gohtim);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
