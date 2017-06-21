package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.Svtx10fDao;

public class Svtx10fDaoServiceImpl extends GenericDaoServiceImpl<Svtx10fDao> implements Svtx10fDaoService{

	private static String trailingZeros = "00";
	
	@Override
	public List<Svtx10fDao> getTaricExportNumbers() {
		return findWhere("SUBSTR(svtx10_01, 9, 2) = '00'");	
	}

	@Override
	public List<Svtx10fDao> getTaricImportNumbers() {
		return findWhere("SUBSTR(svtx10_01, 9, 2) <> '00'");	
	}

	@Override
	public boolean tariExportNrExist(String taricnr) {
		String taricnrToValidate = taricnr + trailingZeros;		
		StringBuilder clauseString = new StringBuilder();
		clauseString.append("SUBSTR(svtx10_01, 9, 2) = '00'");
		clauseString.append("AND svtx10_01 = '");clauseString.append(taricnrToValidate+"'");

		return exist(clauseString.toString());
	}

	@Override
	public boolean taricImportNrExist(String taricnr) {
		StringBuilder clauseString = new StringBuilder();
		clauseString.append("SUBSTR(svtx10_01, 9, 2) <> '00'");
		clauseString.append("AND svtx10_01 = '");clauseString.append(taricnr+"'");

		return exist(clauseString.toString());
	}

	@Override
	public List<Svtx10fDao> findByLikeId(String varukod) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("svtx10_01", WILD_CARD + varukod + WILD_CARD);
		return findAll(params);
	}
	
	private boolean exist(String clause){
		List<Svtx10fDao> daoList = findWhere(clause);	
		if (daoList.size() > 0) {
			return true;
		} else {
			return false;
		}		
	}

}
