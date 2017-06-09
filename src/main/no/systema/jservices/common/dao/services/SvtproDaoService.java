package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.SvtproDao;

public interface SvtproDaoService extends GenericDaoService<SvtproDao> {
	
	/**
	 * Retrieves all SvtproDao where svpr_ie = 'E'.
	 * 
	 * @return a list with SvtproDao
	 */
	public List<SvtproDao> getEup1Koder();	
	
	/**
	 * Check if  svpr_pr exist where svpr_ie='E'
	 * 
	 * @return true is exist, else false
	 */
	public boolean svpr_prExist(String svpr_pr);			
	
}
