package no.systema.jservices.common.dao.services;


import java.util.List;

import no.systema.jservices.common.dao.GodsjfDao;


/**
 * 
 * @author oscardelatorre
 * @date Jun-2018
 */
public interface GodsjfDaoService extends GenericDaoService<GodsjfDao> {
	
	public List<GodsjfDao> findDefault(String currentYear, String fromDay, GodsjfDao dao);

}
