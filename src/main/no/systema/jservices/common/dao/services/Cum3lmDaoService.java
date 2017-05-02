package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.Cum3lmDao;

public interface Cum3lmDaoService extends GenericDaoService<Cum3lmDao> {
	
	/**
	 * Delete all cum3lm-lines for customer.
	 * 
	 * @param m3firm firma
	 * @param m3kund customer
	 */
	public void deleteAll(String m3firm, String m3kund);

}
