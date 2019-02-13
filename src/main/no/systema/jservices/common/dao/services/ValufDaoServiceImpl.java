package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.ValufDao;

public class ValufDaoServiceImpl extends GenericDaoServiceImpl<ValufDao> implements ValufDaoService{

//	static String firmaColumnName = "firma";
	
	@Override
	public boolean exist(Object id) {
		return existInFirma(id, firmaColumnName);
	}

	@Override
	public ValufDao find(Object id) {
		return findInFirma(id,firmaColumnName);
	}

	@Override
	public boolean exist(String currencyCode) {
		ValufDao qDao = new ValufDao();
		qDao.setValkod(currencyCode);
		return  exist(qDao);
	}
	
	@Override
	public List<ValufDao> findByLike(String currencyCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("valkod", WILD_CARD + currencyCode + WILD_CARD);
		return findAllInFirma(params, firmaColumnName);
		
	}	
	
	
	
}
