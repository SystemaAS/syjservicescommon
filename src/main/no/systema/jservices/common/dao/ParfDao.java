package no.systema.jservices.common.dao;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import lombok.Data;

/**
 * Dao to Tradevision (flyeksport - flyfraktsbrev) PARF - Participants(flygbolag) file for tradevision. Key towards FFR00F: CNRECN
 * 
 * @author oscardelatorre
 * @date Feb, 2019
 *
 */
@Data
public class ParfDao implements IDao {
	
	private String paid; 	//17 VARCHAR - Participant ID
	private String panam; 		//35 VARCHAR - Company Name
	private String paneta; 		//35 VARCHAR - Network address
	private String patype;  	//3 VARCHAR - Part.type
	
	private String papaqa;  	//4 VARCHAR - Part.ID Mode Qualif.
	private String paltyp;  	//10 VARCHAR - Label type
	private String labnamn;  	//10 VARCHAR - Label name
	private String pamffr;  	//1 VARCHAR - Capabilities FFR 
	private String pamffa;  	//1 VARCHAR - Capabilities FFA 
	private String pamffc;  	//1 VARCHAR - Capabilities FFC 
	private String pamfsr;  	//1 VARCHAR - Capabilities FSR
	private String pamfsa;  	//1 VARCHAR - Capabilities FSA
	private String pamfsu;  	//1 VARCHAR - Capabilities FSU
	
	private String pamfsl;  	//1 VARCHAR - Capabilities FSL
	private String pamfad;  	//1 VARCHAR - Capabilities FAD
	private String pamfrp;  	//1 VARCHAR - Capabilities FRP
	private String pamffm;  	//1 VARCHAR - Capabilities FFM
	private String pamfbl;  	//1 VARCHAR - Capabilities FBL
	private String pamfwb;  	//1 VARCHAR - Capabilities FWB
	private String pamfwr;  	//1 VARCHAR - Capabilities FWR
	private String pamfsb;  	//1 VARCHAR - Capabilities FSB
	private String pamfma;  	//1 VARCHAR - Capabilities FMA
	private String pamfna;  	//1 VARCHAR - Capabilities FNA
	private String pamcri;  	//1 VARCHAR - Capabilities CRI
	private String pamcsi;  	//1 VARCHAR - Capabilities CSI
	private String pamcsn;  	//1 VARCHAR - Capabilities CSN
	private String pamfir;  	//1 VARCHAR - Capabilities FIR
	private String pamfia;  	//1 VARCHAR - Capabilities FIA
	
	private String pamfvr;  	//1 VARCHAR - Capabilities FVR
	private String pamfva;  	//1 VARCHAR - Capabilities FVA
	private String pamftr;  	//1 VARCHAR - Capabilities FTR
	private String pamfta;  	//1 VARCHAR - Capabilities FTA
	private String pamfrr;  	//1 VARCHAR - Capabilities FRR
	private String pamfra;  	//1 VARCHAR - Capabilities FRA
	
	private String pamfqr;  	//1 VARCHAR - Capabilities FQR
	private String pamfqa;  	//1 VARCHAR - Capabilities FQA
	private String pamfai;  	//1 VARCHAR - Capabilities FAI
	private String pamfas;  	//1 VARCHAR - Capabilities FAS
	private String pamfyt;  	//1 VARCHAR - Capabilities FYT
	private String pamazb;  	//1 VARCHAR - Capabilities AZB
	private String pamazf;  	//1 VARCHAR - Capabilities AZF
	
	private String pamisr;  	//1 VARCHAR - Capabilities ISR
	private String pamisa;  	//1 VARCHAR - Capabilities ISA
	private String pabref;  	//7 VARCHAR - Booking Reference
	private String pabook;  	//1 VARCHAR - Volume required
	private String pamnoa;  	//1 VARCHAR - Capabilities NOA
	
	private String pamtm;  	//1 VARCHAR - Mess. transp.mode
	private String parfv;  	//1 VARCHAR - RFF MSG VER.
	
	
	private Map<String, Object> keys = new HashMap<String, Object>();
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("paid", paid);
		
		return keys;
	}
	
	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
	
}
