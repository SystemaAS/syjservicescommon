package no.systema.jservices.common.dto;

import no.systema.jservices.common.dao.SyparfDao;

/**
 * This is the Data Transfer Object between service and UI for Kunderegister - Div. params
 * 
 * @author Fredrik Möller
 * @date Mar 3, 2017
 *
 */
public class SyparfDto extends SyparfDao {
	
	private String sypaidDesc;

	public String getSypaidDesc() {
		return sypaidDesc;
	}

	public void setSypaidDesc(String sypaidDesc) {
		this.sypaidDesc = sypaidDesc;
	}
	
	
}
