package common.date;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormatTime {

	public static void main(String[] args) throws ParseException {

		Date date = new Date();
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String timeFormat = sdf.format(date);
		System.out.println(timeFormat);

		//
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE));

		//
		SimpleDateFormat simpDate;
		simpDate = new SimpleDateFormat("kk:mm:ss");
		System.out.println(simpDate.format(date));

		//
		Format formatter = new SimpleDateFormat("MMMM");
		String s = formatter.format(new Date());
		System.out.println(s);

		//
		String[] weekdays = new DateFormatSymbols().getWeekdays();
		for (int i = 2; i < (weekdays.length - 1); i++) {
			String weekday = weekdays[i];
			System.out.println("weekday = " + weekday);
		}

		//
		System.out.println("Current week of month is : " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("Current week of year is : " + cal.get(Calendar.WEEK_OF_YEAR));
		
		// String to Date
		DateFormat dateFormat = new SimpleDateFormat(pattern);
		Date dateFromStr = dateFormat.parse(timeFormat);
		System.out.println("Resultant Date and Time = " + dateFromStr.toString());
	}
}
