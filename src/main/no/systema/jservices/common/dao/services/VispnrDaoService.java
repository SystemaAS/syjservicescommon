package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.VispnrDao;

public interface VispnrDaoService extends GenericDaoService<VispnrDao> {
	
	/**
	 * Check if landkode exist in Vispnr
	 * 
	 * @param vilk
	 * @return true if landkode exist, else false
	 */
	public boolean landKodeExist(String vilk);

}
