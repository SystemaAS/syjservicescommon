	/**
 * 
 */
package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * This class holds value from kundefaktura.
 *  
 * @author fredrikmoller
 *
 */
@Data
public class VistranskDao implements IDao {

	private String aktkod;
	private String firma;
	private int bilnr; //key
	private int posnr; //key
	private int bilaar;
	private int bilmnd;
	private int bildag;
	private int peraar;
	private int pernr;
	private String valkod;
	private BigDecimal valku1 = new BigDecimal(0);
	private String bilkod;
	private String biltxt;
	private int konto;
	private int ksted;
	private int kbarer;
	private int niv1po;
	private int niv2po;
	private String momsk;
	private BigDecimal bbelop = new BigDecimal(0);
	private String valkox;
	private BigDecimal belopv = new BigDecimal(0);
	private  BigDecimal ant = new BigDecimal(0);
	private String enhet;
	private int prosnr;
	private int refnr;
	private String krnr;
	private int krdaar;
	private int krdmnd;
	private int krddag;
	private int ffdaar;
	private int ffdmnd;
	private int ffddag;
	private String betbet;
	private String attest;
	private String kryss;
	private String opdkod;
	private int resnr; //key
	private int bilnre;
	private String nokkel;
	private String agio;
	private String delkod;
	private int fkund;
	private String grkode;
	private String opdmva;
	private String intkod;
	private int krnrdb;
	private int poslnr;
	private String krnokd;
	private int kaarpo;
	private int kmndpo;
	private int kdagpo;
	private BigDecimal nbelpo = new BigDecimal(0);
	private BigDecimal mvabpo = new BigDecimal(0);
	private BigDecimal invbpo = new BigDecimal(0);
	private int baarpo;
	private int bmndpo;
	private int bdagpo;
	private BigDecimal bonspo = new BigDecimal(0);
	private int konbpo;
	private int stebpo;
	private int barbpo;
	private int nib1po;
	private int nib2po;
	private String grkopo;
	private String frefpo;
	private String opkdpo;
	private int anidpo;
	private String anttpo;
	private int euvepo;
	private int fjdapo;
	private int fjnrpo;
	private int ljdapo;
	private int ljnrpo;
	private int snrmpo;
	private BigDecimal mgutpo = new BigDecimal(0);
	private int starpo;
	private int stpepo;
	private int inkdpo;
	private int antppo;
	private int pktopo;
	private String blkppo;
	private String pekdpo;
	private String lkid;
	private int syncda;
	private String syerro;
	
	private Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("resnr", resnr);  //kundnr
		keys.put("bilnr", bilnr);  //fakturanr
		keys.put("posnr", posnr);  //radnr
		return keys;
	}

}
