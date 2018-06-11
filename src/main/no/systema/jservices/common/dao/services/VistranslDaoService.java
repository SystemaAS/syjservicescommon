package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VistranslDao;

public interface VistranslDaoService extends GenericDaoService<VistranslDao> {
	
	/**
	 * Find all vistransl  in firma on levnr, bilnr and/or syncda.
	 * 
	 * @param kundnr
	 * @param bilnr
	 * @param syncda
	 * @return List<CundfDao>
	 */
	public List<VistranslDao> findAllInFirma(int kundnr, int bilnr , int syncda);
	
	/**
	 * Delete all vistransk for bilnr in firma. 
	 * Bilnr=fakturanummer
	 * 
	 * @param firma
	 * @param bilnr e.i. fakturanummer
	 */
	public void deleteAll(String firma, int bilnr);
	
	/**
	 * Update Supplier Invoice on error, e.i. all rows on firma, recnr and bilnr.
	 * 
	 * A bit nasty but Visma does not report error on lines.
	 * 
	 * @param dao with values in firma, recnr, bilnr,syncda and syerror
	 * 
	 */
	public void updateOnError(VistranslDao dao);		
	
	
	
}
