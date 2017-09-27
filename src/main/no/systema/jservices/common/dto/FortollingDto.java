package no.systema.jservices.common.dto;

import java.util.Map;

import no.systema.jservices.common.dao.IDao;

/**
 * This class is primary used as serving reports with data
 * 
 * @author Fredrik Möller
 * @date Sept, 27 2017
 *
 */
public class FortollingDto implements IDao {

	private int siavd;
	private int sitdn;
	private int sidt;
	private String sisg;

	public int getSiavd() {
		return siavd;
	}

	public void setSiavd(int siavd) {
		this.siavd = siavd;
	}

	public int getSitdn() {
		return sitdn;
	}

	public void setSitdn(int sitdn) {
		this.sitdn = sitdn;
	}

	public int getSidt() {
		return sidt;
	}

	public void setSidt(int sidt) {
		this.sidt = sidt;
	}

	public String getSisg() {
		return sisg;
	}

	public void setSisg(String sisg) {
		this.sisg = sisg;
	}

	@Override
	public Map<String, Object> getKeys() {
		return null; // Just used as upstreams DTO
	}

}
