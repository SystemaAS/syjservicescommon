package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtotyDao;

public interface KodtotyDaoService extends GenericDaoService<KodtotyDao> {
	
	/**
	 * Retrieves all oppdragstyper
	 * 
	 * @return a list with KodtotyDao
	 */
	public List<KodtotyDao> getOppdragstyper();
	
	
	
	/**
	 * Check if ko1kod exist where KO1UNI="OTY" 
	 * 
	 * @return true is exist, else false
	 */
	public boolean oppdragsTypeExist(String ko1kod);
	
	
}
