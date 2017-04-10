package no.systema.jservices.common.dto;

import no.systema.jservices.common.dao.ArktxtDao;


/**
 * This is the Data Transfer Object between service and UI for Arkiv dokumenter
 * @author Fredrik Möller
 * @date Apr 10, 2017
 *
 */
public class ArktxtDto extends ArktxtDao {

	private String arctxtDesc;

	public String getArctxtDesc() {
		return arctxtDesc;
	}

	public void setArctxtDesc(String arctxtDesc) {
		this.arctxtDesc = arctxtDesc;
	}

}
