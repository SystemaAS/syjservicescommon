package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.VispnrDao;
import no.systema.jservices.common.dto.SingleValueDto;

public class VispnrDaoServiceImpl extends GenericDaoServiceImpl<VispnrDao> implements VispnrDaoService{

	@Override
	public boolean landKodeExist(String vilk) {
		StringBuilder queryString = new StringBuilder("SELECT DISTINCT vilk AS value FROM VISPNR ");
		List<SingleValueDto> list = findAll(queryString.toString(), new GenericObjectMapper(new SingleValueDto()));		
	
		boolean exist = list.stream()
				  .filter(val -> vilk.equals(val.getValue()))
				  .findAny()
				  .isPresent();
		
		return exist;
	}
	
}
