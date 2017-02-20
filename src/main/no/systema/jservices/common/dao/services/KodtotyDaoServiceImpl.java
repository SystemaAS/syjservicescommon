package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodtotyDao;

public class KodtotyDaoServiceImpl extends GenericDaoServiceImpl<KodtotyDao> implements KodtotyDaoService{

	@Override
	public List<KodtotyDao> getOppdragstyper() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ko1uni", "OTY");
		return findAll(params);
	}

	@Override
	public boolean oppdragsTypeExist(String ko1kod) {
		KodtotyDao qDao = new KodtotyDao();
		qDao.setKo1uni("OTY");
		qDao.setKo1kod(ko1kod);
		return exist(qDao);	
	}

}
