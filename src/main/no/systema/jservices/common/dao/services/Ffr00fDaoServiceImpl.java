package no.systema.jservices.common.dao.services;

import org.modelmapper.ModelMapper;

import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.Ffr03fDao;
import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.modelmapper.converter.DaoConverter;

public class Ffr00fDaoServiceImpl extends GenericDaoServiceImpl<Ffr00fDao> implements Ffr00fDaoService{
	
	
	/**
	 * This method is necessary because of the CRUD-cascade on several tables in an atomic transaction
	 */
	public Ffr00fDao create(Ffr00fDto dto){
		ModelMapper modelMapper = new ModelMapper();
		DaoConverter daoConverter = new DaoConverter();
		modelMapper.addConverter(daoConverter.doBigDecimal());
		modelMapper.addConverter(daoConverter.doInteger());
		//handover to all DAOs
		Ffr00fDao daoParent = modelMapper.map(dto, Ffr00fDao.class);
		//03
		Ffr03fDao daoChild_1 = modelMapper.map(dto, Ffr03fDao.class);
		daoChild_1.setF03rec(daoParent.getF00rec());
		
		//Create cascade
		Ffr00fDao rDaoParent = super.create(daoParent);
		Ffr03fDao rDaoChild_1 = ffr03fDaoService.create(daoChild_1);
		
		return rDaoParent;
	}
	
	
	//Wired
	private Ffr03fDaoService ffr03fDaoService = null;
	public void setFfr03fDaoService (Ffr03fDaoService ffr03fDaoService) {this.ffr03fDaoService = ffr03fDaoService;}
	public Ffr03fDaoService getFfr03fDaoService() { return this.ffr03fDaoService; }
		
	
}
