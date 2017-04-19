package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.ArktxtDao;

public interface ArktxtDaoService extends GenericDaoService<ArktxtDao> {

	/**
	 * Retrieves all ArktxtDao where arsban is not null
	 * 
	 * @return a list with ArktxtDao
	 */
	public List<ArktxtDao> getAllUploadbane();
}
