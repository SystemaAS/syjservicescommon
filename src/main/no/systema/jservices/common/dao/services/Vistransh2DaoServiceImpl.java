package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.Vistransh2Dao;

public class Vistransh2DaoServiceImpl extends GenericDaoServiceImpl<Vistransh2Dao> implements Vistransh2DaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<Vistransh2Dao> findAllInFirma(int bilnr ,int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Vistransh2Dao> list = new ArrayList<Vistransh2Dao>();

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
	public Vistransh2Dao find(Object id) {
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
	public void updateOnError(Vistransh2Dao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE vistransh2 SET syncda = ? , syerro = ?  ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND bilnr = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getSyncda(), dao.getSyerro(), dao.getFirma(), dao.getBilnr() });

		} catch (DataAccessException e) {
			logger.error("Error updating VISTRANSH2!", e);
			logger.error("On bilnr="+dao.getBilnr()+", syerro="+dao.getSyerro()+", syncda="+dao.getSyncda());
			throw e;
		}
		
	}	
	
}
