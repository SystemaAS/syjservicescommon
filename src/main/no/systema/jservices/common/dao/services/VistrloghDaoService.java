package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VistrloghDao;

public interface VistrloghDaoService extends GenericDaoService<VistrloghDao> {
	
	/**
	 * Find all vistrlogh in firma on bilnr and/or syncda.
	 * 
	 * @param bilnr
	 * @param syncda
	 * @return List<VistrloglDao>
	 */
	public List<VistrloghDao> findAllInFirma(int bilnr , int syncda);
	
}
