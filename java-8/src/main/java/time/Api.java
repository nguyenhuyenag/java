package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Api {

	public static void TimeApi() {

		// the current date
		LocalDate date = LocalDate.now();
		System.out.println("The current date is " + date);

		// the current time
		LocalTime time = LocalTime.now();
		System.out.println("The current time is " + time);

		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("Current date & time : " + current);

		// to print in a particular format
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatedDateTime = current.format(format);
		System.out.println("In foramatted manner: " + formatedDateTime);

		// printing months days and seconds
		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		String ouput = String.format("Month: %s, Day: %s, Seconds: %s", month, day, seconds);
		System.out.println(ouput);

		// printing some specified date
		LocalDate date2 = LocalDate.of(1950, 1, 26);
		System.out.println("The repulic day:" + date2);

	}

	public static void main(String[] args) {
		TimeApi();
	}

}
