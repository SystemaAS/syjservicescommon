package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Kodts7Dao;

public interface Kodts7DaoService extends GenericDaoService<Kodts7Dao> {
	
	/**
	 * Retrieves all Kodts7Dao where ks7uni = S7
	 * 
	 * @return a list with Kodts7Dao
	 */
	public List<Kodts7Dao> getS7Koder();
	
	/**
	 * Check if ks7vf exist where ks7uni = S7
	 * 
	 * @return true is exist, else false
	 */
	public boolean vfKodeExist(int ks7vf);	
	
}
