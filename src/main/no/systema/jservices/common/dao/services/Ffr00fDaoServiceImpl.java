package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.facade.Ffr00fDaoFacade;

import java.util.*;

import org.modelmapper.ModelMapper;

import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.Ffr03fDao;
import no.systema.jservices.common.dao.Ffr04fDao;


public class Ffr00fDaoServiceImpl extends GenericDaoServiceImpl<Ffr00fDao> implements Ffr00fDaoService{
	
	/**
	 * The method returns a complete dto (cascade of all dao's in a parent-child retaltionship)
	 * In this way the result will be used in a single view element based on this dto
	 *  
	 */
	
	public List<Ffr00fDto> findAll(Map<String, Object> params, Ffr00fDaoFacade f){
		Ffr00fDto dto = f.getDto();
		
		List<Ffr00fDto> listDto = new ArrayList<Ffr00fDto>();
		List<Ffr00fDao> listDao = super.findAll(params);
		
		for (Ffr00fDao record: listDao){
			//parent record
			f.setDto(record);
			
			//03
			Ffr03fDao dao03 = new Ffr03fDao();
			dao03.setF03rec(record.getF00rec());
			dao03 = ffr03fDaoService.find(dao03);
			if(dao03!=null){
				f.setDto(dao03);
			}
			//04
			Ffr04fDao dao04 = new Ffr04fDao();
			dao04.setF04rec(record.getF00rec());
			dao04 = ffr04fDaoService.find(dao04);
			if(dao04!=null){
				f.setDto(dao04);
			}
	
			//set final list with complete dto
			listDto.add(f.getDto());
		}
		
		return listDto;
	}
	
	
	/**
	 *
	 * CREATE NEW
	 * CRUD-cascade on several child-tables
	 */
	 
	public Ffr00fDao create(Ffr00fDto dto, Ffr00fDaoFacade facade){
		//Create cascade
		Ffr00fDao rDaoParent = super.create(facade.getFfr00fDao());
		ffr03fDaoService.create(facade.getFfr03fDao());
		/*ffr04fDaoService.create(facade.getFfr04fDao());
		ffr08fDaoService.create(facade.getFfr08fDao());
		ffr10fDaoService.create(facade.getFfr10fDao());
		ffr11fDaoService.create(facade.getFfr11fDao());
		*/
		return rDaoParent;
	}
	
	/**
	 * UPDATE
	 * CRUD-cascade on several child-tables
	 */
	public Ffr00fDao update(Ffr00fDto dto, Ffr00fDaoFacade facade){
		Ffr00fDao rDaoParent = super.update(facade.getFfr00fDao());
		ffr03fDaoService.update(facade.getFfr03fDao());
		/*ffr04fDaoService.update(facade.getFfr04fDao());
		ffr08fDaoService.update(facade.getFfr08fDao());
		ffr10fDaoService.update(facade.getFfr10fDao());
		ffr11fDaoService.update(facade.getFfr11fDao());
		*/
		
		return rDaoParent;
	}
	
	/**
	 * DELETE
	 * CRUD-cascade
	 * 
	 */
	public void delete(Ffr00fDto dto, Ffr00fDaoFacade facade ){
		super.delete(facade.getFfr00fDao());
		ffr03fDaoService.delete(facade.getFfr03fDao());
		/*ffr04fDaoService.delete(facade.getFfr04fDao());
		ffr08fDaoService.delete(facade.getFfr08fDao());
		ffr10fDaoService.delete(facade.getFfr10fDao());
		ffr11fDaoService.delete(facade.getFfr11fDao());
		*/
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
