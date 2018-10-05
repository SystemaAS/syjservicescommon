package no.systema.jservices.common.dao.services;


import java.util.List;

import no.systema.jservices.common.dao.MerknfDao;


/**
 * 
 * @author oscardelatorre
 * @date Okt-2018
 */
public interface MerknfDaoService extends GenericDaoService<MerknfDao> {
	public int findById (String gogn, String gotrnr);
}
