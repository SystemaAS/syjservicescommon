package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) CNFF - Configuration (installation) file for tradevision. Key towards FFR00F: CNRECN
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
@Data
public class CnffDao implements IDao {
	
	private Integer cnrecn = 0; 	//9,0 PAKKET - Last used rec.no 
	private String cnhoid; 		//36 VARCHAR - FTP Userid
	private String cnpw; 		//14 VARCHAR - FTP pass
	private String cndayl;  		//3,0 PAKKET - Days to store logg
	
	private String cntfsr;  	//5,0 PAKKET - Time out FSR;in sec.
	private String cntffr;  	//5,0 PAKKET - Time out FFR;in sec.
	private String cntfir;  	//5,0 PAKKET - Time out FIR;in sec.
	private String cntftr;  	//5,0 PAKKET - Time out FTR;in sec.
	private String cntfvr;  	//5,0 PAKKET - Time out FVR;in sec.
	private String cntisr;  	//5,0 PAKKET - Time out ISR;in sec.
	private String cnsfwr;  	//1 VARCHAR - Retrans. strat. FWB
	
	private String cnsfsr;  	//1 VARCHAR - Retrans. strat. FSR
	private String cnsffr;  	//1 VARCHAR - Retrans. strat. FFR
	private String cnsfir;  	//1 VARCHAR - Retrans. strat. FIR
	private String cnsftr;  	//1 VARCHAR - Retrans. strat. FTR
	private String cnsfvr;  	//1 VARCHAR - Retrans. strat. FVR
	private String cnsfai;  	//1 VARCHAR - Retrans. strat. FAI
	private String cnsfyt;  	//1 VARCHAR - Retrans. strat. FYT
	private String cnsazb;  	//1 VARCHAR - Retrans. strat. AZB
	private String cnsazf;  	//1 VARCHAR - Retrans. strat. AZF
	private String cnsisr;  	//1 VARCHAR - Retrans. strat. ISR
	private String cnafsa;  	//1 VARCHAR - Print function  FSA 
	private String cnaffa;  	//1 VARCHAR - Print function  FFA 
	private String cnafia;  	//1 VARCHAR - Print function  FIA 
	private String cnafta;  	//1 VARCHAR - Print function  FTA
	private String cnafva;  	//1 VARCHAR - Print function  FVA
	
	private String cnafsu;  	//1 VARCHAR - Print function  FSU
	private String cnafna;  	//1 VARCHAR - Print function  FNA
	private String cnafma;  	//1 VARCHAR - Print function  FMA
	private String cnafwb;  	//1 VARCHAR - Print function  FWB
	private String cnaxxx;  	//1 VARCHAR - Print function  XXX
	
	private String cnafai;  	//1 VARCHAR - Print function  FAI
	private String cnaifn;  	//1 VARCHAR - Print function  Pr. func. Int. FNA  
	private String cnafyt;  	//1 VARCHAR - Print function  FYT
	private String cnaazb;  	//1 VARCHAR - Print function  AZB  
	private String cnaazf;  	//1 VARCHAR - Print function  AZF
	private String cnaisa;  	//1 VARCHAR - Print function  ISA
	
	private String cnctck;  	//1 VARCHAR - Chk Valid City Codes (Y/N)
	private String cnprt;  	//10 VARCHAR - Printer Id
	private String cnanda;  	//1 VARCHAR - Print function NOA
	
	private String cnpre1;  	//14 VARCHAR - Prefix PIMA
	private String cnpre2;  	//14 VARCHAR - Prefix SITA
	private String cnpre3;  	//14 VARCHAR - Prefix FAX
	private String cnedir;  	//3 VARCHAR - Edifact routing
	
	private String cnrlib;  	//10 VARCHAR - Receive Library 
	private String cnrfil;  	//10 VARCHAR - Receive File
	private String cncod1;  	//1 VARCHAR - Use CCS adress logic 
	private String cncod2;  	//1 VARCHAR - Chk part. capability
	private String cnipad;  	//35 VARCHAR - FTP Host IP Address
	
	private String cnsndi;  	//60 VARCHAR - Local *IFS SND
	private String cnrcvi;  	//60 VARCHAR - Local *IFS RCV
	private String cnftxt;  	//128 VARCHAR - Free text
	private String cnftpg;  	//1 VARCHAR - FTP get ?
	
	

	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("cnrecn", cnrecn);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
