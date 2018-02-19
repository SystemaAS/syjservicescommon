package no.systema.jservices.common.dao;

import java.math. BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * Fly Fraktbrev (common for Import and Export)
 * 
 * @author Oscar de la Torre
 * @date Feb 19, 2018
 */
public class DokefDao implements IDao {

	 private String dfst;       //status                                   1    1     1         a
	 private String dfxx1;      //ledige 55 lang                           2   55    54         a
	 private String dftlfs;     //telefonnummer 15                        56   70    15         a
	 private String dftlfk;     //telefonnummer 15                        71   85    15         a
	 private String dfkddc;     //due carrier kode                        86   86     1         a
	 private BigDecimal dfbldc = new BigDecimal (0);    //due carrier beløp                       87   95     9   9   2 s
	 private String dfinf1;     //informasjon-1                           96  130    35         a
	 private String dfinf2;     //informasjon-2                          131  165    35         a
	 private String dfvs7;      //vareslag                               166  190    25         a
	 private String dfvs8;      //vareslag                               191  215    25         a
	 private String dfvs9;      //vareslag                               216  240    25         a
	 private String dfvs10;     //vareslag                               241  265    25         a
	 private String dfxx2;      //ledige 22 lang                         266  287    22         a
	 private String dfft;       //dokument tekst                         288  328    41         a
	 private String dfsg;      //signatur                               329  331     3         a
	 private int  dffsn = 0;      //flyselskapsnr.                         332  334     3   3   0 s
	 private String dfroa1;     //routing a                              335  337     3         a
	 private String dfrob1;     //routing b                              338  344     7         a
	 private int  dfroc1 = 0;     //routing c                              345  346     2   2   0 s
	 private String dfroa2;     //routing a                              347  349     3         a
	 private String dfrob2;     //routing b                              350  356     7         a
	 private int  dfroc2 = 0;     //routing c                              357  358     2   2   0 s
	 private String dfroa3;     //routing a                              359  361     3         a
	 private String dfrob3;     //routing b                              362  368     7         a
	 private int  dfroc3 = 0;     //routing c                              369  370     2   2   0 s
	 private String dfval;      //valutakode                             371  373     3         a
	 private String dfccpp;     //ccpp pâ fraktbrev                      374  375     2         a
	 private String dfdvca;     //decl. value carriage                   376  382     7         a
	 private String dfdvcu;     //decl. value customs                    383  389     7         a
	 private BigDecimal dfbelf = new BigDecimal (0);     //forikring belÿp                        390  396     7   7   0 s
	 private String dfinfa;     //fritekst                               397  467    71         a
	 private String dfinfb;     //fritekst                               468  538    71         a
	 private String dfinfc;     //fritekst                               539  609    71         a
	 private String dfnt1;     //antall                                 610  613     4         a
	 private BigDecimal dfvkt1 = new BigDecimal (0);     //vekt-1                                 614  617     4   7   1 p
	 private String dfrc1;      //rate class                             618  618     1         a
	 private String dfcom1;     //commdity                               619  622     4         a
	 private BigDecimal dffbv1 = new BigDecimal (0);    //fraktbr.vekt-1                         623  626     4   7   1 p
	 private String dfrk1;      //rate kode                              627  627     1         a
	 private BigDecimal dfrpr1 = new BigDecimal(0);     //bel¯p                                  628  635     8   8   2 s
	 private BigDecimal dfblt1 = new BigDecimal(0);     //bel¯p                                  636  645    10  10   2 s
	 private String dfvs1;      //vareslag                               646  670    25         a
	 private String dfnt2;      //antall                                 671  674     4         a
	 private BigDecimal dfvkt2 = new BigDecimal (0);     //vekt-2                                 675  678     4   7   1 p
	 private String dfrc2;      //rate class                             679  679     1         a
	 private String dfcom2;     //commdity                               680  683     4         a
	 private BigDecimal dffbv2 = new BigDecimal (0);     //fraktbr.vekt-2                         684  687     4   7   1 p
	 private String dfrk2;      //rate kode                              688  688     1         a
	 private BigDecimal dfrpr2 = new BigDecimal(0);     //bel¯p                                  689  696     8   8   2 s
	 private BigDecimal dfblt2 = new BigDecimal(0);    //bel¯p                                  697  706    10  10   2 s
	 private String dfvs2;      //vareslag                               707  731    25         a
	 private String dfnt3;      //antall                                 732  735     4         a
	 private BigDecimal dfvkt3 = new BigDecimal(0);     //vekt-3                                 736  739     4   7   1 p
	 
	 private String dfrc3;      //rate class                             740  740     1         a
	 private String dfcom3;     //commdity                               741  744     4         a
	 private BigDecimal dffbv3 = new BigDecimal(0);     //fraktbr.vekt-3                         745  748     4   7   1 p
	 private String dfrk3;      //rate kode                              749  749     1         a
	 private BigDecimal dfrpr3 = new BigDecimal(0);     //bel¯p                                  750  757     8   8   2 s
	 private BigDecimal dfblt3 = new BigDecimal(0);    //bel¯p                                  758  767    10  10   2 s
	 private String dfvs3;      //vareslag                               768  792    25         a
	 private String dfnt4;      //antall                                 793  796     4         a
	 private BigDecimal dfvkt4 = new BigDecimal(0);    //vekt-4                                 797  800     4   7   1 p
	 private String dfrc4;      //rate class                             801  801     1         a
	 private String dfcom4;     //commdity                               802  805     4         a
	 private BigDecimal dffbv4 = new BigDecimal(0);    //fraktbr.vekt-4                         806  809     4   7   1 p
	 private String dfrk4;      //rate kode                              810  810     1         a
	 private BigDecimal dfrpr4 = new BigDecimal(0);    //bel¯p                                  811  818     8   8   2 s
	 private BigDecimal dfblt4 = new BigDecimal(0);   //bel¯p                                  819  828    10  10   2 s
	 private String dfvs4;      //vareslag                               829  853    25         a
	 private String dfnt5;      //antall                                 854  857     4         a
	 private BigDecimal dfvkt5 = new BigDecimal(0);   //vekt-5                                 858  861     4   7   1 p
	 private String dfrc5;      //rate class                             862  862     1         a
	 private String dfcom5;     //commdity                               863  866     4         a
	 private BigDecimal dffbv5 = new BigDecimal(0);    //fraktbr.vekt-5                         867  870     4   7   1 p
	 private String dfrk5;      //rate kode                              871  871     1         a
	 private BigDecimal dfrpr5 = new BigDecimal(0);    //bel¯p                                  872  879     8   8   2 s
	 private BigDecimal dfblt5 = new BigDecimal(0);  //bel¯p                                  880  889    10  10   2 s
	 private String dfvs5;      //vareslag                               890  914    25         a
	 private String dfnt6;      //antall                                 915  918     4         a
	 private BigDecimal dfvkt6 = new BigDecimal(0);    //vekt-6                                 919  922     4   7   1 p
	 private String dfrc6 ;     //rate class                             923  923     1         a
	 private String dfcom6;     //commdity                               924  927     4         a
	 private BigDecimal dffbv6 = new BigDecimal(0);    //fraktbr.vekt-6                         928  931     4   7   1 p
	 private String dfrk6;      //rate kode                              932  932     1         a
	 private BigDecimal dfrpr6 = new  BigDecimal(0);    //bel¯p                                  933  940     8   8   2 s
	 private BigDecimal dfblt6 = new  BigDecimal(0);     //bel¯p                                  941  950    10  10   2 s
	 private String dfvs6;      //kundenr selger                         951  975    25         a
	 private BigDecimal dfntt = new  BigDecimal(0);      //antall                                 976  979     4   4   0 s
	 private BigDecimal dfblt = new  BigDecimal(0);      //bel¯p                                  980  984     5   9   2 p
	 private BigDecimal dfvktt = new  BigDecimal(0);     //totall vekt                            985  988     4   7   1 p
	 private BigDecimal dfbla = new  BigDecimal(0);      //bel¯p                                  989  993     5   9   2 p
	 private BigDecimal dfblav = new  BigDecimal(0);     //avgift belÿp                           994  998     5   9   2 p
	 private String dfkdme;     //merkelapp  /x                          999  999     1         a
	 private String dfxx3;      //ledige                                1000 1006     7         a
	 private String dfri;       //record id                             1007 1007     1         a
	 private int  dfavd  = 0;     //avdeling                              1008 1011     4   4   0 s
	 private int  dfopd  = 0;    //oppdragsnummer                        1012 1018     7   7   0 s
	 private int  dflop  = 0;    //lopenr                                1019 1021     3   3   0 s
	 private String dfcmn;      //comunication                          1022 1022     1         a
	 private int  dftrid = 0;     //cmn. trans id                         1023 1027     5   9   0 p
	 private String dftols;     //tollstatus                            1028 1029     2         a
	 private int  dfetd1  = 0;     //est tim dep-1                         1030 1033     4   4   0 s
	 private int  dfeta1  = 0;     //est tim arr-1                         1034 1037     4   4   0 s
	 private int  dfeda1  = 0;     //est day arr-1                         1038 1039     2   2   0 s
	 private int  dfetd2  = 0;     //est tim dep-2                         1040 1043     4   4   0 s
	 private int  dfeta2  = 0;     //est tim arr-2                         1044 1047     4   4   0 s
	 private int  dfeda2  = 0;     //est day arr-2                         1048 1049     2   2   0 s
	 private int  dfetd3  = 0;     //est tim dep-3                         1050 1053     4   4   0 s
	 private int  dfeta3  = 0;     //est tim arr-3                         1054 1057     4   4   0 s
	 private int  dfeda3  = 0;     //est day arr-3                         1058 1059     2   2   0 s
	 private BigDecimal dffuel = new  BigDecimal(0);    //fuel surcharge                        1060 1068     9   9   2 s
	 private BigDecimal dfnett = new  BigDecimal(0);     //netto frakt                           1069 1077     9   9   2 s
	 private String dfsph1;     //sph code-1                            1078 1080     3         a
	 private String dfsph2;    //sph code-2                            1081 1083     3         a
	 private String dfsph3;     //sph code-3                            1084 1086     3         a
	 private String dfsph4;     //sph code-4                            1087 1089     3         a
	 private String dfsph5;     //sph code-5                            1090 1092     3         a
	 private String dfsph6;     //sph code-6                            1093 1095     3         a
	 private String dfsph7;     //sph code-7                            1096 1098     3         a
	 private String dfsph8;     //sph code-8                            1099 1101     3         a
	 private String dfsph9;     //sph code-9                            1102 1104     3         a
	 private Map<String, Object> keys = new HashMap<String, Object>();

	 
	 
	 
	public String getDfst() {
		return dfst;
	}
	public void setDfst(String dfst) {
		this.dfst = dfst;
	}
	public String getDfxx1() {
		return dfxx1;
	}
	public void setDfxx1(String dfxx1) {
		this.dfxx1 = dfxx1;
	}
	public String getDftlfs() {
		return dftlfs;
	}
	public void setDftlfs(String dftlfs) {
		this.dftlfs = dftlfs;
	}
	public String getDftlfk() {
		return dftlfk;
	}
	public void setDftlfk(String dftlfk) {
		this.dftlfk = dftlfk;
	}
	public String getDfkddc() {
		return dfkddc;
	}
	public void setDfkddc(String dfkddc) {
		this.dfkddc = dfkddc;
	}
	public BigDecimal getDfbldc() {
		return dfbldc;
	}
	public void setDfbldc(BigDecimal dfbldc) {
		this.dfbldc = dfbldc;
	}
	public String getDfinf1() {
		return dfinf1;
	}
	public void setDfinf1(String dfinf1) {
		this.dfinf1 = dfinf1;
	}
	public String getDfinf2() {
		return dfinf2;
	}
	public void setDfinf2(String dfinf2) {
		this.dfinf2 = dfinf2;
	}
	public String getDfvs7() {
		return dfvs7;
	}
	public void setDfvs7(String dfvs7) {
		this.dfvs7 = dfvs7;
	}
	public String getDfvs8() {
		return dfvs8;
	}
	public void setDfvs8(String dfvs8) {
		this.dfvs8 = dfvs8;
	}
	public String getDfvs9() {
		return dfvs9;
	}
	public void setDfvs9(String dfvs9) {
		this.dfvs9 = dfvs9;
	}
	public String getDfvs10() {
		return dfvs10;
	}
	public void setDfvs10(String dfvs10) {
		this.dfvs10 = dfvs10;
	}
	public String getDfxx2() {
		return dfxx2;
	}
	public void setDfxx2(String dfxx2) {
		this.dfxx2 = dfxx2;
	}
	public String getDfft() {
		return dfft;
	}
	public void setDfft(String dfft) {
		this.dfft = dfft;
	}
	public String getDfsg() {
		return dfsg;
	}
	public void setDfsg(String dfsg) {
		this.dfsg = dfsg;
	}
	public int getDffsn() {
		return dffsn;
	}
	public void setDffsn(int dffsn) {
		this.dffsn = dffsn;
	}
	public String getDfroa1() {
		return dfroa1;
	}
	public void setDfroa1(String dfroa1) {
		this.dfroa1 = dfroa1;
	}
	public String getDfrob1() {
		return dfrob1;
	}
	public void setDfrob1(String dfrob1) {
		this.dfrob1 = dfrob1;
	}
	public int getDfroc1() {
		return dfroc1;
	}
	public void setDfroc1(int dfroc1) {
		this.dfroc1 = dfroc1;
	}
	public String getDfroa2() {
		return dfroa2;
	}
	public void setDfroa2(String dfroa2) {
		this.dfroa2 = dfroa2;
	}
	public String getDfrob2() {
		return dfrob2;
	}
	public void setDfrob2(String dfrob2) {
		this.dfrob2 = dfrob2;
	}
	public int getDfroc2() {
		return dfroc2;
	}
	public void setDfroc2(int dfroc2) {
		this.dfroc2 = dfroc2;
	}
	public String getDfroa3() {
		return dfroa3;
	}
	public void setDfroa3(String dfroa3) {
		this.dfroa3 = dfroa3;
	}
	public String getDfrob3() {
		return dfrob3;
	}
	public void setDfrob3(String dfrob3) {
		this.dfrob3 = dfrob3;
	}
	public int getDfroc3() {
		return dfroc3;
	}
	public void setDfroc3(int dfroc3) {
		this.dfroc3 = dfroc3;
	}
	public String getDfval() {
		return dfval;
	}
	public void setDfval(String dfval) {
		this.dfval = dfval;
	}
	public String getDfccpp() {
		return dfccpp;
	}
	public void setDfccpp(String dfccpp) {
		this.dfccpp = dfccpp;
	}
	public String getDfdvca() {
		return dfdvca;
	}
	public void setDfdvca(String dfdvca) {
		this.dfdvca = dfdvca;
	}
	public String getDfdvcu() {
		return dfdvcu;
	}
	public void setDfdvcu(String dfdvcu) {
		this.dfdvcu = dfdvcu;
	}
	public BigDecimal getDfbelf() {
		return dfbelf;
	}
	public void setDfbelf(BigDecimal dfbelf) {
		this.dfbelf = dfbelf;
	}
	public String getDfinfa() {
		return dfinfa;
	}
	public void setDfinfa(String dfinfa) {
		this.dfinfa = dfinfa;
	}
	public String getDfinfb() {
		return dfinfb;
	}
	public void setDfinfb(String dfinfb) {
		this.dfinfb = dfinfb;
	}
	public String getDfinfc() {
		return dfinfc;
	}
	public void setDfinfc(String dfinfc) {
		this.dfinfc = dfinfc;
	}
	public String getDfnt1() {
		return dfnt1;
	}
	public void setDfnt1(String dfnt1) {
		this.dfnt1 = dfnt1;
	}
	public BigDecimal getDfvkt1() {
		return dfvkt1;
	}
	public void setDfvkt1(BigDecimal dfvkt1) {
		this.dfvkt1 = dfvkt1;
	}
	public String getDfrc1() {
		return dfrc1;
	}
	public void setDfrc1(String dfrc1) {
		this.dfrc1 = dfrc1;
	}
	public String getDfcom1() {
		return dfcom1;
	}
	public void setDfcom1(String dfcom1) {
		this.dfcom1 = dfcom1;
	}
	public BigDecimal getDffbv1() {
		return dffbv1;
	}
	public void setDffbv1(BigDecimal dffbv1) {
		this.dffbv1 = dffbv1;
	}
	public String getDfrk1() {
		return dfrk1;
	}
	public void setDfrk1(String dfrk1) {
		this.dfrk1 = dfrk1;
	}
	public BigDecimal getDfrpr1() {
		return dfrpr1;
	}
	public void setDfrpr1(BigDecimal dfrpr1) {
		this.dfrpr1 = dfrpr1;
	}
	public BigDecimal getDfblt1() {
		return dfblt1;
	}
	public void setDfblt1(BigDecimal dfblt1) {
		this.dfblt1 = dfblt1;
	}
	public String getDfvs1() {
		return dfvs1;
	}
	public void setDfvs1(String dfvs1) {
		this.dfvs1 = dfvs1;
	}
	public String getDfnt2() {
		return dfnt2;
	}
	public void setDfnt2(String dfnt2) {
		this.dfnt2 = dfnt2;
	}
	public BigDecimal getDfvkt2() {
		return dfvkt2;
	}
	public void setDfvkt2(BigDecimal dfvkt2) {
		this.dfvkt2 = dfvkt2;
	}
	public String getDfrc2() {
		return dfrc2;
	}
	public void setDfrc2(String dfrc2) {
		this.dfrc2 = dfrc2;
	}
	public String getDfcom2() {
		return dfcom2;
	}
	public void setDfcom2(String dfcom2) {
		this.dfcom2 = dfcom2;
	}
	public BigDecimal getDffbv2() {
		return dffbv2;
	}
	public void setDffbv2(BigDecimal dffbv2) {
		this.dffbv2 = dffbv2;
	}
	public String getDfrk2() {
		return dfrk2;
	}
	public void setDfrk2(String dfrk2) {
		this.dfrk2 = dfrk2;
	}
	public BigDecimal getDfrpr2() {
		return dfrpr2;
	}
	public void setDfrpr2(BigDecimal dfrpr2) {
		this.dfrpr2 = dfrpr2;
	}
	public BigDecimal getDfblt2() {
		return dfblt2;
	}
	public void setDfblt2(BigDecimal dfblt2) {
		this.dfblt2 = dfblt2;
	}
	public String getDfvs2() {
		return dfvs2;
	}
	public void setDfvs2(String dfvs2) {
		this.dfvs2 = dfvs2;
	}
	public String getDfnt3() {
		return dfnt3;
	}
	public void setDfnt3(String dfnt3) {
		this.dfnt3 = dfnt3;
	}
	public BigDecimal getDfvkt3() {
		return dfvkt3;
	}
	public void setDfvkt3(BigDecimal dfvkt3) {
		this.dfvkt3 = dfvkt3;
	}
	public String getDfrc3() {
		return dfrc3;
	}
	public void setDfrc3(String dfrc3) {
		this.dfrc3 = dfrc3;
	}
	public String getDfcom3() {
		return dfcom3;
	}
	public void setDfcom3(String dfcom3) {
		this.dfcom3 = dfcom3;
	}
	public BigDecimal getDffbv3() {
		return dffbv3;
	}
	public void setDffbv3(BigDecimal dffbv3) {
		this.dffbv3 = dffbv3;
	}
	public String getDfrk3() {
		return dfrk3;
	}
	public void setDfrk3(String dfrk3) {
		this.dfrk3 = dfrk3;
	}
	public BigDecimal getDfrpr3() {
		return dfrpr3;
	}
	public void setDfrpr3(BigDecimal dfrpr3) {
		this.dfrpr3 = dfrpr3;
	}
	public BigDecimal getDfblt3() {
		return dfblt3;
	}
	public void setDfblt3(BigDecimal dfblt3) {
		this.dfblt3 = dfblt3;
	}
	public String getDfvs3() {
		return dfvs3;
	}
	public void setDfvs3(String dfvs3) {
		this.dfvs3 = dfvs3;
	}
	public String getDfnt4() {
		return dfnt4;
	}
	public void setDfnt4(String dfnt4) {
		this.dfnt4 = dfnt4;
	}
	public BigDecimal getDfvkt4() {
		return dfvkt4;
	}
	public void setDfvkt4(BigDecimal dfvkt4) {
		this.dfvkt4 = dfvkt4;
	}
	public String getDfrc4() {
		return dfrc4;
	}
	public void setDfrc4(String dfrc4) {
		this.dfrc4 = dfrc4;
	}
	public String getDfcom4() {
		return dfcom4;
	}
	public void setDfcom4(String dfcom4) {
		this.dfcom4 = dfcom4;
	}
	public BigDecimal getDffbv4() {
		return dffbv4;
	}
	public void setDffbv4(BigDecimal dffbv4) {
		this.dffbv4 = dffbv4;
	}
	public String getDfrk4() {
		return dfrk4;
	}
	public void setDfrk4(String dfrk4) {
		this.dfrk4 = dfrk4;
	}
	public BigDecimal getDfrpr4() {
		return dfrpr4;
	}
	public void setDfrpr4(BigDecimal dfrpr4) {
		this.dfrpr4 = dfrpr4;
	}
	public BigDecimal getDfblt4() {
		return dfblt4;
	}
	public void setDfblt4(BigDecimal dfblt4) {
		this.dfblt4 = dfblt4;
	}
	public String getDfvs4() {
		return dfvs4;
	}
	public void setDfvs4(String dfvs4) {
		this.dfvs4 = dfvs4;
	}
	public String getDfnt5() {
		return dfnt5;
	}
	public void setDfnt5(String dfnt5) {
		this.dfnt5 = dfnt5;
	}
	public BigDecimal getDfvkt5() {
		return dfvkt5;
	}
	public void setDfvkt5(BigDecimal dfvkt5) {
		this.dfvkt5 = dfvkt5;
	}
	public String getDfrc5() {
		return dfrc5;
	}
	public void setDfrc5(String dfrc5) {
		this.dfrc5 = dfrc5;
	}
	public String getDfcom5() {
		return dfcom5;
	}
	public void setDfcom5(String dfcom5) {
		this.dfcom5 = dfcom5;
	}
	public BigDecimal getDffbv5() {
		return dffbv5;
	}
	public void setDffbv5(BigDecimal dffbv5) {
		this.dffbv5 = dffbv5;
	}
	public String getDfrk5() {
		return dfrk5;
	}
	public void setDfrk5(String dfrk5) {
		this.dfrk5 = dfrk5;
	}
	public BigDecimal getDfrpr5() {
		return dfrpr5;
	}
	public void setDfrpr5(BigDecimal dfrpr5) {
		this.dfrpr5 = dfrpr5;
	}
	public BigDecimal getDfblt5() {
		return dfblt5;
	}
	public void setDfblt5(BigDecimal dfblt5) {
		this.dfblt5 = dfblt5;
	}
	public String getDfvs5() {
		return dfvs5;
	}
	public void setDfvs5(String dfvs5) {
		this.dfvs5 = dfvs5;
	}
	public String getDfnt6() {
		return dfnt6;
	}
	public void setDfnt6(String dfnt6) {
		this.dfnt6 = dfnt6;
	}
	public BigDecimal getDfvkt6() {
		return dfvkt6;
	}
	public void setDfvkt6(BigDecimal dfvkt6) {
		this.dfvkt6 = dfvkt6;
	}
	public String getDfrc6() {
		return dfrc6;
	}
	public void setDfrc6(String dfrc6) {
		this.dfrc6 = dfrc6;
	}
	public String getDfcom6() {
		return dfcom6;
	}
	public void setDfcom6(String dfcom6) {
		this.dfcom6 = dfcom6;
	}
	public BigDecimal getDffbv6() {
		return dffbv6;
	}
	public void setDffbv6(BigDecimal dffbv6) {
		this.dffbv6 = dffbv6;
	}
	public String getDfrk6() {
		return dfrk6;
	}
	public void setDfrk6(String dfrk6) {
		this.dfrk6 = dfrk6;
	}
	public BigDecimal getDfrpr6() {
		return dfrpr6;
	}
	public void setDfrpr6(BigDecimal dfrpr6) {
		this.dfrpr6 = dfrpr6;
	}
	public BigDecimal getDfblt6() {
		return dfblt6;
	}
	public void setDfblt6(BigDecimal dfblt6) {
		this.dfblt6 = dfblt6;
	}
	public String getDfvs6() {
		return dfvs6;
	}
	public void setDfvs6(String dfvs6) {
		this.dfvs6 = dfvs6;
	}
	public BigDecimal getDfntt() {
		return dfntt;
	}
	public void setDfntt(BigDecimal dfntt) {
		this.dfntt = dfntt;
	}
	public BigDecimal getDfblt() {
		return dfblt;
	}
	public void setDfblt(BigDecimal dfblt) {
		this.dfblt = dfblt;
	}
	public BigDecimal getDfvktt() {
		return dfvktt;
	}
	public void setDfvktt(BigDecimal dfvktt) {
		this.dfvktt = dfvktt;
	}
	public BigDecimal getDfbla() {
		return dfbla;
	}
	public void setDfbla(BigDecimal dfbla) {
		this.dfbla = dfbla;
	}
	public BigDecimal getDfblav() {
		return dfblav;
	}
	public void setDfblav(BigDecimal dfblav) {
		this.dfblav = dfblav;
	}
	public String getDfkdme() {
		return dfkdme;
	}
	public void setDfkdme(String dfkdme) {
		this.dfkdme = dfkdme;
	}
	public String getDfxx3() {
		return dfxx3;
	}
	public void setDfxx3(String dfxx3) {
		this.dfxx3 = dfxx3;
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
	public int getDflop() {
		return dflop;
	}
	public void setDflop(int dflop) {
		this.dflop = dflop;
	}
	public String getDfcmn() {
		return dfcmn;
	}
	public void setDfcmn(String dfcmn) {
		this.dfcmn = dfcmn;
	}
	public int getDftrid() {
		return dftrid;
	}
	public void setDftrid(int dftrid) {
		this.dftrid = dftrid;
	}
	public String getDftols() {
		return dftols;
	}
	public void setDftols(String dftols) {
		this.dftols = dftols;
	}
	public int getDfetd1() {
		return dfetd1;
	}
	public void setDfetd1(int dfetd1) {
		this.dfetd1 = dfetd1;
	}
	public int getDfeta1() {
		return dfeta1;
	}
	public void setDfeta1(int dfeta1) {
		this.dfeta1 = dfeta1;
	}
	public int getDfeda1() {
		return dfeda1;
	}
	public void setDfeda1(int dfeda1) {
		this.dfeda1 = dfeda1;
	}
	public int getDfetd2() {
		return dfetd2;
	}
	public void setDfetd2(int dfetd2) {
		this.dfetd2 = dfetd2;
	}
	public int getDfeta2() {
		return dfeta2;
	}
	public void setDfeta2(int dfeta2) {
		this.dfeta2 = dfeta2;
	}
	public int getDfeda2() {
		return dfeda2;
	}
	public void setDfeda2(int dfeda2) {
		this.dfeda2 = dfeda2;
	}
	public int getDfetd3() {
		return dfetd3;
	}
	public void setDfetd3(int dfetd3) {
		this.dfetd3 = dfetd3;
	}
	public int getDfeta3() {
		return dfeta3;
	}
	public void setDfeta3(int dfeta3) {
		this.dfeta3 = dfeta3;
	}
	public int getDfeda3() {
		return dfeda3;
	}
	public void setDfeda3(int dfeda3) {
		this.dfeda3 = dfeda3;
	}
	public BigDecimal getDffuel() {
		return dffuel;
	}
	public void setDffuel(BigDecimal dffuel) {
		this.dffuel = dffuel;
	}
	public BigDecimal getDfnett() {
		return dfnett;
	}
	public void setDfnett(BigDecimal dfnett) {
		this.dfnett = dfnett;
	}
	public String getDfsph1() {
		return dfsph1;
	}
	public void setDfsph1(String dfsph1) {
		this.dfsph1 = dfsph1;
	}
	public String getDfsph2() {
		return dfsph2;
	}
	public void setDfsph2(String dfsph2) {
		this.dfsph2 = dfsph2;
	}
	public String getDfsph3() {
		return dfsph3;
	}
	public void setDfsph3(String dfsph3) {
		this.dfsph3 = dfsph3;
	}
	public String getDfsph4() {
		return dfsph4;
	}
	public void setDfsph4(String dfsph4) {
		this.dfsph4 = dfsph4;
	}
	public String getDfsph5() {
		return dfsph5;
	}
	public void setDfsph5(String dfsph5) {
		this.dfsph5 = dfsph5;
	}
	public String getDfsph6() {
		return dfsph6;
	}
	public void setDfsph6(String dfsph6) {
		this.dfsph6 = dfsph6;
	}
	public String getDfsph7() {
		return dfsph7;
	}
	public void setDfsph7(String dfsph7) {
		this.dfsph7 = dfsph7;
	}
	public String getDfsph8() {
		return dfsph8;
	}
	public void setDfsph8(String dfsph8) {
		this.dfsph8 = dfsph8;
	}
	public String getDfsph9() {
		return dfsph9;
	}
	public void setDfsph9(String dfsph9) {
		this.dfsph9 = dfsph9;
	}
	 
	@Override
	public Map<String, Object> getKeys() {
		keys.put("dfavd", dfavd);
		keys.put("dfopd", dfopd);
		keys.put("dflop", dflop);
		return keys;
	}
	
	//alternative 
			public void setKeys(int avd, int opd, int lop) {
				keys.put("dfavd", avd);
				keys.put("dfopd", opd);
				keys.put("dflop", lop);		
			}
			//alternative
			public void setKeys(int avd, int opd) {
				keys.put("dfavd", avd);
				keys.put("dfopd", opd);
			}

	 
}
