package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.VisleveDao;

public class VisleveDaoServiceImpl extends GenericDaoServiceImpl<VisleveDao> implements VisleveDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public List<VisleveDao> findAllInFirma(int levnr, int syncda) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<VisleveDao> list = new ArrayList<VisleveDao>();

		if( levnr > 0 ){
			params.put("kundnr", levnr);				
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
	public VisleveDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public void updateOnError(VisleveDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE visleve SET syncda = ? , syerro = ?  ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND levnr = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getSyncda(), dao.getSyerro(), dao.getFirma(), dao.getLevnr() });

		} catch (DataAccessException e) {
			logger.error("Error updating VISLEVE!", e);
			logger.error("On levnr="+dao.getLevnr()+", firma="+dao.getFirma()+", syerro="+dao.getSyerro()+", syncda="+dao.getSyncda());
			throw e;
		}
		
	}

}
