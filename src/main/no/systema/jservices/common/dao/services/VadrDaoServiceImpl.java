package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.VadrDao;

public class VadrDaoServiceImpl extends GenericDaoServiceImpl<VadrDao> implements VadrDaoService{

	@Override
	public List<VadrDao> getList(int kundnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		return findAll(params);	
	}
	
	@Override
	public List<VadrDao> getList(int kundnr, int vadrnr, String firma) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		params.put("vadrnr", vadrnr);
		params.put("firma", firma);
		return findAll(params);	
	}
	@Override
	public List<VadrDao> getList(int kundnr, String firma) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		params.put("firma", firma);
		return findAll(params);	
	}
	
}
