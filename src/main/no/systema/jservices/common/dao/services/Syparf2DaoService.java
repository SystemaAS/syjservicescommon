package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SyparfDao;

public interface Syparf2DaoService extends GenericDaoService<SyparfDao> {
	
	/**
	 * Retrieve all syparf for syuser, user
	 * 
	 * @param syuser, actual user
	 * @return a List of SyparfDao, could be empty
	 */
	public List<SyparfDao> findAll(String syuser);
	
	/**
	 * Delete all syparf for syuser, user
	 * 
	 * @param syuser, actual user
	 */
	public void deleteAll(String syuser);
	
	/**
	 * Get unique syparf
	 * 
	 * @param syuser, user
	 * @param syrecn, recordnr
	 * @return a {@link SyparfDao}, i found, else null
	 */
	public SyparfDao find(String syuser, String syrecn);
	
	
}
