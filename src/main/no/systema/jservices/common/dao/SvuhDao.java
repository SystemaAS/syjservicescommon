package no.systema.jservices.common.dao;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class SvuhDao implements IDao {

			private String svuh_st   = ""; //   = ""; //tegn            1       1         1        begge    status p=utskriven
			private String mrn   = ""; //   = ""; //tegn           35       35                 begge    Mrn-nummer (TESS)
			private String  doc_1001     = ""; //   = ""; //tegn            3       3         2    begge    dokumentnamn      
			private String loc_3225a     = ""; //   = ""; //tegn            3       3         5    begge    godslokalkod      
			private String loc_3225c     = ""; //   = ""; //tegn           25      25         8    begge    lager, id 
			private String loc_1131      = ""; //tegn            1       1        33        begge    lager, typ        
			private String loc_3224      = ""; //tegn            2       2        34        begge    lager, lk         
			private String doc_1004      = ""; //tegn           10      10        36        begge    tullid         
			private String dtm_2380a     = ""; //tegn            8       8        46        begge    taxebest.datum 
			private String dtm_2380b     = ""; //tegn            8       8        54        begge    utlæmningsdatum
			private String nad_3039a     = ""; //tegn           12      12        62        begge    ombud orgnr    
			private String nad_1131a     = ""; //tegn            2       2        74        begge    ombud orgnr lk 
			private String nad_3036a     = ""; //tegn           35      35        76        begge    ombud namn     
			private String nad_3042aa    = ""; //tegn           35      35       111        begge    ombud adress1
			private String nad_3042ba    = ""; //tegn           35      35       146        begge    ombud adress2
			private String nad_3251a     = ""; //tegn           15      15       181        begge    ombud postnr 
			private String nad_3164a     = ""; //tegn           35      35       196        begge    ombud ort    
			private String nad_3207a     = ""; //tegn            2       2       231        begge    ombud lk     
			private String cta_3412a     = ""; //tegn           35      35       233        begge    ombud handl  
			private String com_3148a     = ""; //tegn           35      35       268        begge    ombud tlf    
			private String nad_3039b     = ""; //tegn           12      12       303        begge    dekl orgnr    
			private String nad_1131b     = ""; //tegn            2       2       315        begge    dekl orgnr lk 
			private String nad_3036b     = ""; //tegn           35      35       317        begge    dekl namn     
			private String nad_3042ab    = ""; //tegn           35      35       352        begge    dekl adress1  
			private String nad_3042bb    = ""; //tegn           35      35       387        begge    dekl adress2  
			private String nad_3251b     = ""; //tegn           15      15       422        begge    dekl postnr   
			private String nad_3164b     = ""; //tegn           35      35       437        begge    dekl ort       
			private String nad_3207b     = ""; //tegn            2       2       472        begge    dekl lk        
			private String cta_3412b     = ""; //tegn           35      35       474        begge    dekl handl     
			private String com_3148b     = ""; //tegn           35      35       509        begge    dekl tlf       
			private String rff_1154a     = ""; //tegn           35      35       544        begge    dekl refnr     
			private String loc_3225b     = ""; //tegn            5       5       579        begge    utl.tullkontor 
			private String nad_3036c     = ""; //tegn           35      35       584        begge    utlk namn    
			private String cta_3412c     = ""; //tegn           35      35       619        begge    utlk handl   
			private String nad_3036d     = ""; //tegn           35      35       654        begge    avs namn     
			private String nad_3042ad    = ""; //tegn           35      35       689        begge    avs adress1  
			private String nad_3042bd    = ""; //tegn           35      35       724        begge    avs adress2  
			private String nad_3251d     = ""; //tegn           15      15       759        begge    mott postnr  
			private String nad_3207d     = ""; //tegn            2       2       774        begge    avs lk       
			private String nad_3164d     = ""; //tegn           35      35       776        begge    avs ort      
			private String nad_1131e     = ""; //tegn            2       2       811        begge    mott orgnr lk
			private String nad_3039e     = ""; //tegn           12      12       813        begge    mott orgnr   
			private String nad_3036e     = ""; //tegn           35      35       825        begge    mott namn    
			private String nad_3042ae    = ""; //tegn           35      35       860        begge    mott adress1 
			private String nad_3042be    = ""; //tegn           35      35       895        begge    mott adress2 
			private String nad_3251e     = ""; //tegn           15      15       930        begge    mott postnr  
			private String nad_3164e     = ""; //tegn           35      35       945        begge    mott ort     
			private String nad_3207e     = ""; //tegn            2       2       980        begge    mott lk      
			private String cnt_6066      = ""; //tegn            6       6       982        begge    tot.kollital 
			private String pac_7077a     = ""; //tegn            2       2       988        begge    kollislag    
			private String pac_7077b     = ""; //tegn            2       2       990        begge    kollislag    
			private String pac_7077c     = ""; //tegn            2       2       992        begge    kollislag 
			private String pac_7077d     = ""; //tegn            2       2       994        begge    kollislag 
			private String pac_7077e     = ""; //tegn            2       2       996        begge    kollislag 
			private String pac_7077f     = ""; //tegn            2       2       998        begge    kollislag 
			private String pac_7077g     = ""; //tegn            2       2      1000        begge    kollislag 
			private String pac_7077h     = ""; //tegn            2       2      1002        begge    kollislag 
			private String pac_7077i     = ""; //tegn            2       2      1004        begge    kollislag 
			private String pac_7064a     = ""; //tegn            6       6      1006        begge    ant.kolli
			private String pac_7064b     = ""; //tegn            6       6      1012        begge    ant.kolli
			private String pac_7064c     = ""; //tegn            6       6      1018        begge    ant.kolli
			private String pac_7064d     = ""; //tegn            6       6      1024        begge    ant.kolli
			private String pac_7064e     = ""; //tegn            6       6      1030        begge    ant.kolli
			private String pac_7064f     = ""; //tegn            6       6      1036        begge    ant.kolli
			private String pac_7064g     = ""; //tegn            6       6      1042        begge    ant.kolli
			private String pac_7064h     = ""; //tegn            6       6      1048        begge    ant.kolli
			private String pac_7064i     = ""; //tegn            6       6      1054        begge    ant.kolli
			private String pac_70641     = ""; //tegn            6       6      1060        begge    ant.delar
			private String pac_70642     = ""; //tegn            6       6      1066        begge    ant.delar
			private String pac_70643     = ""; //tegn            6       6      1072        begge    ant.delar
			private String pac_70644     = ""; //tegn            6       6      1078        begge    ant.delar
			private String pac_70645     = ""; //tegn            6       6      1084        begge    ant.delar
			private String pac_70646     = ""; //tegn            6       6      1090        begge    ant.delar
			private String pac_70647     = ""; //tegn            6       6      1096        begge    ant.delar
			private String pac_70648     = ""; //tegn            6       6      1102        begge    ant.delar
			private String pac_70649     = ""; //tegn            6       6      1108        begge    ant.delar
			private String ftx_4440a     = ""; //tegn           70      70      1114        begge    varuslag 
			private String ftx_4440b     = ""; //tegn           70      70      1184        begge    varuslag
			private String ftx_4440c     = ""; //tegn           70      70      1254        begge    varuslag
			private String ftx_4440d     = ""; //tegn           70      70      1324        begge    varuslag
			private String ftx_4440e     = ""; //tegn           70      70      1394        begge    varuslag
			private String ftx_4440f     = ""; //tegn           70      70      1464        begge    varuslag
			private String ftx_4440g     = ""; //tegn           70      70      1534        begge    varuslag
			private String ftx_4440h     = ""; //tegn           70      70      1604        begge    varuslag    
			private String ftx_4440i     = ""; //tegn           70      70      1674        begge    varuslag    
			private String ftx_4440j     = ""; //tegn           70      70      1744        begge    varuslag    
			private String pci_7102a     = ""; //tegn           50      50      1814        begge    godsmærkning
			private String pci_7102b     = ""; //tegn           50      50      1864        begge    godsmærkning
			private String pci_7102c     = ""; //tegn           50      50      1914        begge    godsmærkning
			private String pci_7102d     = ""; //tegn           50      50      1964        begge    godsmærkning 
			private String pci_7102e     = ""; //tegn           50      50      2014        begge    godsmærkning 
			private String pci_7102f     = ""; //tegn           50      50      2064        begge    godsmærkning 
			private String pci_7102g     = ""; //tegn           50      50      2114        begge    godsmærkning 
			private String pci_7102h     = ""; //tegn           50      50      2164        begge    godsmærkning 
			private String pci_7102i     = ""; //tegn           50      50      2214        begge    godsmærkning 
			private String pci_7102j     = ""; //tegn           50      50      2264        begge    godsmærkning 
			private String mea_6314      = ""; //tegn           15      15      2314        begge    bruttovikt 
			private String mea_6314b     = ""; //tegn           15      15      2329        begge    bruttovikt 
			private String mea_6314c     = ""; //tegn           15      15      2344        begge    bruttovikt 
			private String mea_6314d     = ""; //tegn           15      15      2359        begge    bruttovikt 
			private String mea_6314e     = ""; //tegn           15      15      2374        begge    bruttovikt 
			private String mea_6314f     = ""; //tegn           15      15      2389        begge    bruttovikt 
			private String mea_6314g     = ""; //tegn           15      15      2404        begge    bruttovikt
			private String mea_6314h     = ""; //tegn           15      15      2419        begge    bruttovikt
			private String mea_6314i     = ""; //tegn           15      15      2434        begge    bruttovikt
			private String mea_6314j     = ""; //tegn           15      15      2449        begge    bruttovikt
			private String rff_1154b     = ""; //tegn           35      35      2464        begge    ytt refnr 
			private String rff_1154c     = ""; //tegn           35      35      2499        begge    ytt refnr 
			private String rff_1154d     = ""; //tegn           35      35      2534        begge    ytt refnr 
			private String rff_1154e     = ""; //tegn           35      35      2569        begge    ytt refnr 
			private String rff_1154f     = ""; //tegn           35      35      2604        begge    ytt refnr 
			private String rff_1154g     = ""; //tegn           35      35      2639        begge    ytt refnr 
			private String rff_1154h     = ""; //tegn           35      35      2674        begge    ytt refnr 
			private String rff_1154i     = ""; //tegn           35      35      2709        begge    ytt refnr 
			private String rff_1154j     = ""; //tegn           35      35      2744        begge    ytt refnr 
			private String rff_1154k     = ""; //tegn           35      35      2779        begge    ytt refnr 
			private String rff_1154l     = ""; //tegn           35      35      2814        begge    ytt refnr 
			private String rff_1154m     = ""; //tegn           35      35      2849        begge    ytt refnr 
			private String rff_1154n     = ""; //tegn           35      35      2884        begge    ytt refnr 
			private String rff_1154o     = ""; //tegn           35      35      2919        begge    ytt refnr 
			private String rff_1154p     = ""; //tegn           35      35      2954        begge    ytt refnr 
			private String rff_1154q     = ""; //tegn           35      35      2989        begge    ytt refnr  
			private String rff_11541     = ""; //tegn           35      35      3024        begge    containernr
			private String rff_11542     = ""; //tegn           35      35      3059        begge    containernr
			private String rff_11543     = ""; //tegn           35      35      3094        begge    containernr
			private String rff_11544     = ""; //tegn           35      35      3129        begge    containernr
			private String rff_11545     = ""; //tegn           35      35      3164        begge    containernr
			private String rff_11546     = ""; //tegn           35      35      3199        begge    containernr 
			private String rff_11547     = ""; //tegn           35      35      3234        begge    containernr 
			private String rff_11548     = ""; //tegn           35      35      3269        begge    containernr 
			
			private Map<String, Object> keys = new HashMap<String, Object>();
			
			@Override
			public Map<String, Object> getKeys() {
				keys.put("doc_1004", doc_1004);
				
				return keys;
			}
			  
}
