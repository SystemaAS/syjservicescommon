package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SvewDao;

public class SvewDaoServiceImpl extends GenericDaoServiceImpl<SvewDao> implements SvewDaoService{

	@Override
	public SvewDao find(int svew_knnr, String svew_knso) {
		SvewDao qDao = new SvewDao();
		qDao.setSvew_knnr(svew_knnr);
		qDao.setSvew_knso(svew_knso);
		return find(qDao);
	}

	@Override
	public List<SvewDao> findAll(String svew_knnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svew_knnr", svew_knnr);
		return findAll(params);	}

}
