package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VisleveDao;

public interface VisleveDaoService extends GenericDaoService<VisleveDao> {
	
	/**
	 * Find all visleve in firma on levnr and/or syncda.
	 * 
	 * @param levnr
	 * @param syncda
	 * @return List<VisleveDao>
	 */
	public List<VisleveDao> findAllInFirma(int levnr , int syncda);
	
	
	/**
	 * Update on error
	 * @param dao with values in syncda and syerror
	 * 
	 */
	public void updateOnError(VisleveDao dao);	
	
}
