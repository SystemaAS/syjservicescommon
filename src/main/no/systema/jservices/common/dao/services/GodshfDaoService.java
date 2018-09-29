package no.systema.jservices.common.dao.services;


import java.util.List;

import no.systema.jservices.common.dao.GodshfDao;


/**
 * 
 * @author oscardelatorre
 * @date Jun-2018
 */
public interface GodshfDaoService extends GenericDaoService<GodshfDao> {
	
	public List<GodshfDao> findDefault(String currentYear, String fromDay, GodshfDao dao);
	
}
