package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.HeadfDao;

public class DokufDaoServiceImpl extends GenericDaoServiceImpl<DokufDao> implements DokufDaoService{

	@Override
	public void create(HeadfDao headfDao) {
		DokufDao newDao = getPopulatedDao(headfDao);
		super.create(newDao);
		
	}

	
	private DokufDao getPopulatedDao(HeadfDao headfDao) {
		DokufDao newDao = new DokufDao();
		newDao.setDfst(" ");
		newDao.setDfri("F");
		newDao.setDfavd(headfDao.getHeavd());
		newDao.setDfopd(headfDao.getHeopd());
		//newDao.getDffbnr(??);
		newDao.setDfsg(headfDao.getHesg());
		newDao.setDf1004(firfbDaoService.getSendningsnr());
		newDao.setDfknss(headfDao.getHekns());
		newDao.setDfnavs(headfDao.getHenas());
		newDao.setDfad1s(headfDao.getHeads1());
		newDao.setDfad2s(" ");
		newDao.setDfpnls(Integer.valueOf(headfDao.getHeads3().substring(0, 4)));  //TODO översyn
		newDao.setDfad3s(headfDao.getHeads3().substring(headfDao.getHeads3().length()-25, headfDao.getHeads3().length()));  //TODO översyn
		newDao.setDfknsm(headfDao.getHeknk());
		newDao.setDfnavm(headfDao.getHenak());
		newDao.setDfad1m(headfDao.getHeadk1());
		newDao.setDfad2m(" ");
		newDao.setDfad3m(headfDao.getHeadk3());
	
		newDao.setDfnavl(headfDao.getHenak());

		newDao.setDfad1l(headfDao.getHeadk1());
		newDao.setDfad2l(" ");
		newDao.setDfpoul(Integer.valueOf(headfDao.getHeadk3().substring(0, 4)));  //TODO översyn
		newDao.setDfad3s(headfDao.getHeadk3().substring(headfDao.getHeadk3().length()-25, headfDao.getHeadk3().length()));  //TODO översyn
		//newDao.setDfkdme(??);
		//newDao.setDftoll(??);
		newDao.setDfvs(headfDao.getHevs1());
		newDao.setDfvs2(headfDao.getHevs2());
		newDao.setDfgm(headfDao.getHegm1());
		newDao.setDfgm2(headfDao.getHegm2());
		newDao.setDfnt(headfDao.getHent());
		newDao.setDfntla(headfDao.getHent());
		newDao.setDfvkt(headfDao.getHevkt());
		newDao.setDflm(headfDao.getHelm());
		newDao.setDfm3(headfDao.getHem3());
		newDao.setDfvktf(headfDao.getHefbv());
		newDao.setDfbela("S");
		
		return newDao;
	}

/*	

HEADF               DOKUF
(el konstant) 
' '           DFST   newDao.setDfst(" ");
'F'           DFRI   newDao.setDfri("F");
HEAVD         DFAVD  newDao.setDfavd(headfDao.getHeavd());
HEOPD         DFOPD  newDao.setDfopd(headfDao.getHeopd());
001           DFFBNR ??  hårdkodat ??
HESG          DFSG   newDao.setDfsg(headfDao.getHesg());
???????       DF1004  (sendingsnr må tildeles (SYGE20) * )   newDao.setDf1004(firfbDaoService.getSendningsnr());
HEKNS         DFKNSS newDao.setDfknss(headfDao.getHekns());
HENAS         DFNAVS newDao.setDfnavs(headfDao.getHenas());
HEADS1        DFAD1S newDao.setDfad1s(headfDao.getHeads1());
*BLANKS       DFAD2S newDao.setDfad2s(" ");
HEADS3        DFPNLS  (4 først av HEADS3 = postnr lastested)  newDao.setDfpnls(Integer.valueOf(headfDao.getHeads3().substring(0, 4)));  //TODO översyn
HEADS3        DFAD3S  (25 siste (eller alle) av HEADS3)  newDao.setDfad3s(headfDao.getHeads3().substring(headfDao.getHeads3().length()-25, headfDao.getHeads3().length()));  //TODO översyn
?? (avsender 5 felt over bør hentes fra "avdeloingens kundenr" når det er import...)  ??
HEKNK         DFKNSM newDao.setDfknsm(headfDao.getHeknk());
HENAK         DFNAVM newDao.setDfnavm(headfDao.getHenak());
HEADK1        DFAD1M newDao.setDfad1m(headfDao.getHeadk1());
*BLANKS       DFAD2M newDao.setDfad2m(" ");
HEADK3        DFAD3M newDao.setDfad3m(headfDao.getHeadk3());
HENAK         DFNAVL newDao.setDfnavl(headfDao.getHenak());
HEADK1        DFAD1L newDao.setDfad1l(headfDao.getHeadk1());
*BLANKS       DFAD2L newDao.setDfad2l(" ");
HEADK3        DFPOUL  (4 først av HEADK3 = postnr utleveringssted)   newDao.setDfpoul(Integer.valueOf(headfDao.getHeadk3().substring(0, 4)));  //TODO översyn
HEADK3        DFAD3S  (25 siste (eller alle) av HEADK3)  newDao.setDfad3s(headfDao.getHeadk3().substring(headfDao.getHeadk3().length()-25, headfDao.getHeadk3().length()));  //TODO översyn
????          DFKDME  (HVIS felt for merkelapp er fylt ut i ordrebildet)   ?? inte lagrat i HEADF ??
????          DFTOLL  (HVIS felt for tollsted er fylt ut i ordrebildet)    ?? inte lagrat i HEADF ??
HEVS1         DFVS   newDao.setDfvs(headfDao.getHevs1());
HEVS2         DFVS2  newDao.setDfvs2(headfDao.getHevs2());
HEGM1         DFGM   newDao.setDfgm(headfDao.getHegm1());
HEGM2         DFGM2  newDao.setDfgm2(headfDao.getHegm2());
HENT          DFNT   newDao.setDfnt(headfDao.getHent());
HENT          DFNTLA newDao.setDfntla(headfDao.getHent());
HEVKT         DFVKT  newDao.setDfvkt(headfDao.getHevkt());
HELM          DFLM   newDao.setDflm(headfDao.getHelm());
HEM3          DFM3   newDao.setDfm3(headfDao.getHem3());
HEFBV         DFVKTF newDao.setDfvktf(headfDao.getHefbv());
'S'           DFBELA  (mer avanser logikk import / eksport / innlanfd bør benyttes men S dekker 90 % ) newDao.setDfbela("S");
*/	
	
	private FirfbDaoService firfbDaoService = null;                                                            
	public void setFirfbDaoService( FirfbDaoService firfbDaoService) {this.firfbDaoService = firfbDaoService;}          
	public FirfbDaoService getFirfbDaoService() {return this.firfbDaoService;}
	
	
	
}
