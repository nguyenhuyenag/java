package com.basic.time;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

//	public static long betweenDates(Date d1, Date d2, TimeUnit unit) throws IOException {
//		return ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
//	}

	public static long calculatorDiff(TimeUnit timeUnit, long l1, long l2) {
		long diff = Math.abs(l1 - l2);
		return DateConvert.convertTimeUnit(diff, TimeUnit.MILLISECONDS, timeUnit);
	}

	public static long calculatorDiff(TimeUnit timeUnit, Object d1, Object d2) {
		long dt1 = DateConvert.getEpochTime(d1);
		long dt2 = DateConvert.getEpochTime(d2);
		return calculatorDiff(timeUnit, dt1, dt2);
	}

	public static void main(String[] args) {
		// Date d1 = new Date(2023, 10, 12);
		// Date d2 = new Date(2023, 10, 20);
		// LocalDate d1 = LocalDate.of(2023, 10, 12);
		// LocalDate d2 = LocalDate.of(2023, Month.OCTOBER, 20);
		LocalDateTime d1 = LocalDateTime.of(2023, 1, 1, 15, 30, 10);
		LocalDateTime d2 = LocalDateTime.of(2023, 12, 1, 15, 30, 10);
		long diff = calculatorDiff(TimeUnit.HOURS, d1, d2);
		System.out.println(diff);
	}

}
