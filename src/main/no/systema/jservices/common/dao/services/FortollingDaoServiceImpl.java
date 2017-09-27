package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.dto.FortollingDto;
import no.systema.jservices.common.util.DateTimeManager;

public class FortollingDaoServiceImpl extends GenericDaoServiceImpl<FortollingDto> implements FortollingDaoService{

	DateTimeManager dm = new DateTimeManager();
	
	@Override
	public List<FortollingDto> getStats(int fromYear) {
		String sidtFromDate = fromYear + "0000"; // e.g. 2016 -> 20160000		
		String sidtToDate = dm.getCurrentDate_ISO();
		StringBuilder queryString = new StringBuilder("select sh.siavd, sh.sitdn, sh.sidt, sh.sisg, count(sv.svtdn) antvareposter ");
		queryString.append(" from sadh sh, sadv sv ");  
		queryString.append(" where sv.svavd = sh.siavd ");  
		queryString.append(" and sv.svtdn = sh.sitdn ");  		
		queryString.append(" and   sh.sidt >= ").append(sidtFromDate);
		queryString.append(" and   sh.sidt <= ").append(sidtToDate);	
		queryString.append(" and   sh.siavd > 0 ");
		queryString.append(" and   sh.sitdn > 0 ");
		queryString.append(" group by  sh.siavd, sh.sitdn, sh.sidt, sh.sisg ");
		queryString.append(" order by sh.siavd ");
		
		logger.info("About to run getStats.queryString.toString()="+queryString.toString());	
		List<FortollingDto> list = null;
		list=  getJdbcTemplate().query(queryString.toString(), new GenericObjectMapper(new FortollingDto()));
		return list;
	
	}
	
}