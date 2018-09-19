package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.KosttDao;

public class KosttDaoServiceImpl extends GenericDaoServiceImpl<KosttDao> implements KosttDaoService{


	@Override
	public int getExistingKtnrAndIncrement(String kttyp) {
		int existingKtnr, incrementedKtnr, scaffoldingKtnr;
		KosttDao qDao = new KosttDao();
		qDao.setKttyp(kttyp);
		KosttDao dao = find(qDao);
		existingKtnr = dao.getKtnr();
		scaffoldingKtnr = existingKtnr;
		dao.setKtnr(++scaffoldingKtnr);
		KosttDao resultDao = update(dao);
		incrementedKtnr = resultDao.getKtnr();
		
		return existingKtnr;
	}

	@Override
	public void substractKtnr(String kttyp) {
		int existingKtnr;
		KosttDao qDao = new KosttDao();
		qDao.setKttyp(kttyp);
		KosttDao dao = find(qDao);
		existingKtnr = dao.getKtnr();
		dao.setKtnr(--existingKtnr);
		update(dao);
		
	}

}
