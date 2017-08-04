package no.systema.jservices.common.dto;

import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 *  * This is the Data Transfer Object between service and UI, primary for report dashboard
 * 
 * @author Fredrik Möller
 * @date Aug 4, 2017
 *
 */
public class FaktDto implements IDao{

	private int faavd;  //avdelning
	private int faopd; //oppdrag
	private int sumfabeln; //sum pengarader
	private int fadato; //datum
	private String fakda;

	public String getFakda() {
		return fakda;
	}
	public void setFakda(String fakda) {
		this.fakda = fakda;
	}
	public int getSumfabeln() {
		return sumfabeln;
	}
	public void setSumfabeln(int sumfabeln) {
		this.sumfabeln = sumfabeln;
	}
	public int getFaavd() {
		return faavd;
	}
	public void setFaavd(int faavd) {
		this.faavd = faavd;
	}
	public int getFaopd() {
		return faopd;
	}
	public void setFaopd(int faopd) {
		this.faopd = faopd;
	}
	public int getFadato() {
		return fadato;
	}
	public void setFadato(int fadato) {
		this.fadato = fadato;
	}

	@Override
	public Map<String, Object> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
