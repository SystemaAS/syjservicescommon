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
	 * Retrieves all <b>FortollingDto</b> filtered, minimum, on year.</br>
	 * Concerned Import-tables:SADH, SADV<br>
	 * 			Export-table: SAEH, SAEV
	 * 			common-table: EDIM
	 * 
	 * @param qDto holder for the where-clause, possible to filter on year, avdeling, signatur and mottaker
	 * @return a list with {@link FortollingDto}
	 */
	public List<FortollingDto> getStats(FortollingDto qDto);		
	
}
