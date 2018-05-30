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
	 * Delete all vistransk for bilnr in firma. 
	 * Bilnr=fakturanummer
	 * 
	 * @param firma
	 * @param bilnr e.i. fakturanummer
	 */
	public void deleteAll(String firma, int bilnr);
	
	/**
	 * Update Invoice on error, e.i. all rows on firma and bilnr.
	 * 
	 * A bit nasty but Visma does not report error on lines.
	 * 
	 * @param dao with values in firma, bilnr,syncda and syerror
	 * 
	 */
	public void updateOnError(VistranskDao dao);		
	
	
	
}
