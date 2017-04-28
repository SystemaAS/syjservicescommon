package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.Map;

import no.systema.jservices.common.dao.KodtftDao;

public class KodtftDaoServiceImpl extends GenericDaoServiceImpl<KodtftDao> implements KodtftDaoService{

	@Override
	public boolean kfttypExist(String kfttyp) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kfttyp", kfttyp);
		int count = countAll(params);
		if (count > 1) {
			return true;
		} else {
			return false;
		}
	}

}
