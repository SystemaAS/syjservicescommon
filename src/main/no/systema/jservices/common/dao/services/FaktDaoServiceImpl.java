package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.FaktDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FaktDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FaktDaoServiceImpl extends GenericDaoServiceImpl<FaktDao> implements FaktDaoService{

	/*
	  Database   SYSDPEDF 
	 Tabellnavn: 
	TTHEADF  
	TTFAKT     
	TTTURER
	TTKOSBU 
	 */
	DateTimeManager dm = new DateTimeManager();
	
	
	@Override
	public List<FaktDao> getYear(int year) {
		int qYear = year * 10000; // e.g. 2016 -> 20160000
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fadato" + GREATER_THEN, qYear);
		return findAll(params);
	}
/*
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("name", person.getName(), Types.VARCHAR);
	params.addValue("lastname", person.getLastname(), Types.VARCHAR);
	params.addValue("birthdate", person.getBirthdate(), Types.DATE);
	params.addValue("idLanguage", person.getLanguage().getId(), Types.NUMERIC);
	return namedJdbcTemplate.update(sql, params);
	
*/	
	
	
	public List<FaktDto> getStats(FaktDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String hedtopFromDate = null;
		String hedtopToDate = null;
		if (isOverview(qDto)) {
			hedtopFromDate = qDto.getRegistreringsdato() + "0100"; //incl. jan, e.g 2016 -> 20160100
			hedtopToDate = qDto.getRegistreringsdato() + "1231";   //incl. jan, e.g 2016 -> 20161231
		} else {  //details
			hedtopFromDate = qDto.getRegistreringsdato() + "00"; // e.g. 201601 -> 20160100	
			hedtopToDate = qDto.getRegistreringsdato() + "31";   // e.g. 201601 -> 20160131
		}
		
		System.out.println("qDto="+ReflectionToStringBuilder.toString(qDto));
		//String hedtopToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder("select t.tupro, t.tubilk, h.heavd avdeling, f.faopd, f.fabeln, h.hedtop registreringsdato, f.fakda, f.faopko, h.trknfa mottaker, f.fask, f.favk ");
		queryString.append(" from  fakt f, headf h, turer t ");
		//queryString.append(" from  ttfakt f, ttheadf h, ttturer t ");  //==Toten data!!
		queryString.append(" where t.tupro = h.hepro ");
		queryString.append(" and f.faavd  = h.heavd ");
		queryString.append(" and   f.faopd = heopd ");
		//queryString.append(" and   (:avdeling = 0 OR h.heavd = :avdeling )");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append(" and  (h.heavd IN ( :avdelingList ) )");
		}
		queryString.append(" and   h.hedtop >= ").append(hedtopFromDate);
		queryString.append(" and   h.hedtop <= ").append(hedtopToDate);
		queryString.append(" and   f.faavd > 0 ");
		queryString.append(" and   f.faopd > 0  ");
		queryString.append(" and   f.faopko = 'O' "); 
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append(" and   (h.hesg IN ( :signaturList ) ) ");
		}

		queryString.append(" and   (:mottaker = 0 OR h.trknfa = :mottaker )");

		if (!qDto.getInclFavkList().isEmpty()) {
			queryString.append(" and   ( f.favk IN ( :inclFavkList ) )");
		}
		//queryString.append(" group by t.tupro, t.tubilk, f.faopd, f.faavd , h.hedtop, f.fakda, f.faopko, h.trknfa ");
		//queryString.append(" order by t.tupro ");

		logger.info("About to run queryString.toString()="+queryString.toString());
		List<FaktDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FaktDto()));
		logger.info("returning list with size="+list.size());
		
		return list;
		
	}

	private boolean isOverview(FaktDto qDto) {
		if (qDto.getRegistreringsdato().length() == 4) {
			return true;
		} else {
			return false;			
		}
	}
	
}