package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.ArktxtDao;

public class ArktxtDaoServiceImpl extends GenericDaoServiceImpl<ArktxtDao> implements ArktxtDaoService{

	@Override
	public List<ArktxtDao> getAllUploadbane() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("arsban", NOT_NULL);
		return findAll(params);
	}

}
