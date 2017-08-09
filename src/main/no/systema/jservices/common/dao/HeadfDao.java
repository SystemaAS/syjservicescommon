package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class HeadfDao implements IDao {
	
	private String hest;// TEGN            1       1         1        Begge    Statuskode      
	private String heur; //    TEGN            1       1         2        Begge    Delsystem-kode    
	private int heavd; //      SONET        4  0       4         3        Begge    Avdeling     //KEY
	private int heopd; //      SONET        7  0       7         7        Begge    Oppdragsnr  //KEY 
	private String hesg; //    TEGN            3       3        14        Begge    Signatur  
	private int hedtop;//   SONET        8  0       8        17        Begge    Oppdragsdato      
	private int hedtr; //      SONET        8  0       8        25        Begge    Registreringsdato   
	private String hesdff;//   TEGN            5       5        33        Begge    Forfrakt fra    
	private String hesdf; //      TEGN            5       5        38        Begge    Frakt fra    
	private String hesdt; //      TEGN            5       5        43        Begge    Frakt til    
	private String hesdvt; //     TEGN            5       5        48        Begge    Viderefrakt til  
	private String hegn;//       TEGN           15      15        53        Begge    Godsnr       
	private String hegnn; //      TEGN           15      15        68        Begge    Nytt godsnr    
	private int hepro; //      SONET        8  0       8        83        Begge    Turnummer   
	private String heplan; //     TEGN            1       1        91        Begge    Turnummer kode   
	private int trrund; //   SONET        8  0       8        92        Begge    Rundturnr     
	private String hepos1; //    TEGN            7       7       100        Begge    Posisjon-1  
	private int hepos2; //    SONET        4  0       4       107        Begge    Posisjon-2  
	private int trknfa; //    SONET        8  0       8       111        Begge    K.nr oppdragsgiver.     
	private String henao; //     TEGN           30      30       119        Begge    Navn oppdragsgiver    
	private int hekna; //      SONET        8  0       8       149        Begge    Agent kundenr  
	private String henaa;//    TEGN           30      30       157        Begge    Agent navn 
	private String herfa;//      TEGN           35      35       187        Begge    Agent referans
	private String hesaml;//   TEGN            6       6       222        Begge    Samlastnr fly  
	private String hehawb;//    TEGN            9       9       228        Begge    Bil/Hawbnr  
	private String hesdla;//    TEGN           20      20       237        Begge    Lastested      
	private String hesdl;//      TEGN           20      20       257        Begge    Lossested   
	private String hevalt; //     TEGN            3       3       277        Begge    Frakttillegg kode     
	private BigDecimal hevalp = new BigDecimal(0); //     SONET        3  3       3       280        Begge    Frakttillegg  %        
	private int heknt; //      SONET        8  0       8       283        Begge    Kundenr Transportør   
	private String helka; //      TEGN            2       2       291        Begge    Landkode   
	private int hekns; //      SONET        8  0       8       293        Begge    Kundenr Selger  
	private String henas; //      TEGN           30      30       301        Begge    Navn Selger      
	private String heads1;//  TEGN           30      30       331        Begge    Adresse-1 Selger      
	private String heads2; //     TEGN           30      30       361        Begge    Adresse-2 Selger 
	private String hepns; //      TEGN            9       9       391        Begge    Postnr Selger
	private String heads3; //     TEGN           30      30       400        Begge    Adresse-3 Selger   
	private String helks; //      TEGN            2       2       430        Begge    Landkode selger 
	private int heknh; //      SONET        8  0       8       432        Begge    Kundenr Hen.adr  
	private String henah; //      TEGN           30      30       440        Begge    Navn Hen.adr 
	private String headh1; //     TEGN           30      30       470        Begge    Adresse-1 Hen.adr
	private String headh2; //     TEGN           30      30       500        Begge    Adresse-2 Hen.adr    
	private String hepnh; //      TEGN            9       9       530        Begge    Postnr Hen.adr 
	private String headh3; //     TEGN           30      30       539        Begge    Adresse-3 Hen.adr
	private String helkh; //      TEGN            2       2       569        Begge    Landkode Hen.ad
	private BigDecimal hehbre = new BigDecimal(0);//   SONET        8  6       8       571        Begge    HENTING, BREDDEGRAD  
	private String hehblk;//    TEGN            1       1       588        Begge    HENT. BRE/LEN-KODE
	private String hekdfs; //     TEGN            1       1       589        Begge    Fakturakode Selger   
	private String hevals; //    TEGN            3       3       590        Begge    Valutakode Selger 
	private int heknsf;//   SONET        8  0       8       593        Begge    Kundenr Selg.fakm 
	private int heans;//      SONET        1  0       1       601        Begge    Avtalenr Selger  
	private String henasf;//    TEGN           30      30       602        Begge    Navn Selg.fakm 
	private int heknk; //      SONET        8  0       8       632        Begge    Kundenr Kjøper 
	private String henak;//    TEGN           30      30       640        Begge    Navn Kjøper    
	private String headk1;//     TEGN           30      30       670        Begge    Adresse-1 Kjøper
	private String headk2; //    TEGN           30      30       700        Begge    Adresse-2 Kjøper
	private String hepnk; //      TEGN            9       9       730        Begge    Postnr Kjøper
	private String headk3; //     TEGN           30      30       739        Begge    Adresse-3 Kjøper  
	private String helkk; //      TEGN            2       2       769        Begge    Landkode kjøper
	private int heknl; //      SONET        8  0       8       771        Begge    Kundenr Lev.adr
	private String henal;//   TEGN           30      30       779        Begge    Navn Lev.ad
	private String headl1; //     tegn           30      30       809        begge    adresse-1 lev.adr 
	private String headl2; //     tegn           30      30       839        begge    adresse-2 lev.adr 
	private String hepnl; //      tegn            9       9       869        begge    postnr lev.ad
	private String headl3; //     tegn           30      30       878        begge    adresse-3 lev.adr
	private String helkl; //      tegn            2       2       908        begge    landkode lev.adr
	private BigDecimal helbre = new BigDecimal(0); //     sonet        8  6       8       910        begge    levering, breddegrad
	private BigDecimal hellen = new BigDecimal(0);; //     sonet        9  6       9       918        begge    levering, lengdegrad
	private String helblk; //     tegn            1       1       927        begge    leve. bre/len-ko
	private String hekdfk; //     tegn            1       1       928        begge    fakturakode kjøper 
	private String hevalk; //     tegn            3       3       929        begge    valutakode kjøper  
	private int heknkf; //     sonet        8  0       8       932        begge    kundenr kjøp.fakm    
	private int heank; //      sonet        1  0       1       940        begge    avtalenr kjøper 
	private String henakf; //     tegn           30      30       941        begge    navn kjøp.fakm 
	private String heot; //       tegn            2       2       971        begge    oppdragstype 
	private String hekdpl; //     tegn            1       1       973        begge    produktkode
	private String hefr; //       tegn            3       3       974        begge    frankatur  
	private int hent; //       sonet        7  0       7       977        begge    antall kolli
	private String hevs1; //      tegn           25      25       984        begge    vareslag-1 
	private String hevs2; //      tegn           25      25      1009        begge    vareslag-2
	private String hegm1; //      tegn           15      15      1034        begge    godsmerking-1  
	private String hegm2; //      tegn           15      15      1049        begge    godsmerking-2 
	private int hevkt; //      pakket       9  0       5      1064        begge    bruttovekt
	private BigDecimal helm = new BigDecimal(0); //       sonet        4  2       4      1069        begge    lastemeter faktura      
	private BigDecimal hem3 = new BigDecimal(0);//      pakket       7  3       4      1073        begge    kubikkmeter   
	private int hefbv; //     pakket       9  0       5      1077        begge    fraktb.vekt   
	private String hekf; //       tegn            2       2      1082        begge    utl forb.kode    
	private String hekft1; //     tegn            1       1      1084        begge    utl forb status   
	private String heft1; //      tegn           51      51      1085        begge    utl forb tekst      
	private int hedtcp; //     sonet        2  0       2      1136        begge    regnskapsårhundre 
	//OBS å private int hedtåp; //     sonet        2  0       2      1138        begge    regnskapsår
	private int hedtmp; //     sonet        2  0       2      1140        begge    regnskapsperiod 
	private String hekdkk; //     tegn            1       1      1142        begge    kreditkode kjøper  
	private int hefngk; //     sonet        7  0       7      1143        begge    kred. faknr kjøper 
	private int hefngs;//     sonet        7  0       7      1150        begge    kred. faknr selger 
	private String hekdtm; //     tegn            1       1      1157        begge    sad transp.måte 
	private int hetrm; //      sonet        2  0       2      1158        begge    sad trans.middel  
	private String hetri; //      tegn            2       2      1160        begge    sad tr.midd l
	private int hetrc; //      sonet        1  0       1      1162        begge    sad container kode
	private String hetrcn; //     tegn           17      17      1163        begge    sad container 
	private int hefbk; //      sonet        7  0       7      1180        begge    sad fraktbeløp
	private String hetle; //      tegn            6       6      1187        begge    sad eksp.enhet 
	private String hetll; //      tegn           10      10      1193        begge    sad løpenr  
	private String hetlku; //     tegn            1       1      1203        begge    sad kan utføres 
	private int hentvs; //     sonet        3  0       3      1204        begge    sad antall linjer  
	private int hevn;//     sonet        3  0       3      1207        begge    ledig...     
	private int hentf;//    sonet        4  0       4      1210        begge    sad ant.linjer
	private int hebelt; //     pakket       9  0       5      1214        begge    sad tollbeløp  
	private int hebelm; //     pakket       9  0       5      1219        begge    sad momsbeløp
	private String hesgm; //      tegn           10      10      1224        begge    mottatt signatur
	private String hedtmo; //     tegn            8       8      1234        begge    mottatt dato  
	private int heklmo; //     sonet        4  0       4      1242        begge    mottatt klokka
	private String hepk1; //      tegn            1       1      1246        begge    printerkode-
	private String hepk2; //      tegn            1       1      1247        begge    printerkode-2 
	private String hepk3; //      tegn            1       1      1248        begge    printerkode-3
	private String hepk4; //      tegn            1       1      1249        begge    printerkode-4 
	private String hepk5; //      tegn            1       1      1250        begge    printerkode-5  
	private String hepk6; //      tegn            1       1      1251        begge    printerkode-6
	private String hepk7; //      tegn            1       1      1252        begge    printerkode-7 
	private String hepk8; //      tegn            1       1      1253        begge    printerkode-8     
	private String hepk9; //      tegn            1       1      1254        begge    printerkode-9    
	private String hekdl; //      tegn           15      15      1255        begge    lagerpos  
	private String helb; //       tegn            5       5      1270        begge    lokalbåt
	private String helkfr; //     tegn            2       2      1275        begge    frankatur land
	private String hesdfr; //     tegn            5       5      1277        begge    frankatur stedskode
	private String hestfr; //     tegn           30      30      1282        begge    frankatur stedsnavn 
	private String herfk; //      tegn           35      35      1312        begge    oppdragsgivers ref
	private int travd0; //     sonet        4  0       4      1349        begge    avdeling opphav  
	private int tropd0; //     sonet        7  0       7      1353        begge    oppdragsnr opphav 
	private int travd1; //     sonet        4  0       4      1360        begge    avdeling forfrakt 
	private int tropd1; //     sonet        7  0       7      1364        begge    oppdragsnr forfrakt  
	private int travd2; //     sonet        4  0       4      1371        begge    avdeling etterfrakt
	private int tropd2; //     sonet        7  0       7      1375        begge    oppdragsnr etterfra 
	private int trsffd; //     sonet        8  0       8      1382        begge    forfrakt dato    
	private int trsffk; //     sonet        4  0       4      1390        begge    forfrakt klokka  
	private int trsdfd; //     sonet        8  0       8      1394        begge    fra dato         
	private int trsdfk; //     sonet        4  0       4      1402        begge    fra klokka       
	private int trsdtd; //     sonet        8  0       8      1406        begge    til dato         
	private int trsdtk; //     sonet        4  0       4      1414        begge    til klokka       
	private int trsvtd; //     sonet        8  0       8      1418        begge    viderefr. dato   
	private int trsvtk; //     sonet        4  0       4      1426        begge    viderefr. klokka 
	private String trkdak; //    tegn            1       1      1430        begge    oppdragsg.kode   
	private String trkdff;//     tegn            1       1      1431        begge    fakturere s/k   
	private String trverv; //     tegn            3       3      1432        begge    valkod vareverdi
	private BigDecimal trverb = new BigDecimal(0);; //     pakket      13  2       7      1435        begge    vareverdi       
	private String trettv; //     tegn            3       3      1442        begge    valkod etterkrav
	private BigDecimal trettb = new BigDecimal(0);; //     pakket      13  2       7      1445        begge    etterkrav       
	private String trfrak; //     tegn            1       1      1452        begge    kode frakt      
	private String trfrav; //     tegn            3       3      1453        begge    valkod frakt    
	private BigDecimal trfrab = new BigDecimal(0); //     pakket      13  2       7      1456        begge    fraktbeløp     
	private String trmva; //      tegn            1       1      1463        begge    mvakode frakt  
	private String trfa11; //     tegn            7       7      1464        begge    farlig gods 11 
	private String trfa12; //     tegn            4       4      1471        begge    farlig gods 12 
	private int trflp1; //     pakket       3  0       2      1475        begge    flashpoint 1   
	private String trfa21; //    tegn            7       7      1477        begge    farlig gods 21 
	private String trfa22; //     tegn            4       4      1484        begge    farlig gods 22 
	private int trflp2; //     pakket       3  0       2      1488        begge    flashpoint 2         
	private String trtsta; //     tegn            1       1      1490        begge    t-papirstatus        
	private String trstaf; //     tegn            1       1      1491        begge    dispstat forfrakt    
	private String trstae; //     tegn            1       1      1492        begge    dispstat etterfrakt  
	private String trsta1; //     tegn            1       1      1493        begge    disponeringsstatus   
	private String trsta2; //     tegn            1       1      1494        begge    ledig                
	private String trsta3; //     tegn            1       1      1495        begge    ledig                
	private String trsta4; //     tegn            1       1      1496        begge    produkt fly   
	private int trkm; //       pakket       5  0       3      1497        begge    kjørte kilometer   
	private String he01; //       tegn            1       1      1500        begge    oppdat stat
	private int hestd; //      sonet        4  0       4      1501        begge    avvikende bærer 
	private String hxsndn; //     tegn           20      20      1505        begge    ean send.nr              
	private int hxpall; //     sonet        3  0       3      1525        begge    ant paller               
	private String hxblgk; //     tegn            3       3      1528        begge    beløp godk. sign         
	private String hxlkod; //     tegn            5       5      1531        begge    lagersted/innland        
	private String hxllst; //     tegn            1       1      1536        begge    ls.stat(er printet)      
	private String hxedik; //     tegn            1       1      1537        begge    edikode,e=edi,k=kweb     
	private String hxteri; //     tegn            1       1      1538        begge    termin.inn               
	private int hehakn;//     sonet        8  0       8      1539        begge    hen.adr.kundenr         
	private int hehaan; //     sonet        3  0       3      1547        begge    hen.adr.adr.nr          
	private int helakn; //     sonet        8  0       8      1550        begge    lev.adr.kundenr         
	private int helaan; //     sonet        3  0       3      1558        begge    lev.adr.adr.nr          
	private int helmla; //     sonet        4  2       4      1561        begge    lastemeter lasting      
	private int hepoen; //     sonet        5  0       5      1565        begge    adr-poeng                   
	private String hestl1; //     tegn            1       1      1570        begge    vlinje 1 status             
	private String hestl2; //     tegn            1       1      1571        begge    vlinje 2 status             
	private String hestl3; //     tegn            1       1      1572        begge    vlinje 3 status             
	private String hestl4; //     tegn            1       1      1573        begge    vlinje 4 status             
	private String hestn1; //     tegn            1       1      1574        begge    status ny 1                 
	private String hestn2; //     tegn            1       1      1575        begge    status ny 2                 
	private String hestn3; //     tegn            1       1      1576        begge    status ny 3           
	private String hestn4; //     tegn            1       1      1577        begge    status ny 4           
	private String hestn5; //     tegn            1       1      1578        begge    status ny 5           
	private String hestn6; //     tegn            1       1      1579        begge    status ny 6           
	private String hestn7; //     tegn            1       1      1580        begge    status ny 7           
	private String hestn8; //     tegn            1       1      1581        begge    status ny 8           
	private String hestn9; //     tegn            1       1      1582        begge    status ny 9               
	private String herfed; //     tegn           35      35      1583        begge    edi ekstern ref           
	private String helib; //      tegn           10      10      1618        begge    bibliotek                 
	private String hefile; //     tegn           10      10      1628        begge    fil                       
	private String hembr; //     tegn           10      10      1638        begge    mbr                       
	private String hetype; //     tegn            6       6      1648        begge    type melding              
	private String helvl; //      tegn            3       3      1654        begge    meldingsnivå              
	private int hesnn; //      pakket       9  0       5      1657        begge    meldingsnr    
	private int heunik; //     pakket       9  0       5      1662        begge    recordnr      
	private String hereff; //     tegn           17      17      1667        begge    referanse     

	public int getHedtop() {
		return hedtop;
	}

	public void setHedtop(int hedtop) {
		this.hedtop = hedtop;
	}

	public int getHedtr() {
		return hedtr;
	}

	public void setHedtr(int hedtr) {
		this.hedtr = hedtr;
	}

	public int getHepro() {
		return hepro;
	}

	public void setHepro(int hepro) {
		this.hepro = hepro;
	}

	public int getTrrund() {
		return trrund;
	}

	public void setTrrund(int trrund) {
		this.trrund = trrund;
	}

	public int getHepos2() {
		return hepos2;
	}

	public void setHepos2(int hepos2) {
		this.hepos2 = hepos2;
	}

	public int getTrknfa() {
		return trknfa;
	}

	public void setTrknfa(int trknfa) {
		this.trknfa = trknfa;
	}

	public int getHekna() {
		return hekna;
	}

	public void setHekna(int hekna) {
		this.hekna = hekna;
	}

	public BigDecimal getHevalp() {
		return hevalp;
	}

	public void setHevalp(BigDecimal hevalp) {
		this.hevalp = hevalp;
	}

	public int getHeknt() {
		return heknt;
	}

	public void setHeknt(int heknt) {
		this.heknt = heknt;
	}

	public int getHeknh() {
		return heknh;
	}

	public void setHeknh(int heknh) {
		this.heknh = heknh;
	}

	public BigDecimal getHehbre() {
		return hehbre;
	}

	public void setHehbre(BigDecimal hehbre) {
		this.hehbre = hehbre;
	}

	public int getHeknsf() {
		return heknsf;
	}

	public void setHeknsf(int heknsf) {
		this.heknsf = heknsf;
	}

	public int getHeans() {
		return heans;
	}

	public void setHeans(int heans) {
		this.heans = heans;
	}

	public int getHeknk() {
		return heknk;
	}

	public void setHeknk(int heknk) {
		this.heknk = heknk;
	}

	public int getHeknl() {
		return heknl;
	}

	public void setHeknl(int heknl) {
		this.heknl = heknl;
	}

	public BigDecimal getHelbre() {
		return helbre;
	}

	public void setHelbre(BigDecimal helbre) {
		this.helbre = helbre;
	}

	public BigDecimal getHellen() {
		return hellen;
	}

	public void setHellen(BigDecimal hellen) {
		this.hellen = hellen;
	}

	public int getHeknkf() {
		return heknkf;
	}

	public void setHeknkf(int heknkf) {
		this.heknkf = heknkf;
	}

	public int getHeank() {
		return heank;
	}

	public void setHeank(int heank) {
		this.heank = heank;
	}

	public int getHent() {
		return hent;
	}

	public void setHent(int hent) {
		this.hent = hent;
	}

	public int getHevkt() {
		return hevkt;
	}

	public void setHevkt(int hevkt) {
		this.hevkt = hevkt;
	}

	public BigDecimal getHelm() {
		return helm;
	}

	public void setHelm(BigDecimal helm) {
		this.helm = helm;
	}

	public BigDecimal getHem3() {
		return hem3;
	}

	public void setHem3(BigDecimal hem3) {
		this.hem3 = hem3;
	}

	public int getHefbv() {
		return hefbv;
	}

	public void setHefbv(int hefbv) {
		this.hefbv = hefbv;
	}

	public int getHedtcp() {
		return hedtcp;
	}

	public void setHedtcp(int hedtcp) {
		this.hedtcp = hedtcp;
	}

	public int getHekns() {
		return hekns;
	}

	public void setHekns(int hekns) {
		this.hekns = hekns;
	}

	public int getHebelt() {
		return hebelt;
	}

	public void setHebelt(int hebelt) {
		this.hebelt = hebelt;
	}

	public int getHebelm() {
		return hebelm;
	}

	public void setHebelm(int hebelm) {
		this.hebelm = hebelm;
	}

	public BigDecimal getTrverb() {
		return trverb;
	}

	public void setTrverb(BigDecimal trverb) {
		this.trverb = trverb;
	}

	public BigDecimal getTrettb() {
		return trettb;
	}

	public void setTrettb(BigDecimal trettb) {
		this.trettb = trettb;
	}

	public BigDecimal getTrfrab() {
		return trfrab;
	}

	public void setTrfrab(BigDecimal trfrab) {
		this.trfrab = trfrab;
	}

	public int getTrflp2() {
		return trflp2;
	}

	public void setTrflp2(int trflp2) {
		this.trflp2 = trflp2;
	}

	public int getTrkm() {
		return trkm;
	}

	public void setTrkm(int trkm) {
		this.trkm = trkm;
	}

	public String getHestl1() {
		return hestl1;
	}

	public void setHestl1(String hestl1) {
		this.hestl1 = hestl1;
	}

	public int getHesnn() {
		return hesnn;
	}

	public void setHesnn(int hesnn) {
		this.hesnn = hesnn;
	}

	public int getHeunik() {
		return heunik;
	}

	public void setHeunik(int heunik) {
		this.heunik = heunik;
	}

	public int getHedtmp() {
		return hedtmp;
	}

	public void setHedtmp(int hedtmp) {
		this.hedtmp = hedtmp;
	}

	public int getHefngk() {
		return hefngk;
	}

	public void setHefngk(int hefngk) {
		this.hefngk = hefngk;
	}

	public int getHefngs() {
		return hefngs;
	}

	public void setHefngs(int hefngs) {
		this.hefngs = hefngs;
	}

	public int getHetrm() {
		return hetrm;
	}

	public void setHetrm(int hetrm) {
		this.hetrm = hetrm;
	}

	public int getHetrc() {
		return hetrc;
	}

	public void setHetrc(int hetrc) {
		this.hetrc = hetrc;
	}

	public int getHefbk() {
		return hefbk;
	}

	public void setHefbk(int hefbk) {
		this.hefbk = hefbk;
	}

	public int getHentvs() {
		return hentvs;
	}

	public void setHentvs(int hentvs) {
		this.hentvs = hentvs;
	}

	public int getHevn() {
		return hevn;
	}

	public void setHevn(int hevn) {
		this.hevn = hevn;
	}

	public int getHentf() {
		return hentf;
	}

	public void setHentf(int hentf) {
		this.hentf = hentf;
	}

	public int getHeklmo() {
		return heklmo;
	}

	public void setHeklmo(int heklmo) {
		this.heklmo = heklmo;
	}

	public int getTravd0() {
		return travd0;
	}

	public void setTravd0(int travd0) {
		this.travd0 = travd0;
	}

	public int getTropd0() {
		return tropd0;
	}

	public void setTropd0(int tropd0) {
		this.tropd0 = tropd0;
	}

	public int getTravd1() {
		return travd1;
	}

	public void setTravd1(int travd1) {
		this.travd1 = travd1;
	}

	public int getTropd1() {
		return tropd1;
	}

	public void setTropd1(int tropd1) {
		this.tropd1 = tropd1;
	}

	public int getTravd2() {
		return travd2;
	}

	public void setTravd2(int travd2) {
		this.travd2 = travd2;
	}

	public int getTropd2() {
		return tropd2;
	}

	public void setTropd2(int tropd2) {
		this.tropd2 = tropd2;
	}

	public int getTrsffd() {
		return trsffd;
	}

	public void setTrsffd(int trsffd) {
		this.trsffd = trsffd;
	}

	public int getTrsffk() {
		return trsffk;
	}

	public void setTrsffk(int trsffk) {
		this.trsffk = trsffk;
	}

	public int getTrsdfd() {
		return trsdfd;
	}

	public void setTrsdfd(int trsdfd) {
		this.trsdfd = trsdfd;
	}

	public int getTrsdfk() {
		return trsdfk;
	}

	public void setTrsdfk(int trsdfk) {
		this.trsdfk = trsdfk;
	}

	public int getTrsdtd() {
		return trsdtd;
	}

	public void setTrsdtd(int trsdtd) {
		this.trsdtd = trsdtd;
	}

	public int getTrsdtk() {
		return trsdtk;
	}

	public void setTrsdtk(int trsdtk) {
		this.trsdtk = trsdtk;
	}

	public int getTrsvtd() {
		return trsvtd;
	}

	public void setTrsvtd(int trsvtd) {
		this.trsvtd = trsvtd;
	}

	public int getTrsvtk() {
		return trsvtk;
	}

	public void setTrsvtk(int trsvtk) {
		this.trsvtk = trsvtk;
	}

	public int getHestd() {
		return hestd;
	}

	public void setHestd(int hestd) {
		this.hestd = hestd;
	}

	public int getHxpall() {
		return hxpall;
	}

	public void setHxpall(int hxpall) {
		this.hxpall = hxpall;
	}

	public int getHehakn() {
		return hehakn;
	}

	public void setHehakn(int hehakn) {
		this.hehakn = hehakn;
	}

	public int getHehaan() {
		return hehaan;
	}

	public void setHehaan(int hehaan) {
		this.hehaan = hehaan;
	}

	public int getHelakn() {
		return helakn;
	}

	public void setHelakn(int helakn) {
		this.helakn = helakn;
	}

	public int getHelaan() {
		return helaan;
	}

	public void setHelaan(int helaan) {
		this.helaan = helaan;
	}

	public int getHelmla() {
		return helmla;
	}

	public void setHelmla(int helmla) {
		this.helmla = helmla;
	}

	public int getHepoen() {
		return hepoen;
	}

	public void setHepoen(int hepoen) {
		this.hepoen = hepoen;
	}

	Map<String, Object> keys = new HashMap<String, Object>();

	public String getHest() {
		return hest;
	}

	public void setHest(String hest) {
		this.hest = hest;
	}

	public String getHeur() {
		return heur;
	}

	public void setHeur(String heur) {
		this.heur = heur;
	}

	public int getHeavd() {
		return heavd;
	}

	public void setHeavd(int heavd) {
		this.heavd = heavd;
	}

	public int getHeopd() {
		return heopd;
	}

	public void setHeopd(int heopd) {
		this.heopd = heopd;
	}

	public String getHesg() {
		return hesg;
	}

	public void setHesg(String hesg) {
		this.hesg = hesg;
	}



	public String getHesdff() {
		return hesdff;
	}

	public void setHesdff(String hesdff) {
		this.hesdff = hesdff;
	}

	public String getHesdf() {
		return hesdf;
	}

	public void setHesdf(String hesdf) {
		this.hesdf = hesdf;
	}

	public String getHesdt() {
		return hesdt;
	}

	public void setHesdt(String hesdt) {
		this.hesdt = hesdt;
	}

	public String getHesdvt() {
		return hesdvt;
	}

	public void setHesdvt(String hesdvt) {
		this.hesdvt = hesdvt;
	}

	public String getHegn() {
		return hegn;
	}

	public void setHegn(String hegn) {
		this.hegn = hegn;
	}

	public String getHegnn() {
		return hegnn;
	}

	public void setHegnn(String hegnn) {
		this.hegnn = hegnn;
	}


	public String getHeplan() {
		return heplan;
	}

	public void setHeplan(String heplan) {
		this.heplan = heplan;
	}



	public String getHepos1() {
		return hepos1;
	}

	public void setHepos1(String hepos1) {
		this.hepos1 = hepos1;
	}


	public String getHenao() {
		return henao;
	}

	public void setHenao(String henao) {
		this.henao = henao;
	}



	public String getHenaa() {
		return henaa;
	}

	public void setHenaa(String henaa) {
		this.henaa = henaa;
	}

	public String getHerfa() {
		return herfa;
	}

	public void setHerfa(String herfa) {
		this.herfa = herfa;
	}

	public String getHesaml() {
		return hesaml;
	}

	public void setHesaml(String hesaml) {
		this.hesaml = hesaml;
	}

	public String getHehawb() {
		return hehawb;
	}

	public void setHehawb(String hehawb) {
		this.hehawb = hehawb;
	}

	public String getHesdla() {
		return hesdla;
	}

	public void setHesdla(String hesdla) {
		this.hesdla = hesdla;
	}

	public String getHesdl() {
		return hesdl;
	}

	public void setHesdl(String hesdl) {
		this.hesdl = hesdl;
	}

	public String getHevalt() {
		return hevalt;
	}

	public void setHevalt(String hevalt) {
		this.hevalt = hevalt;
	}



	public String getHelka() {
		return helka;
	}

	public void setHelka(String helka) {
		this.helka = helka;
	}


	public String getHenas() {
		return henas;
	}

	public void setHenas(String henas) {
		this.henas = henas;
	}

	public String getHeads1() {
		return heads1;
	}

	public void setHeads1(String heads1) {
		this.heads1 = heads1;
	}

	public String getHeads2() {
		return heads2;
	}

	public void setHeads2(String heads2) {
		this.heads2 = heads2;
	}

	public String getHepns() {
		return hepns;
	}

	public void setHepns(String hepns) {
		this.hepns = hepns;
	}

	public String getHeads3() {
		return heads3;
	}

	public void setHeads3(String heads3) {
		this.heads3 = heads3;
	}

	public String getHelks() {
		return helks;
	}

	public void setHelks(String helks) {
		this.helks = helks;
	}



	public String getHenah() {
		return henah;
	}

	public void setHenah(String henah) {
		this.henah = henah;
	}

	public String getHeadh1() {
		return headh1;
	}

	public void setHeadh1(String headh1) {
		this.headh1 = headh1;
	}

	public String getHeadh2() {
		return headh2;
	}

	public void setHeadh2(String headh2) {
		this.headh2 = headh2;
	}

	public String getHepnh() {
		return hepnh;
	}

	public void setHepnh(String hepnh) {
		this.hepnh = hepnh;
	}

	public String getHeadh3() {
		return headh3;
	}

	public void setHeadh3(String headh3) {
		this.headh3 = headh3;
	}

	public String getHelkh() {
		return helkh;
	}

	public void setHelkh(String helkh) {
		this.helkh = helkh;
	}



	public String getHehblk() {
		return hehblk;
	}

	public void setHehblk(String hehblk) {
		this.hehblk = hehblk;
	}

	public String getHekdfs() {
		return hekdfs;
	}

	public void setHekdfs(String hekdfs) {
		this.hekdfs = hekdfs;
	}

	public String getHevals() {
		return hevals;
	}

	public void setHevals(String hevals) {
		this.hevals = hevals;
	}



	public String getHenasf() {
		return henasf;
	}

	public void setHenasf(String henasf) {
		this.henasf = henasf;
	}


	public String getHenak() {
		return henak;
	}

	public void setHenak(String henak) {
		this.henak = henak;
	}

	public String getHeadk1() {
		return headk1;
	}

	public void setHeadk1(String headk1) {
		this.headk1 = headk1;
	}

	public String getHeadk2() {
		return headk2;
	}

	public void setHeadk2(String headk2) {
		this.headk2 = headk2;
	}

	public String getHepnk() {
		return hepnk;
	}

	public void setHepnk(String hepnk) {
		this.hepnk = hepnk;
	}

	public String getHeadk3() {
		return headk3;
	}

	public void setHeadk3(String headk3) {
		this.headk3 = headk3;
	}

	public String getHelkk() {
		return helkk;
	}

	public void setHelkk(String helkk) {
		this.helkk = helkk;
	}



	public String getHenal() {
		return henal;
	}

	public void setHenal(String henal) {
		this.henal = henal;
	}

	public String getHeadl1() {
		return headl1;
	}

	public void setHeadl1(String headl1) {
		this.headl1 = headl1;
	}

	public String getHeadl2() {
		return headl2;
	}

	public void setHeadl2(String headl2) {
		this.headl2 = headl2;
	}

	public String getHepnl() {
		return hepnl;
	}

	public void setHepnl(String hepnl) {
		this.hepnl = hepnl;
	}

	public String getHeadl3() {
		return headl3;
	}

	public void setHeadl3(String headl3) {
		this.headl3 = headl3;
	}

	public String getHelkl() {
		return helkl;
	}

	public void setHelkl(String helkl) {
		this.helkl = helkl;
	}



	public String getHelblk() {
		return helblk;
	}

	public void setHelblk(String helblk) {
		this.helblk = helblk;
	}

	public String getHekdfk() {
		return hekdfk;
	}

	public void setHekdfk(String hekdfk) {
		this.hekdfk = hekdfk;
	}

	public String getHevalk() {
		return hevalk;
	}

	public void setHevalk(String hevalk) {
		this.hevalk = hevalk;
	}



	public String getHenakf() {
		return henakf;
	}

	public void setHenakf(String henakf) {
		this.henakf = henakf;
	}

	public String getHeot() {
		return heot;
	}

	public void setHeot(String heot) {
		this.heot = heot;
	}

	public String getHekdpl() {
		return hekdpl;
	}

	public void setHekdpl(String hekdpl) {
		this.hekdpl = hekdpl;
	}

	public String getHefr() {
		return hefr;
	}

	public void setHefr(String hefr) {
		this.hefr = hefr;
	}



	public String getHevs1() {
		return hevs1;
	}

	public void setHevs1(String hevs1) {
		this.hevs1 = hevs1;
	}

	public String getHevs2() {
		return hevs2;
	}

	public void setHevs2(String hevs2) {
		this.hevs2 = hevs2;
	}

	public String getHegm1() {
		return hegm1;
	}

	public void setHegm1(String hegm1) {
		this.hegm1 = hegm1;
	}

	public String getHegm2() {
		return hegm2;
	}

	public void setHegm2(String hegm2) {
		this.hegm2 = hegm2;
	}




	public String getHekf() {
		return hekf;
	}

	public void setHekf(String hekf) {
		this.hekf = hekf;
	}

	public String getHekft1() {
		return hekft1;
	}

	public void setHekft1(String hekft1) {
		this.hekft1 = hekft1;
	}

	public String getHeft1() {
		return heft1;
	}

	public void setHeft1(String heft1) {
		this.heft1 = heft1;
	}



	public String getHekdkk() {
		return hekdkk;
	}

	public void setHekdkk(String hekdkk) {
		this.hekdkk = hekdkk;
	}



	public String getHekdtm() {
		return hekdtm;
	}

	public void setHekdtm(String hekdtm) {
		this.hekdtm = hekdtm;
	}


	public String getHetri() {
		return hetri;
	}

	public void setHetri(String hetri) {
		this.hetri = hetri;
	}



	public String getHetrcn() {
		return hetrcn;
	}

	public void setHetrcn(String hetrcn) {
		this.hetrcn = hetrcn;
	}



	public String getHetle() {
		return hetle;
	}

	public void setHetle(String hetle) {
		this.hetle = hetle;
	}

	public String getHetll() {
		return hetll;
	}

	public void setHetll(String hetll) {
		this.hetll = hetll;
	}

	public String getHetlku() {
		return hetlku;
	}

	public void setHetlku(String hetlku) {
		this.hetlku = hetlku;
	}



	public String getHesgm() {
		return hesgm;
	}

	public void setHesgm(String hesgm) {
		this.hesgm = hesgm;
	}

	public String getHedtmo() {
		return hedtmo;
	}

	public void setHedtmo(String hedtmo) {
		this.hedtmo = hedtmo;
	}



	public String getHepk1() {
		return hepk1;
	}

	public void setHepk1(String hepk1) {
		this.hepk1 = hepk1;
	}

	public String getHepk2() {
		return hepk2;
	}

	public void setHepk2(String hepk2) {
		this.hepk2 = hepk2;
	}

	public String getHepk3() {
		return hepk3;
	}

	public void setHepk3(String hepk3) {
		this.hepk3 = hepk3;
	}

	public String getHepk4() {
		return hepk4;
	}

	public void setHepk4(String hepk4) {
		this.hepk4 = hepk4;
	}

	public String getHepk5() {
		return hepk5;
	}

	public void setHepk5(String hepk5) {
		this.hepk5 = hepk5;
	}

	public String getHepk6() {
		return hepk6;
	}

	public void setHepk6(String hepk6) {
		this.hepk6 = hepk6;
	}

	public String getHepk7() {
		return hepk7;
	}

	public void setHepk7(String hepk7) {
		this.hepk7 = hepk7;
	}

	public String getHepk8() {
		return hepk8;
	}

	public void setHepk8(String hepk8) {
		this.hepk8 = hepk8;
	}

	public String getHepk9() {
		return hepk9;
	}

	public void setHepk9(String hepk9) {
		this.hepk9 = hepk9;
	}

	public String getHekdl() {
		return hekdl;
	}

	public void setHekdl(String hekdl) {
		this.hekdl = hekdl;
	}

	public String getHelb() {
		return helb;
	}

	public void setHelb(String helb) {
		this.helb = helb;
	}

	public String getHelkfr() {
		return helkfr;
	}

	public void setHelkfr(String helkfr) {
		this.helkfr = helkfr;
	}

	public String getHesdfr() {
		return hesdfr;
	}

	public void setHesdfr(String hesdfr) {
		this.hesdfr = hesdfr;
	}

	public String getHestfr() {
		return hestfr;
	}

	public void setHestfr(String hestfr) {
		this.hestfr = hestfr;
	}

	public String getHerfk() {
		return herfk;
	}

	public void setHerfk(String herfk) {
		this.herfk = herfk;
	}








	public String getTrkdak() {
		return trkdak;
	}

	public void setTrkdak(String trkdak) {
		this.trkdak = trkdak;
	}

	public String getTrkdff() {
		return trkdff;
	}

	public void setTrkdff(String trkdff) {
		this.trkdff = trkdff;
	}

	public String getTrverv() {
		return trverv;
	}

	public void setTrverv(String trverv) {
		this.trverv = trverv;
	}


	public String getTrettv() {
		return trettv;
	}

	public void setTrettv(String trettv) {
		this.trettv = trettv;
	}


	public String getTrfrak() {
		return trfrak;
	}

	public void setTrfrak(String trfrak) {
		this.trfrak = trfrak;
	}

	public String getTrfrav() {
		return trfrav;
	}

	public void setTrfrav(String trfrav) {
		this.trfrav = trfrav;
	}

	public String getTrmva() {
		return trmva;
	}

	public void setTrmva(String trmva) {
		this.trmva = trmva;
	}

	public String getTrfa11() {
		return trfa11;
	}

	public void setTrfa11(String trfa11) {
		this.trfa11 = trfa11;
	}

	public String getTrfa12() {
		return trfa12;
	}

	public void setTrfa12(String trfa12) {
		this.trfa12 = trfa12;
	}

	public int getTrflp1() {
		return trflp1;
	}

	public void setTrflp1(int trflp1) {
		this.trflp1 = trflp1;
	}

	public String getTrfa21() {
		return trfa21;
	}

	public void setTrfa21(String trfa21) {
		this.trfa21 = trfa21;
	}

	public String getTrfa22() {
		return trfa22;
	}

	public void setTrfa22(String trfa22) {
		this.trfa22 = trfa22;
	}


	public String getTrtsta() {
		return trtsta;
	}

	public void setTrtsta(String trtsta) {
		this.trtsta = trtsta;
	}

	public String getTrstaf() {
		return trstaf;
	}

	public void setTrstaf(String trstaf) {
		this.trstaf = trstaf;
	}

	public String getTrstae() {
		return trstae;
	}

	public void setTrstae(String trstae) {
		this.trstae = trstae;
	}

	public String getTrsta1() {
		return trsta1;
	}

	public void setTrsta1(String trsta1) {
		this.trsta1 = trsta1;
	}

	public String getTrsta2() {
		return trsta2;
	}

	public void setTrsta2(String trsta2) {
		this.trsta2 = trsta2;
	}

	public String getTrsta3() {
		return trsta3;
	}

	public void setTrsta3(String trsta3) {
		this.trsta3 = trsta3;
	}

	public String getTrsta4() {
		return trsta4;
	}

	public void setTrsta4(String trsta4) {
		this.trsta4 = trsta4;
	}

	public String getHe01() {
		return he01;
	}

	public void setHe01(String he01) {
		this.he01 = he01;
	}


	public String getHxsndn() {
		return hxsndn;
	}

	public void setHxsndn(String hxsndn) {
		this.hxsndn = hxsndn;
	}


	public String getHxblgk() {
		return hxblgk;
	}

	public void setHxblgk(String hxblgk) {
		this.hxblgk = hxblgk;
	}

	public String getHxlkod() {
		return hxlkod;
	}

	public void setHxlkod(String hxlkod) {
		this.hxlkod = hxlkod;
	}

	public String getHxllst() {
		return hxllst;
	}

	public void setHxllst(String hxllst) {
		this.hxllst = hxllst;
	}

	public String getHxedik() {
		return hxedik;
	}

	public void setHxedik(String hxedik) {
		this.hxedik = hxedik;
	}

	public String getHxteri() {
		return hxteri;
	}

	public void setHxteri(String hxteri) {
		this.hxteri = hxteri;
	}




	public String getHestl2() {
		return hestl2;
	}

	public void setHestl2(String hestl2) {
		this.hestl2 = hestl2;
	}

	public String getHestl3() {
		return hestl3;
	}

	public void setHestl3(String hestl3) {
		this.hestl3 = hestl3;
	}

	public String getHestl4() {
		return hestl4;
	}

	public void setHestl4(String hestl4) {
		this.hestl4 = hestl4;
	}

	public String getHestn1() {
		return hestn1;
	}

	public void setHestn1(String hestn1) {
		this.hestn1 = hestn1;
	}

	public String getHestn2() {
		return hestn2;
	}

	public void setHestn2(String hestn2) {
		this.hestn2 = hestn2;
	}

	public String getHestn3() {
		return hestn3;
	}

	public void setHestn3(String hestn3) {
		this.hestn3 = hestn3;
	}

	public String getHestn4() {
		return hestn4;
	}

	public void setHestn4(String hestn4) {
		this.hestn4 = hestn4;
	}

	public String getHestn5() {
		return hestn5;
	}

	public void setHestn5(String hestn5) {
		this.hestn5 = hestn5;
	}

	public String getHestn6() {
		return hestn6;
	}

	public void setHestn6(String hestn6) {
		this.hestn6 = hestn6;
	}

	public String getHestn7() {
		return hestn7;
	}

	public void setHestn7(String hestn7) {
		this.hestn7 = hestn7;
	}

	public String getHestn8() {
		return hestn8;
	}

	public void setHestn8(String hestn8) {
		this.hestn8 = hestn8;
	}

	public String getHestn9() {
		return hestn9;
	}

	public void setHestn9(String hestn9) {
		this.hestn9 = hestn9;
	}

	public String getHerfed() {
		return herfed;
	}

	public void setHerfed(String herfed) {
		this.herfed = herfed;
	}

	public String getHelib() {
		return helib;
	}

	public void setHelib(String helib) {
		this.helib = helib;
	}

	public String getHefile() {
		return hefile;
	}

	public void setHefile(String hefile) {
		this.hefile = hefile;
	}

	public String getHembr() {
		return hembr;
	}

	public void setHembr(String hembr) {
		this.hembr = hembr;
	}

	public String getHetype() {
		return hetype;
	}

	public void setHetype(String hetype) {
		this.hetype = hetype;
	}

	public String getHelvl() {
		return helvl;
	}

	public void setHelvl(String helvl) {
		this.helvl = helvl;
	}

	public String getHereff() {
		return hereff;
	}

	public void setHereff(String hereff) {
		this.hereff = hereff;
	}

	@Override
	public Map<String, Object> getKeys() {
		keys.put("heavd", heavd);
		keys.put("heopd", heopd);
		return keys;
	}

}
