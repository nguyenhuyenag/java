package com.basic.time;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

	// public static Date asDate(LocalDate localDate) {
	// return
	// Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	// }
	//
	// public static Date asDate(LocalDateTime localDateTime) {
	// return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	// }

	public static long betweenDates(Date d1, Date d2, TimeUnit unit) throws IOException {
		return ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
	}

//	public static long call1(LocalDate d1, LocalDate d2, TimeUnit unit) {
//		long epoch1 = d1.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
//		long epoch2 = d2.atStartOfDay().toEpochSecond(ZoneOffset.UTC);
//		return convertTimeUnit(Math.abs(epoch1 - epoch2), unit);
//	}

	private static long convertTimeUnit(Date d1, Date d2, TimeUnit unit) {
		long diff = Math.abs(d1.getTime() - d2.getTime());
		// return unit.convert(diff, unit);
		System.out.println("Diff of d1 & d2: " + Math.abs(diff));
		// millisecond -> other
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) {
		// LocalDate d1 = LocalDate.of(2023, Month.JUNE, 10);
		// LocalDate d2 = LocalDate.of(2023, Month.JUNE, 15);
		// long result = call1(d1, d2, TimeUnit.DAYS);
		Date d1 = new Date(2023, 10, 12);
		Date d2 = new Date(2023, 10, 20);
		long diff = convertTimeUnit(d1, d2, TimeUnit.HOURS);
		System.out.println(diff);
	}

}
