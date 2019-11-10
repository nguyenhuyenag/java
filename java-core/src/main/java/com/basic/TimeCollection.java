package com.basic;

import java.text.ParseException;
import java.util.Calendar;

public class TimeCollection {

	public static void main(String[] args) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
		System.out.println("Current week of month is : " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Current week of year is : " + calendar.get(Calendar.WEEK_OF_YEAR));

		// String[] weekdays = DateFormatSymbols.getInstance().getWeekdays();
		// String[] shortWeekdays = DateFormatSymbols.getInstance().getShortWeekdays();

		// String[] months = DateFormatSymbols.getInstance().getMonths();
		// String[] shortMonths = DateFormatSymbols.getInstance().getShortMonths();

	}
}
