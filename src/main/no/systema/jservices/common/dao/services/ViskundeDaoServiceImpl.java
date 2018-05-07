package no.systema.jservices.common.dao.services;

import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.ViskundeDao;

public class ViskundeDaoServiceImpl extends GenericDaoServiceImpl<ViskundeDao> implements ViskundeDaoService{

	private String firmaColumnName = "firma";
	
	@Override
	public ViskundeDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public void updateOnError(ViskundeDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE viskunde SET syncda = ? , syerro = ?  ");
			updateString.append(" WHERE firma = ? ");
			updateString.append(" AND kundnr = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getSyncda(), dao.getSyerro(), dao.getFirma(), dao.getKundnr() });

		} catch (DataAccessException e) {
			logger.error("Error updating VISKUNDE!", e);
			throw e;
		}
		
	}

}
