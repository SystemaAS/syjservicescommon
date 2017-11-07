package no.systema.jservices.common.brreg.proxy.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "adresse", "postnummer", "poststed", "kommunenummer", "kommune", "landkode", "land" })
public class Postadresse implements Serializable{

	@JsonProperty("adresse")
	private String adresse;
	@JsonProperty("postnummer")
	private String postnummer;
	@JsonProperty("poststed")
	private String poststed;
	@JsonProperty("kommunenummer")
	private String kommunenummer;
	@JsonProperty("kommune")
	private String kommune;
	@JsonProperty("landkode")
	private String landkode;
	@JsonProperty("land")
	private String land;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The adresse
	 */
	@JsonProperty("adresse")
	public String getAdresse() {
		return adresse;
	}

	/**
	 * 
	 * @param adresse
	 *            The adresse
	 */
	@JsonProperty("adresse")
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * 
	 * @return The postnummer
	 */
	@JsonProperty("postnummer")
	public String getPostnummer() {
		return postnummer;
	}

	/**
	 * 
	 * @param postnummer
	 *            The postnummer
	 */
	@JsonProperty("postnummer")
	public void setPostnummer(String postnummer) {
		this.postnummer = postnummer;
	}

	/**
	 * 
	 * @return The poststed
	 */
	@JsonProperty("poststed")
	public String getPoststed() {
		return poststed;
	}

	/**
	 * 
	 * @param poststed
	 *            The poststed
	 */
	@JsonProperty("poststed")
	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}

	/**
	 * 
	 * @return The kommunenummer
	 */
	@JsonProperty("kommunenummer")
	public String getKommunenummer() {
		return kommunenummer;
	}

	/**
	 * 
	 * @param kommunenummer
	 *            The kommunenummer
	 */
	@JsonProperty("kommunenummer")
	public void setKommunenummer(String kommunenummer) {
		this.kommunenummer = kommunenummer;
	}

	/**
	 * 
	 * @return The kommune
	 */
	@JsonProperty("kommune")
	public String getKommune() {
		return kommune;
	}

	/**
	 * 
	 * @param kommune
	 *            The kommune
	 */
	@JsonProperty("kommune")
	public void setKommune(String kommune) {
		this.kommune = kommune;
	}

	/**
	 * 
	 * @return The landkode
	 */
	@JsonProperty("landkode")
	public String getLandkode() {
		return landkode;
	}

	/**
	 * 
	 * @param landkode
	 *            The landkode
	 */
	@JsonProperty("landkode")
	public void setLandkode(String landkode) {
		this.landkode = landkode;
	}

	/**
	 * 
	 * @return The land
	 */
	@JsonProperty("land")
	public String getLand() {
		return land;
	}

	/**
	 * 
	 * @param land
	 *            The land
	 */
	@JsonProperty("land")
	public void setLand(String land) {
		this.land = land;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}