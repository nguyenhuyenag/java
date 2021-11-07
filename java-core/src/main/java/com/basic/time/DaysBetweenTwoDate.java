package com.basic.time;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

	public static long getDifferenceDays(Date d1, Date d2) {
		long diff = d2.getTime() - d1.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.DAYS);
	}

	public static long betweenDates(Date firstDate, Date secondDate) throws IOException {
		return ChronoUnit.DAYS.between(firstDate.toInstant(), secondDate.toInstant());
	}
	
	//	public static Date asDate(LocalDate localDate) {
	//		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	//	}
	//
	//	public static Date asDate(LocalDateTime localDateTime) {
	//		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	//	}

	public static void main(String[] args) {
		// LocalDate d1 = LocalDate.of(1987, Month.JUNE, 24);
		// LocalDate d2 = LocalDate.of(2007, Month.JULY, 15);
		// int days = Days.daysBetween(past,now).getDays();
	}

}
