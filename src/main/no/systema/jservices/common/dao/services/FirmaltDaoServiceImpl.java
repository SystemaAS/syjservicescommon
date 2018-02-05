package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.FirmaltDao;

public class FirmaltDaoServiceImpl extends GenericDaoServiceImpl<FirmaltDao> implements FirmaltDaoService{

	private String firmaColumnName = "aifirm";
	
	@Override
	public FirmaltDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}
	
}
