package no.systema.jservices.common.brreg.proxy.entities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * This class represent a entity found as UnderEnhet
 * 
 * @author Fredrik Möller
 * @date Nov 29, 2016
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "organisasjonsnummer", "navn", "organisasjonsform", "postadresse",
		"registreringsdatoEnhetsregisteret", "registrertIMvaregisteret", "naeringskode1", "antallAnsatte",
		"overordnetEnhet", "beliggenhetsadresse" })
public class UnderEnhet implements IEnhet{

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
	@JsonProperty("overordnetEnhet")
	private String overordnetEnhet;
	@JsonProperty("beliggenhetsadresse")
	private Beliggenhetsadresse beliggenhetsadresse;
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

	@JsonProperty("overordnetEnhet")
	public String getOverordnetEnhet() {
		return overordnetEnhet;
	}

	@JsonProperty("overordnetEnhet")
	public void setOverordnetEnhet(String overordnetEnhet) {
		this.overordnetEnhet = overordnetEnhet;
	}

	@JsonProperty("beliggenhetsadresse")
	public Beliggenhetsadresse getBeliggenhetsadresse() {
		return beliggenhetsadresse;
	}

	@JsonProperty("beliggenhetsadresse")
	public void setBeliggenhetsadresse(Beliggenhetsadresse beliggenhetsadresse) {
		this.beliggenhetsadresse = beliggenhetsadresse;
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
	public Boolean getKonkurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getUnderAvvikling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getUnderTvangsavviklingEllerTvangsopplosning() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKonkurs(Boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnderAvvikling(Boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUnderTvangsavviklingEllerTvangsopplosning(Boolean b) {
		// TODO Auto-generated method stub
		
	}

}
