package no.systema.jservices.common.values;

/**
 * <li>CREATE = 1 <li>
 * <li>READ = 2 <li>
 * <li>UPDATE = 3 <li>
 * <li>DELETE = 4 <li> <br>
 * 
 * @author fredrikmoller
 * @date Oct 8, 2018
 */
public enum CRUDEnum {

	CREATE(1),
	
	READ(2),

	UPDATE(3),

	DELETE(4);

	private Integer value;

	CRUDEnum(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
	
}
