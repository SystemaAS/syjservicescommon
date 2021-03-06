package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellgeDao;

public interface TellgeDaoService extends GenericDaoService<TellgeDao> {
	
	/**
	 * Increment geno with 1 and return it updated.
	 * 
	 * @param geco, actual code.
	 * @return updated geno
	 */
	public int getGenoAndIncrement(String geco);
	
	/**
	 * Get geno as is and then increment it in db after fetch
	 * @param geco
	 * @return
	 */
	public int getGenoAndIncrementAfterFetch(String geco);
	
	/**
	 * Substract geno with 1.
	 * 
	 * @param geco, actual code.
	 */
	public void substractGeno(String geco);

}
