package no.systema.jservices.common.dao.services;

import org.modelmapper.ModelMapper;

import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.Ffr03fDao;
import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.modelmapper.converter.DaoConverter;

public class Ffr00fDaoServiceImpl extends GenericDaoServiceImpl<Ffr00fDao> implements Ffr00fDaoService{
	
	
	/**
	 * CREATE NEW
	 * CRUD-cascade on several child-tables
	 */
	public Ffr00fDao create(Ffr00fDto dto){
		ModelMapper modelMapper = new ModelMapper();
		DaoConverter daoConverter = new DaoConverter();
		//Converters
		modelMapper.addConverter(daoConverter.doBigDecimal());
		modelMapper.addConverter(daoConverter.doInteger());
		//handover to all DAOs
		Ffr00fDao daoParent = modelMapper.map(dto, Ffr00fDao.class);
		//03
		Ffr03fDao daoChild_1 = modelMapper.map(dto, Ffr03fDao.class);
		daoChild_1.setF03rec(daoParent.getF00rec());
		
		//Create cascade
		Ffr00fDao rDaoParent = super.create(daoParent);
		ffr03fDaoService.create(daoChild_1);
		
		return rDaoParent;
	}
	
	/**
	 * UPDATE
	 * CRUD-cascade on several child-tables
	 */
	public Ffr00fDao update(Ffr00fDto dto){
		ModelMapper modelMapper = new ModelMapper();
		DaoConverter daoConverter = new DaoConverter();
		//Converters
		modelMapper.addConverter(daoConverter.doBigDecimal());
		modelMapper.addConverter(daoConverter.doInteger());
		//handover to all DAOs
		Ffr00fDao daoParent = modelMapper.map(dto, Ffr00fDao.class);
		//03
		Ffr03fDao daoChild_1 = modelMapper.map(dto, Ffr03fDao.class);
		daoChild_1.setF03rec(daoParent.getF00rec());
		
		//Create cascade
		Ffr00fDao rDaoParent = super.update(daoParent);
		Ffr03fDao rDaoChild_1 = ffr03fDaoService.update(daoChild_1);
		
		return rDaoParent;
	}
	
	/**
	 * DELETE
	 * CRUD-cascade
	 * 
	 */
	public void delete(Ffr00fDto dto){
		ModelMapper modelMapper = new ModelMapper();
		DaoConverter daoConverter = new DaoConverter();
		//Converters
		modelMapper.addConverter(daoConverter.doBigDecimal());
		modelMapper.addConverter(daoConverter.doInteger());
		//handover to all DAOs
		Ffr00fDao daoParent = modelMapper.map(dto, Ffr00fDao.class);
		//03
		Ffr03fDao daoChild_1 = modelMapper.map(dto, Ffr03fDao.class);
		//daoChild_1.setF03rec(daoParent.getF00rec());
		
		//Create cascade
		super.delete(daoParent);
		ffr03fDaoService.delete(daoChild_1);
		
		
	}
	
	
	
	//Wired
	private Ffr03fDaoService ffr03fDaoService = null;
	public void setFfr03fDaoService (Ffr03fDaoService ffr03fDaoService) {this.ffr03fDaoService = ffr03fDaoService;}
	public Ffr03fDaoService getFfr03fDaoService() { return this.ffr03fDaoService; }
	
	private Ffr04fDaoService ffr04fDaoService = null;
	public void setFfr04fDaoService (Ffr04fDaoService ffr04fDaoService) {this.ffr04fDaoService = ffr04fDaoService;}
	public Ffr04fDaoService getFfr04fDaoService() { return this.ffr04fDaoService; }
	
	private Ffr08fDaoService ffr08fDaoService = null;
	public void setFfr08fDaoService (Ffr08fDaoService ffr08fDaoService) {this.ffr08fDaoService = ffr08fDaoService;}
	public Ffr08fDaoService getFfr08fDaoService() { return this.ffr08fDaoService; }
	
	private Ffr10fDaoService ffr10fDaoService = null;
	public void setFfr10fDaoService (Ffr10fDaoService ffr10fDaoService) {this.ffr10fDaoService = ffr10fDaoService;}
	public Ffr10fDaoService getFfr10fDaoService() { return this.ffr10fDaoService; }
	
	private Ffr11fDaoService ffr11fDaoService = null;
	public void setFfr11fDaoService (Ffr11fDaoService ffr11fDaoService) {this.ffr11fDaoService = ffr11fDaoService;}
	public Ffr11fDaoService getFfr11fDaoService() { return this.ffr11fDaoService; }
	
	
}
