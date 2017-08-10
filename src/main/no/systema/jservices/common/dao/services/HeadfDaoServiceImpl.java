package no.systema.jservices.common.dao.services;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.HeadfDao;
import no.systema.jservices.common.dto.HeadfDto;

public class HeadfDaoServiceImpl extends GenericDaoServiceImpl<HeadfDao> implements HeadfDaoService {

	@Override
	public List<HeadfDto> get(HeadfDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		StringBuilder queryString = new StringBuilder(
							"SELECT heavd, heopd , hedtop ,hedtr, henas , henak, hesg , hent , hevkt , hem3 , helks ,  hepns , helkk , hepnk, heot FROM headf");
		queryString.append(" WHERE (:heavd = 0 OR :heavd = :heavd )");
		queryString.append(" AND   (:heopd = 0 OR heopd = :heopd )");
		queryString.append(" AND   (:hedtop = 0 OR hedtop = :hedtop )");
		queryString.append(" AND   (:henas IS NULL OR henas like :henas ) ");
		queryString.append(" AND   (:henak IS NULL OR henak like :henak ) ");
		queryString.append(" AND   (:hesg  IS NULL OR hesg  like :hesg ) ");
		queryString.append(" AND   (:helks IS NULL OR helks = :helks ) ");
		queryString.append(" AND   (:hepns IS NULL OR hepns = :hepns ) ");
		queryString.append(" AND   (:helkk IS NULL OR helkk = :helkk ) ");
		queryString.append(" AND   (:hepnk IS NULL OR hepnk = :hepnk ) ");
		queryString.append(" AND DATE( LEFT(DIGITS(hedtr), 4 ) CONCAT '-' CONCAT SUBSTR(DIGITS(hedtr), 5, 2) CONCAT '-' CONCAT RIGHT( DIGITS(hedtr), 2) )  >  ( CURRENT DATE - :dftdg DAYS ) "); 
		queryString.append(" AND hedtr > 0 ");
		queryString.append(" ORDER BY hedtr DESC ");		
		
		return namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new HeadfDto()));

	}

	@Override
	public HeadfDao find(int heavd, int heopd) {
		HeadfDao qDao = new HeadfDao();
		qDao.setHeavd(heavd);
		qDao.setHeopd(heopd);
		return find(qDao);
	}

}
