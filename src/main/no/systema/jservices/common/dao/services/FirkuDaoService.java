package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.FirkuDao;

public interface FirkuDaoService extends GenericDaoService<FirkuDao> {	

	/**
	 * Get the one FirkuDao
	 * 
	 * @return FirkuDao
	 */
	public FirkuDao get();
	
	/**
	 * Check if customer is adresscustomer
	 * @param kundnr
	 * @return true if adresscustomer, else false.
	 */
	public boolean isAdressCustomer(int kundnr);
	
}
