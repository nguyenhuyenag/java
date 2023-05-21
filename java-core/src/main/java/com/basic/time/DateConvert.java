package com.basic.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateConvert {

//	// Date -> LocalDate
//	public static LocalDate dateToLocalDate(Date date) {
//		return 
//	}
//
//	// Date -> LocalDateTime
//	public static LocalDateTime dateToLocalDateTime(Date date) {
//		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//	}
//
//	// Date -> Instant
//	public static Instant dateToInstant(Date date) {
//		return Instant.ofEpochMilli(date.getTime());
//	}
//
//	// LocalDate -> Date
//	public static Date localDateToDate(LocalDate localDate) {
//		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
//	}
//
//	// LocalDate -> LocalDateTime
//	public static LocalDateTime localDateToLocalDateTime(LocalDate localDate) {
//		return localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalDateTime();
//	}
//
//	// LocalDate -> Instant
//	public static Instant localDateToLocalInstant(LocalDate localDate) {
//		LocalDateTime localDateTime = localDate.atStartOfDay();
//		return localDateTime.toInstant(ZoneOffset.UTC);
//	}
//
//	// Instant -> Date
//	public static Date instantToDate(Instant instant) {
//		return Date.from(instant);
//	}
//
//	// Instant -> LocalDate
//	public static LocalDate instantToLocalDate(Instant instant) {
//		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
//		return zonedDateTime.toLocalDate();
//	}
//
//	// Instant -> LocalDateTime
//	public static LocalDateTime instantToLocalDateTime(Instant instant) {
//		return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//	}

	public static Date toDate(Object dateTimeObject) {
		if (dateTimeObject instanceof Instant) {
			Instant instant = (Instant) dateTimeObject;
			return Date.from(instant);
		} else if (dateTimeObject instanceof LocalDate) {
			LocalDate localDate = (LocalDate) dateTimeObject;
			Instant instant = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
			return Date.from(instant);
		} else if (dateTimeObject instanceof LocalDateTime) {
			LocalDateTime localDateTime = (LocalDateTime) dateTimeObject;
			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
			return Date.from(instant);
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static Instant toInstant(Object dateTimeObject) {
		if (dateTimeObject instanceof Date) {
			Date date = (Date) dateTimeObject;
			return date.toInstant();
		} else if (dateTimeObject instanceof LocalDate) {
			LocalDate localDate = (LocalDate) dateTimeObject;
			return localDate.atStartOfDay().toInstant(ZoneOffset.UTC);
		} else if (dateTimeObject instanceof LocalDateTime) {
			LocalDateTime localDateTime = (LocalDateTime) dateTimeObject;
			return localDateTime.toInstant(ZoneOffset.UTC);
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static LocalDate toLocalDate(Object dateTimeObject) {
		if (dateTimeObject instanceof Date) {
			Date date = (Date) dateTimeObject;
			// Instant instant = date.toInstant();
			// return instant.atZone(ZoneOffset.UTC).toLocalDate();
			return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} else if (dateTimeObject instanceof Instant) {
			Instant instant = (Instant) dateTimeObject;
			return instant.atZone(ZoneOffset.UTC).toLocalDate();
		} else if (dateTimeObject instanceof LocalDateTime) {
			LocalDateTime localDateTime = (LocalDateTime) dateTimeObject;
			return localDateTime.toLocalDate();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static LocalDateTime toLocalDateTime(Object dateTimeObject) {
		if (dateTimeObject instanceof Date) {
			Date date = (Date) dateTimeObject;
			Instant instant = date.toInstant();
			return instant.atZone(ZoneOffset.UTC).toLocalDateTime();
		} else if (dateTimeObject instanceof Instant) {
			Instant instant = (Instant) dateTimeObject;
			return instant.atZone(ZoneOffset.UTC).toLocalDateTime();
		} else if (dateTimeObject instanceof LocalDate) {
			LocalDate localDate = (LocalDate) dateTimeObject;
			return localDate.atStartOfDay();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	public static long getEpochTime(Object dateTimeObject) {
		if (dateTimeObject instanceof Date) {
			Date date = (Date) dateTimeObject;
			Instant instant = date.toInstant();
			return instant.toEpochMilli();
		} else if (dateTimeObject instanceof LocalDate) {
			LocalDate localDate = (LocalDate) dateTimeObject;
			LocalDateTime localDateTime = localDate.atStartOfDay();
			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
			return instant.toEpochMilli();
		} else if (dateTimeObject instanceof LocalDateTime) {
			LocalDateTime localDateTime = (LocalDateTime) dateTimeObject;
			Instant instant = localDateTime.toInstant(ZoneOffset.UTC);
			return instant.toEpochMilli();
		} else {
			throw new IllegalArgumentException("Unsupported DateTime object type");
		}
	}

	// convertTimeUnit(TimeUnit.HOURS, TimeUnit.MINUTES, 1L);
	public static long convertTimeUnit(long duration, TimeUnit from, TimeUnit to) {
		return to.convert(duration, from);
	}

	public static void main(String[] args) {
		// long convert = convertTimeUnit(TimeUnit.HOURS, TimeUnit.MINUTES, 10L);
		// System.out.println("Convert: " + convert);
		// LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);
		// System.out.println("Giờ UTC hiện tại: " + now);
	}

}
