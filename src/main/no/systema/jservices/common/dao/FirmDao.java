package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 *@author fredrikmoller
 *@date May 8 2017
 */
public class FirmDao implements IDao {

	//Note: fields copy form other FirmDao
	private String fifirm = "";      //key                        
	public void setFifirm (String value){ this.fifirm = value;   }   
	public String getFifirm (){ return this.fifirm;   }  
	
	private String fift = "";                                
	public void setFift (String value){ this.fift = value;   }   
	public String getFift (){ return this.fift;   }  
	
	private String fikdul = "";                                
	public void setFikdul (String value){ this.fikdul = value;   }   
	public String getFikdul (){ return this.fikdul;   }  
	
	private String filtb = "";                                
	public void setFiltb (String value){ this.filtb = value;   }   
	public String getFiltb (){ return this.filtb;   }  
	
	private String filfb = "";                                
	public void setFilfb (String value){ this.filfb = value;   }   
	public String getFilfb (){ return this.filfb;   }  
	
	private String fiups = "";                                
	public void setFiups (String value){ this.fiups = value;   }   
	public String getFiups (){ return this.fiups;   }  
	
	private String fiupm = "";                                
	public void setFiupm (String value){ this.fiupm = value;   }   
	public String getFiupm (){ return this.fiupm;   }  
	
	private String fikdt = "";                                
	public void setFikdt (String value){ this.fikdt = value;   }   
	public String getFikdt (){ return this.fikdt;   }  
	
	private String fiatk = "";                                
	public void setFiatk (String value){ this.fiatk = value;   }   
	public String getFiatk (){ return this.fiatk;   }  
	
	private String fiurli = "";                                
	public void setFiurli (String value){ this.fiurli = value;   }   
	public String getFiurli (){ return this.fiurli;   }  
	
	private String fiurle = "";                                
	public void setFiurle (String value){ this.fiurle = value;   }   
	public String getFiurle (){ return this.fiurle;   }  
	
	private String fiurfi = "";                                
	public void setFiurfi (String value){ this.fiurfi = value;   }   
	public String getFiurfi (){ return this.fiurfi;   }  
	
	private String fiurfe = "";                                
	public void setFiurfe (String value){ this.fiurfe = value;   }   
	public String getFiurfe (){ return this.fiurfe;   }  
	
	private String fiurfl = "";                                
	public void setFiurfl (String value){ this.fiurfl = value;   }   
	public String getFiurfl (){ return this.fiurfl;   }  
	
	private String fiurbi = "";                                
	public void setFiurbi (String value){ this.fiurbi = value;   }   
	public String getFiurbi (){ return this.fiurbi;   }  
	
	private String fiurbe = "";                                
	public void setFiurbe (String value){ this.fiurbe = value;   }   
	public String getFiurbe (){ return this.fiurbe;   }  
	
	private String fiurbl = "";                                
	public void setFiurbl (String value){ this.fiurbl = value;   }   
	public String getFiurbl (){ return this.fiurbl;   }  
	
	private String fiursi = "";                                
	public void setFiursi (String value){ this.fiursi = value;   }   
	public String getFiursi (){ return this.fiursi;   }  
	
	private String fiurse = "";                                
	public void setFiurse (String value){ this.fiurse = value;   }   
	public String getFiurse (){ return this.fiurse;   }  
	
	private String fimvas = "";                                
	public void setFimvas (String value){ this.fimvas = value;   }   
	public String getFimvas (){ return this.fimvas;   }  
	
	private String fivalk = "";                                
	public void setFivalk (String value){ this.fivalk = value;   }   
	public String getFivalk (){ return this.fivalk;   }  
	
	private String ficurr = "";                                
	public void setFicurr (String value){ this.ficurr = value;   }   
	public String getFicurr (){ return this.ficurr;   }  
	
	private String fitax = "";                                
	public void setFitax (String value){ this.fitax = value;   }   
	public String getFitax (){ return this.fitax;   }  
	
	private String fidtfm = "";                                
	public void setFidtfm (String value){ this.fidtfm = value;   }   
	public String getFidtfm (){ return this.fidtfm;   }  
	
	private String fideci = "";                                
	public void setFideci (String value){ this.fideci = value;   }   
	public String getFideci (){ return this.fideci;   }  
	
	private String fiecon = "";                                
	public void setFiecon (String value){ this.fiecon = value;   }   
	public String getFiecon (){ return this.fiecon;   }  
	
	private String fiavte = "";                                
	public void setFiavte (String value){ this.fiavte = value;   }   
	public String getFiavte (){ return this.fiavte;   }  
	
	private String fikont = "";                                
	public void setFikont (String value){ this.fikont = value;   }   
	public String getFikont (){ return this.fikont;   }  
	
	private String filand = "";                                
	public void setFiland (String value){ this.filand = value;   }   
	public String getFiland (){ return this.filand;   }  
	
	private String fitdvi = "";                                
	public void setFitdvi (String value){ this.fitdvi = value;   }   
	public String getFitdvi (){ return this.fitdvi;   }  
	
	private String fistfn = "";                                
	public void setFistfn (String value){ this.fistfn = value;   }   
	public String getFistfn (){ return this.fistfn;   }  
	
	private String fistfe = "";                                
	public void setFistfe (String value){ this.fistfe = value;   }   
	public String getFistfe (){ return this.fistfe;   }  
	
	private String fistft = "";                                
	public void setFistft (String value){ this.fistft = value;   }   
	public String getFistft (){ return this.fistft;   }  
	
	private String file12 = "";                                
	public void setFile12 (String value){ this.file12 = value;   }   
	public String getFile12 (){ return this.file12;   }  
	
	private String file22 = "";                                
	public void setFile22 (String value){ this.file22 = value;   }   
	public String getFile22 (){ return this.file22;   }  
	
	private String file11 = "";                                
	public void setFile11 (String value){ this.file11 = value;   }   
	public String getFile11 (){ return this.file11;   }  
	
	private String file21 = "";                                
	public void setFile21 (String value){ this.file21 = value;   }   
	public String getFile21 (){ return this.file21;   }  
	
	private String file31 = "";                                
	public void setFile31 (String value){ this.file31 = value;   }   
	public String getFile31 (){ return this.file31;   }  
	
	private String file41 = "";                                
	public void setFile41 (String value){ this.file41 = value;   }   
	public String getFile41 (){ return this.file41;   }  
	
	private String fitran = "";                                
	public void setFitran (String value){ this.fitran = value;   }   
	public String getFitran (){ return this.fitran;   }  
	
	private String fikrtn = "";                                
	public void setFikrtn (String value){ this.fikrtn = value;   }   
	public String getFikrtn (){ return this.fikrtn;   }  
	
	private String fitax2 = "";                                
	public void setFitax2 (String value){ this.fitax2 = value;   }   
	public String getFitax2 (){ return this.fitax2;   }  
	
	private String fitaxd = "";                                
	public void setFitaxd (String value){ this.fitaxd = value;   }   
	public String getFitaxd (){ return this.fitaxd;   }  
	
	private String fisadk = "";                                
	public void setFisadk (String value){ this.fisadk = value;   }   
	public String getFisadk (){ return this.fisadk;   }  
	
	private String filibf = "";                                
	public void setFilibf (String value){ this.filibf = value;   }   
	public String getFilibf (){ return this.filibf;   }  
	
	private String filibo = "";                                
	public void setFilibo (String value){ this.filibo = value;   }   
	public String getFilibo (){ return this.filibo;   }  
	
	private String innutl = "";                                
	public void setInnutl (String value){ this.innutl = value;   }   
	public String getInnutl (){ return this.innutl;   }  
	
	private String zipcod = "";                                
	public void setZipcod (String value){ this.zipcod = value;   }   
	public String getZipcod (){ return this.zipcod;   }  	

	Map<String, Object> keys = new HashMap<String, Object>();	
	
	@Override
	public Map<String, Object> getKeys() {
		keys.put("fifirm", fifirm);
		return keys;
	}

}
