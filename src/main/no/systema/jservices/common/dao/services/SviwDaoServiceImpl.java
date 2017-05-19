package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SviwDao;

public class SviwDaoServiceImpl extends GenericDaoServiceImpl<SviwDao> implements SviwDaoService{

	@Override
	public SviwDao find(int sviw_knnr, String sviw_knso) {
		SviwDao qDao = new SviwDao();
		qDao.setSviw_knnr(sviw_knnr);
		qDao.setSviw_knso(sviw_knso);
		return find(qDao);
	}

	@Override
	public List<SviwDao> findAll(String sviw_knnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sviw_knnr", sviw_knnr);
		return findAll(params);
	}

}
