package no.systema.jservices.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class ArkivpDao implements IDao  {
	String arstat = "A"; //TEGN 1 
	String artype = "TL"; //TEGN 2 
 	String arfirm = ""; //TEGN 2 
 	String aravd = "0";  //SONET 4.0 
	String aropd = "0";  //SONET 7.0  
	String arunde = ""; //TEGN 10 
	String aruser = ""; //TEGN 10
	String ardate = "0"; //SONET 8.0
	String artime = "0"; //SONET 6.0
	String arkund = "0"; //SONET 8.0 
	String arlink = ""; //TEGN 40 Unik link (pdfnamn)
	String arrfk = "";  //TEGN 35 Kunde ref
	String arfri = "";  //TEGN 15 Fri
	String arbhis = ""; //TEGN 30 Bane historikk
	
	String own_ardateTo="0";
	
	Map<String, Object> keys = new HashMap<String, Object>();

	                                                                                    
	                                                                                      
}
