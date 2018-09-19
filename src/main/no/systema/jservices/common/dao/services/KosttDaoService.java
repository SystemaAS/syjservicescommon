package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.KosttDao;

public interface KosttDaoService extends GenericDaoService<KosttDao> {
	
	/**
	 * Increment ktnr with 1 and but return current.
	 * 
	 * @param kttyp
	 * @return existing ktnr
	 */
	public int getExistingKtnrAndIncrement(String kttyp);
	
	/**
	 * Substract ktnr with 1.
	 * 
	 * @param kttyp
	 */
	public void substractKtnr(String kttyp);

}
