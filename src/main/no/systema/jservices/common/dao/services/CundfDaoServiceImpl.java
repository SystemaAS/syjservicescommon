package no.systema.jservices.common.dao.services;

import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.CundfDao;

public class CundfDaoServiceImpl extends GenericDaoServiceImpl<CundfDao> implements CundfDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<CundfDao> findAllInFirma(Map<String, Object> params) {
		return findAllInFirma(params, firmaColumnName);
	}
	
	/**
	 * Not supported  due to unknown behavior, CUD found elsewhere
	 * 
	 */
	@Override
	public CundfDao create(CundfDao dao) {
		throw new UnsupportedOperationException("Not supported, implemented.");
	}

	/**
	 * Not supported  due to unknown behavior, CUD found elsewhere
	 * 
	 */
	@Override
	public void delete(Object dao) {
		throw new UnsupportedOperationException("Not supported, implemented.");
	}

	/**
	 * Not supported  due to unknown behavior, CUD found elsewhere
	 * 
	 */
	@Override
	public CundfDao update(CundfDao dao) {
		throw new UnsupportedOperationException("Not supported, implemented.");
	}

	
}
