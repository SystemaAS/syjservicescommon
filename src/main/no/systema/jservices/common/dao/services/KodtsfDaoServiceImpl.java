package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.KodtsfDao;

public class KodtsfDaoServiceImpl extends GenericDaoServiceImpl<KodtsfDao> implements KodtsfDaoService{

	@Override
	public List<KodtsfDao> findByLike(String kosfnv) {
		params.put("kosfnv", WILD_CARD + kosfnv + WILD_CARD);
		return findAll(params);
	}
	
}
