package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.SvltuDao;

public class SvltuDaoServiceImpl extends GenericDaoServiceImpl<SvltuDao> implements SvltuDaoService{

	@Override
	public List<SvltuDao> findAll(String svltu_igl, String svltu_ign, String svltu_pos) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svltu_igl", svltu_igl);
		params.put("svltu_ign", svltu_ign);
		params.put("svltu_pos", svltu_pos);
		
		return findAll(params);
	}}
