package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.Map;

import no.systema.jservices.common.dao.SvtproDao;

public class SvtproDaoServiceImpl extends GenericDaoServiceImpl<SvtproDao> implements SvtproDaoService{

	@Override
	public boolean svpr_prExist(String svpr_pr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svpr_ie", "E");
		params.put("svpr_pr",svpr_pr);
		int rows = countAll(params);
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}

}
