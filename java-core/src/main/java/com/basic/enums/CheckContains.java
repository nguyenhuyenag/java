package com.basic.enums;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CheckContains {

	@Getter
	@AllArgsConstructor
	public enum DayOfWeek {

		MONDAY(2, "Thứ hai"), 	//
		TUESDAY(3, "Thứ ba"), 	//
		WEDNESDAY(4, "Thứ tư"), //
		THURSDAY(5, "Thứ năm"), //
		FRIDAY(6, "Thứ sáu"), 	//
		SATURDAY(7, "Thứ bảy"), //
		SUNDAY(8, "Chủ nhật");

		private final int value;
		private final String vietnameseName;

		private static Set<String> values = new HashSet<>();
		private static Map<Integer, DayOfWeek> map = new HashMap<>();

		// O(n) - runs once
		static {
			for (DayOfWeek choice : DayOfWeek.values()) {
				values.add(choice.name());
				map.put(choice.getValue(), choice);
			}
		}

		// O(1) - runs several times
		public static boolean contains(String value) {
			return values.contains(value);
		}

		// Show all enums information
		public static void showAll() {
			for (DayOfWeek e : DayOfWeek.values()) {
				System.out.println(e.name() + ", " + e.getValue() + ", " + e.getVietnameseName());
			}
		}

		// Find by value: 2, 3, 4,...
		public static DayOfWeek findByValue(int value) {
			if (!map.containsKey(value)) {
				throw new IllegalArgumentException("No enum constant with value " + value);
			}
			return map.get(value);
		}

		// Find by name: MONDAY, TUESDAY,...
		public static DayOfWeek findByName(String name) {
			DayOfWeek dayOfWeek = DayOfWeek.valueOf(name);
			if (dayOfWeek == null) {
				throw new IllegalArgumentException("No enum constant with name " + name);
			}
			return dayOfWeek;
		}
	}

	public static void main(String[] args) {
		// DayOfWeek.contains("MONDAY")	// -> true
		// System.out.println(DayOfWeek.findByValue(7));
		System.out.println(DayOfWeek.findByName("FRIDAYs"));
	}

}
