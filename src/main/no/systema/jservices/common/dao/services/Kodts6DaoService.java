package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Kodts6Dao;

public interface Kodts6DaoService extends GenericDaoService<Kodts6Dao> {
	
	/**
	 * Retrieves all Kodts6Dao where ks6uni = S6
	 * 
	 * @return a list with Kodts6Dao
	 */
	public List<Kodts6Dao> getS6Koder();
	
	/**
	 * Check if ks6pre exist where ks6uni = S6
	 * 
	 * @return true is exist, else false
	 */
	public boolean preKodeExist(String ks6pre);	
	
}
