package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Row data for supplier invoice.
 * 
 * @author fredrikmoller
 * @date 2018-10-01
 */
@Data
public class KostbDao implements IDao {

	private int kbavd;
	private String kbbilt;
	private BigDecimal kbblf = new BigDecimal(0);
	private BigDecimal kbblhb = new BigDecimal(0);
	private int kbbnr; //key
	private BigDecimal kbbuds = new BigDecimal(0);
	private String kbbval;
	private String kbfree;
	private int kbgeby;
	private String kbgod;
	private int kbkavd;
	private int kbkdm;
	private String kbkdmv;
	private String kbkdpf;
	private String kbkkey;
	private int kbkn;
	private int KBNØKK;
	private int kbopd;
	private int KBPÅR; 
	private int kbpcc;
	private int kbpmn;
	private String kbrefa;
	private String kbrefb;
	private String kbrefc;
	private String kbrekl;
	private String kbsg;
	private String kbsgg;
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("kbbnr", kbbnr);
		return keys;
	}

}
