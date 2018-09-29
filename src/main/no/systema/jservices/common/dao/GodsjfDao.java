package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;


@Data
public class GodsjfDao implements IDao {
	private String gogn; 		//15 VARCHAR  
	private String gomott; 		//15 VARCHAR
	private String gobiln; 		//13 VARCHAR
	private String goavg;  		//15 VARCHAR
	private String gotrnr; 		//20 VARCHAR
	private String gotrdt;  		//8 SONET
	private String gorei1;  	//20 VARCHAR
	private String gorei2;  	//20 VARCHAR
	private String gorei3;  	//20 VARCHAR
	private String gorei4;  	//20 VARCHAR
	private String gogren;  	//20 VARCHAR
	private String gogrdt;  		//8 SONET
	private Integer gogrkl = 0;  		//4 SONET
	private String golsen;  	//20 VARCHAR
	private String golsdt;  		//8 SONET
	private Integer golskl = 0; 		//4 SONET
	private String gotype; 		//20 VARCHAR
	private String goturn;		//17 VARCHAR
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("gogn", gogn);
		keys.put("gotrnr", gotrnr);
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
