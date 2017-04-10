package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

public class ArkextDao implements IDao {

	private String arcfir; // key
	private String arcext; // key
	private String arcpad;
	private String arcane;
	private String arcpae;

	Map<String, Object> keys = new HashMap<String, Object>();

	/*
	 *  ARCFIR     TEGN            2       2         1        Begge    FIRMA   
	 *                 Felttekst . . . . . . . . . . . . . . . .
	 * :  FIRMA                                    ID for kodet tegnsett  . . .
	 * :                 277                                
	 *  ARCEXT     TEGN            2       2         3        Begge   
	 * EXTERNMASKIN             Felttekst . . . . . . . . . . . . . . . .
	 * :  EXTERNMASKIN                             ID for kodet tegnsett  . . .
	 * :                 277                                
	 *  ARCPAD     TEGN           30      30         5        Begge    IPADRESSE
	 * LOKAL          Felttekst . . . . . . . . . . . . . . . . :  IPADRESSE
	 * LOKAL                          ID for kodet tegnsett  . . .
	 * :                 277                                
	 *  ARCANE     TEGN           30      30        35        Begge    BANE    
	 *                 Felttekst . . . . . . . . . . . . . . . .
	 * :  BANE                                     ID for kodet tegnsett  . . .
	 * :                 277                                
	 *  ARCPAE     TEGN           30      30        65        Begge    IPADRESSE
	 * EKSTERN        Felttekst . . . . . . . . . . . . . . . . :  IPADRESSE
	 * EKSTERN                        ID for kodet tegnsett  . . .
	 * :                 277     
	 * 
	 */

	public String getArcfir() {
		return arcfir;
	}

	public void setArcfir(String arcfir) {
		this.arcfir = arcfir;
	}

	public String getArcext() {
		return arcext;
	}

	public void setArcext(String arcext) {
		this.arcext = arcext;
	}

	public String getArcpad() {
		return arcpad;
	}

	public void setArcpad(String arcpad) {
		this.arcpad = arcpad;
	}

	public String getArcane() {
		return arcane;
	}

	public void setArcane(String arcane) {
		this.arcane = arcane;
	}

	public String getArcpae() {
		return arcpae;
	}

	public void setArcpae(String arcpae) {
		this.arcpae = arcpae;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("arcfir", arcfir);
		keys.put("arcext", arcext);
		return keys;
	}

}
