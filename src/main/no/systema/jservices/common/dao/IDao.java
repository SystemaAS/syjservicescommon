package no.systema.jservices.common.dao;

import java.util.Map;

/**
 * Grandmother for all normal Dao entities
 * @author oscardelatorre
 * @date May 18, 2016
 */
public interface IDao { 
	
	/**
	 * Added table keys in Map
	 * 
	 * @return A Map with table keys
	 */
	public Map<String, Object> getKeys();
	
}
