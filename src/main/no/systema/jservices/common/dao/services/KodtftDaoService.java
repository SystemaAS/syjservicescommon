package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.KodtftDao;

public interface KodtftDaoService extends GenericDaoService<KodtftDao> {

	/**
	 * Check if kfttyp exist (independent of kftln)
	 * 
	 * @return true is exist, else false
	 */
	public boolean kfttypExist(String kfttyp);	

}
