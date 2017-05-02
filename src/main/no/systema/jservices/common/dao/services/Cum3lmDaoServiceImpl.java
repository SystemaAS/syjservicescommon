package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.Map;

import no.systema.jservices.common.dao.Cum3lmDao;

public class Cum3lmDaoServiceImpl extends GenericDaoServiceImpl<Cum3lmDao> implements Cum3lmDaoService{

	private String firmaColumnName = "m3firm";
	
	@Override
	public boolean exist(Object id) {
		return existInFirma(id, firmaColumnName);
	}

	@Override
	public Cum3lmDao find(Object id) {
		return findInFirma(id,firmaColumnName);
	}

	@Override
	public void deleteAll(String m3firm, String m3kund) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("m3firm", m3firm);
		params.put("m3kund", m3kund);
		deleteAll(params);
	}
	
}
