package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VistrlogkDao;

public interface VistrlogkDaoService extends GenericDaoService<VistrlogkDao> {
	
	/**
	 * Find all vistrlogk in firma on bilnr and/or syncda.
	 * 
	 * @param bilnr
	 * @param syncda
	 * @return List<VistrlogkDao>
	 */
	public List<VistrlogkDao> findAllInFirma(int bilnr , int syncda);
	
}
