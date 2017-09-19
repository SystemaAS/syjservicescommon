package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellDao;

public class TellDaoServiceImpl extends GenericDaoServiceImpl<TellDao> implements TellDaoService{

	/*
	 *  JOVO:	Verdien som ligger i TELL er NESTE NUMMER   (IKKE sist brukte) 
				Logikken for tildeling skal derfor være 
     			benytt det nummer dere finner i teller - DERETTER add 1 og lagre teller...  
	 */
	@Override
	public int getExistingTeopdnAndIncrement(int teavd) {
		int existingTeopdn, incrementedTeopdn, scaffoldingTeopdn;
		TellDao qDao = new TellDao();
		qDao.setTeavd(teavd);
		TellDao dao = find(qDao);
		existingTeopdn = dao.getTeopdn();
		scaffoldingTeopdn = existingTeopdn;
		dao.setTeopdn(++scaffoldingTeopdn);
		TellDao resultDao = update(dao);
		incrementedTeopdn = resultDao.getTeopdn();
		
		return existingTeopdn;
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
