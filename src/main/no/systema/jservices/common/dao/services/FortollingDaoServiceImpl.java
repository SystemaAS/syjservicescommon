package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;
import no.systema.jservices.common.dto.SingleValueDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	private DateTimeManager dm = new DateTimeManager();
	private Map<String, String> sadkapMap = new HashMap<String, String>();
	private Map<String, String> merknadMap = null;
	
	@Override
	public List<FortollingDto> getStats(FortollingDto qDto) {  
		merknadMap = new HashMap<String, String>();
		List<FortollingDto> impList = getImportStats(qDto);
		List<FortollingDto> expList = getExportStats(qDto);  
		List<FortollingDto> impAndExpList =  new ArrayList<FortollingDto>();
		impAndExpList.addAll(impList);
		impAndExpList.addAll(expList);
		
		return impAndExpList;
	
	}

	
	public List<FortollingDto> getImportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		
		StringBuilder queryString = new StringBuilder(" select 'Import' type, siavd avdeling, sitdn deklarasjonsnr, svln off_vareposter ,sidt registreringsdato, sisg signatur, svexr02 inputtype, siknk mottaker, sidtg deklarasjonsdato, SUBSTR(svvnt, 1, 2) sadkap01 ");
		queryString.append(" 	   	from SADH, SADV ");
		queryString.append("	    where siavd = svavd AND  sitdn = svtdn ");
		queryString.append("      	and  (:registreringsdato IS NULL OR sidt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR sidt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
		queryString.append("    and  (siavd IN ( :avdelingList ) )");
		}		
		queryString.append(" 		and   siavd > 0 "); //sanity check
		queryString.append(" 		and   sitdn > 0 "); //sanity check
		if (qDto.getMottaker() > 0) {
		queryString.append(" 	and   siknk = "+qDto.getMottaker());	
		}
		if (!qDto.getSignaturList().isEmpty()) {
		queryString.append("    and  (sisg IN ( :signaturList )) ");
		}
		queryString.append(" 		and sist = 'P' ");
		

		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getImportStats list.size="+list.size());
		
		
		addDataBySadkap(list);
		addDataByEdimTvineF(list);
		
		return list;
	}	
	
	public List<FortollingDto> getExportStats(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		
		StringBuilder queryString = new StringBuilder(" select 'Export' type, seavd avdeling, setdn deklarasjonsnr, svln off_vareposter ,sedt registreringsdato, sesg signatur, svexr02 inputtype, seknk mottaker, sedtg deklarasjonsdato, SUBSTR(svvnt, 1, 2) sadkap01 ");
		queryString.append(" 	   	from SAEH, SADV ");
		queryString.append("	    where seavd = svavd AND  setdn = svtdn ");
		queryString.append("      	and  (:registreringsdato IS NULL OR sedt >= :registreringsdato )");
		queryString.append(" 		and   (:registreringsdato IS NULL OR sedt <="+sidtToDate+")");
		if (!qDto.getAvdelingList().isEmpty()) {
		queryString.append("    and  (seavd IN ( :avdelingList ) )");
		}		
		queryString.append(" 		and   seavd > 0 "); //sanity check
		queryString.append(" 		and   setdn > 0 "); //sanity check
		if (qDto.getMottaker() > 0) {
		queryString.append(" 	and   seknk = "+qDto.getMottaker());	
		}
		if (!qDto.getSignaturList().isEmpty()) {
		queryString.append("    and  (sesg IN ( :signaturList )) ");
		}
		queryString.append(" 		and sest = 'P' ");
		

		logger.info("About to run getExportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getExportStats list.size="+list.size());
		
		
		addDataBySadkap(list);
		addDataByEdimTvineF(list);
		
		return list;
	}		
	
	/* !IMPORTANT NOTES!
	 * 
	 * Special treatment, due to too complex structure only one(1) merknad can be viewed, since placeholder i data is SADV-rows
	 * (Need more work to become composte as Data model, se below.)
	 * 
	 * 
	 * 
	 * Data model = https://www.draw.io/?lightbox=1&highlight=0000ff&edit=_blank&layers=1&nav=1#G1XLxSYmrb9WmgJ_-9jFEl3M-q9iMTkMS7
	 * 
	 * Result: Every row in SADV is holding the same value, e.g. PP972, same as for e.g. signatur
	 * 
	 * TODO: Add collection/array of edimtvinf-rows, e.g PP972, NE950
	 */
	private void addDataByEdimTvineF(List<FortollingDto> list) {
		String merknad = null;
		String merknadKey = null;
		for (FortollingDto fortollingDto : list) {
			merknadKey = String.valueOf(fortollingDto.getAvdeling()) + fortollingDto.getDeklarasjonsnr();
			if (!merknadMap.containsKey(merknadKey)) { // TODO empty map
				merknadMap.put(merknadKey, getMerknad(fortollingDto));
			}

			merknad = merknadMap.get(merknadKey.toString());
			fortollingDto.setEdim(merknad);

		}

	}

	private String getMerknad(FortollingDto fortollingDto) {
		String merknad =  null;
		SingleValueDto resultDto = null;
		List<SingleValueDto> dtoList = null;
		StringBuilder queryString = new StringBuilder(" select concat(t.f4815,  ");
		queryString.append(" 					CASE ");
		queryString.append("  						WHEN NULLIF(t.f0077,  '') IS NULL THEN t.f0078a ");
		queryString.append("  		 				WHEN t.f0077 IS NOT NULL THEN t.f0077 ");
		queryString.append("  		 			END) AS value");	
		queryString.append(" 				  from EDIM e, TVINF t ");
		queryString.append(" 				  where e.mmn = t.fmn ");
		queryString.append(" 				  and   e.msr = 'R' and   e.m0065 = 'CUSRES' and   e.m1n07 in ('DME','DFI') ");
		queryString.append("  				  and e.mavd= "+fortollingDto.getAvdeling());
		queryString.append("  				  and e.mtdn= "+fortollingDto.getDeklarasjonsnr());				
		queryString.append(" 				  and   ( t.f0078a in('950','954','972') OR  NULLIF(t.f0077, '') IS NOT NULL )");
		queryString.append(" 				  and   t.f4815 in('NE','PP') ");

		dtoList = findAll(queryString.toString(), new GenericObjectMapper(new SingleValueDto()), null);
	
		if (dtoList.size() > 0) {
			resultDto = dtoList.get(0); 
			merknad = resultDto.getValue();
		} else {
			merknad = "OK";	
		}
		
//		if (dtoList.size() > 1) { 
//			logger.error("More than 1 hit in TVINF on deklarasjonnr="+fortollingDto.getDeklarasjonsnr()+ " and avdeling="+fortollingDto.getAvdeling());
//		}		
		
		return merknad;
	}

	private void addDataBySadkap(List<FortollingDto> list) {
		String sadkap02 = null;
		for (FortollingDto fortollingDto : list) {
			if (!sadkapMap.containsKey(fortollingDto.getSadkap01())) {
				sadkapMap.put(fortollingDto.getSadkap01(), getSadKap2(fortollingDto.getSadkap01()));
			}

			sadkap02 = sadkapMap.get(fortollingDto.getSadkap01());
			fortollingDto.setAvsnitt(sadkap02);

		}
	}

	private String getSadKap2(String sadkap01) {
		String sadkap02 = null;
		SingleValueDto resultDto = null;
		List<SingleValueDto> dtoList = null;

		StringBuilder queryString = new StringBuilder(" select sadkap02 as value ");
		queryString.append("from sadkap ");
		queryString.append("where sadkap01 =" + sadkap01);

		dtoList = findAll(queryString.toString(), new GenericObjectMapper(new SingleValueDto()), null);

		if (dtoList.size() > 0) {
			resultDto = dtoList.get(0); // unika poster
			sadkap02 = resultDto.getValue();
		}

		return sadkap02;

	}
	
	@Deprecated // to be removed
	private List<FortollingDto> getImportStatsORG(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder(
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, "
							+ "'Import' type,  COALESCE(concat(e.kalle, e.anka), 'OK') edim, sk.sadkap02 avsnitt, sh.deklarasjonsdato, sv.svexr02 inputtype ");
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
		queryString.append(" JOIN SADKAP sk  ");
		queryString.append("	 ON SUBSTR(sv.svvnt, 1, 2) = sk.sadkap01 ");
		queryString.append(" LEFT OUTER JOIN (select e.mavd mavd , e.mtdn mtdn, t.f4815 kalle,  ");
		queryString.append(" 					CASE ");
		queryString.append("  						WHEN NULLIF(t.f0077,  '') IS NULL THEN t.f0078a ");
		queryString.append("  		 				WHEN t.f0077 IS NOT NULL THEN t.f0077 ");
		queryString.append("  		 			END anka ");	
		queryString.append(" 				  from EDIM e, TVINF t ");
		queryString.append(" 				  where e.mmn = t.fmn ");
		queryString.append(" 				  and   e.msr = 'R' and   e.m0065 = 'CUSRES' and   e.m1n07 in ('DME','DFI') ");
		queryString.append(" 				  and   ( t.f0078a in('950','954','972') OR  NULLIF(t.f0077, '') IS NOT NULL )");
		queryString.append(" 				  and   t.f4815 in('NE','PP') ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, COALESCE(concat(e.kalle, e.anka), 'OK'), sk.sadkap02, sh.deklarasjonsdato, sv.svexr02 ");

		logger.info("About to run getImportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getImportStats list.size="+list.size());
		return list;
	}	
	
	
	@Deprecated // to be removed
	private List<FortollingDto> getExportStatsORG(FortollingDto qDto) {
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getJdbcTemplate().getDataSource());
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(qDto);
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder(
							"SELECT  sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, count(sv.svtdn) reg_vareposter,  max(sv.svln) off_vareposter, "
							+ "'Export' type, COALESCE(concat(e.kalle, e.anka), 'OK') edim, sk.sadkap02 avsnitt, sh.deklarasjonsdato, sv.svexr02 inputtype ");
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
		queryString.append(" JOIN SADKAP sk  ");
		queryString.append("	 ON SUBSTR(sv.svvnt, 1, 2) = sk.sadkap01 ");		
		queryString.append(" LEFT OUTER JOIN (select e.mavd mavd , e.mtdn mtdn, t.f4815 kalle, ");
		queryString.append(" 					CASE ");
		queryString.append("  						WHEN NULLIF(t.f0077,  '') IS NULL THEN t.f0078a ");
		queryString.append("  		 				WHEN t.f0077 IS NOT NULL THEN t.f0077 ");
		queryString.append("  		 			END anka ");	
		queryString.append(" 				  from EDIM e, TVINF t ");
		queryString.append(" 				  where e.mmn = t.fmn ");
		queryString.append(" 				  and   e.msr = 'R' and   e.m0065 = 'CUSRES' and    e.m1n07 in ('DME','DFI')  ");
		queryString.append(" 				  and   ( t.f0078a in('950','954','972') OR NULLIF(t.f0077, '') IS NOT NULL )");
		queryString.append(" 				  and   t.f4815 in('NE','PP') ) e ");
		queryString.append("  	ON sh.avdeling = e.mavd AND sh.deklarasjonsnr = e.mtdn ");
		queryString.append(" group by sh.avdeling, sh.deklarasjonsnr, sh.registreringsdato, sh.signatur,  sh.mottaker, COALESCE(concat(e.kalle, e.anka), 'OK'), sk.sadkap02, sh.deklarasjonsdato, sv.svexr02 ");
	
		
		logger.info("About to run getExportStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  namedParameterJdbcTemplate.query(queryString.toString(), namedParameters, new GenericObjectMapper(new FortollingDto()));
		logger.info("getExportStats list.size="+list.size());
		return list;
	}	

	
}