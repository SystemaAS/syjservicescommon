package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Sted2Dao;

public class Sted2DaoServiceImpl extends GenericDaoServiceImpl<Sted2Dao> implements Sted2DaoService{

	@Override
	public List<Sted2Dao> findByLike(String st2kod) {
		params.put("st2kod", WILD_CARD + st2kod + WILD_CARD);
		return findAll(params);
	}
}
