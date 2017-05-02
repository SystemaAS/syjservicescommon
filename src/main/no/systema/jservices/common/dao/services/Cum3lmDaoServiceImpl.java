package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.Cum3lmDao;

public class Cum3lmDaoServiceImpl extends GenericDaoServiceImpl<Cum3lmDao> implements Cum3lmDaoService{

	private String firmaColumnName = "m3firm";
	
	@Override
	public boolean exist(Object id) {
		return existInFirma(id, firmaColumnName);
	}

	@Override
	public Cum3lmDao find(Object id) {
		return findInFirma(id,firmaColumnName);
	}
	
	
}
