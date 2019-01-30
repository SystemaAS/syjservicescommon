package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KostbDao;

public interface KostbDaoService extends GenericDaoService<KostbDao> {

	/**
	 * Find all KostbDao on kbbnr
	 * 
	 * @param kbbnr
	 * @return list of KostbDao
	 */
	List<KostbDao> findByKbbnr(Integer kbbnr);
	
	
	/**
	 * Calculate sum of all rows on kbblhb (Belop) for a Kosta
	 * 
	 * 
	 * @param kbbnr
	 * @return sum of kbblhb
	 */
	double getFordelt(Integer kbbnr);
	
	
}
