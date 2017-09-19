package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dto.FaktDto;

public interface FaktDaoService extends GenericDaoService<FaktDao> {

	/**
	 * Retrieves all FaktDao filtered on year.
	 * 
	 * @param year format yyyy
	 * @return a list with FaktDao
	 */
	public List<FaktDao> getYear(int year);
	
	
	/**
	 * Retrieves all <b>FaktDto</b> filtered on year.</br>
	 * Sum on fabeln, grouped by faavd, faopdm fadato and fakda.</br>
	 * filter: faavd  > 0</br>
	 * filter: faopd  > 0</br>
	 * filter: fadato > 0
	 * @param fromYear format yyyy
	 * @return a list with {@link FaktDto}
	 */
	public List<FaktDto> getYearSumGroupAvdOpdDato(int fromYear);	
	
	
}
