package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.BridfDao;

public interface BridfDaoService extends GenericDaoService<BridfDao> {
	
	/**
	 * Get bibrid on delivered name
	 * 
	 * @param name
	 * @return
	 */
	public String getUserName(String name);
	

	/**
	 * Check if user exist in BRIDF. 
	 * Non-unique, can be same user multiple times.
	 * 
	 * @param name
	 * @return true if user exist, false otherwise
	 */
	public boolean userNameExist(String name);	
	
	
}
