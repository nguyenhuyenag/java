package learn.basic;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class FormatTime {

	public static String getNowByPattern(String pattern) throws DateTimeException {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		return now.format(format);
	}

	public static void main(String[] args) throws ParseException {

		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
		System.out.println("Current week of month is : " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Current week of year is : " + calendar.get(Calendar.WEEK_OF_YEAR));

		// String[] weekdays = new DateFormatSymbols().getWeekdays();
		// for (int i = 2; i < weekdays.length - 1; i++) {
		// String weekday = weekdays[i];
		// System.out.println("weekday = " + weekday);
		// }

	}
}
