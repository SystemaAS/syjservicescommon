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
	private int kabnr; //key  BILAGSNUMMER //TODO teller fra KOSTT. TA KTNR och sedan uppdatera
	private int kabnr2;
	private int kadte;
	private BigDecimal kadtr = new BigDecimal(0);
	private BigDecimal kafdt = new BigDecimal(0);
	private BigDecimal kaffdt = new BigDecimal(0);
	private String kafnr;
	private int kajour;
	private String kalkid;
	private BigDecimal kalnr = new BigDecimal(0);
	private String kamva;
	private int kaoavd;
	private BigDecimal kaomrf = new BigDecimal(0);
	private int kaopd;
	private int KAPÅR;
	private int kapcc;
	private int kapmn;
	private BigDecimal karnr = new BigDecimal(0);
	private String kasg;
	private String kast;
	private int katavd;
	private BigDecimal katdr = new BigDecimal(0);
	private int katme;
	private int katunr;
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
