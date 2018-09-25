package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.KostaDao;

public class KostaDaoServiceImpl extends GenericDaoServiceImpl<KostaDao> implements KostaDaoService{

	@Override
	public List<KostaDao> findAll(String bilagsnr, String innregnr, String faktnr, String levnr, String attkode, String komment, Number fradato) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (innregnr != null) {
			params.put("kabnr", innregnr);
		}
		if (bilagsnr != null) {
			params.put("kabnr2", bilagsnr);
		}
		if (faktnr != null) {
			params.put("kafnr", faktnr);
		}
		if (levnr != null) {
			params.put("kalnr", levnr);
		}
		if (attkode != null) {
			params.put("kasg", attkode);
		}
		if (komment != null) {
			params.put("katxt", komment);
		}
		if (fradato != null) {
			params.put("kabdt" + GREATER_AND_EQUALS_THEN, fradato);
		}
	
		return findAll(params);
	}

}
