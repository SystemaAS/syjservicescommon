package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FratxtDao;

public interface FratxtDaoService extends GenericDaoService<FratxtDao> {
	
	/**
	 * Retrieve all record for requested customer and delsys.
	 * 
	 * @param delsys, requested delsys.
	 * @param fxknr, customer
	 * @return a List of FratxtDao
	 */
	public List<FratxtDao> getDelsys(String fxknr, String delsys);
}
