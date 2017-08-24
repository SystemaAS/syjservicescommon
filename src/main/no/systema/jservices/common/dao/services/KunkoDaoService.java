package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KunkoDao;

public interface KunkoDaoService extends GenericDaoService<KunkoDao> {

	/**
	 * Retrieves all <b>KunkoDao</b>.
	 * 
	 * @param kukun1 
	 * @return a list with {@link KunkoDao} filtered on kukun1
	 */
	public List<KunkoDao> getList(int kukun1);		
	
}
