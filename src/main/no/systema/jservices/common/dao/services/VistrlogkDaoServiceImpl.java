package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.VistrlogkDao;

public class VistrlogkDaoServiceImpl extends GenericDaoServiceImpl<VistrlogkDao> implements VistrlogkDaoService {

	private String firmaColumnName = "firma";

	@Override
	public VistrlogkDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<VistrlogkDao> findAllInFirma(int bilnr, int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VistrlogkDao> list = new ArrayList<VistrlogkDao>();

		if( bilnr > 0 ){
			params.put("kundnr", bilnr);				
		}
		if( syncda > 0 ){
			params.put("syncda" + GREATER_THEN, syncda );	
		}			
		
		if (params.isEmpty()){
			list = findAllInFirma(null, firmaColumnName);
		} else {
			list = findAllInFirma(params, firmaColumnName);				
		}
		
		return list;
	}

}
