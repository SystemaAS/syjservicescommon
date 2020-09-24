package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TellgeDao;

public class TellgeDaoServiceImpl extends GenericDaoServiceImpl<TellgeDao> implements TellgeDaoService{

	@Override
	public int getGenoAndIncrement(String geco) {
		int existingGeno, incrementedGeno;
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(geco);
		TellgeDao dao = find(qDao);
		existingGeno = Integer.parseInt(dao.getGeno());
		dao.setGeno(String.valueOf(++existingGeno));
		TellgeDao resultDao = update(dao);
		incrementedGeno = Integer.parseInt(resultDao.getGeno());
		return incrementedGeno;
	}
	
	@Override
	public int getGenoAndIncrementAfterFetch(String geco) {
		int existingGeno, incrementedGeno;
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(geco);
		TellgeDao dao = find(qDao);
		existingGeno = Integer.parseInt(dao.getGeno());
		dao.setGeno(String.valueOf(existingGeno + 1));
		TellgeDao resultDao = update(dao);
		//incrementedGeno = Integer.parseInt(resultDao.getGeno());
		return existingGeno;
	}

	@Override
	public void substractGeno(String geco) {
		int existingGeno;
		TellgeDao qDao = new TellgeDao();
		qDao.setGeco(geco);
		TellgeDao dao = find(qDao);
		existingGeno = Integer.parseInt(dao.getGeno());
		dao.setGeno(String.valueOf(--existingGeno));
		update(dao);
	}
}
