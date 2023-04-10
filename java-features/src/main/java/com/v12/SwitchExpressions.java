package com.v12;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchExpressions {

	public static void oldStyle() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		String typeOfDay = "";
		switch (dayOfWeek) {
			case MONDAY:
			case TUESDAY:
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
				typeOfDay = "Working Day";
				break;
			case SATURDAY:
			case SUNDAY:
				typeOfDay = "Day Off";
				break;
		}
		System.out.println(typeOfDay);
	}
	
	public static void newStyle() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		var typeOfDay = switch (dayOfWeek) {
	    	case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
	    	case SATURDAY, SUNDAY -> "Day Off";
		};
		System.out.println(typeOfDay);
	}
	
	public static void main(String[] args) {
		oldStyle();
		// newStyle();
	}

}
