package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellDao;

public interface TellDaoService extends GenericDaoService<TellDao> {
	
	/**
	 * Increment geno with 1 and return it updated.
	 * 
	 * @param teavd, actual avdeling.
	 * @return updated teopdn
	 */
	public int getTeopdnAndIncrement(int teavd);
	
	/**
	 * Substract teopdn with 1.
	 * 
	 * @param teavd, actual avdeling.
	 */
	public void substractTeopdn(int teavd);

}
