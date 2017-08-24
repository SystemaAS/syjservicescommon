package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.VadrDao;

public interface VadrDaoService extends GenericDaoService<VadrDao> {
	

	/**
	 * Retrieves all <b>VadrDao</b> filtered on kundnr
	 * 
	 * @param kundnr 
	 * @return a list with {@link VadrDao} filtered on kundnr
	 */
	public List<VadrDao> getList(int kundnr);		
	
}
