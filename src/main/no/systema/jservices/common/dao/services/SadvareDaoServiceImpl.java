package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SadvareDao;

public class SadvareDaoServiceImpl extends GenericDaoServiceImpl<SadvareDao> implements SadvareDaoService{

	@Override
	public SadvareDao find(String levenr, String varenr) {
		SadvareDao qDao = new SadvareDao();
		qDao.setLevenr(levenr);
		qDao.setVarenr(varenr);
		return find(qDao);
	}

	@Override
	public List<SadvareDao> findAll(String levenr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levenr", levenr);
		return findAll(params);
	}

	@Override
	public void deleteAll(String levenr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("levenr", levenr);
		deleteAll(params);
	}

}
