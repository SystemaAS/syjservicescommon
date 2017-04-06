package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.Kodts8Dao;

public class Kodts8DaoServiceImpl extends GenericDaoServiceImpl<Kodts8Dao> implements Kodts8DaoService{

	@Override
	public List<Kodts8Dao> getKoder() {
		StringBuilder queryString = new StringBuilder("SELECT * FROM kodts8 WHERE NULLIF(ks8skv, '') IS NOT NULL");
		return findAll(queryString.toString(), new GenericObjectMapper(new Kodts8Dao()));
	}

}
