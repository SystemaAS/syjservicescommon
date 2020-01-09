package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.BridfDao;

public class BridfDaoServiceImpl extends GenericDaoServiceImpl<BridfDao> implements BridfDaoService{

	@Override
	public String getUserName(String name) {
		BridfDao qDao = new BridfDao();
		name = this.cleanXSS(name);
		qDao.setBibrid(name);
		BridfDao resultDao = find(qDao);
	
		if (resultDao != null) {
			return resultDao.getBibrid();	
		} else {
			return null;
		}
		
	}

	@Override
	public boolean userNameExist(String name) {
		name = this.cleanXSS(name);
		params.put("bibrid", name);
		List<BridfDao> resultList = findAll(params);
	
		if (resultList.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * clean user from XSS-attacks 
	 * @param value
	 * @return
	 */
	private String cleanXSS(String value) {
		// You'll need to remove the spaces from the html entities below
		logger.info("InnXSS RequestWrapper ..............." + value);
		//value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		//value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		//value = value.replaceAll("'", "& #39;");
		value = value.replaceAll("eval\\((.*)\\)", "");
		value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

		value = value.replaceAll("(?i)<script.*?>.*?<script.*?>", "");
		value = value.replaceAll("(?i)<script.*?>.*?</script.*?>", "");
		value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
		value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
		value = value.replaceAll("script", "");
		//value = value.replaceAll("</script>", "");
		
		value = value.replaceAll("'", "");
		logger.info("OutnXSS RequestWrapper ........ value ......." + value);
		return value;
	}

}
