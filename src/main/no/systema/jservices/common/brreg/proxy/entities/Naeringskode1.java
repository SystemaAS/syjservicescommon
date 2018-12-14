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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beskrivelse",
    "kode"
})
public class Naeringskode1 implements Serializable{

    @JsonProperty("beskrivelse")
    private String beskrivelse;
    @JsonProperty("kode")
    private String kode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("beskrivelse")
    public String getBeskrivelse() {
        return beskrivelse;
    }

    @JsonProperty("beskrivelse")
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @JsonProperty("kode")
    public String getKode() {
        return kode;
    }

    @JsonProperty("kode")
    public void setKode(String kode) {
        this.kode = kode;
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