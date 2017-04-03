package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Kodts5Dao;

public class Kodts5DaoServiceImpl extends GenericDaoServiceImpl<Kodts5Dao> implements Kodts5DaoService{

	@Override
	public List<Kodts5Dao> getS5Koder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks5uni", "S5");
		return findAll(params);
	}

	@Override
	public boolean tlnKodeExist(String ks2tln) {
		Kodts5Dao qDao = new Kodts5Dao();
		qDao.setKs5uni("S5");
		qDao.setKs5tln(ks2tln);
		return exist(qDao);	
	}

}
