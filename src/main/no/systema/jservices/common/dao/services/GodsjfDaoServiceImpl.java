package no.systema.jservices.common.dao.services;

import java.util.List;

import org.apache.log4j.Logger;

import no.systema.jservices.common.dao.GodsjfDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.util.StringUtils;

public class GodsjfDaoServiceImpl extends GenericDaoServiceImpl<GodsjfDao> implements GodsjfDaoService{
	private static final Logger logger = Logger.getLogger(GodsjfDaoServiceImpl.class.getName());
	
	@Override
	public List<GodsjfDao> findDefault(String currentYear, String fromDay, GodsjfDao dao) {
		StringBuilder queryString = new StringBuilder("SELECT * from godsjf ");
		queryString.append(" where substr(GOGN,1,4) = ? and substr(GOGN,10,3) > ? ");
		
		if(StringUtils.hasValue(dao.getGotrnr())){
			queryString.append(" and gotrnr =  '" + dao.getGotrnr() + "'" );
		}
		if(StringUtils.hasValue(dao.getGobiln())){
			queryString.append(" and gobiln =  '" + dao.getGobiln() + "'" );
		}
		if(StringUtils.hasValue(dao.getGoturn())){
			queryString.append(" and goturn =  '" + dao.getGoturn() + "'" );
		}

		queryString.append(" order by GOGN desc ");
		logger.info(queryString.toString());
		logger.info("PARAMS currentYear:" + currentYear + " fromDay:" + fromDay);
		
		return super.getJdbcTemplate().query( queryString.toString(), new Object[] { currentYear, fromDay  }, new GenericObjectMapper(new GodsjfDao()));
		
	}

	
}
