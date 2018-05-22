package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VistranskDao;

public interface VistranskDaoService extends GenericDaoService<VistranskDao> {
	
	/**
	 * Find all vistransk  in firma on posnr and/or syncda.
	 * 
	 * @param posnr
	 * @param syncda
	 * @return List<CundfDao>
	 */
	public List<VistranskDao> findAllInFirma(int posnr , int syncda);
	
	
	/**
	 * Update on error
	 * @param dao with values in syncda and syerror
	 * 
	 */
	public void updateOnError(VistranskDao dao);	
	
}
