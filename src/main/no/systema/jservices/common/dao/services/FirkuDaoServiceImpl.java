package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FirkuDao;

public class FirkuDaoServiceImpl extends GenericDaoServiceImpl<FirkuDao> implements FirkuDaoService {

	private String firmaColumnName = "fifirm";
	
	@Override
	public FirkuDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public FirkuDao get() {
		List<FirkuDao> daoList = findAll(null);
		if (daoList == null || daoList.size() != 1) {
			throw new IllegalStateException("Somethings wrong with FIRKU! Single row not found!");
		} else {
			return daoList.get(0);
		}
	}

	@Override
	public boolean isAdressCustomer(int kundnr) {
		FirkuDao dao = get();
		
		if(kundnr >= dao.getFikufr() && kundnr <= dao.getFikuti()) {
			return true;
		} else {
			return false;
		}	

	}	
	
}
