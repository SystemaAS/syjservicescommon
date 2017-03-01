package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.FratxtDao;

public class FratxtDaoServiceImpl extends GenericDaoServiceImpl<FratxtDao> implements FratxtDaoService{

	@Override
	public List<FratxtDao> getDelsys(String fxknr, String delsys) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fxknr", fxknr);
		params.put("delsys", delsys);	
		return findAll(params);
	}

	@Override
	public void deleteAll(String fxknr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fxknr", fxknr);
		deleteAll(params);
	}

}
