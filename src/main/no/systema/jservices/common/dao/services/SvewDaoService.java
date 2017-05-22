package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SvewDao;

public interface SvewDaoService extends GenericDaoService<SvewDao> {
	
	/**
	 * Get unique svew
	 * 
	 * @param svew_knnr, customer
	 * @param svew_knso, product
	 * @return a {@link SvewDao}, i found, else null
	 */
	public SvewDao find(int svew_knnr, String svew_knso);
	
	
	/**
	 * Retrieve all svews for svew_knnr, customer
	 * 
	 * @param svew_knnr, actual customer
	 * @return a List of {@link SvewDao}, could be empty
	 */
	public List<SvewDao> findAll(String svew_knnr);		


}
