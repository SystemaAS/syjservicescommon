package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class KodtvaDao implements IDao {

	private String kvasta; // KVASTA TEGN 1 1 STATUS
	private String kvakod; // VAKOD TEGN 3 3 VALUTAKODE //key
	private String kvauni; // KVAUNI TEGN 2 2 UNIK KODE //key
	private BigDecimal kvakrs = new BigDecimal(0); // KVAKRS SONET 11 3 11 VALUTAKURS
	private int kvaomr; // KVAOMR SONET 3 0 OMREGNINGSFAKTOR
	private int kvadt; // KVADT SONET 8 0 OPPDATERINGSDATO //key
	private BigDecimal kvagkr = new BigDecimal(0); // KVAGKR SONET 11 3 11 GAMMELT VALUTAKURS
	private String kvaxxx; // TEGN 27 27 BESKRIVELSE
	private int kvagv; // SONET 11 0 11 GRENSEVERDI

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getKvasta() {
		return kvasta;
	}

	public void setKvasta(String kvasta) {
		this.kvasta = kvasta;
	}

	public String getKvakod() {
		return kvakod;
	}

	public void setKvakod(String kvakod) {
		this.kvakod = kvakod;
	}

	public String getKvauni() {
		return kvauni;
	}

	public void setKvauni(String kvauni) {
		this.kvauni = kvauni;
	}

	public BigDecimal getKvakrs() {
		return kvakrs;
	}

	public void setKvakrs(BigDecimal kvakrs) {
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

	public BigDecimal getKvagkr() {
		return kvagkr;
	}

	public void setKvagkr(BigDecimal kvagkr) {
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
