package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.LevefDao;

public interface LevefDaoService extends GenericDaoService<LevefDao> {
	
	/**
	 * Find all supplier inn firma.
	 * 
	 * @param Map<String, Object> params if null: all LevefDao
	 * @return List<LevefDao>
	 */
	public List<LevefDao> findAllInFirma(Map<String, Object> params);	
	
	/**
	 * Retrieves all LevefDao where levnr and lnavn LIKE arg.
	 * 
	 * @param levnr with LIKE search, can be null
	 * @param lnavn with LIKE search, ignoring case. Can be null
	 * @return a list with LevefDao
	 */
	public List<LevefDao> findByLike(Integer levnr, String lnavn);		
	
}
