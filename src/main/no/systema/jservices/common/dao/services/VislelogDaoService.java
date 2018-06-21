package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VislelogDao;

public interface VislelogDaoService extends GenericDaoService<VislelogDao> {
	
	/**
	 * Find all vislelog in firma on levnr and/or syncda.
	 * 
	 * @param levnr
	 * @param syncda
	 * @return List<VislelogDao>
	 */
	public List<VislelogDao> findAllInFirma(int kundnr , int syncda);
	
}
