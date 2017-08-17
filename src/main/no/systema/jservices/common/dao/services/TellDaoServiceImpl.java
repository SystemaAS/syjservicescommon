package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellDao;

public class TellDaoServiceImpl extends GenericDaoServiceImpl<TellDao> implements TellDaoService{

	@Override
	public int getTeopdnAndIncrement(int teavd) {
		int existingTeopdn, incrementedTeopdn;
		TellDao qDao = new TellDao();
		qDao.setTeavd(teavd);
		TellDao dao = find(qDao);
		existingTeopdn = dao.getTeopdn();
		dao.setTeopdn(++existingTeopdn);
		TellDao resultDao = update(dao);
		incrementedTeopdn = resultDao.getTeopdn();
		
		return incrementedTeopdn;
	}

	@Override
	public void substractTeopdn(int teavd) {
		int existingTeopdn;
		TellDao qDao = new TellDao();
		qDao.setTeavd(teavd);
		TellDao dao = find(qDao);
		existingTeopdn = dao.getTeopdn();
		dao.setTeopdn(--existingTeopdn);
		update(dao);
		
	}

}