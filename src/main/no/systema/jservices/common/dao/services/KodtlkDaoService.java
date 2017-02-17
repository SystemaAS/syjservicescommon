package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtlkDao;

public interface KodtlkDaoService extends GenericDaoService<KodtlkDao> {
	
	/**
	 * Retrieve all landkoder
	 * 
	 * @return a List with KodtlkDao
	 */
	public List<KodtlkDao> getLandKoder();
	
	/**
	 * Check if klklk exist where KLKUNI="LK" 
	 * 
	 * @return
	 */
	public boolean landKodeExist(String klklk);
	
}
