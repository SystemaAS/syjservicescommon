package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KodafDao;

/**
 * Betalingsbetingelser
 * @author fredrikmoller
 * @date 2019-03-06
 */
public class KodafDaoServiceImpl extends GenericDaoServiceImpl<KodafDao> implements KodafDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public KodafDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<KodafDao> findAll(Map<String, Object> params) {
		return findAllInFirma(params, firmaColumnName);
	}
	
}
