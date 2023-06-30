package com.basic.time;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

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
		// System.out.println("DayOfMonth: " + now.getDayOfMonth());
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
		// System.out.println("DayOfMonth: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DayOfYear: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("WeekOfMonth: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("WeekOfYear: " + calendar.get(Calendar.WEEK_OF_YEAR));
		// Last day of month
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("LastDayOfMonth: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.printf("Calendar: %d-%02d-%02d %02d:%02d:%02d.%03d\n", year, month, day, hour, minute, second, millis);
	}

	public static void basicDateTimeInfo() {
		byCalendar();
		// byLocalDateTime();
	}

	public static void firstDayOfWeek() {
		LocalDate today = LocalDate.now();
		LocalDate firstDayOfWeek = today.with(DayOfWeek.MONDAY);
		LocalDate lastDayOfWeek = today.with(DayOfWeek.SUNDAY);
		LocalDate lastDayOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("Ngày đầu tiên của tuần: " + firstDayOfWeek);
		System.out.println("Ngày cuối cùng của tuần: " + lastDayOfWeek);
		System.out.println("Ngày cuối cùng của tháng: " + lastDayOfMonth);
	}
	
	public static void dateCompare() {
		String pattern = "dd-MM-yyyy HH:mm:ss";
		Date d1 = TimeUtils.stringToDate("01-01-2020 02:03:01", pattern);
		Date d2 = TimeUtils.stringToDate("01-01-2020 02:03:02", pattern);
		Date d3 = TimeUtils.stringToDate("01-10-2020 02:03:03", pattern);

		System.out.println("d1 < d2: " + d1.compareTo(d2)); // = -1 ->	d1 < d2
		System.out.println("d2 = d2: " + d2.compareTo(d2)); // =  0 ->	d2 = d2
		System.out.println("d3 > d2: " + d3.compareTo(d2)); // =  1	->	d3 > d32

		System.out.println("Before: " + d1.before(d1));
		System.out.println("After: " + d1.after(d2));
	}

	public static void main(String[] args) throws ParseException {
		dateCompare();
		// firstDayOfWeek();
		// basicDateTimeInfo();
	}
}
