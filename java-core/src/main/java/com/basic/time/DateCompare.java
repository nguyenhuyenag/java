package com.basic.time;

import java.util.Date;

import common.util.DateTimeUtils;

public class DateCompare {

	public static void main(String[] args) {
		String pattern = "dd-MM-yyyy HH:mm:ss";
		Date d1 = DateTimeUtils.stringToDate("01-01-2020 02:03:04", pattern);
		Date d2 = DateTimeUtils.stringToDate("02-01-2020 02:03:04", pattern);
		Date d3 = DateTimeUtils.stringToDate("03-10-2020 02:03:04", pattern);
		
		System.out.println("d1 = d1: " + d1.compareTo(d1)); 	// d1 = d1
		System.out.println("d1 < d2: " + d1.compareTo(d2)); 	// d1 < d2
		// System.out.println("d2 < d3: " + d2.compareTo(d3)); 	// d2 < d3
		System.out.println("d3 > d1: " + d3.compareTo(d1)); 	// d3 > d1

		System.out.println(d1.before(d1));
		// System.out.println(d1.after(d2));
	}

}
