package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class FirfbDao implements IDao {

	private String fifirm; // Firmakode //KEY
	private String fifbnr; //   TILDEL SEND.NR FR.BR    
	private String fitpnr; //  TILDEL SEND.NR TOLLP      
	private int firecn; // SIST BRUKTE SEND.NR
	private int firecm; // MAX.SENDNR
	private int fisnla;
	private int fisnle;
	private int fiidla;
	private int fiidle;
	private int fiidnr;
	private int fiidmx;

	private Map<String, Object> keys = new HashMap<String, Object>();

	public String getFifirm() {
		return fifirm;
	}

	public void setFifirm(String fifirm) {
		this.fifirm = fifirm;
	}

	public String getFifbnr() {
		return fifbnr;
	}

	public void setFifbnr(String fifbnr) {
		this.fifbnr = fifbnr;
	}

	public String getFitpnr() {
		return fitpnr;
	}

	public void setFitpnr(String fitpnr) {
		this.fitpnr = fitpnr;
	}

	public int getFirecn() {
		return firecn;
	}

	public void setFirecn(int firecn) {
		this.firecn = firecn;
	}

	public int getFirecm() {
		return firecm;
	}

	public void setFirecm(int firecm) {
		this.firecm = firecm;
	}

	public int getFisnla() {
		return fisnla;
	}

	public void setFisnla(int fisnla) {
		this.fisnla = fisnla;
	}

	public int getFisnle() {
		return fisnle;
	}

	public void setFisnle(int fisnle) {
		this.fisnle = fisnle;
	}

	public int getFiidla() {
		return fiidla;
	}

	public void setFiidla(int fiidla) {
		this.fiidla = fiidla;
	}

	public int getFiidle() {
		return fiidle;
	}

	public void setFiidle(int fiidle) {
		this.fiidle = fiidle;
	}

	public int getFiidnr() {
		return fiidnr;
	}

	public void setFiidnr(int fiidnr) {
		this.fiidnr = fiidnr;
	}

	public int getFiidmx() {
		return fiidmx;
	}

	public void setFiidmx(int fiidmx) {
		this.fiidmx = fiidmx;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("fifirm", fifirm);
		return keys;
	}

}
