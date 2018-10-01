package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KostaDao;

public interface KostaDaoService extends GenericDaoService<KostaDao> {
	
	/**
	 * Find all {@linkplain KostaDao} on provided search-criteria. <br>
	 * param can be null.
	 * 
	 * @param bilagsnr
	 * @param innregnr
	 * @param faktnr
	 * @param levnr
	 * @param attkode
	 * @param komment
	 * @param fradato (greater than)
	 * @param frapermnd 
	 * @param fraperaar 
	 * @param reklamasjon 
	 * @param status 
	 * @return a List of {@linkplain KostaDao}
	 */
	public List<KostaDao> findAll(String bilagsnr, String innregnr, String faktnr, String levnr, String attkode, String komment,  Number fradato, Number fraperaar, Number frapermnd, String reklamasjon, String status);
	
}
