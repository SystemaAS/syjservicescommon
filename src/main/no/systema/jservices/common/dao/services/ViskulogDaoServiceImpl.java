package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.ViskulogDao;

public class ViskulogDaoServiceImpl extends GenericDaoServiceImpl<ViskulogDao> implements ViskulogDaoService {

	private String firmaColumnName = "firma";

	@Override
	public ViskulogDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<ViskulogDao> findAllInFirma(int kundnr, int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<ViskulogDao> list = new ArrayList<ViskulogDao>();

		if( kundnr > 0 ){
			params.put("kundnr", kundnr);				
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
