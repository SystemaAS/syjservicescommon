package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ValufDao;

public class ValufDaoServiceImpl extends GenericDaoServiceImpl<ValufDao> implements ValufDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public boolean exist(Object id) {
		return existInFirma(id, firmaColumnName);
	}

	@Override
	public ValufDao find(Object id) {
		return findInFirma(id,firmaColumnName);
	}
	
	
}
