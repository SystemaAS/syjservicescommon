package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.LevefDao;

public class LevefDaoServiceImpl extends GenericDaoServiceImpl<LevefDao> implements LevefDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<LevefDao> findAllInFirma(Map<String, Object> params) {
		return findAllInFirma(params, firmaColumnName);
	}
	
	@Override
	public LevefDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<LevefDao> findByLike(String lnavn) {
		params.put("lnavn", WILD_CARD + lnavn + WILD_CARD);
		return findAllInFirma(params, firmaColumnName);	}

}
