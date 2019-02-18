package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtgeDao;

public interface KodtgeDaoService extends GenericDaoService<KodtgeDao> {
	
	List<KodtgeDao> findByLike(String kgekod);
}
