package no.systema.jservices.common.dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import no.systema.jservices.common.dao.GodshfDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.util.StringUtils;

public class GodshfDaoServiceImpl extends GenericDaoServiceImpl<GodshfDao> implements GodshfDaoService{
	private static final Logger logger = Logger.getLogger(GodshfDaoServiceImpl.class.getName());
	
	@Override
	public List<GodshfDao> findDefault(String currentYear, String fromDay, GodshfDao dao) {
		StringBuilder queryString = new StringBuilder("SELECT * from godshf ");
		queryString.append(" where substr(GOGN,1,4) = ? and substr(GOGN,10,3) > ? ");
		
		if(StringUtils.hasValue(dao.getGotrnr())){
			queryString.append(" and gotrnr =  '" + dao.getGotrnr() + "'" );
		}
		if(StringUtils.hasValue(dao.getGohpgm())){
			queryString.append(" and gohpgm =  '" + dao.getGohpgm() + "'" );
		}
		
		if(dao.getGohdat()>0){
			queryString.append(" and gohdat =  '" + dao.getGohdat() + "'" );
		}
		if(dao.getGohtim()>0){
			queryString.append(" and gohtim =  '" + dao.getGohtim() + "'" );
		}
		
		if(StringUtils.hasValue(dao.getGohusr())){
			queryString.append(" and gohusr =  '" + dao.getGohusr() + "'" );
		}
		if(StringUtils.hasValue(dao.getGohkod())){
			queryString.append(" and gohkod =  '" + dao.getGohkod() + "'" );
		}

		queryString.append(" order by GOGN desc ");
		logger.info(queryString.toString());
		logger.info("PARAMS currentYear:" + currentYear + " fromDay:" + fromDay);
		
		return super.getJdbcTemplate().query( queryString.toString(), new Object[] { currentYear, fromDay  }, new GenericObjectMapper(new GodshfDao()));
		
	}
	
}
