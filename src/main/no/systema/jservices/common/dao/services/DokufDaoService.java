package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.HeadfDao;

public interface DokufDaoService extends GenericDaoService<DokufDao> {
	
	/**
	 * Create, e.g. copy much of data from {@link HeadfDao}
	 * 
	 * @param headfDao a populated dao.
	 */
	public void create(HeadfDao headfDao);

}
