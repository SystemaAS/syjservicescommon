package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.VispnrDao;
import no.systema.jservices.common.dto.SingleValueDto;

public class VispnrDaoServiceImpl extends GenericDaoServiceImpl<VispnrDao> implements VispnrDaoService{

	@Override
	public boolean landKodeExist(String vilk) {
		if (firmvisDaoService.countAll() > 0) {
			//has Visma.net integration, validate downstreams.
			return validateLandKodeExist(vilk);
		} else {
			return true;
		}
	}
	
	@Override
	public boolean exist(Object id) {
		if (firmvisDaoService.countAll() > 0) {
			//has Visma.net integration, validate downstreams.
			return super.exist(id);
		} else {
			return true;
		}
	}
	
	private boolean validateLandKodeExist(String vilk) {
		StringBuilder queryString = new StringBuilder("SELECT DISTINCT vilk AS value FROM VISPNR ");
		List<SingleValueDto> list = findAll(queryString.toString(), new GenericObjectMapper(new SingleValueDto()));		
	
		boolean exist = list.stream()
				  .filter(val -> vilk.equals(val.getValue()))
				  .findAny()
				  .isPresent();
		
		return exist;		
		
	}
	
	private FirmvisDaoService firmvisDaoService = null;                                                            
	public void setFirmvisDaoService( FirmvisDaoService firmvisDaoService) {this.firmvisDaoService = firmvisDaoService;}          
	public FirmvisDaoService getFirmvisDaoService() {return this.firmvisDaoService;}	
	
	
}
