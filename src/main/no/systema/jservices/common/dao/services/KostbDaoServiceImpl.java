package no.systema.jservices.common.dao.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import no.systema.jservices.common.dao.IDao;
import no.systema.jservices.common.dao.KostbDao;

/**
 * {@linkplain KostbDao} is not decorated with normal db-keys. Instead the DB2-function RRN is used to identify record <br>
 * for Create, Update and Delete.
 * 
 * @author fredrikmoller
 * @date 2019-02-11
 */
public class KostbDaoServiceImpl extends GenericDaoServiceImpl<KostbDao> implements KostbDaoService{

	@Override
	public List<KostbDao> findByKbbnr(Integer kbbnr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kbbnr", kbbnr);
		return findAllRRN(params);	
	}

	@Override
	public double getFordelt(Integer kbbnr) {
		List<KostbDao> daoList = findByKbbnr(kbbnr);
		
		Function<KostbDao, BigDecimal> totalMapper = kb -> kb.getKbblhb();
		BigDecimal result = daoList.stream()
		        .map(totalMapper)
		        .reduce(BigDecimal.ZERO, BigDecimal::add);
		
		return result.doubleValue();
	}
	

	@Override
	public KostbDao create(KostbDao dao) {
		int ret;
		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT into Kostb ( Kbbnr,Kbblhb,Kbavd,Kbkkey,Kbbilt,Kbblf,Kbbuds,Kbbval,Kbfree,Kbgeby,Kbgod,Kbkavd,Kbkdm,Kbkdmv,Kbkdpf,Kbkn,KBNØKK,Kbopd,KBPÅR,Kbpcc,"
				+ "Kbpmn,Kbrefa,Kbrefb,Kbsg,Kbrefc,Kbrekl,Kbsgg,Kbvk )");
		sql.append("VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ");

		try {
			ret =	getJdbcTemplate().update(sql.toString(), new Object[] { dao.getKbbnr(), dao.getKbblhb(), dao.getKbavd(), dao.getKbkkey(), dao.getKbbilt(), dao.getKbblf(), dao.getKbbuds(),
					dao.getKbbval(), dao.getKbfree(), dao.getKbgeby(), dao.getKbgod(), dao.getKbkavd(), dao.getKbkdm(), dao.getKbkdmv(), dao.getKbkdpf(), dao.getKbkn(),
					dao.getKBNØKK(), dao.getKbopd(), dao.getKBPÅR(), dao.getKbpcc(), dao.getKbpmn(), dao.getKbrefa(), dao.getKbrefb(), dao.getKbsg(), dao.getKbrefc(),
					dao.getKbrekl(), dao.getKbsgg(), dao.getKbvk()});	

		} catch (DataAccessException e) { //RuntimeException
			logger.error("Error:", e);
			logger.error("Error, string="+sql.toString());
			logger.error("debugFieldValue="+ReflectionToStringBuilder.toString(dao, ToStringStyle.MULTI_LINE_STYLE));
			throw e;
		}
		
		if (ret != 1) {
			dao = null;
		}		
		
		return dao;		
		
	}

	@Override
	public KostbDao update(KostbDao dao) {
		int ret;
		final StringBuilder sql = new StringBuilder();
		sql.append("UPDATE Kostb "
				+ "SET Kbbnr = ?, Kbblhb = ?, Kbavd = ?,Kbkkey = ?, Kbbilt = ?, Kbblf = ?, Kbbuds = ?, Kbbval = ?, Kbfree = ?, Kbgeby = ?, Kbgod = ?, Kbkavd = ?,"
				+ "Kbkdm = ?, Kbkdmv = ?, Kbkdpf = ?, Kbkn = ?, KBNØKK = ?, Kbopd = ?, KBPÅR = ?, Kbpcc = ?,"
				+ "Kbpmn = ?, Kbrefa = ? , Kbrefb = ?, Kbsg = ?, Kbrefc = ?, Kbrekl = ?, Kbsgg = ?, Kbvk = ? ");
		sql.append(" WHERE RRN(Kostb) = ? ");
		
		try {
			ret =	getJdbcTemplate().update(sql.toString(), new Object[] { dao.getKbbnr(), dao.getKbblhb(), dao.getKbavd(), dao.getKbkkey(), dao.getKbbilt(), dao.getKbblf(), dao.getKbbuds(),
					dao.getKbbval(), dao.getKbfree(), dao.getKbgeby(), dao.getKbgod(), dao.getKbkavd(), dao.getKbkdm(), dao.getKbkdmv(), dao.getKbkdpf(), dao.getKbkn(),
					dao.getKBNØKK(), dao.getKbopd(), dao.getKBPÅR(), dao.getKbpcc(), dao.getKbpmn(), dao.getKbrefa(), dao.getKbrefb(), dao.getKbsg(), dao.getKbrefc(),
					dao.getKbrekl(), dao.getKbsgg(), dao.getKbvk(),
					//where
					dao.getRrn()});	

		} catch (DataAccessException e) { //RuntimeException
			logger.error("Error:", e);
			logger.error("Error, string="+sql.toString());
			logger.error("debugFieldValue="+ReflectionToStringBuilder.toString(dao, ToStringStyle.MULTI_LINE_STYLE));
			throw e;
		}
		
		if (ret != 1) {
			dao = null;
		}		
		
		return dao;		
	
	}

	@Override
	public void delete(Object obj) {
		IDao dao = (IDao) obj;
		int ret = 0;
		final StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM Kostb ");
		sql.append(" WHERE RRN(Kostb) = ? ");

		final Map.Entry<String, Object> rrn = dao.getKeys().entrySet().iterator().next();

		try {
			ret = getJdbcTemplate().update(sql.toString(),new Object[] {
							// where
							rrn.getValue() });

			logger.debug("delete executed. deleteString=" + sql + " on rrn=" + rrn.getValue());
		} catch (Exception e) {
			logger.error("Error:", e);
			logger.error("Error, string=" + sql.toString());
			throw e;
		}

		if (ret != 1) {
			logger.error("Row not found for DELETE!");
			logger.error("Error, string=" + sql.toString());
			throw new DataAccessResourceFailureException("Row not found for DELETE on rrn=" + rrn.getValue());
		}

	}
	
	
}
