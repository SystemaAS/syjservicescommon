package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViskundeDao;

public interface ViskundeDaoService extends GenericDaoService<ViskundeDao> {
	
	/**
	 * Find unique ViskundeDao on kundnr.
	 * 
	 * firma is joined.
	 * 
	 * 
	 * @param kundnr
	 * @return ViskundeDao return null if more than one tuple is found. Meaning inconsisteny in database.
	 */
	public ViskundeDao find(String kundnr);
	
}
