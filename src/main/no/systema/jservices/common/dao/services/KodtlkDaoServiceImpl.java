package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodtlkDao;

public class KodtlkDaoServiceImpl extends GenericDaoServiceImpl<KodtlkDao> implements KodtlkDaoService{

	@Override
	public List<KodtlkDao> getLandKoder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("klkuni", "LK");
		return findAll(params);
	}

	@Override
	public boolean landKodeExist(String klklk) {
		KodtlkDao qDao = new KodtlkDao();
		qDao.setKlklk(klklk);
		qDao.setKlkuni("LK");
		return exist(qDao);	
	}

}
