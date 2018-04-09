package no.systema.jservices.common.dao.services;

import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.dao.DataAccessException;

import no.systema.jservices.common.dao.FirmaltDao;

public class FirmaltDaoServiceImpl extends GenericDaoServiceImpl<FirmaltDao> implements FirmaltDaoService{

	private String firmaColumnName = "aifirm";
	
	@Override
	public FirmaltDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public List<FirmaltDao> get() {
		List<FirmaltDao> list = null;
		list = findAllInFirma(null, firmaColumnName);

		String message = String.format(" All %s records in FIRMALT==>", list.size());
		logger.debug(message);
		list.forEach((f) -> logger.debug("	"+ReflectionToStringBuilder.toString(f)));
		
		return list;

	}

	@Override
	public void updateAiDatoAndAiTid(FirmaltDao dao) {
		int retval = 0;
		try {
			StringBuilder updateString = new StringBuilder();
			updateString.append(" UPDATE firmalt SET aidato = ? , aitid = ?  ");
			updateString.append(" WHERE aifirm = ? ");
			updateString.append(" AND aiorg = ? ");

			retval = getJdbcTemplate().update(updateString.toString(),
					new Object[] { dao.getAidato(), dao.getAitid(), dao.getAifirm(), dao.getAiorg(), });

		} catch (DataAccessException e) {
			logger.error("Error updating FIRMALT!", e);
			throw e;
		}
		
	}
	
}
