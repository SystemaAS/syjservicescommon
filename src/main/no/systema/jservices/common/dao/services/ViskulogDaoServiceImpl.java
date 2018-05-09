package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViskulogDao;

public class ViskulogDaoServiceImpl extends GenericDaoServiceImpl<ViskulogDao> implements ViskulogDaoService {

	private String firmaColumnName = "firma";

	@Override
	public ViskulogDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

}
