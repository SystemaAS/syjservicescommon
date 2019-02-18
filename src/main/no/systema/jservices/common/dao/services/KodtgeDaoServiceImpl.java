package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodtgeDao;

public class KodtgeDaoServiceImpl extends GenericDaoServiceImpl<KodtgeDao> implements KodtgeDaoService{

	@Override
	public List<KodtgeDao> findByLike(String kgekod) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kgekod", WILD_CARD + kgekod + WILD_CARD);
		return findAll(params);
	}
	
}
