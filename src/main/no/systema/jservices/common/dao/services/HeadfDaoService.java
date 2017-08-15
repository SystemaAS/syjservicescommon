package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public interface HeadfDaoService extends GenericDaoService<HeadfDao> {
	
	/**
	 * Retrieves all <b>HeadfDto</b> , potentially filtered on its parameters.</br>
	 * Special treatment on hedtop: if delivered, filter on hedtop where hedtop is between delivered hedtop and CURRENT DATE.<br>
	 * If no query params is set, days to view in list, dftdg, is used.<br>
	 * hedtop and hedtr must not be 0.
	 * @param qDto HeadfDto populated with queryparams.
	 * @return a list with {@link HeadfDto}
	 */
	public List<HeadfDto> get(HeadfDto qDto);		
	
	
	/**
	 * Get unique headf
	 * 
	 * @param heavd avdeling
	 * @param heopd oppdrag
	 * @return a {@link HeadfDto}, i found, else null
	 */
	public HeadfDao find(int heavd, int heopd);	
	
	
}
