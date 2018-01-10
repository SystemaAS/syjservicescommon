package no.systema.jservices.common.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Land Fraktbrev
 * 
 * @author Fredrik Möller
 * @date Aug 22, 2017
 */
public class DokufDao implements IDao {

	
	private String dfst; // Status    (1)
	private String dfri; //  Record ID   (1)
	private int dfavd; // Avdeling //KEY  SONET (4)
	private int dfopd; // Oppdragsnummer //KEY  SONET (7)
	private int dffbnr; // Fraktbrevnummer //KEY  SONET (3)
	private String dfsg; // Signatur  (3)
	private String dfcmn; // J=Kommunikasjon (1) 
	private String dfven; // Ventekode (1) 
	private String df1004; // Sendningsnr (35)
	private int dfdtu; // R17.Utstedelsesdato SONET (8) 
	private int dftoll; //  Tollsted, 00=Fr.brev SONET(4)
	private int dfknss; // SYSPED Knr Sender  SONET(8)
	private String dfnavs; //  R01.Navn Sender (30)
	private String dfad1s; // R02.Adresse Sender  (30)
	private String dfad2s; // Adresse2 Sender   (30)  
	private int dfpnls; // Postnr Sender    PAKKET (4)  
	private String dfad3s; // Sted Sender  (30)
	private String dflks; // Sender Landkode (2)
	private String dfpnus; // Sender Pnr utland (9) 
	private String dfkns; // R15.Kundenr Sender (12) 
	private String dfsref; //  R16.Senders ref  (17)
	private int dfpnat; // Postnr avg.terminal  PAKKET (4)
	private int dfknsm; //  SYSPED Knr Mottaker SONET (8)
	private String dfnavm; // R04.Navn Mottaker   (30)
	private String dfad1m; //  R05.Adresse Mottaker (30)
	private String dfad2m; //  Adresse 2 Mottaker (30)
	private String dfad3m; // R06.Pnr/sted Mottak  (30)
	private String dflkm; // Landkode Mottaker   (2)
	private String dfpnum; //  Pnr utland Mottaker (9)
	private String dfknm; // R23.Kundenr Mottaker (12)
	private String dfmref; // R25.Mottakers ref  (17)
	private String dfnavl; //  R07.Navn Lev.adr (30)      
	private String dfad1l; // R08.Leveringsadresse  (30)      
	private String dfad2l; // LeveringsAdresse 2 (30)
	private int dfpoul; // R09.Postnr Utl.sted   PAKKET (4)  
	private String dfadul; // R09.Utleveringssted    (30)  
	private String dflkl; //  Lev.adr. Landkode   (2)
	private String dfpnul; //  Lev.adr. Pnr utland  (9)
	private int dfknsx; // SYSPED Knr Annen F  SONET(8)
	private String dfnavx; //  R19.Navn Annen F   (30)
	private String dfad1x; // R21.Adresse Annen F  (30) 
	private String dfad2x; // Adresse 2 Annen F  (30)
	private String dfad3x; // R22.Pnr/sted Annen  (30)
	private String dflkx; // Landkode Annen F  (2)   
	private String dfpnux; //  Pnr utland Annen F  (9)  
	private String dfknx; // R20.kundenr Annen F  (12)
	private String dfover; // R11.Over    (17)
	private int dftran; //  SYSPED Transp.no SONET (8)
	private String dfnat; // R10.Navn Transportør (20)
	private String dfprok; // R14.Produkt kode    (5)
	private String dfpro1; // R14.Prod. tekst 1   (30)
	private String dfpro2; // R14.Prod. tekst 2   (30)
	private int dfnteu; // R12.A.EURO-pl utveks SONET(2)
	private int dfntau; // R13.A.Andr-pl utveks SONET(2)
	private String dfbela; // R28.Belast S/M/A   (1)
	private String dfkde; //  Etterkrav  /X  (1)
	private String dfgm; // R33.Godsmerke (1/2) (12)  
	private String dfgm2; // R33.Godsmerke (2/2) (12)
	private int dfnt; // R34.Ant kolli (sum)   SONET(7)
	private String dfvs; // R35.Type/Slag (1/2) (25)
	private String dfvs2; // R35.Type/Slag (2/2)    (25) 
	private int dfvkt; //  R36.Brt vekt (sum)  PAKKET(9) 
	//   DFMÅL      TEGN           17      17       898        Begge   POD:DT(8)TID(4)SG(5)
	private BigDecimal dfm3 = new BigDecimal(0); //  R37.Kub. METER PAKKET(7,3)
	private BigDecimal dflm = new BigDecimal(0); // Lastemeter   SONET(4,2)
	private int dfvktf; // R39.F.ber.vkt(sum)   PAKKET(9)
	private String dfkdme; // Merkelapp  /X    (1)
	private int dfntla; //  Ant. merkelapper     SONET(4)
	private int dffore; // Foretaksnr  SONET(9)
	private int dfrg; //  Regn Fylk.skatt.sjef SONET(8) 
	private int dfkta; // Tollkontonr-1   SONET(5)
	private int dfktb; // Tollkontonr-2    SONET(2)
	private String dfst2; // STATUS FOR SAD (1)
	private String dffase; // Faktura-sender  (25) 
	private BigDecimal dffvbl = new BigDecimal(0); // R24.Forsikringsverdi       PAKKET(9,2)
	private String dffvcu; // R24.F.verdi, valuta (3)
	private String dffkat; // R24.F.verdi,kategori   (4)
	private String dfpoli; // R26.Posisenr   (13)
	private String dfskfo; // R26.SKAL forsikres (1) 
	private String dflevb; // R27.Lev.betingelse (3)
	private String dflevt; // R27.Lev.bet.tekst (20)
	private String dflevi; // R30.Lev.innstruks (30)
	private int df6060; //  F.vekt i retur PAKKET(5)
	private int df500a; //  B.frakt i retur     Pakket(5)
	private int df500b; // Rabatt i retur      Pakket(5)
	private BigDecimal dfbele = new BigDecimal(0); // Etterkravsbeløp    PAKKET(9,2)  
	private String dffrku; // FRITT KUNDESPESIAL    (30)
	private String dfbref; // R18.Booking ref        (17)
	private String dftpk1; // TILLEGGS PROD.KODE 1   (5)
	private String dftpk2; // TILLEGGS PROD.KODE 2   (5)
	private String dftpk3; // TILLEGGS PROD.KODE 3     (5) 
	private String dftpk4; // TILLEGGS PROD.KODE 4    (5)
	private Map<String, Object> keys = new HashMap<String, Object>();

	
	public String getDfst() {
		return dfst;
	}

	public void setDfst(String dfst) {
		this.dfst = dfst;
	}

	public String getDfri() {
		return dfri;
	}

	public void setDfri(String dfri) {
		this.dfri = dfri;
	}

	public int getDfavd() {
		return dfavd;
	}

	public void setDfavd(int dfavd) {
		this.dfavd = dfavd;
	}

	public int getDfopd() {
		return dfopd;
	}

	public void setDfopd(int dfopd) {
		this.dfopd = dfopd;
	}

	public int getDffbnr() {
		return dffbnr;
	}

	public void setDffbnr(int dffbnr) {
		this.dffbnr = dffbnr;
	}

	public String getDfsg() {
		return dfsg;
	}

	public void setDfsg(String dfsg) {
		this.dfsg = dfsg;
	}

	public String getDfcmn() {
		return dfcmn;
	}

	public void setDfcmn(String dfcmn) {
		this.dfcmn = dfcmn;
	}

	public String getDfven() {
		return dfven;
	}

	public void setDfven(String dfven) {
		this.dfven = dfven;
	}

	public String getDf1004() {
		return df1004;
	}

	public void setDf1004(String df1004) {
		this.df1004 = df1004;
	}

	public int getDfdtu() {
		return dfdtu;
	}

	public void setDfdtu(int dfdtu) {
		this.dfdtu = dfdtu;
	}

	public int getDftoll() {
		return dftoll;
	}

	public void setDftoll(int dftoll) {
		this.dftoll = dftoll;
	}

	public int getDfknss() {
		return dfknss;
	}

	public void setDfknss(int dfknss) {
		this.dfknss = dfknss;
	}

	public String getDfnavs() {
		return dfnavs;
	}

	public void setDfnavs(String dfnavs) {
		this.dfnavs = dfnavs;
	}

	public String getDfad1s() {
		return dfad1s;
	}

	public void setDfad1s(String dfad1s) {
		this.dfad1s = dfad1s;
	}

	public String getDfad2s() {
		return dfad2s;
	}

	public void setDfad2s(String dfad2s) {
		this.dfad2s = dfad2s;
	}

	public int getDfpnls() {
		return dfpnls;
	}

	public void setDfpnls(int dfpnls) {
		this.dfpnls = dfpnls;
	}

	public String getDfad3s() {
		return dfad3s;
	}

	public void setDfad3s(String dfad3s) {
		this.dfad3s = dfad3s;
	}

	public String getDflks() {
		return dflks;
	}

	public void setDflks(String dflks) {
		this.dflks = dflks;
	}

	public String getDfpnus() {
		return dfpnus;
	}

	public void setDfpnus(String dfpnus) {
		this.dfpnus = dfpnus;
	}

	public String getDfkns() {
		return dfkns;
	}

	public void setDfkns(String dfkns) {
		this.dfkns = dfkns;
	}

	public String getDfsref() {
		return dfsref;
	}

	public void setDfsref(String dfsref) {
		this.dfsref = dfsref;
	}

	public int getDfpnat() {
		return dfpnat;
	}

	public void setDfpnat(int dfpnat) {
		this.dfpnat = dfpnat;
	}

	public int getDfknsm() {
		return dfknsm;
	}

	public void setDfknsm(int dfknsm) {
		this.dfknsm = dfknsm;
	}

	public String getDfnavm() {
		return dfnavm;
	}

	public void setDfnavm(String dfnavm) {
		this.dfnavm = dfnavm;
	}

	public String getDfad1m() {
		return dfad1m;
	}

	public void setDfad1m(String dfad1m) {
		this.dfad1m = dfad1m;
	}

	public String getDfad2m() {
		return dfad2m;
	}

	public void setDfad2m(String dfad2m) {
		this.dfad2m = dfad2m;
	}

	public String getDfad3m() {
		return dfad3m;
	}

	public void setDfad3m(String dfad3m) {
		this.dfad3m = dfad3m;
	}

	public String getDflkm() {
		return dflkm;
	}

	public void setDflkm(String dflkm) {
		this.dflkm = dflkm;
	}

	public String getDfpnum() {
		return dfpnum;
	}

	public void setDfpnum(String dfpnum) {
		this.dfpnum = dfpnum;
	}

	public String getDfknm() {
		return dfknm;
	}

	public void setDfknm(String dfknm) {
		this.dfknm = dfknm;
	}

	public String getDfmref() {
		return dfmref;
	}

	public void setDfmref(String dfmref) {
		this.dfmref = dfmref;
	}

	public String getDfnavl() {
		return dfnavl;
	}

	public void setDfnavl(String dfnavl) {
		this.dfnavl = dfnavl;
	}

	public String getDfad1l() {
		return dfad1l;
	}

	public void setDfad1l(String dfad1l) {
		this.dfad1l = dfad1l;
	}

	public String getDfad2l() {
		return dfad2l;
	}

	public void setDfad2l(String dfad2l) {
		this.dfad2l = dfad2l;
	}

	public int getDfpoul() {
		return dfpoul;
	}

	public void setDfpoul(int dfpoul) {
		this.dfpoul = dfpoul;
	}

	public String getDfadul() {
		return dfadul;
	}

	public void setDfadul(String dfadul) {
		this.dfadul = dfadul;
	}

	public String getDflkl() {
		return dflkl;
	}

	public void setDflkl(String dflkl) {
		this.dflkl = dflkl;
	}

	public String getDfpnul() {
		return dfpnul;
	}

	public void setDfpnul(String dfpnul) {
		this.dfpnul = dfpnul;
	}

	public int getDfknsx() {
		return dfknsx;
	}

	public void setDfknsx(int dfknsx) {
		this.dfknsx = dfknsx;
	}

	public String getDfnavx() {
		return dfnavx;
	}

	public void setDfnavx(String dfnavx) {
		this.dfnavx = dfnavx;
	}

	public String getDfad1x() {
		return dfad1x;
	}

	public void setDfad1x(String dfad1x) {
		this.dfad1x = dfad1x;
	}

	public String getDfad2x() {
		return dfad2x;
	}

	public void setDfad2x(String dfad2x) {
		this.dfad2x = dfad2x;
	}

	public String getDfad3x() {
		return dfad3x;
	}

	public void setDfad3x(String dfad3x) {
		this.dfad3x = dfad3x;
	}

	public String getDflkx() {
		return dflkx;
	}

	public void setDflkx(String dflkx) {
		this.dflkx = dflkx;
	}

	public String getDfpnux() {
		return dfpnux;
	}

	public void setDfpnux(String dfpnux) {
		this.dfpnux = dfpnux;
	}

	public String getDfknx() {
		return dfknx;
	}

	public void setDfknx(String dfknx) {
		this.dfknx = dfknx;
	}

	public String getDfover() {
		return dfover;
	}

	public void setDfover(String dfover) {
		this.dfover = dfover;
	}

	public int getDftran() {
		return dftran;
	}

	public void setDftran(int dftran) {
		this.dftran = dftran;
	}

	public String getDfnat() {
		return dfnat;
	}

	public void setDfnat(String dfnat) {
		this.dfnat = dfnat;
	}

	public String getDfprok() {
		return dfprok;
	}

	public void setDfprok(String dfprok) {
		this.dfprok = dfprok;
	}

	public String getDfpro1() {
		return dfpro1;
	}

	public void setDfpro1(String dfpro1) {
		this.dfpro1 = dfpro1;
	}

	public String getDfpro2() {
		return dfpro2;
	}

	public void setDfpro2(String dfpro2) {
		this.dfpro2 = dfpro2;
	}

	public int getDfnteu() {
		return dfnteu;
	}

	public void setDfnteu(int dfnteu) {
		this.dfnteu = dfnteu;
	}

	public int getDfntau() {
		return dfntau;
	}

	public void setDfntau(int dfntau) {
		this.dfntau = dfntau;
	}

	public String getDfbela() {
		return dfbela;
	}

	public void setDfbela(String dfbela) {
		this.dfbela = dfbela;
	}

	public String getDfkde() {
		return dfkde;
	}

	public void setDfkde(String dfkde) {
		this.dfkde = dfkde;
	}

	public String getDfgm() {
		return dfgm;
	}

	public void setDfgm(String dfgm) {
		this.dfgm = dfgm;
	}

	public String getDfgm2() {
		return dfgm2;
	}

	public void setDfgm2(String dfgm2) {
		this.dfgm2 = dfgm2;
	}

	public int getDfnt() {
		return dfnt;
	}

	public void setDfnt(int dfnt) {
		this.dfnt = dfnt;
	}

	public String getDfvs() {
		return dfvs;
	}

	public void setDfvs(String dfvs) {
		this.dfvs = dfvs;
	}

	public String getDfvs2() {
		return dfvs2;
	}

	public void setDfvs2(String dfvs2) {
		this.dfvs2 = dfvs2;
	}

	public int getDfvkt() {
		return dfvkt;
	}

	public void setDfvkt(int dfvkt) {
		this.dfvkt = dfvkt;
	}

	public BigDecimal getDfm3() {
		return dfm3;
	}

	public void setDfm3(BigDecimal dfm3) {
		this.dfm3 = dfm3;
	}

	public BigDecimal getDflm() {
		return dflm;
	}

	public void setDflm(BigDecimal dflm) {
		this.dflm = dflm;
	}

	public int getDfvktf() {
		return dfvktf;
	}

	public void setDfvktf(int dfvktf) {
		this.dfvktf = dfvktf;
	}

	public String getDfkdme() {
		return dfkdme;
	}

	public void setDfkdme(String dfkdme) {
		this.dfkdme = dfkdme;
	}

	public int getDfntla() {
		return dfntla;
	}

	public void setDfntla(int dfntla) {
		this.dfntla = dfntla;
	}

	public int getDffore() {
		return dffore;
	}

	public void setDffore(int dffore) {
		this.dffore = dffore;
	}

	public int getDfrg() {
		return dfrg;
	}

	public void setDfrg(int dfrg) {
		this.dfrg = dfrg;
	}

	public int getDfkta() {
		return dfkta;
	}

	public void setDfkta(int dfkta) {
		this.dfkta = dfkta;
	}

	public int getDfktb() {
		return dfktb;
	}

	public void setDfktb(int dfktb) {
		this.dfktb = dfktb;
	}

	public String getDfst2() {
		return dfst2;
	}

	public void setDfst2(String dfst2) {
		this.dfst2 = dfst2;
	}

	public String getDffase() {
		return dffase;
	}

	public void setDffase(String dffase) {
		this.dffase = dffase;
	}

	public BigDecimal getDffvbl() {
		return dffvbl;
	}

	public void setDffvbl(BigDecimal dffvbl) {
		this.dffvbl = dffvbl;
	}

	public String getDffvcu() {
		return dffvcu;
	}

	public void setDffvcu(String dffvcu) {
		this.dffvcu = dffvcu;
	}

	public String getDffkat() {
		return dffkat;
	}

	public void setDffkat(String dffkat) {
		this.dffkat = dffkat;
	}

	public String getDfpoli() {
		return dfpoli;
	}

	public void setDfpoli(String dfpoli) {
		this.dfpoli = dfpoli;
	}

	public String getDfskfo() {
		return dfskfo;
	}

	public void setDfskfo(String dfskfo) {
		this.dfskfo = dfskfo;
	}

	public String getDflevb() {
		return dflevb;
	}

	public void setDflevb(String dflevb) {
		this.dflevb = dflevb;
	}

	public String getDflevt() {
		return dflevt;
	}

	public void setDflevt(String dflevt) {
		this.dflevt = dflevt;
	}

	public String getDflevi() {
		return dflevi;
	}

	public void setDflevi(String dflevi) {
		this.dflevi = dflevi;
	}

	public int getDf6060() {
		return df6060;
	}

	public void setDf6060(int df6060) {
		this.df6060 = df6060;
	}

	public int getDf500a() {
		return df500a;
	}

	public void setDf500a(int df500a) {
		this.df500a = df500a;
	}

	public int getDf500b() {
		return df500b;
	}

	public void setDf500b(int df500b) {
		this.df500b = df500b;
	}

	public BigDecimal getDfbele() {
		return dfbele;
	}

	public void setDfbele(BigDecimal dfbele) {
		this.dfbele = dfbele;
	}

	public String getDffrku() {
		return dffrku;
	}

	public void setDffrku(String dffrku) {
		this.dffrku = dffrku;
	}

	public String getDfbref() {
		return dfbref;
	}

	public void setDfbref(String dfbref) {
		this.dfbref = dfbref;
	}

	public String getDftpk1() {
		return dftpk1;
	}

	public void setDftpk1(String dftpk1) {
		this.dftpk1 = dftpk1;
	}

	public String getDftpk2() {
		return dftpk2;
	}

	public void setDftpk2(String dftpk2) {
		this.dftpk2 = dftpk2;
	}

	public String getDftpk3() {
		return dftpk3;
	}

	public void setDftpk3(String dftpk3) {
		this.dftpk3 = dftpk3;
	}

	public String getDftpk4() {
		return dftpk4;
	}

	public void setDftpk4(String dftpk4) {
		this.dftpk4 = dftpk4;
	}
	
	

	@Override
	public Map<String, Object> getKeys() {
		keys.put("dfavd", dfavd);
		keys.put("dfopd", dfopd);
		keys.put("dffbnr", dffbnr);
		return keys;
	}

}
