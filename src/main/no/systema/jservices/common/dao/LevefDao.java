package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * Suppliers.
 * 
 * Note: physically located in L1DAT.
 * 
 * @author fredrikmoller
 * @date 13 non 2018
 */
@Data
public class LevefDao implements IDao {

	private String adr1;//	CHAR	30	-
	private String adr2;//	CHAR	30	-
	private String adr21;//	CHAR	30	-
	private String adr3;//	CHAR	24	-
	private int agennr;//	NUMERIC	8	0
	private String agkdle;//	CHAR	1	-
	private BigDecimal akidle = new BigDecimal(0);//	DECIMAL	2	0
	private String akont;//	CHAR	1	-
	private String aktkod;//	CHAR	1	-
	private String bankg;//	CHAR	35	-
	private String bbrele;//	CHAR	2	-
	private String betbet;//	CHAR	2	-
	private String betmat;//	CHAR	1	-
	private BigDecimal bonsle = new BigDecimal(0);//	DECIMAL	4	2
	private String bspele;//	CHAR	1	-
	private int daoaar;//	NUMERIC	4	0
	private int daodag;//	NUMERIC	2	0
	private int daomnd;	//NUMERIC	2	0
	private String efkdle;//	CHAR	2	-
	private String etkdle;//	CHAR	2	-
	private String fact;//	CHAR	9	-
	private int factnr;//	NUMERIC	8	0
	private String firma;//	CHAR	2	-
	private BigDecimal foretn = new BigDecimal(0);//	DECIMAL	9	0
	private String head;//	CHAR	1	-
	private BigDecimal journr = new BigDecimal(0);	//DECIMAL	5	0
	private String khenit;//	CHAR	3	-
	private String khenv;//	CHAR	3	-
	private String knrlle;//	CHAR	15	-
	private String kpers;//	CHAR	30	-
	private BigDecimal krtile = new BigDecimal(0);//	DECIMAL	3	0
	private BigDecimal ksaldo = new BigDecimal(0);//	DECIMAL	13	2
	private int kundnr;//	NUMERIC	8	0
	private String kvant; //;	CHAR	1	-
	private String land;//	CHAR	3	-
	private String ledi20;//	CHAR	20	-
	private BigDecimal ledtid = new BigDecimal(0);	//DECIMAL	3	0
	private String levbet;//	CHAR	2	-
	private String levmat;//	CHAR	2	-
	private Integer levnr;//	NUMERIC	8	0
	private String levtyp;//	CHAR	1	-
	private String lnavn;//	CHAR	30	-
	private BigDecimal lomkpr = new BigDecimal(0);//DECIMAL	5	2
	private BigDecimal ordral = new BigDecimal(0);//	DECIMAL	5	2
	private BigDecimal paslle = new BigDecimal(0);//	DECIMAL	5	2
	private BigDecimal pernle = new BigDecimal(0);//	DECIMAL	11	0
	private String pnpble;//	CHAR	10	-
	private String postg;//	CHAR	35	-
	private int postnr;//	NUMERIC	4	0
	private String postnu;//	CHAR	10	-
	private String pspele;	//CHAR	1	-
	private String rekdle;//	CHAR	1	-
	private String retyle;//	CHAR	1	-
	private String rnrale;//	CHAR	20	-
	private BigDecimal saifle = new BigDecimal(0);//	DECIMAL	13	2
	private int sitaar;//	NUMERIC	4	0
	private int sitdag;//	NUMERIC	2	0
	private int sitmnd;//	NUMERIC	2	0
	private String sjkdle;//	CHAR	1	-
	private String sonavn;//	CHAR	10	-
	private String spednr;//	CHAR	2	-
	private String spraak;//	CHAR	1	-
	private String tfaxnr;//	CHAR	15	-
	private String tlf;//	CHAR	15	-
	private String valkod; //	CHAR

	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("levnr", levnr);
		return keys;
	}

}
