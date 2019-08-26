package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.BridfDao;

public class BridfDaoServiceImpl extends GenericDaoServiceImpl<BridfDao> implements BridfDaoService{

	@Override
	public String getUserName(String name) {
		BridfDao qDao = new BridfDao();
		qDao.setBibrid(name);
		BridfDao resultDao = find(qDao);
	
		if (resultDao != null) {
			return resultDao.getBibrid();	
		} else {
			return null;
		}
		
	}

	@Override
	public boolean userNameExist(String name) {
		params.put("bibrid", name);
		List<BridfDao> resultList = findAll(params);
	
		if (resultList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

}
