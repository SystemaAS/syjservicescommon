package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViskundeDao;

public interface ViskundeDaoService extends GenericDaoService<ViskundeDao> {
	
	
	/**
	 * Update on error
	 * @param dao with values in syncda and syerror
	 * 
	 */
	public void updateOnError(ViskundeDao dao);	
	
}
