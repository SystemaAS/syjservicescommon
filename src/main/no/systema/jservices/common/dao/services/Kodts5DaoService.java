package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Kodts5Dao;

public interface Kodts5DaoService extends GenericDaoService<Kodts5Dao> {
	
	/**
	 * Retrieves all Kodts5Dao where ks5uni = S5
	 * 
	 * @return a list with Kodts5Dao
	 */
	public List<Kodts5Dao> getS5Koder();
	
	/**
	 * Check if ks2tln exist where ks2uni = S5
	 * 
	 * @return true is exist, else false
	 */
	public boolean tlnKodeExist(String ks2tln);	
	
}
