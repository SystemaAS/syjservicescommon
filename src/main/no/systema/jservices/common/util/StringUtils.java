package no.systema.jservices.common.util;

import java.math.BigDecimal;

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

	
	/**
	 * Check if value has valid String value, ignore zero as value
	 * 
	 * @param value
	 * @return true if value exist, in Systema perspective
	 */
	public static boolean hasValueIgnoreZero(String value) {
		if (value != null && !"0".equals(value)) {
			return hasValue(value);
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean isNotNull(String value){
		boolean retval = false;
		if(value!=null && !"".equals(value)){
			retval = true;
		}
		return retval;
	}
	/**
	 * 
	 * @param value
	 * @return
	 */
	public boolean isNull(String value){
		boolean retval = false;
		if(value==null || "".equals(value)){
			retval = true;
		}
		return retval;
	}
	
	/**
	 * Converts the decimal separator for a BigDecimal value, from dot to comma.
	 * 
	 * @param dbValue {@linkplain BigDecimal}
	 * @return a BigDecimal value as String with , as decimal separator.
	 */
	public static String convertToSystemaUIFormat(BigDecimal dbValue) {
		if (dbValue == null) {
			return null;
		} else {
			return dbValue.toString().replace(".", ",");
		}
	}
	/**
	 * Usually used to replace null with "" (in db-updates)
	 * @param value
	 * @return
	 */
	public static String nvl(String value){
		String retval = "";
		if(value!=null){
			retval = value;
		}
		return retval;
	}
	
	/**
	 * 
	 * @param value
	 * @param fieldLimit
	 * @param fillerChar
	 * @return
	 */
	public String leadingStringWithNumericFiller(String value, int fieldLimit, String fillerChar){
		String FILLER = fillerChar;
		int FTX_LIMIT = fieldLimit;
		StringBuffer str = new StringBuffer();
		String filler = new String();
		try{
			if(value!=null && !"".equals(value)){
				int len = value.length();
				for (int x=1;x<=FTX_LIMIT-len;x++){
					if(x==1){
						filler = FILLER;
					}else{
						filler = filler + FILLER;
					}
				}
				str.append(filler + value);
			}
			
		}catch(Exception e){
			
		}
		return str.toString();
	}
	
}
