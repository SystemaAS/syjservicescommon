package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dto.FortollingDto;

/**
 * This interface serves with data primary used in statistics report
 * 
 * @author Fredrik Möller
 * @date Sept, 27, 20127
 *
 */
public interface FortollingDaoService extends GenericDaoService<FortollingDto> {

	
	/**
	 * Retrieves all <b>FortollingDao</b> filtered on year.</br>
	 * Concerned tables:SADH, SADV, EDIM
	 * @param fromYear format yyyy
	 * @return a list with {@link FortollingDto}
	 */
	public List<FortollingDto> getStats(int fromYear);	
	
	
}
