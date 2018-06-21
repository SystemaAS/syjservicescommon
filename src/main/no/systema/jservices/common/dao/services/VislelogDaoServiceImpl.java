package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.VislelogDao;

public class VislelogDaoServiceImpl extends GenericDaoServiceImpl<VislelogDao> implements VislelogDaoService {

	private String firmaColumnName = "firma";

	@Override
	public VislelogDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<VislelogDao> findAllInFirma(int levnr, int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VislelogDao> list = new ArrayList<VislelogDao>();

		if( levnr > 0 ){
			params.put("levnr", levnr);				
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
