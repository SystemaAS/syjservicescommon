package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TranDao;

public interface TranDaoService extends GenericDaoService<TranDao> {
	public void incrementCounter(TranDao dao);
}
