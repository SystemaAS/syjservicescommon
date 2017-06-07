package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Svtx10fDao;

public interface Svtx10fDaoService extends GenericDaoService<Svtx10fDao> {
	
	/**
	 * Retrieves all Svtx10fDao where SUBSTR(svtx10_01, 9, 2) = '00'
	 * 
	 * Lenght is 8 for exportnumber
	 * 
	 * @return a list with Svtx10fDao taric nr export
	 */
	public List<Svtx10fDao> getTaricExportNumbers();
	
	/**
	 * Retrieves all Svtx10fDao where SUBSTR(svtx10_01, 9, 2) <> '00'
	 * 
	 * Lenght is 10 for importnumber.
	 * 
	 * @return a list with Svtx10fDao taric nr import
	 */
	public List<Svtx10fDao> getTaricImportNumbers();	
	
	
	/**
	 * Check if svtx10_01 (id)  exist  where SUBSTR(svtx10_01, 9, 2) = '00'
	 * 
	 * @return true is exist, else false
	 */
	public boolean tariExportNrExist(String taricnr);			
	
	/**
	 * Check if svtx10_01 (id)  exist where SUBSTR(svtx10_01, 9, 2) <> '00'
	 * 
	 * @return true is exist, else false
	 */
	public boolean taricImportNrExist(String taricnr);			
	
	
	
	
}
