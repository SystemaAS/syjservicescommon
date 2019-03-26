package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.VadrDao;

public class VadrDaoServiceImpl extends GenericDaoServiceImpl<VadrDao> implements VadrDaoService{

	@Override
	public List<VadrDao> getList(int kundnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		return findAll(params);	
	}
	
	@Override
	public List<VadrDao> getList(int kundnr, int vadrnr, String firma) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		params.put("vadrnr", vadrnr);
		params.put("firma", firma);
		return findAll(params);	
	}
	@Override
	public List<VadrDao> getList(int kundnr, String firma) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kundnr", kundnr);
		params.put("firma", firma);
		return findAll(params);	
	}
	
	@Override
	public VadrDao updateNr1(VadrDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE vadr SET Vadrna = ? , Vadrn1 = ?, Vadrn2 = ?, Vadrn3 = ?,  Valand = ? ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND kundnr = ? ");
			updateString.append(" AND vadrnr = ? ");
			
			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getVadrna(), dao.getVadrn1(), dao.getVadrn2(), dao.getVadrn3(), dao.getValand(),
								//keys
								dao.getFirma(), dao.getKundnr(), dao.getVadrnr()
								});

		} catch (DataAccessException e) {
			logger.error("Error updating VADR!", e);
			throw e;
		}
	
		if (retval != 1) {
			logger.error("Error updating VADR!, retval="+retval);
			dao = null;
		}
		
		return dao;
		
	}
	
}
