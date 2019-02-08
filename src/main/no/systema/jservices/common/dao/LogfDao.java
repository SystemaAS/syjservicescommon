package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) LOGF - Log file for tradevision. Key towards FFR00F: LGRECN
 * 
 * @author oscardelatorre
 * @date Jan, 2019
 *
 */
@Data
public class LogfDao implements IDao {
	
	private String lgid; 		//17 VARCHAR - Participant ID  
	private String lgidne; 		//35 VARCHAR - Part.Net.adr
	private String lgmsid; 		//17 VARCHAR - Message ID.
	private String lgsid;  		//17 VARCHAR - Sender ID
	
	private String lgsnet;  	//35 VARCHAR - Sender adress
	private String lgrnet;  	//17 VARCHAR - Recipient Adress
	private Integer lgrecn = 0;  //9,0 SONET - Recordnumber
	private Integer lgtrid = 0;  //9,0 SONET - Trans ID
	private String lgtr;  //1 VARCHAR - Transmitt/Receive
	private String lgstat;  //1 VARCHAR - Status
	private Integer lgdate = 0;  //6,0 SONET - Date YMD
	private Integer lgtime = 0;  //6,0 SONET - Time HMS
	private String lgref2;  		 //12 VARCHAR - Data from Ref:2.0
	private String lghaag;  		 //10 VARCHAR - Check for copy in..
	private String lgpacp;  		 //17 VARCHAR - Copy to Pariticipant 
	private String lgprst;  		 //1 VARCHAR - Print status 
	private String lgrdst;  		 //1 VARCHAR - Read status
	private String lg0068;  		 //35 VARCHAR - Com.Acc.Ref
	private String lgpaca;  		 //35 VARCHAR - Copy to Part.Address
	private String lgcpai;  		 //17 VARCHAR -  Copy to Agent Id.
	private String lgcpaa;  		 //35 VARCHAR -  Copy to Agent Adress
	private String lgmtm1;  		 //1 VARCHAR -  Mess. Transp. mode 1 
	private String lgmtm2;  		 //1 VARCHAR -  Mess. Transp. mode 2 
	private String lgmtm3;  		 //1 VARCHAR -  Mess. Transp. mode 3
	
	private String lglib;  		 //10 VARCHAR -  Mess. Library
	private String lgfil;  		 //10 VARCHAR -  Mess. File
	private String lgmbr;  		 //10 VARCHAR -  Mess. Member
	
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("lgid", lgid);
		return keys;
	}
	
	public Map<String, Object> getKeysLgRecn() {
		keys.put("lgrecn", lgrecn);
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
