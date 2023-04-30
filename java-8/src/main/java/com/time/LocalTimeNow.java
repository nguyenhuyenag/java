package com.time;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class LocalTimeNow {

	public static void main(String[] args) {

		LocalTime now = LocalTime.now();
		
		// now
		System.out.println(now);

		// of()
		LocalTime _time = LocalTime.of(10, 43, 12);
		System.out.println(_time);

		// minusHours() and minusMinutes()
		LocalTime local = LocalTime.of(10, 43, 12);
		System.out.println(local);
		System.out.println(local.minusHours(2));
		System.out.println(local.minusMinutes(34));

		// plusHours() and plusMinutes()
		ZoneId zone1 = ZoneId.of("Asia/Ho_Chi_Minh");
		ZoneId zone2 = ZoneId.of("Asia/Tokyo");
		LocalTime time1 = LocalTime.now(zone1);
		System.out.println("Ho Chi Minh Time Zone: " + time1);

		LocalTime time2 = LocalTime.now(zone2);
		System.out.println("Japan Time Zone: " + time2);

		long hours = ChronoUnit.HOURS.between(time1, time2);
		System.out.println("Hours between two Time Zone: " + hours);

		long minutes = ChronoUnit.MINUTES.between(time1, time2);
		System.out.println("Minutes between two time zone: " + minutes);

	}

}
