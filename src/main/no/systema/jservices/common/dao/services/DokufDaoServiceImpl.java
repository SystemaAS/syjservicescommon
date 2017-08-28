package no.systema.jservices.common.dao.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.HeadfDao;

public class DokufDaoServiceImpl extends GenericDaoServiceImpl<DokufDao> implements DokufDaoService{

	@Override
	public DokufDao create(DokufDao t) {
		t.setDffbnr(createDffbnr(t.getDfavd(),t.getDfopd()));
		return super.create(t);
	}
	
	@Override
	public DokufDao create(HeadfDao headfDao) {
		DokufDao newDao = getPopulatedDao(headfDao);
		return super.create(newDao);
		
	}

	private DokufDao getPopulatedDao(HeadfDao headfDao) {
		DokufDao newDao = new DokufDao();
		newDao.setDfst(" ");
		newDao.setDfri("F");
		newDao.setDfavd(headfDao.getHeavd());
		newDao.setDfopd(headfDao.getHeopd());
		newDao.setDfsg(headfDao.getHesg());
		newDao.setDf1004(firfbDaoService.getSendningsnr());
		newDao.setDfknss(headfDao.getHekns());
		newDao.setDfnavs(headfDao.getHenas());
		newDao.setDfad1s(headfDao.getHeads1());
		newDao.setDfad2s(" ");
		newDao.setDfpnls(getFourFirstChar(headfDao.getHeads3())); 
		newDao.setDfad3s(getTwentyFiveLastChar(headfDao.getHeads3()));
		newDao.setDfknsm(headfDao.getHeknk());
		newDao.setDfnavm(headfDao.getHenak());
		newDao.setDfad1m(headfDao.getHeadk1());
		newDao.setDfad2m(" ");
		newDao.setDfad3m(headfDao.getHeadk3());
		newDao.setDfnavl(headfDao.getHenak());
		newDao.setDfad1l(headfDao.getHeadk1());
		newDao.setDfad2l(" ");
		newDao.setDfpoul(getFourFirstChar(headfDao.getHeadk3())); 
		newDao.setDfad3s(getTwentyFiveLastChar(headfDao.getHeadk3()));
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

	private int getFourFirstChar(String string) {
		int nr = 0;
		if (string == null) {
			return nr;
		}
		try {
			nr = Integer.parseInt(string.substring(0,4));
		} catch (NumberFormatException e) {
			//do nothing.
		}
		return nr;
	}
	
	private String getTwentyFiveLastChar(String string) {
		if (string == null) {
			return null;
		}
		if (string != null && string.length() <= 25) {
			return string;
		}
		return string.substring(string.length() - 25 ,string.length() );
	}

	
	private int createDffbnr(int avd, int opd) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dfavd", avd);
		params.put("dfopd", opd);
		List<DokufDao> daoList = findAll(params);
		if (!daoList.isEmpty()) {
			DokufDao latestRecord = daoList.get(daoList.size()-1);
			return latestRecord.getDffbnr() + 1;
		} else {
			return 1;
		}
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
HEADS3        DFPNLS  (4 først av HEADS3 = postnr lastested) 	newDao.setDfpnls(Integer.parseInt(getFourFirstChar(headfDao.getHeads3()))); 
HEADS3        DFAD3S  (25 siste (eller alle) av HEADS3) newDao.setDfad3s(getTwentyFiveLastChar(headfDao.getHeads3()));
?? (avsender 5 felt over bør hentes fra "avdeloingens kundenr" når det er import...)  ??
HEKNK         DFKNSM newDao.setDfknsm(headfDao.getHeknk());
HENAK         DFNAVM newDao.setDfnavm(headfDao.getHenak());
HEADK1        DFAD1M newDao.setDfad1m(headfDao.getHeadk1());
*BLANKS       DFAD2M newDao.setDfad2m(" ");
HEADK3        DFAD3M newDao.setDfad3m(headfDao.getHeadk3());
HENAK         DFNAVL newDao.setDfnavl(headfDao.getHenak());
HEADK1        DFAD1L newDao.setDfad1l(headfDao.getHeadk1());
*BLANKS       DFAD2L newDao.setDfad2l(" ");
HEADK3        DFPOUL  (4 først av HEADK3 = postnr utleveringssted)  	newDao.setDfpoul(Integer.parseInt(getFourFirstChar(headfDao.getHeadk3()))); 
HEADK3        DFAD3S  (25 siste (eller alle) av HEADK3) 	newDao.setDfad3s(getTwentyFiveLastChar(headfDao.getHeadk3()));
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
