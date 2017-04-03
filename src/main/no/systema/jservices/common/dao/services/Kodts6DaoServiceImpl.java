package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Kodts6Dao;

public class Kodts6DaoServiceImpl extends GenericDaoServiceImpl<Kodts6Dao> implements Kodts6DaoService{

	@Override
	public List<Kodts6Dao> getS6Koder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks6uni", "S6");
		return findAll(params);
	}

	@Override
	public boolean preKodeExist(String ks6pre) {
		Kodts6Dao qDao = new Kodts6Dao();
		qDao.setKs6uni("S6");
		qDao.setKs6pre(ks6pre);
		return exist(qDao);	
	}

}
