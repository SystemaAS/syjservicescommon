package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViscrossrDao;
import no.systema.jservices.common.values.ViscrossrKoder;

public class ViscrossrDaoServiceImpl extends GenericDaoServiceImpl<ViscrossrDao> implements ViscrossrDaoService{

	@Override
	public String getVismaCodeId(String syspedCode, ViscrossrKoder codeType) {
		ViscrossrDao qDao = new ViscrossrDao();
		qDao.setSvsysp(syspedCode);
		qDao.setSvtype(codeType.toString());
		ViscrossrDao result =  find(qDao);
		
		if (result != null) {
			return result.getSvvism();
		} else {
			return null;
		}
	}

}
