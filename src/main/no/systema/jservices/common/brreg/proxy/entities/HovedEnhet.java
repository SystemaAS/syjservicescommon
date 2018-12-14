package no.systema.jservices.common.brreg.proxy.entities;

/**
 * This class represent a entity found as HovedEnhet
 * 
 * @author Fredrik Möller
 * @date Nov 29, 2016
 *
 */
@SuppressWarnings("serial")
public class HovedEnhet extends Enhet {


	public HovedEnhet() {
		//for jackson
	}
	
	
//	public HovedEnhet(CSVRecord csvRecord) {
//		String organisasjonsnummer = csvRecord.get("organisasjonsnummer");
//		String konkurs = csvRecord.get("konkurs");
//		String registrertIMvaregisteret = csvRecord.get("registrertIMvaregisteret");
//		String underAvvikling = csvRecord.get("underAvvikling");
//		String underTvangsavviklingEllerTvangsopplosning = csvRecord.get("underTvangsavviklingEllerTvangsopplosning");
//		String organisasjonsform = csvRecord.get("organisasjonsform");
//		String navn = csvRecord.get("navn");
//		String registreringsdatoEnhetsregisteret = csvRecord.get("registreringsdatoEnhetsregisteret");
//		String hjemmeside = csvRecord.get("hjemmeside");
//		String registrertIFrivillighetsregisteret = csvRecord.get("registrertIFrivillighetsregisteret");
//		String registrertIForetaksregisteret = csvRecord.get("registrertIForetaksregisteret");
//		String registrertIStiftelsesregisteret = csvRecord.get("registrertIStiftelsesregisteret");
//		String antallAnsatte = csvRecord.get("antallAnsatte");
//		String institusjonellSektorkodeKode = csvRecord.get("institusjonellSektorkode.kode");
//		String institusjonellSektorkodeBeskrivelse = csvRecord.get("institusjonellSektorkode.beskrivelse");
//		String naeringskode1Kode = csvRecord.get("naeringskode1.kode");
//		String naeringskode1Beskrivelse = csvRecord.get("naeringskode1.beskrivelse");
//		String postadresseAdresse = csvRecord.get("postadresse.adresse");
//		String postadressePostnummer = csvRecord.get("postadresse.postnummer");
//		String postadressePoststed = csvRecord.get("postadresse.poststed");
//		String postadresseLandkode = csvRecord.get("postadresse.landkode");
//		String postadresseKommunenummer = csvRecord.get("postadresse.kommunenummer");
//		String postadresseKommune = csvRecord.get("postadresse.kommune");
//		String postadresseLand = csvRecord.get("postadresse.land");
//		String overordnetEnhet = csvRecord.get("overordnetEnhet");
//
//		this.setOrganisasjonsnummer(new Integer(organisasjonsnummer));
//		this.setKonkurs(konkurs);
//		this.setRegistrertIMvaregisteret(registrertIMvaregisteret);
//		this.setUnderAvvikling(underAvvikling);
//		this.setUnderTvangsavviklingEllerTvangsopplosning(underTvangsavviklingEllerTvangsopplosning);
//		this.setOrganisasjonsform(organisasjonsform);
//		this.setNavn(navn);
//		this.setRegistreringsdatoEnhetsregisteret(registreringsdatoEnhetsregisteret);
//		this.setHjemmeside(hjemmeside);
//		this.setRegistrertIFrivillighetsregisteret(registrertIFrivillighetsregisteret);
//		this.setRegistrertIForetaksregisteret(registrertIForetaksregisteret);
//		this.setRegistrertIStiftelsesregisteret(registrertIStiftelsesregisteret);
//		this.setAntallAnsatte(Integer.getInteger(antallAnsatte));
//
//		InstitusjonellSektorkode institusjonellSektorkode = new InstitusjonellSektorkode();
//		institusjonellSektorkode.setKode(institusjonellSektorkodeKode);
//		institusjonellSektorkode.setBeskrivelse(institusjonellSektorkodeBeskrivelse);
//		this.setInstitusjonellSektorkode(institusjonellSektorkode);
//
//		Naeringskode1 naeringskode1 = new Naeringskode1();
//		naeringskode1.setKode(naeringskode1Kode);
//		naeringskode1.setBeskrivelse(naeringskode1Beskrivelse);
//		this.setNaeringskode1(naeringskode1);
//		
//		Postadresse pa = new Postadresse();
//		pa.setAdresse(postadresseAdresse);
//		pa.setPostnummer(postadressePostnummer);
//		pa.setPoststed(postadressePoststed);
//		pa.setLandkode(postadresseLandkode);
//		pa.setLand(postadresseLand);
//		pa.setKommunenummer(postadresseKommunenummer);
//		pa.setKommune(postadresseKommune);
//		this.setPostadresse(pa);
//		this.setOverordnetEnhet(Integer.getInteger(overordnetEnhet));
//		
//	}

}
