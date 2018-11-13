package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtsfDao;

public interface KodtsfDaoService extends GenericDaoService<KodtsfDao> {
	
	/**
	 * Retrieves all KodtsfDao where kosfnv LIKE arg.
	 * 
	 * @param kosfnv with LIKE search, ignoring case.
	 * @return a list with KodtsfDao
	 */
	public List<KodtsfDao> findByLike(String kosfnv);	
	
}
