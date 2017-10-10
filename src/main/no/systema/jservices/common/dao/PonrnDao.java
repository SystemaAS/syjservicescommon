package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class PonrnDao implements IDao {

	private String ponnr; //key (4)
	private String ponnav; // (30) 
	private String ponbes; // (30)
	private String pontyk; // (10)
	private String pontyp; // (75)
	private String ponknr; // (4)
	private String ponkna; // (20)
	private Map<String, Object> keys = new HashMap<String, Object>();

	
	public String getPonnr() {
		return ponnr;
	}



	public void setPonnr(String ponnr) {
		this.ponnr = ponnr;
	}



	public String getPonnav() {
		return ponnav;
	}



	public void setPonnav(String ponnav) {
		this.ponnav = ponnav;
	}



	public String getPonbes() {
		return ponbes;
	}



	public void setPonbes(String ponbes) {
		this.ponbes = ponbes;
	}



	public String getPontyk() {
		return pontyk;
	}



	public void setPontyk(String pontyk) {
		this.pontyk = pontyk;
	}



	public String getPontyp() {
		return pontyp;
	}



	public void setPontyp(String pontyp) {
		this.pontyp = pontyp;
	}



	public String getPonknr() {
		return ponknr;
	}



	public void setPonknr(String ponknr) {
		this.ponknr = ponknr;
	}



	public String getPonkna() {
		return ponkna;
	}



	public void setPonkna(String ponkna) {
		this.ponkna = ponkna;
	}
	
	


	@Override
	public Map<String, Object> getKeys() {
		keys.put("ponnr", ponnr);
		return keys;
	}




}
