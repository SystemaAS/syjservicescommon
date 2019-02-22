package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodfriDao;

public class KodfriDaoServiceImpl extends GenericDaoServiceImpl<KodfriDao> implements KodfriDaoService{

	@Override
	public List<KodfriDao> findByLike(String kfsotx) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfsotx", WILD_CARD + kfsotx + WILD_CARD);
		return findAll(params);
	}
	
}
