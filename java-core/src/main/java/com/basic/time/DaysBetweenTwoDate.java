package com.basic.time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

//	public static long betweenDates(Date d1, Date d2, TimeUnit unit) throws IOException {
//		return ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
//	}

	public static long calculatorDiff(TimeUnit unit, long l1, long l2) {
		long diff = Math.abs(l1 - l2);
		return DateConvert.convertTimeUnit(diff, TimeUnit.MILLISECONDS, unit);
	}

	public static long calculatorDiff(TimeUnit unit, Date d1, Date d2) {
		return calculatorDiff(unit, d1.getTime(), d2.getTime());
	}

	public static void main(String[] args) {
		// LocalDate ld1 = LocalDate.of(2023, Month.JUNE, 10);
		// LocalDate ld2 = LocalDate.of(2023, Month.JUNE, 15);
		Date d1 = new Date(2023, 10, 12);
		Date d2 = new Date(2023, 10, 20);
		long diff = calculatorDiff(TimeUnit.HOURS, d1, d2);
		System.out.println(diff);
	}

}
