package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ValufDao;

public class ValufDaoServiceImpl extends GenericDaoServiceImpl<ValufDao> implements ValufDaoService{

	private String firmaColumnName = "arcfir";
	
	@Override
	public boolean exist(Object id) {
		return existInFirma(id, firmaColumnName);
	}
	
}
