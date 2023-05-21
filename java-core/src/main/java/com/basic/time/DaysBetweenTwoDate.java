package com.basic.time;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

//	public static long betweenDates(Date d1, Date d2, TimeUnit unit) throws IOException {
//		return ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
//	}

	public static long calculatorDiff(TimeUnit timeUnit, long l1, long l2) {
		long diff = Math.abs(l1 - l2);
		return DateConvert.convertTimeUnit(diff, TimeUnit.MILLISECONDS, timeUnit);
	}

	public static long calculatorDiff(TimeUnit timeUnit, Date d1, Date d2) {
		return calculatorDiff(timeUnit, d1.getTime(), d2.getTime());
	}

	public static void main(String[] args) {
		// Date d1 = new Date(2023, 10, 12);
		// Date d2 = new Date(2023, 10, 20);
		LocalDate ld1 = LocalDate.of(2023, Month.OCTOBER, 12);
		LocalDate ld2 = LocalDate.of(2023, Month.OCTOBER, 20);
		long l1 = DateConvert.getEpochTime(ld1);
		long l2 = DateConvert.getEpochTime(ld2);
		long diff = calculatorDiff(TimeUnit.HOURS, l1, l2);
		System.out.println(diff);
	}

}
