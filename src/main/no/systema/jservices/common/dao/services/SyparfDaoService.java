package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SyparfDao;
import no.systema.jservices.common.dto.SyparfDto;

public interface SyparfDaoService extends GenericDaoService<SyparfDao> {
	
	/**
	 * Retrieve all syparf for sykunr, customer
	 * 
	 * @param sykunr, actual customer
	 * @return a List of SyparfDao, could be empty
	 */
	public List<SyparfDao> findAll(String sykunr);
	
	/**
	 * Get unique syparf
	 * 
	 * @param sykunr, customer
	 * @param syrecn, recordnr
	 * @return a {@link SyparfDao}, i found, else null
	 */
	public SyparfDao find(String sykunr, String syrecn);
}
