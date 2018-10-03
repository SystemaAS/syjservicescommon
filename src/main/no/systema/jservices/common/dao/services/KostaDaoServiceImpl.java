package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dao.KostaDao;
import no.systema.jservices.common.dto.KostaDto;

public class KostaDaoServiceImpl extends GenericDaoServiceImpl<KostaDao> implements KostaDaoService{

	@Override
	public List<KostaDao> findAll(Integer bilagsnr, Integer innregnr, String faktnr, Integer levnr, String attkode,
			String komment, Integer fradato, Integer fraperaar, Integer frapermnd, String status) {

		Map<String, Object> params = new HashMap<String, Object>();
		if (innregnr != null) {
			params.put("kabnr", innregnr);
		}
		if (bilagsnr != null) {
			params.put("kabnr2", bilagsnr);
		}
		if (faktnr != null) {
			params.put("kafnr", faktnr);
		}
		if (levnr != null) {
			params.put("kalnr", levnr);
		}
		if (attkode != null) {
			params.put("kasg", attkode);
		}
		if (komment != null) {
			params.put("katxt", komment);
		}
		if (fradato != null) {
			params.put("kabdt" + GREATER_AND_EQUALS_THEN, fradato);
		}
		//TODO grupper år och mån i sökning
		if (fraperaar != null) {
			params.put("KAPÅR" + GREATER_AND_EQUALS_THEN, fraperaar);
		}
		if (frapermnd != null) {
			params.put("kapmn" + GREATER_AND_EQUALS_THEN, frapermnd);
		}
		if (status != null) {
			params.put("kast", status);
		}
		
		
		return findAll(params);
	}

	@Override
	public List<KostaDao> findAllComplex(KostaDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);

		if (qDto.getKbrekl() == null && qDto.getFskode() == null && qDto.getFssok() == null) {
			return findAll(qDto.getKabnr2(), qDto.getKabnr(), qDto.getKafnr(), qDto.getKalnr(), qDto.getKasg(), qDto.getKatxt(), qDto.getKabdt(), 
					qDto.getKAPÅR(), qDto.getKapmn(), qDto.getKast());
		} else {
			//Search on kun reklamasjon
			
			StringBuilder queryString = new StringBuilder("select ka.* ");
			queryString.append(" from  kosta ka, kostb kb");
			queryString.append(" where ka.kabnr = kb.kbbnr ");
//		queryString.append(" and f.faavd  = h.heavd ");
//		queryString.append(" and   f.faopd = heopd ");
//		queryString.append(" and   h.hedtop >= ").append(hedtopFromDate);
//		queryString.append(" and   h.hedtop <= ").append(hedtopToDate);
//		queryString.append(" and   f.faavd > 0 ");
//		queryString.append(" and   f.faopd > 0  ");
//		queryString.append(" and   f.faopko = 'O' "); 
			queryString.append(" and   (:kbrekl = '' OR kb.kbrekl = :kbrekl )");
			
			logger.info("About to run queryString.toString()="+queryString.toString());
			List<KostaDao> list = null;
			list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new KostaDao()));
			logger.info("returning list with size="+list.size());
			
			return list;
		}
		
	
	
	}

}
