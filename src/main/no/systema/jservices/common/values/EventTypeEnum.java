package no.systema.jservices.common.values;

/**
 * 
 * @author fredrikmoller
 * @date Apr 1, 2019
 */
public enum EventTypeEnum {

	/** I */
	INLAGG("I"),
	/** U*/
	UTTAG("U"),
	/** H */
	RATTELSE("R");

	private String value;

	EventTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
