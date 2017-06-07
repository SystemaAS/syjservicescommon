package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.Svtx10fDao;

public class Svtx10fDaoServiceImpl extends GenericDaoServiceImpl<Svtx10fDao> implements Svtx10fDaoService{

	@Override
	public List<Svtx10fDao> getTaricExportNumbers() {
		return findWhere("SUBSTR(svtx10_01, 9, 2) = '00'");	
	}

	@Override
	public List<Svtx10fDao> getTaricImportNumbers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean tariExportNrExist(String taricnr) {
		StringBuilder clauseString = new StringBuilder();
		clauseString.append("SUBSTR(svtx10_01, 9, 2) = '00'");
		clauseString.append("AND svtx10_01 = '");clauseString.append(taricnr+"'");
		List<Svtx10fDao> daoList = findWhere(clauseString.toString());	
		if (daoList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean taricImportNrExist(String taricnr) {
		// TODO Auto-generated method stub
		return false;
	}

}
