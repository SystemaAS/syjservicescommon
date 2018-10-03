package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dto.KostaDto;

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
	public List<KostaDao> findAll(Integer bilagsnr, Integer innregnr, String faktnr, Integer levnr, String attkode,
			String komment, Integer fradato, Integer fraperaar, Integer frapermnd, String status);

	
	/**
	 * Complex search. Stretching outside {@linkplain KostaDao}.
	 * 
	 * 
	 * @param qDto prepared with query params.
	 * @return a List of {@linkplain KostaDto}
	 */
	public List<KostaDao> findAllComplex(KostaDto qDto);
	
	
}
