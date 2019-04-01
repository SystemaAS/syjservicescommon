package no.systema.jservices.common.values;

/**
 * 
 * @author fredrikmoller
 * @date Apr 1, 2019
 */
public enum EventTypeEnum {

	INLAGG("I"),
	UTTAG("U"),
	OVRIG("H");

	private String value;

	EventTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
