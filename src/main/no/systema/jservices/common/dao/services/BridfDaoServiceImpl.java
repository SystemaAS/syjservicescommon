package no.systema.jservices.common.dao.services;

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

}
