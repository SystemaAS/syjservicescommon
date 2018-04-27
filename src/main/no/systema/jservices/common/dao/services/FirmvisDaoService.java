package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.FirmvisDao;

public interface FirmvisDaoService extends GenericDaoService<FirmvisDao> {
	
	/**
	 * Get single tuple in FirmvisDao.
	 * 
	 * FIRMVIS support only one corporateID
	 * 
	 * @return List<FirmvisDao>
	 */
	public FirmvisDao get();
	

}
