package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViskundeDao;

public class ViskundeDaoServiceImpl extends GenericDaoServiceImpl<ViskundeDao> implements ViskundeDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public ViskundeDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}
	
}
