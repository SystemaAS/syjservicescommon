package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellDao;

public interface TellDaoService extends GenericDaoService<TellDao> {
	
	/**
	 * Increment teopdn with 1 and but return current.
	 * 
	 * @param teavd, actual avdeling.
	 * @return existing teopdn
	 */
	public int getExistingTeopdnAndIncrement(int teavd);
	
	/**
	 * Substract teopdn with 1.
	 * 
	 * @param teavd, actual avdeling.
	 */
	public void substractTeopdn(int teavd);

}
