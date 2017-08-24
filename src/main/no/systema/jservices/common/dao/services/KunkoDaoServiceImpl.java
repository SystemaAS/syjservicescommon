package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KunkoDao;

public class KunkoDaoServiceImpl extends GenericDaoServiceImpl<KunkoDao> implements KunkoDaoService{

	@Override
	public List<KunkoDao> getList(int kukun1) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kukun1", kukun1);
		return findAll(params);	
	}
	
}
