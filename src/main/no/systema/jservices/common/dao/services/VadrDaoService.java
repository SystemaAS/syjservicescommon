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
	public List<VadrDao> getList(int kundnr, String firma);
	public List<VadrDao> getList(int kundnr, int vadrnr, String firma);
	
	/**
	 * Update a subset of fields for vadrnr=1
	 * 
	 * @param dao
	 * @return a decimated dao, recommeded not to use.
	 */
	public VadrDao updateNr1(VadrDao dao);
	
	
}
