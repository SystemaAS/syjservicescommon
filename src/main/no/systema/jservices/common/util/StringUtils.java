package no.systema.jservices.common.util;

/**
 * This class serves with convenience methods where GUI/DB has specialhandling.
 * 
 * @author Fredrik Möller
 * @date Apr 24, 2017
 *
 */
public class StringUtils {

	/**
	 * Check if value has valid value
	 * 
	 * @param value
	 * @return true if value exist, in Systema perspective
	 */
	public static boolean hasValue(String value) {
		if (value != null) {
			value = value.trim();
			if (value.length() > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
		
}
