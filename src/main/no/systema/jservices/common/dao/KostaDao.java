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
	private int kabdt;
	private BigDecimal kabl = new BigDecimal(0);
	private BigDecimal kablm = new BigDecimal(0);
	private String kablst;
	private Integer kabnr; //key  BILAGSNUMMER //TODO teller fra KOSTT. TA KTNR och sedan uppdatera
	private Integer kabnr2;
	private Integer kadte;
	private BigDecimal kadtr = new BigDecimal(0);
	private BigDecimal kafdt = new BigDecimal(0);
	private BigDecimal kaffdt = new BigDecimal(0);
	private String kafnr;
	private Integer kajour;
	private String kalkid;
	private Integer kalnr;
	private String kamva;
	private Integer kaoavd;
	private BigDecimal kaomrf = new BigDecimal(0);
	private Integer kaopd;
	private Integer KAPÅR;
	private Integer kapcc;
	private Integer kapmn;
	private BigDecimal karnr = new BigDecimal(0);
	private String kasg;
	private String kast;
	private Integer katavd;
	private BigDecimal katdr = new BigDecimal(0);
	private Integer katme;
	private Integer katunr;
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
