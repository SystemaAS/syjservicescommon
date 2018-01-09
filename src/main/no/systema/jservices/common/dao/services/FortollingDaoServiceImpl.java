package no.systema.jservices.common.dao.services;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	private DateTimeManager dm = new DateTimeManager();
	
	@Override
	public List<FortollingDto> getStats(FortollingDto qDto) {  
		return getImportStatsNew(qDto);
	
	}

	private List<FortollingDto> getImportStatsNew(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder();
		queryString.append( "SELECT  siavd avdeling,  sitdn deklarasjonsnr, sidt registreringsdato, sisg signatur,  siknk mottaker, wvpreg reg_vareposter,  wvpoff off_vareposter, ");
		queryString.append("  		wie type,  wmerk edim,  sidtg deklarasjonsdato, wsvexr03 inputtype ");
		queryString.append(" FROM SADHAN   ");	
		queryString.append(" WHERE  (:registreringsdato IS NULL OR sidt >= :registreringsdato )");
		queryString.append(" AND    (:registreringsdato IS NULL OR sidt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    AND  (siavd IN ( :avdelingList ) )");
		}		
		if (qDto.getMottaker() > 0) {
			queryString.append(" 	AND   siknk = "+qDto.getMottaker());	
		}
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    AND  (sisg IN ( :signaturList )) ");
		}
		
		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	
	
	@Deprecated
	private List<FortollingDto> getImportStatsORG(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder( 
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, "
							+ "'Import' type,  COALESCE(concat(e.kalle, e.anka), 'OK') edim,  sh.deklarasjonsdato, sv.svexr02 inputtype ");
		queryString.append(" FROM (select shX.siavd avdeling, shX.sitdn deklarasjonsnr, shX.sidt registreringsdato, shX.sisg signatur,  shX.siknk mottaker, shX.sidtg deklarasjonsdato ");
		queryString.append(" 	   	from SADH shX  ");
		queryString.append("      	where  (:registreringsdato IS NULL OR shX.sidt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR shX.sidt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    and  (shX.siavd IN ( :avdelingList ) )");
		}		
		queryString.append(" 		and   shX.siavd > 0 "); //sanity check
		queryString.append(" 		and   shX.sitdn > 0 "); //sanity check
		if (qDto.getMottaker() > 0) {
			queryString.append(" 	and   shX.siknk = "+qDto.getMottaker());	
		}
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    and  (shX.sisg IN ( :signaturList )) ");
		}
		queryString.append(" 		and shX.sist = 'P' ");
		queryString.append(" ) as sh ");
		queryString.append(" JOIN SADV sv  ");
		queryString.append("	 ON sh.avdeling = sv.svavd AND  sh.deklarasjonsnr = sv.svtdn ");
		queryString.append(" LEFT OUTER JOIN (select et.mavd mavd , et.mtdn mtdn, et.f4815 kalle,  ");
		queryString.append(" 					CASE ");
		queryString.append("  						WHEN NULLIF(et.f0077,  '') IS NULL THEN et.f0078a ");
		queryString.append("  		 				WHEN et.f0077 IS NOT NULL THEN et.f0077 ");
		queryString.append("  		 			END anka ");	
		queryString.append(" 				  from EDIMTVINF et ");
		queryString.append(" 				 ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, sh.deklarasjonsdato, sv.svexr02,  e.kalle, e.anka");

		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	

	
	@Deprecated
	private List<FortollingDto> getExportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder( 
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, "
							+ "'Export' type, COALESCE(concat(e.kalle, e.anka), 'OK') edim, sh.deklarasjonsdato, sv.svexr02 inputtype ");
		queryString.append(" FROM (select shX.seavd avdeling, shX.setdn deklarasjonsnr, shX.sedt registreringsdato, shX.sesg signatur,  shX.seknk mottaker, shX.sedtg deklarasjonsdato ");
		queryString.append(" 	   	from SAEH shX  ");
		queryString.append("      	where  (:registreringsdato IS NULL OR shX.sedt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR shX.sedt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
			queryString.append("    and  (shX.seavd IN ( :avdelingList ) )");
		}	
		queryString.append(" 		and   shX.seavd > 0 "); //sanity check
		queryString.append(" 		and   shX.setdn > 0 "); //sanity check
		if (qDto.getMottaker() > 0) {
			queryString.append(" 	and   shX.seknk = "+qDto.getMottaker());	
		}		
		if (!qDto.getSignaturList().isEmpty()) {
			queryString.append("    and  (shX.sesg IN ( :signaturList )) ");
		}		
		queryString.append(" 		and shX.sest = 'P' ");
		queryString.append(" ) as sh ");
		queryString.append(" JOIN SAEV sv  ");
		queryString.append("	 ON sh.avdeling = sv.svavd AND  sh.deklarasjonsnr = sv.svtdn ");
		queryString.append(" LEFT OUTER JOIN (select et.mavd mavd , et.mtdn mtdn, et.f4815 kalle,  ");
		queryString.append(" 					CASE ");
		queryString.append("  						WHEN NULLIF(et.f0077,  '') IS NULL THEN et.f0078a ");
		queryString.append("  		 				WHEN et.f0077 IS NOT NULL THEN et.f0077 ");
		queryString.append("  		 			END anka ");	
		queryString.append(" 				  from EDIMTVINF et ");
		queryString.append(" 				 ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, sh.deklarasjonsdato, sv.svexr02, e.kalle, e.anka");
	
		
		logger.info("About to run getExportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		
		logger.info("getExportStats list.size="+list.size());
		
		return list;
		
	}	

	
}