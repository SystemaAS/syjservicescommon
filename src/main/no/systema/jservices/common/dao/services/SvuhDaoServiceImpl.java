package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvuhDao;

public class SvuhDaoServiceImpl extends GenericDaoServiceImpl<SvuhDao> implements SvuhDaoService{
	
	public SvuhDao createWithDelete(SvuhDao dao) {
		try {
			super.delete(dao);
		}catch(Exception e) {
			e.toString();
		}
		SvuhDao result = super.create(dao);
		return result;
	}
}
