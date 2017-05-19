package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SviwDao;

public interface SviwDaoService extends GenericDaoService<SviwDao> {
	
	/**
	 * Get unique sviw
	 * 
	 * @param sviw_knnr, customer
	 * @param sviw_knso, product
	 * @return a {@link SviwDao}, i found, else null
	 */
	public SviwDao find(int sviw_knnr, String sviw_knso);
	
	
	/**
	 * Retrieve all sviws for sviw_knnr, customer
	 * 
	 * @param sviw_knnr, actual customer
	 * @return a List of {@link SviwDao}, could be empty
	 */
	public List<SviwDao> findAll(String sviw_knnr);		
	
		
}
