package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.FirmvisDao;

public interface FirmvisDaoService extends GenericDaoService<FirmvisDao> {
	
	/**
	 * Get single tuple in FirmvisDao.
	 * 
	 * FIRMVIS support only one corporateID
	 * 
	 * @return FirmvisDao
	 * @throws RuntimeException if no value found.
	 */
	public FirmvisDao get();
	

}
