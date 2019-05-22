package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Utgående handlingar, utöver den i SVLTH.
 * 
 * @author fredrikmoller
 * @date 2019-05-22
 */
@Data
public class SvltuDao implements IDao {

	private String svltu_igl;
	private String svltu_ign;	
	private String svltu_pos;	
	private String svltu_uha;	
	
	Map<String, Object> keys = new HashMap<String, Object>();	
	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("svltu_igl", svltu_igl);
		keys.put("svltu_ign", svltu_ign);
		keys.put("svltu_pos", svltu_pos);
		return keys;
	}

}
