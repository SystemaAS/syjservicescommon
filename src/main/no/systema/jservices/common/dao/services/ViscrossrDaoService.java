package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.ViscrossrDao;
import no.systema.jservices.common.values.ViscrossrKoder;

public interface ViscrossrDaoService extends GenericDaoService<ViscrossrDao> {

	/**
	 * Converting SYSPED code into Visma.net code on requested codetype. 
	 * 
	 * @see {@linkplain ViscrossrKoder}
	 * 
	 * @param syspedCode
	 * @param codeType
	 * @return Visma.net value, return null if not found
	 */
	public String getVismaCodeId(String syspedCode, ViscrossrKoder codeType);
	
}
