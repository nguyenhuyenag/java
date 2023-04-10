package com.basic.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// @NoArgsConstructor
public enum DayOfWeek {

	MONDAY(2, "Thứ hai"), //
	TUESDAY(3, "Thứ ba"), //
	WEDNESDAY(4, "Thứ tư"), //
	THURSDAY(5, "Thứ năm"), //
	FRIDAY(6, "Thứ sáu"), //
	SATURDAY(7, "Thứ bảy"), //
	SUNDAY(8, "Chủ nhật");

	private final int value;
	private final String vietnameseName;

	public static void showAll() {
		for (DayOfWeek e : DayOfWeek.values()) {
			System.out.println(e.name() + ", " + e.getValue() + ", " + e.getVietnameseName());
		}
	}

	public static DayOfWeek fromValue(int value) {
		for (DayOfWeek day : DayOfWeek.values()) {
			if (day.getValue() == value) {
				return day;
			}
		}
		throw new IllegalArgumentException("No enum constant with value " + value);
	}
	
	public static DayOfWeek fromString(String name) {
		return DayOfWeek.valueOf(name);
	}

	public static void main(String[] args) {
		// System.out.println("Value: " + DayOfWeek.MONDAY.getValue());
		
		// showAll();
		
		// DayOfWeek M = fromValue(2);
		DayOfWeek M = fromString("MONDAY");
		System.out.println(M.getVietnameseName());
				
	}

}

