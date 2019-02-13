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
	 * @deprecated
	 */
	public List<KostaDao> findAll(Integer bilagsnr, Integer innregnr, String faktnr, Integer levnr, String attkode,
			String komment, Integer fradato, Integer fraperaar, Integer frapermnd, String status);

	
	/**
	 * Complex search. Stretching outside {@linkplain KostaDao}.
	 * 
	 * 
	 * @param qDao prepared with query params.
	 * @param fssok 
	 * @param fskode 
	 * @param reklamasjon 
	 * @return a List of {@linkplain KostaDao}
	 */
	public List<KostaDao> findAllComplex(KostaDao qDto, String reklamasjon, String fskode, String fssok);

	/**
	 * Create dao, using kttyp för finding next key, e.g. kabnr.
	 * 
	 * using {@linkplain KosttDaoService}.getExistingKtnrAndIncrement(kttyp);
	 * 
	 * @param dao
	 * @param kttyp
	 * @return  KostaDao
	 */
	public KostaDao create(KostaDao dao, String kttyp);
	
}
