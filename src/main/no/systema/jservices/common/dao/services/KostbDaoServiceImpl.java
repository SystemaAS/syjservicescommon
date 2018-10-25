package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KostbDao;

public class KostbDaoServiceImpl extends GenericDaoServiceImpl<KostbDao> implements KostbDaoService{

	@Override
	public List<KostbDao> findByKabnr(Integer innregnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kbbnr", innregnr);
		return findAll(params);	
	}

}
