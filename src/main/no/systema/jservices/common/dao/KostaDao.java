package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Header data for supplier invoice.
 * 
 * @author fredrikmoller
 * @date 2018-09-19
 */
@Data
public class KostaDao implements IDao {

	private String kabb;
	private Integer kabdt = new Integer(0);
	private BigDecimal kabl = new BigDecimal(0);
	private BigDecimal kablm = new BigDecimal(0);
	/**
	 * Kabnr er ikke bilagsnummer men kun et unikt nummer som matcher KBBNR i KOSTB Vi kaller det innregistreringsnummer.
	 * Bilagsnummer kan tildeles posten på et sent tidspunkt og vil legge seg i KABNR
	 * */
	private Integer kabnr = new Integer(0); //key  innregistreringsnummer
	private Integer kabnr2 = new Integer(0);  //BILAGSNUMMER //TODO teller fra KOSTT. TA KTNR och sedan uppdatera
	private Integer kadte = new Integer(0);
	private Integer kadtr = new Integer(0);
	private BigDecimal kafdt = new BigDecimal(0);
	private Integer kaffdt = new Integer(0);
	private String kafnr;
	private Integer kajour = new Integer(0);
	private String kalkid;
	private Integer kalnr = new Integer(0);
	private String kamva;
	private Integer kaoavd = new Integer(0);
	private BigDecimal kaomrf = new BigDecimal(0);
	private Integer kaopd = new Integer(0);
	private Integer KAPÅR = new Integer(0);
	private Integer kapcc = new Integer(0);
	private Integer kapmn = new Integer(0);
	private BigDecimal karnr = new BigDecimal(0);
	private String kasg;
	private String kast;
	private Integer katavd = new Integer(0);
	private Integer katdr = new Integer(0);
	private Integer katme = new Integer(0);
	private Integer katunr = new Integer(0);
	private String katxt;
	private String kauser;
	private String kaval;
	private String kavk;
	private BigDecimal kavku = new BigDecimal(0);
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("kabnr", kabnr);
		return keys;
	}

}
