package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.PonrnDao;

public class PonrnDaoServiceImpl extends GenericDaoServiceImpl<PonrnDao> implements PonrnDaoService{

	@Override
	public List<PonrnDao> findByLike(String ponnr) {
		params.put("ponnr", WILD_CARD + ponnr + WILD_CARD);
		return findAll(params);
	}
}
