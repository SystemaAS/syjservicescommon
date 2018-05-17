package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.CundfDao;

public interface CundfDaoService extends GenericDaoService<CundfDao> {
	
	/**
	 * Find all customer inn firma.
	 * 
	 * @params Map<String, Object> params if null: all Cundf
	 * @return List<CundfDao>
	 */
	public List<CundfDao> findAllInFirma(Map<String, Object> params);
	
	
}
