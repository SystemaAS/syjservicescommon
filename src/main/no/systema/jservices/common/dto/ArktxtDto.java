package no.systema.jservices.common.dto;

import no.systema.jservices.common.dao.ArktxtDao;


/**
 * This is the Data Transfer Object between service and UI for Arkiv dokumenter
 * @author Fredrik Möller
 * @date Apr 10, 2017
 *
 */
public class ArktxtDto extends ArktxtDao {

	private String arklagDesc;

	public String getArklagDesc() {
		return arklagDesc;
	}

	public void setArklagDesc(String arklagDesc) {
		this.arklagDesc = arklagDesc;
	}

}
