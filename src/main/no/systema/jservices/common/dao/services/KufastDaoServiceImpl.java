package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KufastDao;
import no.systema.jservices.common.values.FasteKoder;

public class KufastDaoServiceImpl extends GenericDaoServiceImpl<KufastDao> implements KufastDaoService{

	@Override
	public KufastDao find(FasteKoder kftyp, String kfkod) {
		KufastDao qDao = new KufastDao();
		qDao.setKftyp(kftyp.name());
		qDao.setKfkod(kfkod);
		return find(qDao);
	}

	@Override
	public List<KufastDao> getList(FasteKoder kftyp) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kftyp", kftyp.name());
		return findAll(params);	
	}
	
}
