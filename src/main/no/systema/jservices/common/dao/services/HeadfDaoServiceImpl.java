package no.systema.jservices.common.dao.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		int fromDate = fromDate(qDto.getHedtop(), qDto.getDftdg());
		StringBuilder queryString = new StringBuilder(
							"SELECT heavd, heopd , hedtop ,hedtr, henas , henak, hesg , hent , hevkt , hem3 , helks ,  hepns , helkk , hepnk, heot, heur, hepro, hegn FROM headf");
		queryString.append(" WHERE (:heavd = 0 OR heavd = :heavd )");
		queryString.append(" AND   (:heopd = 0 OR heopd = :heopd )");
		
		if (qDto.getHeavd() > 0 && qDto.getHeopd() > 0) {
			logger.info("heavd and heopd delivered, no more in where-clause");
		} else {
			queryString.append(" AND   (:hedtop = 0 OR hedtop >= :hedtop )");
			queryString.append(" AND   (:henas IS NULL OR henas like :henas ) ");
			queryString.append(" AND   (:henak IS NULL OR henak like :henak ) ");
			queryString.append(" AND   (:hesg  IS NULL OR hesg  like :hesg ) ");
			queryString.append(" AND   (:helks IS NULL OR helks = :helks ) ");
			queryString.append(" AND   (:hepns IS NULL OR hepns = :hepns ) ");
			queryString.append(" AND   (:helkk IS NULL OR helkk = :helkk ) ");
			queryString.append(" AND   (:hepnk IS NULL OR hepnk = :hepnk ) ");
			if(qDto.getHedtop() == 0) {  //Only if date not delivered
				queryString.append(" AND  hedtr >= "+fromDate);
			}
		}
		
		queryString.append(" ORDER BY hedtr DESC ");		
		
		logger.info("queryString="+queryString.toString());
		
		return namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new HeadfDto()));

	}

	
	
	private int fromDate(int hedtop, int dftdg) {
		String hedstopAsString = String.valueOf(hedtop);  
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(sdf.parse(hedstopAsString));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, -dftdg);  // number of days withdraw
		hedstopAsString = sdf.format(c.getTime()); 
		
		return Integer.valueOf(hedstopAsString.toString());
		
	}
	
	@Override
	public HeadfDao find(int heavd, int heopd) {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(heavd);
		qDao.setHeopd(heopd);
		return find(qDao);
	}

}
