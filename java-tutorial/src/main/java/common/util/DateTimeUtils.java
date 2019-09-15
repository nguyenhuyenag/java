package common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateTimeUtils {

	public static final long ONE_SECONDS 			= 	Duration.ofSeconds(1).toMillis();
	public static final long ONE_MINUTES 			= 	TimeUnit.MINUTES.toMillis(1);
	public static final long ONE_HOURS 				= 	60 * ONE_MINUTES;
	public static final long ONE_DAYS 				= 	24 * ONE_HOURS;
	public static final long ONE_MONTHS 			= 	30 * ONE_DAYS;

	public static final String HHMMSS 			=	"HH:mm:ss";
	public static final String YYYYMMDD			=	"yyyy-MM-dd";
	public static final String YYYYMMDD_HHMMSS	=	"yyyy-MM-dd HH:mm:ss";
	
	/**
	 * Date format
	 * @param date the time value to be formatted into a time string
	 * @param pattern the pattern describing the date and time format
	 * @return the formatted time string
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern != null ? pattern : YYYYMMDD_HHMMSS);
		return sdf.format(date);
	}

	/**
	 * Date format
	 * @param date the time value to be formatted into a time string
	 * @return the formatted time string
	 */
	public static String formatDate(Date date) {
		return formatDate(date, null);
	}
	
	/**
	 * Get now
	 * @param pattern
	 * @return now string
	 */
	public static String now(String pattern) {
		return formatDate(new Date(), pattern);
	}

	public static String now() throws DateTimeException {
		return formatDate(new Date(), null);
	}

	/**
	 * Get later date
	 * <pre>
	 * getLaterDate(ONE_HOURS)		= 1 giờ sau
	 * getLaterDate( ONE_DAYS )		= 1 ngày sau
	 * </pre>
	 * @param amounts là thời gian tính bằng mili giây
	 * @return Date
	 */
	public static Date getLaterDate(long amounts) {
		return new Date(System.currentTimeMillis() + amounts);
	}

	/**
	 * Replace Date constructor warning @Deprecated
	 */
	public static Date asDate(int year, int month, int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, date);
		return calendar.getTime();
	}
	
	/**
	 * String to Date
	 */
	public static Date asDate(String date, String pattern) throws ParseException {
		DateFormat sdf = new SimpleDateFormat(pattern != null ? pattern : YYYYMMDD_HHMMSS);
		return sdf.parse(date);
	}

	public static Date asDate(String date) throws ParseException {
		return asDate(date, YYYYMMDD_HHMMSS);
	}
	
}
