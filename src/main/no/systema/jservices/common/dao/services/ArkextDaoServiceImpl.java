package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ArkextDao;

public class ArkextDaoServiceImpl extends GenericDaoServiceImpl<ArkextDao> implements ArkextDaoService{

	private String firmaColumnName = "arcfir";
	
	@Override
	public ArkextDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}
	
}
