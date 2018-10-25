package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KostbDao;

public interface KostbDaoService extends GenericDaoService<KostbDao> {

	/**
	 * Find all KostbDao on kabnr
	 * 
	 * @param innregnr
	 * @return list of KostbDao
	 */
	List<KostbDao> findByKabnr(Integer innregnr);
	
}
