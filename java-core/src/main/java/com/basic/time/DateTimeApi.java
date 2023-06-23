package com.basic.time;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;

// Xem thêm time trong Java 8
public class DateTimeApi {

	public static void byLocalDateTime() {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		int millis = now.get(ChronoField.MILLI_OF_SECOND); // Note: no direct getter available
		System.out.println("DayOfMonth: " + now.getDayOfMonth());
		System.out.println("DayOfWeek: " + now.getDayOfWeek());
		System.out.println("DayOfYear: " + now.getDayOfYear());
		System.out.printf("LocalDateTime: %d-%02d-%02d %02d:%02d:%02d.%03d\n", year, month, day, hour, minute, second, millis);
	}

	public static void byCalendar() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1; // Note: zero based!
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millis = calendar.get(Calendar.MILLISECOND);
		System.out.println("DayOfWeek: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DayOfMonth: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DayOfYear: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("WeekOfMonth: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WeekOfYear: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.printf("Calendar: %d-%02d-%02d %02d:%02d:%02d.%03d", year, month, day, hour, minute, second, millis);
	}

	public static void basicDateTimeInfo() {
		byCalendar();
		// byLocalDateTime();
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
		basicDateTimeInfo();
		// firstDayOfWeek();
	}
}
