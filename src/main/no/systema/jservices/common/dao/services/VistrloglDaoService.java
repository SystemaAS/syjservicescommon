package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VistrloglDao;

public interface VistrloglDaoService extends GenericDaoService<VistrloglDao> {
	
	/**
	 * Find all vistrlogl in firma on bilnr and/or syncda.
	 * 
	 * @param bilnr
	 * @param syncda
	 * @return List<VistrloglDao>
	 */
	public List<VistrloglDao> findAllInFirma(int bilnr , int syncda);
	
}
