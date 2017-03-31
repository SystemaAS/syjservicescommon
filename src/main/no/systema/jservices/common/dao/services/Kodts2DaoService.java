package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Kodts2Dao;

public interface Kodts2DaoService extends GenericDaoService<Kodts2Dao> {
	
	/**
	 * Retrieves all Kodts2Dao where ks2uni = S2
	 * 
	 * @return a list with Kodts2Dao
	 */
	public List<Kodts2Dao> getS2Koder();
	
	/**
	 * Check if ks2lk exist where ks2uni = S2
	 * 
	 * @return true is exist, else false
	 */
	public boolean lkKodeExist(String ks2lk);	
	
}
