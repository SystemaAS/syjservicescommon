package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Svtx03fDao;

public interface Svtx03fDaoService extends GenericDaoService<Svtx03fDao> {
	
	/**
	 * Retrieves all Svtx03fDao where svtx03_01 = 'A' and svtx03_02 = 'GCY'
	 * 
	 * @return a list with Svtx03fDao
	 */
	public List<Svtx03fDao> getLandKoder();
	
	
	
	/**
	 * Check if svtx03_03 (id)  exist  where svtx03_01 = 'A' and svtx03_02 = 'GCY'
	 * 
	 * @return true is exist, else false
	 */
	public boolean landKodeExist(String landkode);		
	
}
