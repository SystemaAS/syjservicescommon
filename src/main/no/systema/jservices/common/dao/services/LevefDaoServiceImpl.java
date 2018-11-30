package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.LevefDao;
import no.systema.jservices.common.util.StringUtils;

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
	public List<LevefDao> findByLike(Integer levnr ,String lnavn) {
		if (levnr != null) {
			params.put("levnr", WILD_CARD + String.valueOf(levnr) + WILD_CARD);			
		}
		if (StringUtils.hasValue(lnavn)) {
			params.put("lnavn", WILD_CARD + lnavn + WILD_CARD);		
		}

		return findAllInFirma(params, firmaColumnName);	}

}
