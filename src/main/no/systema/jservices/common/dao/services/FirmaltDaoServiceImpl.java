package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FirmaltDao;

public class FirmaltDaoServiceImpl extends GenericDaoServiceImpl<FirmaltDao> implements FirmaltDaoService{

	private String firmaColumnName = "aifirm";
	
	@Override
	public FirmaltDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public FirmaltDao get() {
		List<FirmaltDao> result = findAllInFirma(null, firmaColumnName);
		if (result.size() > 1) {
			throw new RuntimeException("Firmalt only supports on tuple. E.i. one orgnr per firmacode.");
		} else {
			return result.get(0);
		}

	}
	
}
