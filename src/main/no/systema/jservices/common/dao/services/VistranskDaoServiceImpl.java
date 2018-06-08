package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.VistranskDao;

public class VistranskDaoServiceImpl extends GenericDaoServiceImpl<VistranskDao> implements VistranskDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<VistranskDao> findAllInFirma(int recnr, int bilnr ,int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VistranskDao> list = new ArrayList<VistranskDao>();

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
	public VistranskDao find(Object id) {
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
	public void updateOnError(VistranskDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE vistransk SET syncda = ? , syerro = ?  ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND recnr = ? ");
			updateString.append(" AND bilnr = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getSyncda(), dao.getSyerro(), dao.getFirma(), dao.getRecnr(), dao.getBilnr() });

		} catch (DataAccessException e) {
			logger.error("Error updating VISTRANSK!", e);
			throw e;
		}
		
	}	
	
}
