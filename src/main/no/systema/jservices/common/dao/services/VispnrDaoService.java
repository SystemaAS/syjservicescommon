package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.VispnrDao;

public interface VispnrDaoService extends GenericDaoService<VispnrDao> {
	
	/**
	 * Check if landkode exist in Vispnr
	 * Note: Validation is only done if Firmvis has row.
	 * 
	 * @param vilk
	 * @return true if landkode exist, else false
	 */
	public boolean landKodeExist(String vilk);
	
	/**
	 * Note: Validation is only done if Firmvis has row.
	 */
	@Override
	boolean exist(Object id);

}
