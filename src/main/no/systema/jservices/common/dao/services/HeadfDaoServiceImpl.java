package no.systema.jservices.common.dao.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public class HeadfDaoServiceImpl extends GenericDaoServiceImpl<HeadfDao> implements HeadfDaoService {
	protected static final Logger logger = Logger.getLogger(HeadfDaoServiceImpl.class.getName());

	@Override
	public List<HeadfDto> get(HeadfDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String hedtopAsString = setDateIntAsStringForTheMysteriousDB2Format(qDto);
		StringBuilder queryString = new StringBuilder(
							"SELECT heavd, heopd , hedtop ,hedtr, henas , henak, hesg , hent , hevkt , hem3 , helks ,  hepns , helkk , hepnk, heot, heur, hepro, hegn FROM headf");
		queryString.append(" WHERE (:heavd = 0 OR heavd = :heavd )");
		queryString.append(" AND   (:heopd = 0 OR heopd = :heopd )");
		if (hedtopAsString !=  null) {
			queryString.append(" AND ( DATE(LEFT(DIGITS(hedtop), 4 ) CONCAT '-' CONCAT SUBSTR(DIGITS(hedtop), 5, 2) CONCAT '-' CONCAT RIGHT( DIGITS(hedtop), 2)) ");
			queryString.append("		BETWEEN '" +hedtopAsString + "' AND CURRENT DATE	) ");	
			queryString.append(" AND hedtop > 0 ");
		}
		queryString.append(" AND   (:henas IS NULL OR henas like :henas ) ");
		queryString.append(" AND   (:henak IS NULL OR henak like :henak ) ");
		queryString.append(" AND   (:hesg  IS NULL OR hesg  like :hesg ) ");
		queryString.append(" AND   (:helks IS NULL OR helks = :helks ) ");
		queryString.append(" AND   (:hepns IS NULL OR hepns = :hepns ) ");
		queryString.append(" AND   (:helkk IS NULL OR helkk = :helkk ) ");
		queryString.append(" AND   (:hepnk IS NULL OR hepnk = :hepnk ) ");
		if(!qDto.hasWhereClause()) {
			queryString.append(" AND DATE( LEFT(DIGITS(hedtr), 4 ) CONCAT '-' CONCAT SUBSTR(DIGITS(hedtr), 5, 2) CONCAT '-' CONCAT RIGHT( DIGITS(hedtr), 2) )  >  ( CURRENT DATE - :dftdg DAYS ) "); 
		}
		queryString.append(" AND hedtr > 0 ");
		queryString.append(" ORDER BY hedtr DESC ");		
		
		logger.info("queryString="+queryString.toString());
		
		return namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new HeadfDto()));

	}

	private String setDateIntAsStringForTheMysteriousDB2Format(HeadfDto qDto) {
		if (qDto.getHedtop() == 0) {
			return null;
		}
		Integer value = qDto.getHedtop();
		SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = null;
		try {
			date = originalFormat.parse(value.toString());
		} catch (ParseException e) {
			logger.error( e);
		}

		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String hedtopAsString =  newFormat.format(date);	
		qDto.setHedtopAsString(hedtopAsString);
		return hedtopAsString;
	}

	@Override
	public HeadfDao find(int heavd, int heopd) {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(heavd);
		qDao.setHeopd(heopd);
		return find(qDao);
	}

}
