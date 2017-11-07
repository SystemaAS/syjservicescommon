package no.systema.jservices.common.brreg.proxy.entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "kode", "beskrivelse" })
public class InstitusjonellSektorkode implements Serializable{

	@JsonProperty("kode")
	private String kode;
	@JsonProperty("beskrivelse")
	private String beskrivelse;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The kode
	 */
	@JsonProperty("kode")
	public String getKode() {
		return kode;
	}

	/**
	 * 
	 * @param kode
	 *            The kode
	 */
	@JsonProperty("kode")
	public void setKode(String kode) {
		this.kode = kode;
	}

	/**
	 * 
	 * @return The beskrivelse
	 */
	@JsonProperty("beskrivelse")
	public String getBeskrivelse() {
		return beskrivelse;
	}

	/**
	 * 
	 * @param beskrivelse
	 *            The beskrivelse
	 */
	@JsonProperty("beskrivelse")
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
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