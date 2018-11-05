package no.systema.jservices.common.dao.services;

import java.util.List;

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
	
	
	
	/**
	 * Retrieves all KosttDao where ktna LIKE arg.
	 * 
	 * @param ktna with LIKE search, ignoring case.
	 * @return a list with KosttDao
	 */
	public List<KosttDao> findByLike(String ktna);	
	
	

}
