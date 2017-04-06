package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Kodts8Dao;

public interface Kodts8DaoService extends GenericDaoService<Kodts8Dao> {
	
	/**
	 * Retrieves all Kodts8Dao where ks8skv is not null
	 * 
	 * @return a list with Kodts8Dao
	 */
	public List<Kodts8Dao> getKoder();

}
