package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.SvuhDao;

public interface SvuhDaoService extends GenericDaoService<SvuhDao> {
	public SvuhDao createWithDelete(SvuhDao dao);
}
