package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Sted2Dao;

public interface Sted2DaoService extends GenericDaoService<Sted2Dao> {

	/**
	 * Retrieves all Sted2Dao where st2kod LIKE %00 + param %.
	 * 
	 * @param st2kod.
	 * @return a list with Sted2Dao
	 */
	public List<Sted2Dao> findByLike(String st2kod);
	
}
