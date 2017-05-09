package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Syparf2Dao;

public interface Syparf2DaoService extends GenericDaoService<Syparf2Dao> {
	
	/**
	 * Retrieve all syparf for sykunr, customer
	 * 
	 * @param sykunr, actual customer
	 * @return a List of SyparfDao, could be empty
	 */
	public List<Syparf2Dao> findAll(String sykunr);
	
	/**
	 * Delete all syparf for sykunr, customer
	 * 
	 * @param sykunr, actual customer
	 */
	public void deleteAll(String sykunr);
	
	/**
	 * Get unique syparf
	 * 
	 * @param syuser, user
	 * @param syrecn, recordnr
	 * @return a {@link Syparf2Dao}, i found, else null
	 */
	public Syparf2Dao find(String syuser, String syrecn);
	
	
}
