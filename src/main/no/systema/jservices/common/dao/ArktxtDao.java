package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class ArktxtDao implements IDao {

	private String artype; // key
	private String artxt;
	private String arkjn;
	private String arksnd;
	private String arklag;
	private int arkdag;
	private String arkved;
	private String arslab;
	private String arsban;
	private String armrg;
	private String arvedl;
	private String arsfsk;
	private String arscts;
	private int arsrle;
	private String arsrpa;
	private String arsrno;

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getArtype() {
		return artype;
	}

	public void setArtype(String artype) {
		this.artype = artype;
	}

	public String getArtxt() {
		return artxt;
	}

	public void setArtxt(String artxt) {
		this.artxt = artxt;
	}

	public String getArkjn() {
		return arkjn;
	}

	public void setArkjn(String arkjn) {
		this.arkjn = arkjn;
	}

	public String getArksnd() {
		return arksnd;
	}

	public void setArksnd(String arksnd) {
		this.arksnd = arksnd;
	}

	public String getArklag() {
		return arklag;
	}

	public void setArklag(String arklag) {
		this.arklag = arklag;
	}

	public int getArkdag() {
		return arkdag;
	}

	public void setArkdag(int arkdag) {
		this.arkdag = arkdag;
	}

	public String getArkved() {
		return arkved;
	}

	public void setArkved(String arkved) {
		this.arkved = arkved;
	}

	public String getArslab() {
		return arslab;
	}

	public void setArslab(String arslab) {
		this.arslab = arslab;
	}

	public String getArsban() {
		return arsban;
	}

	public void setArsban(String arsban) {
		this.arsban = arsban;
	}

	public String getArmrg() {
		return armrg;
	}

	public void setArmrg(String armrg) {
		this.armrg = armrg;
	}

	public String getArvedl() {
		return arvedl;
	}

	public void setArvedl(String arvedl) {
		this.arvedl = arvedl;
	}

	public String getArsfsk() {
		return arsfsk;
	}

	public void setArsfsk(String arsfsk) {
		this.arsfsk = arsfsk;
	}

	public String getArscts() {
		return arscts;
	}

	public void setArscts(String arscts) {
		this.arscts = arscts;
	}

	public int getArsrle() {
		return arsrle;
	}

	public void setArsrle(int arsrle) {
		this.arsrle = arsrle;
	}

	public String getArsrpa() {
		return arsrpa;
	}

	public void setArsrpa(String arsrpa) {
		this.arsrpa = arsrpa;
	}

	public String getArsrno() {
		return arsrno;
	}

	public void setArsrno(String arsrno) {
		this.arsrno = arsrno;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("artype", artype);
		return keys;
	}

}
