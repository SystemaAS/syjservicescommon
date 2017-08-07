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
							"select heavd, heopd , hedtop , henas , henak , hent , hevkt , hem3 , helks ,  hepns , helkk , hepnk from headf");
		queryString.append(" where (:heavd = 0 or :heavd = :heavd )");
		queryString.append(" and   (:heopd = 0 or heopd = :heopd )");
		queryString.append(" and   (:hedtop = 0 or hedtop = :hedtop )");
		queryString.append(" and   (:henas is null or henas = :henas ) ");
		queryString.append(" and   (:henak is null or henak = :henak ) ");
		queryString.append(" and   (:helks is null or helks = :helks ) ");
		queryString.append(" and   (:hepns is null or hepns = :hepns ) ");
		queryString.append(" and   (:helkk is null or helkk = :helkk ) ");
		queryString.append(" and   (:hepnk is null or hepnk = :hepnk ) ");

		return namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new HeadfDto()));

	}

}
