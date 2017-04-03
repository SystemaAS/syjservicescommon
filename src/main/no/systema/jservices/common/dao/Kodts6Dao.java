package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy from dao in TVINN
 * 
 * @author Fredrik Möller
 * @date Apr 3, 2017
 *
 */
public class Kodts6Dao implements IDao {

	private String ks6sta;
	private String ks6uni; // key
	private String ks6pre; // key
	private String ks6ftx;
	private String ks6trn;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKs6sta() {
		return ks6sta;
	}

	public void setKs6sta(String ks6sta) {
		this.ks6sta = ks6sta;
	}

	public String getKs6uni() {
		return ks6uni;
	}

	public void setKs6uni(String ks6uni) {
		this.ks6uni = ks6uni;
	}

	public String getKs6pre() {
		return ks6pre;
	}

	public void setKs6pre(String ks6pre) {
		this.ks6pre = ks6pre;
	}

	public String getKs6ftx() {
		return ks6ftx;
	}

	public void setKs6ftx(String ks6ftx) {
		this.ks6ftx = ks6ftx;
	}

	public String getKs6trn() {
		return ks6trn;
	}

	public void setKs6trn(String ks6trn) {
		this.ks6trn = ks6trn;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("ks6uni", ks6uni);
		keys.put("ks6pre", ks6pre);
		return keys;
	}

}
