package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ValufDao;

public interface ValufDaoService extends GenericDaoService<ValufDao> {
	
	/**
	 * Check if currencycode exist, e.g name, valkod, kaval
	 * 
	 * @param currencyCode
	 * @return true if exist, else false;
	 */
	public boolean exist(String currencyCode);
	
	
}
