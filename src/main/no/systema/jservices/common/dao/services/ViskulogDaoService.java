package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.ViskulogDao;

public interface ViskulogDaoService extends GenericDaoService<ViskulogDao> {
	
	/**
	 * Find all viskulog in firma on kundnr and/or syncda.
	 * 
	 * @param kundnr
	 * @param syncda
	 * @return List<ViskulogDao>
	 */
	public List<ViskulogDao> findAllInFirma(int kundnr , int syncda);
	
}
