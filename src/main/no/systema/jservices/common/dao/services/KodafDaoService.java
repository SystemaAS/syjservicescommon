package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodafDao;

public interface KodafDaoService extends GenericDaoService<KodafDao> {
	

	/**
	 * delegates to findInFirma
	 * 
	 */
	@Override
	public KodafDao find(Object id);	
	
	/**
	 * delegates to findAllInFirma
	 * 
	 */
	@Override
	List<KodafDao> findAll(Map<String, Object> params);
	
}
