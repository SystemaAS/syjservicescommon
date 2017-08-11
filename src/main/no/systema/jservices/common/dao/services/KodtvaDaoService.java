package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtvaDao;

public interface KodtvaDaoService extends GenericDaoService<KodtvaDao> {
	
	/**
	 * Retrieves all distinct KodtvaDao 
	 * 
	 * @return a list with KodtvalDao
	 */
	public List<KodtvaDao> getKoder();


}
