package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class KodtvalfDao implements IDao {

	private String kvasta;
	private String kvauni; //key
	private String kvakod; //key
	private int kvakrs;
	private int kvaomr;
	private int kvadt; //key
	private int kvagkr;
	private String kvaxxx;
	private int kvagv;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKvasta() {
		return kvasta;
	}

	public void setKvasta(String kvasta) {
		this.kvasta = kvasta;
	}

	public String getKvauni() {
		return kvauni;
	}

	public void setKvauni(String kvauni) {
		this.kvauni = kvauni;
	}

	public String getKvakod() {
		return kvakod;
	}

	public void setKvakod(String kvakod) {
		this.kvakod = kvakod;
	}

	public int getKvakrs() {
		return kvakrs;
	}

	public void setKvakrs(int kvakrs) {
		this.kvakrs = kvakrs;
	}

	public int getKvaomr() {
		return kvaomr;
	}

	public void setKvaomr(int kvaomr) {
		this.kvaomr = kvaomr;
	}

	public int getKvadt() {
		return kvadt;
	}

	public void setKvadt(int kvadt) {
		this.kvadt = kvadt;
	}

	public int getKvagkr() {
		return kvagkr;
	}

	public void setKvagkr(int kvagkr) {
		this.kvagkr = kvagkr;
	}

	public String getKvaxxx() {
		return kvaxxx;
	}

	public void setKvaxxx(String kvaxxx) {
		this.kvaxxx = kvaxxx;
	}

	public int getKvagv() {
		return kvagv;
	}

	public void setKvagv(int kvagv) {
		this.kvagv = kvagv;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("kvauni", kvauni);
		keys.put("kvakod", kvakod);
		keys.put("kvadt", kvadt);
		return keys;
	}

}
