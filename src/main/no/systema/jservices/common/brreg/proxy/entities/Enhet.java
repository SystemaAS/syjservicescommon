package no.systema.jservices.common.brreg.proxy.entities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "organisasjonsnummer", "navn", "organisasjonsform", "postadresse",
		"registreringsdatoEnhetsregisteret", "registrertIMvaregisteret", "naeringskode1", "antallAnsatte",
		"forretningsadresse", "stiftelsesdato", "registrertIForetaksregisteret", "registrertIStiftelsesregisteret",
		"registrertIFrivillighetsregisteret", "konkurs", "underAvvikling", "underTvangsavviklingEllerTvangsopplosning",
		"maalform" })

/**
 * 
 * GENERATED using http://www.jsonschema2pojo.org/
 */
public class Enhet implements IEnhet{

	@JsonProperty("organisasjonsnummer")
	private String organisasjonsnummer;
	@JsonProperty("navn")
	private String navn;
	@JsonProperty("organisasjonsform")
	private Organisasjonsform organisasjonsform;
	@JsonProperty("postadresse")
	private Postadresse postadresse;
	@JsonProperty("registreringsdatoEnhetsregisteret")
	private String registreringsdatoEnhetsregisteret;
	@JsonProperty("registrertIMvaregisteret")
	private Boolean registrertIMvaregisteret;
	@JsonProperty("naeringskode1")
	private Naeringskode1 naeringskode1;
	@JsonProperty("antallAnsatte")
	private Integer antallAnsatte;
	@JsonProperty("forretningsadresse")
	private Forretningsadresse forretningsadresse;
	@JsonProperty("stiftelsesdato")
	private String stiftelsesdato;
	@JsonProperty("registrertIForetaksregisteret")
	private Boolean registrertIForetaksregisteret;
	@JsonProperty("registrertIStiftelsesregisteret")
	private Boolean registrertIStiftelsesregisteret;
	@JsonProperty("registrertIFrivillighetsregisteret")
	private Boolean registrertIFrivillighetsregisteret;
	@JsonProperty("konkurs")
	private Boolean konkurs;
	@JsonProperty("underAvvikling")
	private Boolean underAvvikling;
	@JsonProperty("underTvangsavviklingEllerTvangsopplosning")
	private Boolean underTvangsavviklingEllerTvangsopplosning;
	@JsonProperty("maalform")
	private String maalform;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("organisasjonsnummer")
	public String getOrganisasjonsnummer() {
		return organisasjonsnummer;
	}

	@JsonProperty("organisasjonsnummer")
	public void setOrganisasjonsnummer(String organisasjonsnummer) {
		this.organisasjonsnummer = organisasjonsnummer;
	}

	@JsonProperty("navn")
	public String getNavn() {
		return navn;
	}

	@JsonProperty("navn")
	public void setNavn(String navn) {
		this.navn = navn;
	}

	@JsonProperty("organisasjonsform")
	public Organisasjonsform getOrganisasjonsform() {
		return organisasjonsform;
	}

	@JsonProperty("organisasjonsform")
	public void setOrganisasjonsform(Organisasjonsform organisasjonsform) {
		this.organisasjonsform = organisasjonsform;
	}

	@JsonProperty("postadresse")
	public Postadresse getPostadresse() {
		return postadresse;
	}

	@JsonProperty("postadresse")
	public void setPostadresse(Postadresse postadresse) {
		this.postadresse = postadresse;
	}

	@JsonProperty("registreringsdatoEnhetsregisteret")
	public String getRegistreringsdatoEnhetsregisteret() {
		return registreringsdatoEnhetsregisteret;
	}

	@JsonProperty("registreringsdatoEnhetsregisteret")
	public void setRegistreringsdatoEnhetsregisteret(String registreringsdatoEnhetsregisteret) {
		this.registreringsdatoEnhetsregisteret = registreringsdatoEnhetsregisteret;
	}

	@JsonProperty("registrertIMvaregisteret")
	public Boolean getRegistrertIMvaregisteret() {
		return registrertIMvaregisteret;
	}

	@JsonProperty("registrertIMvaregisteret")
	public void setRegistrertIMvaregisteret(Boolean registrertIMvaregisteret) {
		this.registrertIMvaregisteret = registrertIMvaregisteret;
	}

	@JsonProperty("naeringskode1")
	public Naeringskode1 getNaeringskode1() {
		return naeringskode1;
	}

	@JsonProperty("naeringskode1")
	public void setNaeringskode1(Naeringskode1 naeringskode1) {
		this.naeringskode1 = naeringskode1;
	}

	@JsonProperty("antallAnsatte")
	public Integer getAntallAnsatte() {
		return antallAnsatte;
	}

	@JsonProperty("antallAnsatte")
	public void setAntallAnsatte(Integer antallAnsatte) {
		this.antallAnsatte = antallAnsatte;
	}

	@JsonProperty("forretningsadresse")
	public Forretningsadresse getForretningsadresse() {
		return forretningsadresse;
	}

	@JsonProperty("forretningsadresse")
	public void setForretningsadresse(Forretningsadresse forretningsadresse) {
		this.forretningsadresse = forretningsadresse;
	}

	@JsonProperty("stiftelsesdato")
	public String getStiftelsesdato() {
		return stiftelsesdato;
	}

	@JsonProperty("stiftelsesdato")
	public void setStiftelsesdato(String stiftelsesdato) {
		this.stiftelsesdato = stiftelsesdato;
	}

	@JsonProperty("registrertIForetaksregisteret")
	public Boolean getRegistrertIForetaksregisteret() {
		return registrertIForetaksregisteret;
	}

	@JsonProperty("registrertIForetaksregisteret")
	public void setRegistrertIForetaksregisteret(Boolean registrertIForetaksregisteret) {
		this.registrertIForetaksregisteret = registrertIForetaksregisteret;
	}

	@JsonProperty("registrertIStiftelsesregisteret")
	public Boolean getRegistrertIStiftelsesregisteret() {
		return registrertIStiftelsesregisteret;
	}

	@JsonProperty("registrertIStiftelsesregisteret")
	public void setRegistrertIStiftelsesregisteret(Boolean registrertIStiftelsesregisteret) {
		this.registrertIStiftelsesregisteret = registrertIStiftelsesregisteret;
	}

	@JsonProperty("registrertIFrivillighetsregisteret")
	public Boolean getRegistrertIFrivillighetsregisteret() {
		return registrertIFrivillighetsregisteret;
	}

	@JsonProperty("registrertIFrivillighetsregisteret")
	public void setRegistrertIFrivillighetsregisteret(Boolean registrertIFrivillighetsregisteret) {
		this.registrertIFrivillighetsregisteret = registrertIFrivillighetsregisteret;
	}

	@JsonProperty("konkurs")
	public Boolean getKonkurs() {
		return konkurs;
	}

	@JsonProperty("konkurs")
	public void setKonkurs(Boolean konkurs) {
		this.konkurs = konkurs;
	}

	@JsonProperty("underAvvikling")
	public Boolean getUnderAvvikling() {
		return underAvvikling;
	}

	@JsonProperty("underAvvikling")
	public void setUnderAvvikling(Boolean underAvvikling) {
		this.underAvvikling = underAvvikling;
	}

	@JsonProperty("underTvangsavviklingEllerTvangsopplosning")
	public Boolean getUnderTvangsavviklingEllerTvangsopplosning() {
		return underTvangsavviklingEllerTvangsopplosning;
	}

	@JsonProperty("underTvangsavviklingEllerTvangsopplosning")
	public void setUnderTvangsavviklingEllerTvangsopplosning(Boolean underTvangsavviklingEllerTvangsopplosning) {
		this.underTvangsavviklingEllerTvangsopplosning = underTvangsavviklingEllerTvangsopplosning;
	}

	@JsonProperty("maalform")
	public String getMaalform() {
		return maalform;
	}

	@JsonProperty("maalform")
	public void setMaalform(String maalform) {
		this.maalform = maalform;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String getOverordnetEnhet() {
		// TODO Auto-generated method stub
		return null;
	}

}