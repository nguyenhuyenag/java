package com.time;

import java.time.LocalDate;

public class LocalDateNow {

	public static void main(String[] args) {

		LocalDate now = LocalDate.now();

		// today
		System.out.println(now);

		// yesterday
		LocalDate yesterday = now.minusDays(1);
		System.out.println("yesterday: " + yesterday);

		// tomorrow
		LocalDate tomorrow = now.plusDays(1);
		System.out.println("tomorrow: " + tomorrow);

		// isLeapYear()
		System.out.println(now.isLeapYear());

		// isLeapYear()
		LocalDate local = LocalDate.of(2016, 9, 23);
		System.out.println(local.isLeapYear());

	}
}
