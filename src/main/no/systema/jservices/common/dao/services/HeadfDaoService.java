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
	
}
