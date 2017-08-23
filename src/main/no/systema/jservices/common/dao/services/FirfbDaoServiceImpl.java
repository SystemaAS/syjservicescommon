package no.systema.jservices.common.dao.services;

import java.util.List;

import no.systema.jservices.common.dao.FirfbDao;
import no.systema.jservices.common.util.GSINCheckDigit;

public class FirfbDaoServiceImpl extends GenericDaoServiceImpl<FirfbDao> implements FirfbDaoService {

	@Override
	public String getSendningsnr() {
		StringBuilder gsinScaffolding = new StringBuilder();
		StringBuilder sendingsNummer = new StringBuilder();
		String checkDigit = null;
		FirfbDao dao = null;
		int updatedFirecn;
		List<FirfbDao> daoList = findAll(null);
		if (daoList == null || daoList.size() != 1) {
			throw new IllegalStateException("Somethings wrong with FIRFB! Single row not found!");
		} else {
			dao = daoList.get(0);
		}

		updatedFirecn = getUpdatedFirecn(dao);
		gsinScaffolding.append(dao.getFisnla());
		gsinScaffolding.append(dao.getFisnle());
		gsinScaffolding.append(adjusted(updatedFirecn));
		checkDigit = GSINCheckDigit.calculate(gsinScaffolding.toString());
		sendingsNummer.append(gsinScaffolding.toString());
		sendingsNummer.append(checkDigit);

		return sendingsNummer.toString();
	}

	private String adjusted(int updatedFirecn) {
		StringBuilder adjustedFirecn = new StringBuilder();
		StringBuilder prefix = new StringBuilder();
		int length = String.valueOf(updatedFirecn).length();
		if (length < 9) {
			for (int i = length; i < 9; i++) {
				prefix.append("0"); // prefixing with zero to get upto 9 digits
			}
			adjustedFirecn.append(prefix);
		}

		adjustedFirecn.append(updatedFirecn);

		return adjustedFirecn.toString();
	}

	private int getUpdatedFirecn(FirfbDao dao) {
		int retval = 0;
		int prevFirecn = dao.getFirecn();
		int updatedFirecn = prevFirecn + 1;
		StringBuilder updateString = new StringBuilder("UPDATE firfb SET firecn =  ?");
		retval = getJdbcTemplate().update(updateString.toString(), new Object[] { updatedFirecn });

		if (retval != 1) {
			throw new IllegalStateException("Somethings wrong with FIRFB! Could not update!");
		}

		return updatedFirecn;
	}

}
