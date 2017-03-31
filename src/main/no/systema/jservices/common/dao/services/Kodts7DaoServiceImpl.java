package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Kodts7Dao;

public class Kodts7DaoServiceImpl extends GenericDaoServiceImpl<Kodts7Dao> implements Kodts7DaoService{

	@Override
	public List<Kodts7Dao> getS7Koder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ks7uni", "S7");
		return findAll(params);
	}

	@Override
	public boolean vfKodeExist(int ks7vf) {
		Kodts7Dao qDao = new Kodts7Dao();
		qDao.setKs7uni("S7");
		qDao.setKs7vf(ks7vf);
		return exist(qDao);	
	}

}
