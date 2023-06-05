package com.basic.time;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

// Xem thêm time trong Java 8
public class TimeCollection {

	public static void test() {
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
		System.out.println("Current week of month: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Current week of year: " + calendar.get(Calendar.WEEK_OF_YEAR));
	}

	// Ngày đầu tiên của tuần hiện tại
	public static void firstDayOfWeek() {
		// Ngày hiện tại
		LocalDate today = LocalDate.now();
		// Ngày đầu tiên của tuần hiện tại
		LocalDate firstDayOfWeek = today.with(DayOfWeek.MONDAY);
		System.out.println("Ngày đầu tiên của tuần: " + firstDayOfWeek);
	}

	public static void main(String[] args) throws ParseException {
		firstDayOfWeek();
	}
}
