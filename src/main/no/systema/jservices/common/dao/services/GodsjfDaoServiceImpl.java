package no.systema.jservices.common.dao.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.*;

import no.systema.jservices.common.dao.GodsjfDao;
import no.systema.jservices.common.dao.GenericObjectMapper;
import no.systema.jservices.common.util.StringUtils;

public class GodsjfDaoServiceImpl extends GenericDaoServiceImpl<GodsjfDao> implements GodsjfDaoService{
	private static final Logger logger = LoggerFactory.getLogger(GodsjfDaoServiceImpl.class.getName());
	
	@Override
	public List<GodsjfDao> findGognInterval(String gogn2, GodsjfDao dao) {
		StringBuilder queryString = new StringBuilder("SELECT * from godsjf ");
		queryString.append(" where GOGN >= ? and GOGN <= ? ");
		
		
		if(dao.getGotrnr()!=null){ //we must allow 'blank'
			queryString.append(" and gotrnr =  '" + dao.getGotrnr() + "'" );
		}
		if(StringUtils.hasValue(dao.getGobiln())){
			queryString.append(" and gobiln =  '" + dao.getGobiln() + "'" );
		}
		if(StringUtils.hasValue(dao.getGomott())){
			queryString.append(" and gomott =  '" + dao.getGomott() + "%'" );
		}
		if(StringUtils.hasValue(dao.getGoturn())){
			queryString.append(" and goturn =  '" + dao.getGoturn() + "'" );
		}

		queryString.append(" order by GOGN desc ");
		logger.info(queryString.toString());
		logger.info("PARAMS gogn:" + dao.getGogn() + " gogn2:" + gogn2);
		
		return super.getJdbcTemplate().query( queryString.toString(), new Object[] { dao.getGogn(), gogn2  }, new GenericObjectMapper(new GodsjfDao()));
		
	}
	
	@Override
	public List<GodsjfDao> findDefault(String currentYear, String fromDay, String toDay, GodsjfDao dao) {
		StringBuilder queryString = new StringBuilder("SELECT * from godsjf ");
		queryString.append(" where substr(GOGN,1,4) = ? and substr(GOGN,10,3) >= ? ");
		if(StringUtils.hasValue(toDay)){
			queryString.append(" and substr(GOGN,10,3) <= ? ");
		}
		
		
		if(dao.getGotrnr()!=null){ //we must allow 'blank'
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
		logger.info("PARAMS currentYear:" + currentYear + " toDay:" + toDay);
		
		List outputList = new ArrayList();
		if(StringUtils.hasValue(toDay)){
			outputList = super.getJdbcTemplate().query( queryString.toString(), new Object[] { currentYear, fromDay, toDay  }, new GenericObjectMapper(new GodsjfDao()));
		}else{
			outputList = super.getJdbcTemplate().query( queryString.toString(), new Object[] { currentYear, fromDay  }, new GenericObjectMapper(new GodsjfDao()));
		}
		return outputList;
		
	}
	/**
	 * 
	 */
	public int deleteSpecialCase(GodsjfDao dao){
		StringBuilder queryString = new StringBuilder("UPDATE godsjf SET gotrnr = '*SLETTET'");
		//where clause
		queryString.append(" where gogn = '" + dao.getGogn() + "'");
		if(dao.getGotrnr()!=null){ //we must allow 'blank'
			queryString.append(" and gotrnr =  '" + dao.getGotrnr() + "'" );
		}
		logger.info(queryString.toString());
		return super.getJdbcTemplate().update(queryString.toString());
	}

	/**
	 * 
	 * @param dao
	 * @param gotrnrOrig
	 * @return
	 */
	public int updateTransittSpecialCase(GodsjfDao dao, String gotrnrOrig){
		StringBuilder queryString = new StringBuilder("UPDATE godsjf SET gotrnr = '" + dao.getGotrnr() + "'");
		queryString.append(", gobiln = '" + StringUtils.nvl(dao.getGobiln()) + "'");
		queryString.append(", goavg = '" + StringUtils.nvl(dao.getGoavg()) + "'");
		queryString.append(", gotrdt = '" + dao.getGotrdt() + "'");
		queryString.append(", gorei1 = '" + StringUtils.nvl(dao.getGorei1()) + "'");
		queryString.append(", gorei2 = '" + StringUtils.nvl(dao.getGorei2()) + "'");
		queryString.append(", gorei3 = '" + StringUtils.nvl(dao.getGorei3()) + "'");
		queryString.append(", gorei4 = '" + StringUtils.nvl(dao.getGorei4()) + "'");
		queryString.append(", gogren = '" + StringUtils.nvl(dao.getGogren()) + "'");
		queryString.append(", gogrdt = '" + dao.getGogrdt() + "'");
		queryString.append(", gogrkl = '" + dao.getGogrkl() + "'");
		queryString.append(", golsen = '" + StringUtils.nvl(dao.getGolsen()) + "'");
		queryString.append(", golsdt = '" + dao.getGolsdt() + "'");
		queryString.append(", golskl = '" + dao.getGolskl() + "'");
		queryString.append(", gotype = '" + StringUtils.nvl(dao.getGotype()) + "'");
		queryString.append(", goturn = '" + StringUtils.nvl(dao.getGoturn()) + "'");
		//where clause
		queryString.append(" where gogn = '" + dao.getGogn() + "'");
		if(dao.getGotrnr()!=null){
			queryString.append(" and gotrnr =  '" + gotrnrOrig + "'" );
		}
		logger.info(queryString.toString());
		return super.getJdbcTemplate().update(queryString.toString());
	}

}
