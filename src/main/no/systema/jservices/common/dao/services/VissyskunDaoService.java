package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.VissyskunDao;

public interface VissyskunDaoService extends GenericDaoService<VissyskunDao> {
	
	/**
	 * Find unique VissyskunDao on SYSPED kundnr.
	 * 
	 * firma is joined.
	 * 
	 * 
	 * @param kundnr 
	 */
	public VissyskunDao findBySyspedKundnr(int kundnr);
	
	/**
	 * Find unique VissyskunDao on Visma.net kundnr.
	 * 
	 * firma is joined.
	 * 
	 * 
	 * @param visknr 
	 */
	public VissyskunDao findByVismaKundnr(int visknr);
	
}
