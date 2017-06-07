package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvtproDao;

public interface SvtproDaoService extends GenericDaoService<SvtproDao> {
	
	/**
	 * Check if  svpr_pr exist where svpr_ie='E'
	 * 
	 * @return true is exist, else false
	 */
	public boolean svpr_prExist(String svpr_pr);			
	
}
