package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;

import no.systema.jservices.common.dao.BridfDao;
import no.systema.jservices.common.dao.VissyskunDao;

@Deprecated //remove when visma i setup
public class VissyskunDaoServiceImpl extends GenericDaoServiceImpl<VissyskunDao> implements VissyskunDaoService {

	private String firmaColumnName = "firma";

	@Override
	public VissyskunDao find(Object id) {
		return findInFirma(id, firmaColumnName);
	}

	@Override
	public VissyskunDao findBySyspedKundnr(int kundnr) {
		VissyskunDao qDao = new VissyskunDao();
		qDao.setKundnr(kundnr); // key

		VissyskunDao resultDao = findInFirma(qDao, firmaColumnName);

		if (resultDao == null) {
			logger.warn("Could not find single record on kundnr=" + kundnr);
		}

		return resultDao;
	}

	@Override
	public VissyskunDao findByVismaKundnr(int visknr) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("visknr", visknr);
		List<VissyskunDao> list = findAllInFirma(params, firmaColumnName);

		if (list.size() > 1) {
			throw new DuplicateKeyException("ERROR: cannot be more than one record for visknr=" + visknr + " in firma");
		}

		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}

	}

}
