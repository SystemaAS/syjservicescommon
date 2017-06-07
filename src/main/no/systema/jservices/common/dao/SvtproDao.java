package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class SvtproDao implements IDao {

	private String svpr_ie;
	private String svpr_pr;
	private String svpr_tx1;
	private String svpr_tx2;
	private String svpr_tx3;
	private String svpr_tx4;
	private String svpr_tx5;

	public String getSvpr_ie() {
		return svpr_ie;
	}

	public void setSvpr_ie(String svpr_ie) {
		this.svpr_ie = svpr_ie;
	}

	public String getSvpr_pr() {
		return svpr_pr;
	}

	public void setSvpr_pr(String svpr_pr) {
		this.svpr_pr = svpr_pr;
	}

	public String getSvpr_tx1() {
		return svpr_tx1;
	}

	public void setSvpr_tx1(String svpr_tx1) {
		this.svpr_tx1 = svpr_tx1;
	}

	public String getSvpr_tx2() {
		return svpr_tx2;
	}

	public void setSvpr_tx2(String svpr_tx2) {
		this.svpr_tx2 = svpr_tx2;
	}

	public String getSvpr_tx3() {
		return svpr_tx3;
	}

	public void setSvpr_tx3(String svpr_tx3) {
		this.svpr_tx3 = svpr_tx3;
	}

	public String getSvpr_tx4() {
		return svpr_tx4;
	}

	public void setSvpr_tx4(String svpr_tx4) {
		this.svpr_tx4 = svpr_tx4;
	}

	public String getSvpr_tx5() {
		return svpr_tx5;
	}

	public void setSvpr_tx5(String svpr_tx5) {
		this.svpr_tx5 = svpr_tx5;
	}

	Map<String, Object> keys = new HashMap<String, Object>();

	@Override
	public Map<String, Object> getKeys() {
		throw new UnsupportedOperationException(
				"No keys identified and defined in dao, hence reduced GenericDao-functionality for Svtx10fDao!");
	}

}
