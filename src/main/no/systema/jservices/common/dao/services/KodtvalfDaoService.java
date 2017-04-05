package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtvalfDao;

public interface KodtvalfDaoService extends GenericDaoService<KodtvalfDao> {
	
	/**
	 * Retrieves all distinct KodtvalfDao where kvauni = VA
	 * 
	 * @return a list with KodtvalfDao
	 */
	public List<KodtvalfDao> getVAKoder();
	
	/**
	 * Check if any vakod exist where kvauni = VA
	 * 
	 * @return true is exist, else false
	 */
	public boolean kvaKodeExist(String kvakod);	
	
}
