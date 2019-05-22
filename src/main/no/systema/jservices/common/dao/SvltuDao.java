package no.systema.jservices.common.dao;

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
	
	private Map<String, Object> keys = null;
	
	@Override
	public Map<String, Object> getKeys() {
		return keys;
	}

}
