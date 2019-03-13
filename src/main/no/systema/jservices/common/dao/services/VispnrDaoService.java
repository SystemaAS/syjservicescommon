package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.FirmvisDao;
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
	
	/**
	 * Check if values exists in {@linkplain FirmvisDao}
	 * 
	 * 
	 * @return true if exist, false otherwise
	 */
	boolean hasVismaIntegration();

}
