package common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.directory.api.util.GeneralizedTime;

public class DateTimeUtils {
	
	private DateTimeUtils() {
		
	}

	public static final long ONE_SECONDS 			= 	Duration.ofSeconds(1).toMillis();
	public static final long ONE_MINUTES 			= 	TimeUnit.MINUTES.toMillis(1);
	public static final long ONE_HOURS 				= 	60 * ONE_MINUTES;
	public static final long ONE_DAYS 				= 	24 * ONE_HOURS;
	public static final long ONE_MONTHS 			= 	30 * ONE_DAYS;

	public static final String HHMMSS 				=	"HH:mm:ss";
	public static final String YYYYMMDD				=	"yyyy-MM-dd";
	public static final String YYYYMMDDHHMMSS		=	"yyyy-MM-dd HH:mm:ss";
	
	/**
	 * Get current date by pattern yyyy-MM-dd HH:mm:ss
	 * @return {@code Date}
	 * @throws DateTimeException
	 */
	public static String now() {
		return dateToString(new Date(), null);
	}
	
	public static String getCurrentDateTimeByPattern(String pattern) throws DateTimeException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		return now.format(formatter);
	}
	
	/**
	 * Date format
	 * @param date the time value to be formatted into a time string
	 * @param pattern the pattern describing the date and time format
	 * @return the formatted time string
	 */
	public static String dateToString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern != null ? pattern : YYYYMMDDHHMMSS);
		return sdf.format(date);
	}

	/**
	 * String to Date
	 * @param date is string Date
	 * @param pattern is patern of string Date
	 * @return {@code Date}
	 * @throws ParseException
	 */
	public static Date stringToDate(String date, String pattern) {
		try {
			DateFormat sdf = new SimpleDateFormat(pattern != null ? pattern : YYYYMMDDHHMMSS);
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String changeDateFormat(String strDate, String currentPattern, String newPattern) {
		try {
			DateFormat sdf = new SimpleDateFormat(currentPattern);
			Date date = sdf.parse(strDate);
			sdf = new SimpleDateFormat(newPattern);
			return sdf.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * Replace for Date constructor warning @Deprecated
	 * @param year is year
	 * @param month is month
	 * @param date is date
	 * @return {@code Date}
	 */
	public static Date asDate(int year, int month, int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, date);
		return calendar.getTime();
	}

	/**
	 * Get later date
	 * <pre>
	 * getLaterDate(ONE_HOURS)		= 1 giờ sau
	 * getLaterDate( ONE_DAYS )		= 1 ngày sau
	 * </pre>
	 * @param amounts là thời gian
	 * @return Date
	 */
	public static Date getLaterDate(int amount) {
		// return new Date(System.currentTimeMillis() + amounts);
		Calendar calendar = Calendar.getInstance();
		// calendar.add(Calendar.MILLISECOND, amount);
		// calendar.add(Calendar.MINUTE, amount);
		calendar.add(Calendar.HOUR, amount);
		// calendar.add(Calendar.MONTH, amount);
		return calendar.getTime();
	}
	
	/**
	 * {@link org.apache.directory.api.util.GeneralizedTime}
	 */
	public static String LDAPDateTime() {
		GeneralizedTime gt = new GeneralizedTime(Calendar.getInstance());
		return gt.toGeneralizedTime(GeneralizedTime.Format.YEAR_MONTH_DAY_HOUR_MIN_SEC,
				GeneralizedTime.FractionDelimiter.DOT, 1, GeneralizedTime.TimeZoneFormat.Z);
	}
	
}
