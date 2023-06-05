package com;

import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance(); // set this up however you need it.
		cal.add(Calendar.DATE, 5);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(day);
	}

}
