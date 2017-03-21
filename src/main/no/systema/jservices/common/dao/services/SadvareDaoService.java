package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SadvareDao;

public interface SadvareDaoService extends GenericDaoService<SadvareDao> {
	
	/**
	 * Get unique sadvare
	 * 
	 * @param levenr, customer
	 * @param varenr, article number
	 * @return a {@link SadvareDao}, i found, else null
	 */
	public SadvareDao find(String levenr, String varenr);
	
	/**
	 * Retrieve all sadvare for levenr, customer
	 * 
	 * @param levenr, actual customer
	 * @return a List of {@link SadvareDao}, could be empty
	 */
	public List<SadvareDao> findAll(String sykunr);	
	
}
