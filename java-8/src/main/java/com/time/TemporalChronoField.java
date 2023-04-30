package com.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class TemporalChronoField {

	public static void main(String[] args) {

		LocalDateTime local = LocalDateTime.now();

		// MONTH_OF_YEAR
		System.out.println("Tháng thứ `" + local.get(ChronoField.MONTH_OF_YEAR) + "` trong năm");

		// DAY_OF_WEEK
		System.out.println("Ngày thứ `" + local.get(ChronoField.DAY_OF_WEEK) + "` trong tuần");
		
		// DAY_OF_YEAR
		System.out.println("Ngày thứ `" + local.get(ChronoField.DAY_OF_YEAR) + "` trong năm");
		
		// DAY_OF_MONTH
		System.out.println("Ngày thứ `" + local.get(ChronoField.DAY_OF_MONTH) + "` trong tháng");

		// HOUR_OF_DAY
		System.out.println("Giờ thứ `" + local.get(ChronoField.HOUR_OF_DAY) + "` trong ngày");

		// MINUTE_OF_HOUR
		System.out.println("Phút thứ `" + local.get(ChronoField.MINUTE_OF_HOUR) + "` trong phút");
		
		// MINUTE_OF_DAY
		System.out.println("Phút thứ `" + local.get(ChronoField.MINUTE_OF_DAY) + "` trong ngày");

	}

}
