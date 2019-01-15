package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KosttDao;

public class KosttDaoServiceImpl extends GenericDaoServiceImpl<KosttDao> implements KosttDaoService{

	@Override
	public int getExistingKtnrAndIncrement(String kttyp) {
		int existingKtnr, scaffoldingKtnr;
		KosttDao qDao = new KosttDao();
		qDao.setKttyp(kttyp);
		KosttDao dao = find(qDao);
		if (dao == null) {
			throw new RuntimeException("Something is wrong with KOSTT. Can not find unique record for kttyp="+kttyp);
		}
		existingKtnr = dao.getKtnr();

		scaffoldingKtnr = existingKtnr;
		dao.setKtnr(++scaffoldingKtnr);
		update(dao);
		
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

	@Override
	public List<KosttDao> findByLike(String ktna) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ktna", WILD_CARD + ktna + WILD_CARD);
		return findAll(params);
		
	}

}
