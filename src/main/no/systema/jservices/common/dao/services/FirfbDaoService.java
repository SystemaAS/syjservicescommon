package no.systema.jservices.common.dao.services;

import no.systema.jservices.common.dao.DokufDao;
import no.systema.jservices.common.dao.FirfbDao;
import no.systema.jservices.common.util.GSINCheckDigit;

public interface FirfbDaoService extends GenericDaoService<FirfbDao> {
	
	/**
	 * Generate sendingsnr (typically used in {@link DokufDao}
	 * 
	 * Sendingnr consist a concatination of : <br>
	 *  FISNLA   - land kode  <br>
	 *	FISNLE   - leverandørnr  <br>
	 *  FIRECN  -  sist brukt løpenr nr  <br>
	 *  
	 *  put into {@link GSINCheckDigit} to generate a number.
	 * 
	 * @return the generated sendingnummer
	 */
	public String getSendningsnr();

}
