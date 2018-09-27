package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;


@Data
public class GodsfiDao implements IDao {
	private String gflbko; 		//5 VARCHAR
	private String gfenh; 		//1 VARCHAR
	private String gflbs1; 		//30 VARCHAR
	private String gflbs2; 		//30 VARCHAR
	private String gflbs3; 		//30 VARCHAR
	private String gflbs4; 		//30 VARCHAR
	private String gfprt; 		//10 VARCHAR
	private String gffax; 		//15 VARCHAR
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("gflbko", gflbko);
		keys.put("gfenh", gfenh);
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
