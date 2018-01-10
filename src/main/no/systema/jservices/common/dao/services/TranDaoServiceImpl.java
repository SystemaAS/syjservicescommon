package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.TranDao;

public class TranDaoServiceImpl extends GenericDaoServiceImpl<TranDao> implements TranDaoService{
	public void incrementCounter(TranDao dao){
		dao.setVmrecn(dao.getVmrecn() + 1);
		this.update(dao);
	}
}
