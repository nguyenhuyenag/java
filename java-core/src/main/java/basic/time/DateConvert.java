package basic.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.DateUtils;

public class DateConvert {

	private static boolean isType(Object input, Class<?> type) {
		return type.isInstance(input);
	}

	private static boolean isDate(Object input) {
		return isType(input, Date.class);
	}

	private static boolean isCalendar(Object input) {
		return isType(input, Calendar.class);
	}

	private static boolean isInstant(Object input) {
		return isType(input, Instant.class);
	}

	private static boolean isLocalDate(Object input) {
		return isType(input, LocalDate.class);
	}

	private static boolean isLocalDateTime(Object input) {
		return isType(input, LocalDateTime.class);
	}

//	public static Date toDate(Object input) {
//		if (isInstant(input)) {
//			Instant instant = (Instant) input;
//			return Date.from(instant);
//		} else if (isLocalDate(input)) {
//			LocalDate localDate = (LocalDate) input;
//			Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
//			return Date.from(instant);
//		} else if (isLocalDateTime(input)) {
//			LocalDateTime localDateTime = (LocalDateTime) input;
//			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
//			return Date.from(instant);
//		} else {
//			throw new IllegalArgumentException("Unsupported DateTime object type");
//		}
//	}
	
	public static Date toDate(Object input) {
		switch (getType(input)) {
			case DATE:
				return (Date) input;
			case CALENDAR:
				Calendar calendar = (Calendar) input;
				return calendar.getTime();
			case INSTANT:
				Instant instant = (Instant) input;
				return Date.from(instant);
			case LOCAL_DATE:
				LocalDate localDate = (LocalDate) input;
				instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
				return Date.from(instant);
			case LOCAL_DATE_TIME:
				LocalDateTime localDateTime = (LocalDateTime) input;
				instant = localDateTime.toInstant(ZoneOffset.UTC);
				return Date.from(instant);
			default:
				throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	private static Type getType(Object input) {
		if (isDate(input)) {
			return Type.DATE;
		} else if (isCalendar(input)) {
			return Type.CALENDAR;
		} else if (isInstant(input)) {
			return Type.INSTANT;
		} else if (isLocalDate(input)) {
			return Type.LOCAL_DATE;
		} else if (isLocalDateTime(input)) {
			return Type.LOCAL_DATE_TIME;
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	private enum Type {
		DATE,
		CALENDAR,
	    INSTANT,
	    LOCAL_DATE,
	    LOCAL_DATE_TIME
	}


	public static Instant toInstant(Object input) {
		if (isDate(input)) {
			Date date = (Date) input;
			return date.toInstant();
		} else if (isLocalDate(input)) {
			LocalDate localDate = (LocalDate) input;
			return localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
		} else if (isLocalDateTime(input)) {
			LocalDateTime localDateTime = (LocalDateTime) input;
			return localDateTime.toInstant(ZoneOffset.UTC);
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static LocalDate toLocalDate(Object input) {
		if (isDate(input)) {
			Date date = (Date) input;
			Instant instant = date.toInstant();
			return instant.atZone(ZoneOffset.UTC).toLocalDate();
		} else if (isInstant(input)) {
			Instant instant = (Instant) input;
			return instant.atZone(ZoneOffset.UTC).toLocalDate();
		} else if (isLocalDateTime(input)) {
			LocalDateTime localDateTime = (LocalDateTime) input;
			return localDateTime.toLocalDate();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static LocalDateTime toLocalDateTime(Object input) {
		if (isDate(input)) {
			Date date = (Date) input;
			Instant instant = date.toInstant();
			return instant.atZone(ZoneOffset.UTC).toLocalDateTime();
		} else if (isInstant(input)) {
			Instant instant = (Instant) input;
			return instant.atZone(ZoneOffset.UTC).toLocalDateTime();
		} else if (isLocalDate(input)) {
			LocalDate localDate = (LocalDate) input;
			return localDate.atStartOfDay();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static Calendar toCalendar(Object input) {
		Calendar calendar = Calendar.getInstance();
		if (isDate(input)) {
			Date date = (Date) input;
			calendar.setTime(date);
		} else if (isInstant(input)) {
			Instant instant = (Instant) input;
			Date date = Date.from(instant);
			calendar.setTime(date);
		} else if (isLocalDate(input)) {
			LocalDate ld = (LocalDate) input;
			Instant instant = ld.atStartOfDay(ZoneId.systemDefault()).toInstant();
			Date date = Date.from(instant);
			calendar.setTime(date);
		} else if (isLocalDateTime(input)) {
			LocalDateTime ldt = (LocalDateTime) input;
			Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
			Date date = Date.from(instant);
			calendar.setTime(date);
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
		return calendar;
	}

	/**
	 * Milliseconds time
	 */
	public static long getEpochTime(Object input) {
		if (isDate(input)) {
			Date date = (Date) input;
			Instant instant = date.toInstant();
			return instant.toEpochMilli();
		} else if (isLocalDate(input)) {
			LocalDate localDate = (LocalDate) input;
			LocalDateTime localDateTime = localDate.atStartOfDay();
			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
			return instant.toEpochMilli();
		} else if (isLocalDateTime(input)) {
			LocalDateTime localDateTime = (LocalDateTime) input;
			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
			return instant.toEpochMilli();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	// convertTimeUnit(1L, TimeUnit.HOURS, TimeUnit.MINUTES);
	public static long convertTimeUnit(long duration, TimeUnit from, TimeUnit to) {
		return to.convert(duration, from);
	}

	public static void main(String[] args) {
		// long convert = convertTimeUnit(TimeUnit.HOURS, TimeUnit.MINUTES, 10L);
		// System.out.println("Convert: " + convert);
		// LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
		// System.out.println("Giờ UTC hiện tại: " + now);
		// Calendar cal = Calendar.getInstance();
		DateUtils.toCalendar(new Date());
	}

}
