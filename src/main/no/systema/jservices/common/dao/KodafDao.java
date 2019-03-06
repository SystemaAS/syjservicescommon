package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @author fredrikmoller
 * @date 2019-03-06
 */
@Data
public class KodafDao implements IDao {

	private String aktkod;
	private String betbet; //key
	private BigDecimal bettid;
	private String bettxt;
	private String bfkdta;
	private String firma;
	private String frilev;
	private BigDecimal journr;
	private BigDecimal kondag;
	private BigDecimal konrab;
	private String tidber;	

	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("betbet", betbet);
		return keys;
	}

}
