package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Kodts2Dao;

public class Kodts2DaoServiceImpl extends GenericDaoServiceImpl<Kodts2Dao> implements Kodts2DaoService{

	@Override
	public List<Kodts2Dao> getS2Koder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks2uni", "S2");
		return findAll(params);
	}

	@Override
	public boolean lkKodeExist(String ks2lk) {
		Kodts2Dao qDao = new Kodts2Dao();
		qDao.setKs2uni("S2");
		qDao.setKs2lk(ks2lk);
		return exist(qDao);	
	}

}
