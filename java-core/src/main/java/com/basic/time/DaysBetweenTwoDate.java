package com.basic.time;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDate {

	public static long betweenDates(Date d1, Date d2, TimeUnit unit) throws IOException {
		return ChronoUnit.DAYS.between(d1.toInstant(), d2.toInstant());
	}

	private static long convertTimeUnit(TimeUnit unit, Date d1, Date d2) {
		long diff = Math.abs(d1.getTime() - d2.getTime());
		// millisecond -> other
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static void main(String[] args) {
		// LocalDate d1 = LocalDate.of(2023, Month.JUNE, 10);
		// LocalDate d2 = LocalDate.of(2023, Month.JUNE, 15);
		// long result = call1(d1, d2, TimeUnit.DAYS);
		Date d1 = new Date(2023, 10, 12);
		Date d2 = new Date(2023, 10, 20);
		long diff = convertTimeUnit(TimeUnit.HOURS, d1, d2);
		System.out.println(diff);
	}

}
