package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dto.FaktDWDto;
import no.systema.jservices.common.dto.FaktDto;

public interface FaktDaoService extends GenericDaoService<FaktDao> {

	/**
	 * Retrieves all FaktDao filtered on year.
	 * 
	 * @param year format yyyy
	 * @return a list with FaktDao
	 */
	public List<FaktDao> getYear(int year);
	
	//TODO javadoc
	public List<FaktDto> getStats(FaktDto qDto);	
	
	//TODO javadoc
	public List<FaktDWDto> getStatsFromDW(FaktDto qDto);	
	
	
}
