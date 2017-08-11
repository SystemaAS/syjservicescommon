package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.KodtvaDao;

public class KodtvaDaoServiceImpl extends GenericDaoServiceImpl<KodtvaDao> implements KodtvaDaoService{

	@Override
	public List<KodtvaDao> getKoder() {
		StringBuilder queryString = new StringBuilder("SELECT distinct(kvakod), kvaxxx FROM kodtva");
		return findAll(queryString.toString(), new GenericObjectMapper(new KodtvaDao()));
	}

}
