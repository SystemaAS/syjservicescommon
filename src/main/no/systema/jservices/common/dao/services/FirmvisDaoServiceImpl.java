package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FirmvisDao;

public class FirmvisDaoServiceImpl extends GenericDaoServiceImpl<FirmvisDao> implements FirmvisDaoService{

	private String firmaColumnName = "vifirm";
	
	@Override
	public FirmvisDao get() {
		List<FirmvisDao> list = null;
		list = findAllInFirma(null, firmaColumnName);

		if (list.size() != 1) {
			String errMsg = "Error in FIRMVIS. Should contain one record.";
			logger.error(errMsg);
			throw new RuntimeException(errMsg);
		}
		
		return list.get(0);

	}

}
