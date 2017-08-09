package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public interface HeadfDaoService extends GenericDaoService<HeadfDao> {
	
	/**
	 * Retrieves all <b>HeadfDto</b> , potentially filtered.</br>
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
