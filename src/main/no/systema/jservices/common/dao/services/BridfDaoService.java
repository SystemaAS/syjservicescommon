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
	

}
