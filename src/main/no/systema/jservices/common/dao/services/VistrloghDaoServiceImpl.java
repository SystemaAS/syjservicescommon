package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.VistrloghDao;

public class VistrloghDaoServiceImpl extends GenericDaoServiceImpl<VistrloghDao> implements VistrloghDaoService {

	private String firmaColumnName = "firma";

	@Override
	public VistrloghDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<VistrloghDao> findAllInFirma(int bilnr, int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VistrloghDao> list = new ArrayList<VistrloghDao>();

		if( bilnr > 0 ){
			params.put("bilnr", bilnr);				
		}
		if( syncda > 0 ){
			params.put("syncda" + GREATER_AND_EQUALS_THEN, syncda );	
		}			
		
		if (params.isEmpty()){
			list = findAllInFirma(null, firmaColumnName);
		} else {
			list = findAllInFirma(params, firmaColumnName);				
		}
		
		return list;
	}

}
