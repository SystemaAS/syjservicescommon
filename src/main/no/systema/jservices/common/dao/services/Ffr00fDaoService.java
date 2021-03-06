package no.systema.jservices.common.dao.services;


import no.systema.jservices.common.dao.Ffr00fDao;
import no.systema.jservices.common.dto.Ffr00fDto;
import no.systema.jservices.common.dao.facade.Ffr00fDaoFacade;

/**
 * 
 * @author oscardelatorre
 * @date Jan 2019
 */
public interface Ffr00fDaoService extends GenericDaoService<Ffr00fDao> {
	
	public Ffr00fDao create(Ffr00fDto t, Ffr00fDaoFacade f);
	public Ffr00fDao update(Ffr00fDto t, Ffr00fDaoFacade f);
	public void delete(Ffr00fDto t, Ffr00fDaoFacade f);
	
}
