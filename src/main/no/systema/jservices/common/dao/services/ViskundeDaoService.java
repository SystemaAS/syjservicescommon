package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.ViskundeDao;

public interface ViskundeDaoService extends GenericDaoService<ViskundeDao> {
	
	
	/**
	 * Find all viskunde in firma on kundnr and/or syncda.
	 * 
	 * @param kundnr
	 * @param syncda
	 * @return List<CundfDao>
	 */
	public List<ViskundeDao> findAllInFirma(int kundnr , int syncda);
	
	
	/**
	 * Update on error
	 * @param dao with values in syncda and syerror
	 * 
	 */
	public void updateOnError(ViskundeDao dao);	
	
}
