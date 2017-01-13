package no.systema.jservices.common.brreg.proxy.entities;

import org.apache.commons.csv.CSVRecord;

/**
 * This class represent a entity found as UnderEnhet
 * 
 * @author Fredrik Möller
 * @date Nov 29, 2016
 *
 */
@SuppressWarnings("serial")
public class UnderEnhet extends Enhet {

	private boolean hasOverordnetEnhet;

	/**
	 * Constructor init values delivered in CSVRecord
	 * 
	 * @param csvRecord
	 */

	public UnderEnhet() {
		// for jackson
	}
	
	public UnderEnhet(CSVRecord csvRecord) {
		String organisasjonsnummer = csvRecord.get("organisasjonsnummer");
		String registrertIMvaregisteret = csvRecord.get("registrertIMvaregisteret");
		String overordnetEnhet = csvRecord.get("overordnetEnhet");
		String organisasjonsform = csvRecord.get("organisasjonsform");
			
		this.setOrganisasjonsnummer(new Integer(organisasjonsnummer));
		this.setRegistrertIMvaregisteret(registrertIMvaregisteret);
		this.setOverordnetEnhet(new Integer(overordnetEnhet));
		this.setOrganisasjonsform(organisasjonsform);
		
	}
	
	
	public boolean isHasOverordnetEnhet() {
		return hasOverordnetEnhet;
	}

	public void setHasOverordnetEnhet(boolean hasOverordnetEnhet) {
		this.hasOverordnetEnhet = hasOverordnetEnhet;
	}
	


}
