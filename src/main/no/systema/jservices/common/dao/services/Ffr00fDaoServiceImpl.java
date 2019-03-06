package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.facade.Ffr00fDaoFacade;
import java.util.*;
import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dao.Ffr03fDao;
import no.systema.jservices.common.util.StringUtils;


/**
 * This class deals with the CRUD of a parent-record AND
 * the CRUD of those single-child-records present in the same GUI as the parent record.
 * 
 * @author oscardelatorre
 * Feb 2019
 *
 */
public class Ffr00fDaoServiceImpl extends GenericDaoServiceImpl<Ffr00fDao> implements Ffr00fDaoService{
	
	/**
	 * 
	 */
	public Ffr00fDao create(Ffr00fDto dto, Ffr00fDaoFacade facade){
		//Create parent
		Ffr00fDao rDaoParent = super.create(facade.getFfr00fDao());
		//Create child 03
		Ffr03fDao daoLocal = facade.getFfr03fDao();
		daoLocal.setF03rec(Integer.valueOf(dto.getF00rec()));
		ffr03fDaoService.create(facade.getFfr03fDao());
		//Create child 04
		/*ffr04fDaoService.create(facade.getFfr04fDao());
		ffr08fDaoService.create(facade.getFfr08fDao());
		ffr10fDaoService.create(facade.getFfr10fDao());
		ffr11fDaoService.create(facade.getFfr11fDao());
		*/
		return rDaoParent;
	}
	
	/**
	 * 
	 */
	public Ffr00fDao update(Ffr00fDto dto, Ffr00fDaoFacade facade){
		//Parent table
		Ffr00fDao rDaoParent = super.update(facade.getFfr00fDao());
		
		//Child tables cascade
		if(StringUtils.hasValue(facade.getDto().getF03rec())){
			ffr03fDaoService.update(facade.getFfr03fDao());
		}else{
			Ffr03fDao daoLocal = facade.getFfr03fDao();
			daoLocal.setF03rec(Integer.valueOf(dto.getF00rec()));
			ffr03fDaoService.createWithoutDulicateCheck(daoLocal);
		}
		/*ffr04fDaoService.update(facade.getFfr04fDao());
		ffr08fDaoService.update(facade.getFfr08fDao());
		ffr10fDaoService.update(facade.getFfr10fDao());
		ffr11fDaoService.update(facade.getFfr11fDao());
		*/
		return rDaoParent;
	}
	
	public void delete(Ffr00fDto dto, Ffr00fDaoFacade facade ){
		//Parent table
		super.delete(facade.getFfr00fDao());
		
		//Child tables cascade
		if(ffr03fDaoService.find(facade.getFfr03fDao())!=null){
			ffr03fDaoService.delete(facade.getFfr03fDao());
		}
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
