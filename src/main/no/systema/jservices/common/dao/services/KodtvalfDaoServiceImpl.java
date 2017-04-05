package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.KodtvalfDao;

public class KodtvalfDaoServiceImpl extends GenericDaoServiceImpl<KodtvalfDao> implements KodtvalfDaoService{

	@Override
	public List<KodtvalfDao> getVAKoder() {
		StringBuilder queryString = new StringBuilder("SELECT distinct(kvakod), kvaxxx FROM kodtvalf WHERE kvauni = 'VA'");
		return findAll(queryString.toString(), new GenericObjectMapper(new KodtvalfDao()));
	}

	@Override
	public boolean kvaKodeExist(String kvakod) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kvauni", "VA");
		params.put("kvakod", kvakod);		
		List<KodtvalfDao> list = findAll(params);
		if (list.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
