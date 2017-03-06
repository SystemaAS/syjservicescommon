package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SyparfDao;
import no.systema.jservices.common.dto.SyparfDto;

public class SyparfDaoServiceImpl extends GenericDaoServiceImpl<SyparfDao> implements SyparfDaoService{

	@Override
	public List<SyparfDao> findAll(String sykunr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sykunr", sykunr);
		return findAll(params);
	}

	@Override
	public SyparfDao find(String sykunr, String syrecn) {
		SyparfDao qDao = new SyparfDao();
		qDao.setSykunr(sykunr);
		qDao.setSyrecn(syrecn);
		return find(qDao);
	}

}
