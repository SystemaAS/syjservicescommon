package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.VistranskDao;
import no.systema.jservices.common.dao.VistranslDao;

public class VistranslDaoServiceImpl extends GenericDaoServiceImpl<VistranslDao> implements VistranslDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<VistranslDao> findAllInFirma(int recnr, int bilnr ,int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VistranslDao> list = new ArrayList<VistranslDao>();

		if( recnr > 0 ){
			params.put("recnr", recnr);				
		}
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
	
	@Override
	public VistranslDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public void deleteAll(String firma, int bilnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("firma", firma);
		params.put("bilnr", bilnr);
		deleteAll(params);
		
	}

	
	@Override
	public void updateOnError(VistranslDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE vistransl SET syncda = ? , syerro = ?  ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND recnr = ? ");
			updateString.append(" AND bilnr = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getSyncda(), dao.getSyerro(), dao.getFirma(), dao.getRecnr(), dao.getBilnr() });

		} catch (DataAccessException e) {
			logger.error("Error updating VISTRANSL!", e);
			logger.error("On recnr="+dao.getRecnr()+", bilnr="+dao.getBilnr()+", syerro="+dao.getSyerro()+", syncda="+dao.getSyncda());
			throw e;
		}
		
	}	
	
}
