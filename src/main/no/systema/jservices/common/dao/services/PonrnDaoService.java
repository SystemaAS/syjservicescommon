package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.PonrnDao;

public interface PonrnDaoService extends GenericDaoService<PonrnDao> {

	/**
	 * Retrieves all PonrnDao 
	 * 
	 * @param ponnr.
	 * @return a list with PonrnDao
	 */
	public List<PonrnDao> findByLike(String ponnr);
	
}
