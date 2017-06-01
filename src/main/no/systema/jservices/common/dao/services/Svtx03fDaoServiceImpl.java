package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Svtx03fDao;

public class Svtx03fDaoServiceImpl extends GenericDaoServiceImpl<Svtx03fDao> implements Svtx03fDaoService{

	@Override
	public List<Svtx03fDao> getLandKoder() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svtx03_01", "A");
		params.put("svtx03_02", "GCY");
		return findAll(params);		
	}

	@Override
	public boolean landKodeExist(String landkode) {
		Svtx03fDao qDao = new Svtx03fDao();
		qDao.setSvtx03_01("A");
		qDao.setSvtx03_02("GCY");
		qDao.setSvtx03_03(landkode);
		return exist(qDao);	
	}

}
