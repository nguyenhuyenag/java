package com.basic.time;

import java.util.Date;

public class DateCompare {

	public static void main(String[] args) {
		String pattern = "dd-MM-yyyy HH:mm:ss";
		Date d1 = DateTimeUtils.stringToDate("01-01-2020 02:03:01", pattern);
		Date d2 = DateTimeUtils.stringToDate("01-01-2020 02:03:02", pattern);
		Date d3 = DateTimeUtils.stringToDate("01-10-2020 02:03:03", pattern);

		System.out.println("d1 < d2: " + d1.compareTo(d2)); // = -1 ->	d1 < d2
		System.out.println("d2 = d2: " + d2.compareTo(d2)); // =  0 ->	d2 = d2
		System.out.println("d3 > d2: " + d3.compareTo(d2)); // =  1	->	d3 > d32

		System.out.println("Before: " + d1.before(d1));
		System.out.println("After: " + d1.after(d2));
	}

}
