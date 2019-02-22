package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodfriDao;

public interface KodfriDaoService extends GenericDaoService<KodfriDao> {

	List<KodfriDao> findByLike(String kfsotx);
	
}
