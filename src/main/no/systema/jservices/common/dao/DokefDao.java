package no.systema.jservices.common.dao;

import java.math. BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

/**
 * Fly Fraktbrev (common for Import and Export)
 * 
 * @author Oscar de la Torre
 * @date Feb 19, 2018
 */
@Data
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
