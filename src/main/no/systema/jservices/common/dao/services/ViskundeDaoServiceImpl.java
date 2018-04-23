package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViskundeDao;

public class ViskundeDaoServiceImpl extends GenericDaoServiceImpl<ViskundeDao> implements ViskundeDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public ViskundeDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public ViskundeDao find(String kundnr) {
		ViskundeDao qDao = new ViskundeDao();
		qDao.setKundgr(kundnr);
		
		ViskundeDao resultDao = new ViskundeDao();
		resultDao = findInFirma(qDao, firmaColumnName);
		if (resultDao == null) {
			logger.warn("Could not find single tuple on kundnr="+kundnr);
		}
		return resultDao;
	}
	
}
