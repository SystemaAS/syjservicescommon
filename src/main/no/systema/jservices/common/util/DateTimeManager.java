/**
 * 
 */
package no.systema.jservices.common.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Utility class to manage date issues
 * 
 * @author oscardelatorre
 * @date Aug 1, 2016
 * 
 */
public class DateTimeManager {
	
	private static Logger logger = Logger.getLogger(DateTimeManager.class.getName());

	public static final String ISO_FORMAT = "yyyyMMdd";
	public static final String NO_FORMAT = "ddMMyy";

	public static final String DB_FORMAT = "yyyy-MM-dd";
	
	
//	private static DateTimeFormatter dateFormatterNO = DateTimeFormatter.ofPattern("NO_FORMAT"); 
//	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
	
	/**
	 * Gets the current ISO date
	 * @return
	 */
	public String getCurrentDate_ISO(){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(ISO_FORMAT);
		Calendar cal = Calendar.getInstance();
		try{
			
			retval = dateFormat.format(cal.getTime()); 
			
		}catch(Exception e){
			//Nothing
		}
		
		return  retval; 
	}
	
	public String getCurrentDate_ISO(String mask){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(mask);
		Calendar cal = Calendar.getInstance();
		try{
			retval = dateFormat.format(cal.getTime()); 
		}catch(Exception e){
			//Nothing
		}
		return  retval; 
	}
	/**
	 * 
	 * @return
	 */
	public String getCurrentDate(){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(DB_FORMAT);
		Calendar cal = Calendar.getInstance();
		try{
			
			retval = dateFormat.format(cal.getTime()); 
			
		}catch(Exception e){
			//Nothing
		}
		
		return  retval; 
	}
	
	public String getCurrentYear(){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		try{
			
			retval = dateFormat.format(cal.getTime()); 
			
		}catch(Exception e){
			//Nothing
		}
		
		return  retval; 
	}
	public String getCurrentMonth(){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		Calendar cal = Calendar.getInstance();
		try{
			
			retval = dateFormat.format(cal.getTime()); 
			
		}catch(Exception e){
			//Nothing
		}
		
		return  retval; 
	}
	/**
	 * The method gets a specific month backwards from the current day (today)
	 * @param numberOfMonths (+)=months forward, (-)=months backwards
	 * @return
	 */
	public String getSpecificMonthFrom_CurrentDate_ISO(int numberOfMonths){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(ISO_FORMAT);
		Calendar cal = Calendar.getInstance();
		try{
			cal.add(Calendar.MONTH, numberOfMonths);
			retval = dateFormat.format(cal.getTime()); 
			
		}catch(Exception e){
			//Nothing
		}
		
		return  retval; 
	}
	/**
	 * Gets the current NO date
	 * @return
	 */
	public String getCurrentDate_NO(){
		String retval = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(NO_FORMAT);
		Calendar cal = Calendar.getInstance();
		try{
			retval = dateFormat.format(cal.getTime()); 
		}catch(Exception e){
			//Nothing
		}
		return  retval; 
	}
	
	/**
	 * 
	 * @param userValue
	 * @param dateMask
	 * @return
	 */
	public boolean isValidCurrentDayBeforeLimit( String userValue, String dateMask){
		boolean retval = false;
		SimpleDateFormat formatter = new SimpleDateFormat(dateMask);
		try{
			if(userValue!=null && dateMask!=null){
				//check for the minimum of values in each string
				if(userValue.length()>=4 && dateMask.length()>=2){
					Date userDate = formatter.parse(userValue);
					Date today = formatter.parse(this.getCurrentDate());
					if(today.equals(userDate) || today.before(userDate)){
						retval = true;
					}
				}
			}
		}catch(Exception e){
			//nothing. the method will return false...
		}
		
		return retval;
	}
	/**
	 * 
	 * @param userValue
	 * @param dateMask
	 * @return
	 */
	public boolean isValidCurrentDayAfterLimit( String userValue, String dateMask){
		boolean retval = false;
		SimpleDateFormat formatter = new SimpleDateFormat(dateMask);
		try{
			if(userValue!=null && dateMask!=null){
				//check for the minimum of values in each string
				if(userValue.length()>=4 && dateMask.length()>=2){
					Date userDate = formatter.parse(userValue);
					Date today = formatter.parse(this.getCurrentDate());
					if(today.equals(userDate) || today.after(userDate)){
						retval = true;
					}
				}
			}
		}catch(Exception e){
			//nothing. the method will return false...
		}
		
		return retval;
	}
	/**
	 * 
	 * The method compares with current date and compares it with the user value.
	 * A valid forward time should always return a positive value.
	 * @param userValue
	 * @return
	 * 
	 */
	public boolean isValidForwardDate( String userValue, String dateTimeMask){
		boolean retval = false;
		SimpleDateFormat formatter = new SimpleDateFormat(dateTimeMask);
		try{
			if(userValue!=null && dateTimeMask!=null){
				//check for the minimum of values in each string
				if(userValue.length()>=4 && dateTimeMask.length()>=2){
					Date userDate = formatter.parse(userValue);
					Date today = formatter.parse(this.getCurrentDate_ISO());
					if(userDate.after(today)){
						retval = true;
					}
				}
			}
		}catch(Exception e){
			//nothing. the method will return false...
		}
		
		return retval;
	}
	/**
	 * 
	 * @param userValue
	 * @param dateTimeMask
	 * @return
	 */
	public boolean isValidBackwardDate( String userValue, String dateTimeMask){
		boolean retval = false;
		SimpleDateFormat formatter = new SimpleDateFormat(dateTimeMask);
		try{
			if(userValue!=null && dateTimeMask!=null){
				//check for the minimum of values in each string
				if(userValue.length()>=4 && dateTimeMask.length()>=2){
					Date userDate = formatter.parse(userValue);
					Date today = formatter.parse(this.getCurrentDate_ISO());
					if(userDate.before(today)){
						retval = true;
					}
				}
			}
		}catch(Exception e){
			//nothing. the method will return false...
		}
		
		return retval;
	}
	
	/**
	 * The method compares with current time-stamp (now) in milliseconds and compare it with the use value.
	 * A valid forward time should always return a positive value.
	 * @param userValue
	 * @return
	 */
	public boolean isValidForwardTime( String userValue, String dateMask){
		boolean retval = false;
		Calendar userCalendar = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		Long diff = 0L;
		try{
			if(userValue!=null && dateMask!=null){
				//check for the minimum of values in each string
				if(userValue.length()>=4 && dateMask.length()>=2){
					Date userDate = new SimpleDateFormat(dateMask).parse(userValue);
					userCalendar.setTime(userDate);
					diff = userCalendar.getTimeInMillis() - calendar.getTimeInMillis();
					//System.out.println("Milliseconds diff: " + diff);
					if (diff>0){
						retval = true;
					}
				}
			}
		}catch(Exception e){
			//nothing. the method will return false...
		}
		
		return retval;
	}
	
	/**
	 * 
	 * @param userValue
	 * @param dateMask
	 * @return
	 */
	public boolean currentDayBeforeUserDate( String userValue, String dateMask){
		boolean retval = false;
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date userDate = formatter.parse(userValue);
			Date today = formatter.parse(this.getCurrentDate_ISO());
			if(today.before(userDate)){
				retval = true;
			}
		}catch(Exception e){
			e.toString();
		}
		return retval;
	}
	
	/**
	 * 
	 * @param value
	 * @param dateMask
	 * @return
	 */
	public String getDateFormatted_ISO(String value, String sourceDateMask){
		String newDateString = null;
		final String OLD_FORMAT = sourceDateMask;
		try{
			String oldDateString = value;
			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDateString);
			
			sdf.applyPattern(ISO_FORMAT);
			newDateString = sdf.format(d);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return newDateString;
	}
	
	/**
	 * 
	 * @param value
	 * @param dateMask
	 * @return
	 */
	public String getDateFormatted_NO(String value, String sourceDateMask){
		String newDateString = null;
		final String OLD_FORMAT = sourceDateMask;
		
		try{
			String oldDateString = value;

			SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
			Date d = sdf.parse(oldDateString);
			sdf.applyPattern(NO_FORMAT);
			newDateString = sdf.format(d);
			//System.out.println(newDateString);
						
		}catch(Exception e){
			e.printStackTrace();
		}

		return newDateString;
	}
	
	/**
	 * User date: 29 = yyyyMM29 (current year and current month) ISO
	 * User date: 2910 = yyy1029 (current year + user month + user day) ISO
	 * 
	 * @param userDate
	 * @return
	 */
	public String adjustUserDateToISODate(String userDate){
		String retval = userDate;
		if(userDate!=null && !"".equals(userDate) && userDate.length()<8){
			if(userDate.length()==2){
				retval = this.getCurrentYear() + this.getCurrentMonth() + userDate;
			}else if (userDate.length()==4){
				String day = userDate.substring(0,2);String month = userDate.substring(2);
				retval = this.getCurrentYear() + month + day;
			}else{
				//nothing
			}
		}
		return retval;
	}

	/**
	 * User time: 23 = 2300
	 * 
	 * @param userTime
	 * @return
	 */
	public String adjustUserTimeToHHmm(String userTime){
		String MINUTES_SUFFIX = "00";
		String HOUR_PREFIX = "0";
		String retval = userTime;
		if(userTime!=null && !"".equals(userTime) && userTime.length()<4){
			if(userTime.length()==2){
				retval = userTime + MINUTES_SUFFIX;
			}else if(userTime.length()==1){
				retval = HOUR_PREFIX + userTime + MINUTES_SUFFIX;
			}else{
				//nothing
			}
		}
		return retval;
	}
	
	/**
	 * 
	 * @param lowerLimitDate
	 * @param lowerLimitDateMask
	 * @param upperLimitDate
	 * @param upperLimitDateMask
	 * @return
	 */
	public boolean validTodayBetweenLimits( String lowerLimitDate, String lowerLimitDateMask, String upperLimitDate, String upperLimitDateMask){
		boolean retval = false;
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date today = formatter.parse(this.getCurrentDate_ISO());
			//lower limit date
			SimpleDateFormat formatterLowerLimit = new SimpleDateFormat(lowerLimitDateMask);
			Date lowerDate = formatterLowerLimit.parse(lowerLimitDate);
			
			if(upperLimitDate!=null && !"".equals(upperLimitDate) && !"0".equals(upperLimitDate)){
				SimpleDateFormat formatterUpperLimit = new SimpleDateFormat(upperLimitDateMask);
				Date upperDate = formatterUpperLimit.parse(upperLimitDate);
				if( (today.after(lowerDate) || today.compareTo(lowerDate)==0) && (today.before(upperDate) || today.compareTo(upperDate)==0)){
					retval = true;
				}
			}else{
				//only consider lower limit date
				if(today.after(lowerDate) || today.compareTo(lowerDate)==0){
					retval = true;
				}
			}
			
		}catch(Exception e){
			e.toString();
		}
		return retval;
	}
	/**
	 * 
	 * @param lowerLimitDate
	 * @param lowerLimitDateMask
	 * @return
	 */
	public boolean validTodayBetweenLimits( String lowerLimitDate, String lowerLimitDateMask){
		boolean retval = false;
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date today = formatter.parse(this.getCurrentDate_ISO());
			//lower limit date
			SimpleDateFormat formatterLowerLimit = new SimpleDateFormat(lowerLimitDateMask);
			Date lowerDate = formatterLowerLimit.parse(lowerLimitDate);
			
			//only consider lower limit date
			if(today.after(lowerDate) || today.compareTo(lowerDate)==0){
				retval = true;
			}
			
			
			
		}catch(Exception e){
			e.toString();
		}
		return retval;
	}

//	/**
//	 * Concat date and time into single unit.
//	 * 
//	 * @param date Systema date
//	 * @param time Systema time
//	 * @return String date
//	 */
//	public static String getDateTime(int date, int time) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(date).append(time);
//		
//		return sb.toString();
//		
//	}
//
//	/**
//	 * Concat date and time into single unit.
//	 * 
//	 * @param date Systema date
//	 * @param time Systema time
//	 * @return String date
//	 */
//	public static String getDateTime(BigDecimal date, BigDecimal time) {
//		StringBuilder sb = new StringBuilder();
//		sb.append(date).append(time);
//		
//		return sb.toString();
//		
//	}
	
	/**
	 * Send -10 or 10 if you want to get a new date after a date operation 
	 * @param days
	 * @return
	 */
	public String getNewDateFromNow( int days){
		String retval = "";
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.add( Calendar.DAY_OF_YEAR, days);
		Date daysAgoOrAhead = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		retval = formatter.format(daysAgoOrAhead);
		
		return retval;
	}
	/**
	 * 
	 * @param formatMask
	 * @param days
	 * @return
	 */
	public String getNewDateFromNow( String formatMask, int days){
		String retval = "";
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.add( Calendar.DAY_OF_YEAR, days);
		Date daysAgoOrAhead = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(formatMask);
		retval = formatter.format(daysAgoOrAhead);
		
		return retval;
	}

	/**
	 * Transform SYSPED date, i.e. YYYYMMDD into norwegian format.
	 * 
	 * @param date, 20181212
	 * @return 12.12.18 , if invalid date, return null.
	 */
	public static String getDate(int date) {
		DateTimeFormatter dateFormatterNO = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		DateTimeFormatter dateFormatterNOOutput = DateTimeFormatter.ofPattern("dd.MM.yy"); 
		if (date == 0) {
			return null;
		}
		String stringDate = String.valueOf(date);
		String returnDate;
		try {
			LocalDate parsedDate = LocalDate.parse(stringDate, dateFormatterNO);
			returnDate = parsedDate.format(dateFormatterNOOutput);
		} catch (Exception e) {
			returnDate = null;
		}
		
		return returnDate;
		
	}
	
	/**
	 * Transform SYSPED date and time
	 * 
	 * @param date, e.g 20181212
	 * @param, time, e.g 91713
	 * @return 12.12.18 09:17:13, if invalid date or time, return null.
	 */
	public static String getDateTime(int date, int time) {
		DateTimeFormatter dateFormatterNO = DateTimeFormatter.ofPattern("yyyyMMdd"); 
		DateTimeFormatter dateFormatterNOOutput = DateTimeFormatter.ofPattern("dd.MM.yy"); 
	
		DateTimeFormatter dateTimeFormatterNO = DateTimeFormatter.ofPattern("HHmmss"); 
		DateTimeFormatter dateTimeFormatterNOOutput = DateTimeFormatter.ofPattern("HH:mm:ss"); 

		if (date == 0 || time == 0) {
			return null;
		}

		String stringDate = String.valueOf(date);
		String stringTime = StringUtils.leftPad(String.valueOf(time), 6, '0');
		
		String returnDate, returnTime;
		StringBuilder returnDateTime = new StringBuilder();
		try {

			LocalDate parsedDate = LocalDate.parse(stringDate, dateFormatterNO);
			returnDate = parsedDate.format(dateFormatterNOOutput);

			LocalTime parsedTime = LocalTime.parse(stringTime, dateTimeFormatterNO);
			returnTime = parsedTime.format(dateTimeFormatterNOOutput);
			
		
		} catch (Exception e) {
			returnDate = null;
			returnTime = null;
		}
		
		return returnDateTime.append(returnDate).append(" ").append(returnTime).toString();
		
	}	
	
	/**
	 * Creates date bases on {@linkplain LocalDateTime}.now() <br>
	 * and puts date in int[0] and time in int[1] <br><br>
	 * 
	 * Date Pattern: DateTimeFormatter.ofPattern("yyyyMMdd") <br>
	 * Time Pattern: DateTimeFormatter.ofPattern("HHmmss")
	 * 
	 * @return int array with date in first position and time in second position.
	 */
	public static int[] getNowDato() {
		int[] dato = new int[2];
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd"); 		
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");		
		LocalDateTime now = LocalDateTime.now();

		String nowDate = now.format(dateFormatter);
		String nowTime = now.format(timeFormatter);

		int syncDa = Integer.valueOf(nowDate);
		int synctm = Integer.valueOf(nowTime);	
		
		dato[0] = syncDa;
		dato[1] = synctm;
		
		return dato;
		
		
	}	
	
	/**
	 * Validate date String according to @link{DateTimeFormatter.ofPattern("yyyyMMdd")}
	 * 
	 * 
	 * @param value e.g 20190506
	 * @return true if valid
	 */
	public static boolean isValidDate(String value) {
		boolean valid = false;
		DateTimeFormatter dateFormatterNO = DateTimeFormatter.ofPattern("yyyyMMdd");

		try {
			LocalDate.parse(value, dateFormatterNO);
			valid = true;
		} catch (Exception e) {
			valid = false;
		}

		return valid;
	}
	
	
	
}
