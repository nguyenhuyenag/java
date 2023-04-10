package com.basic.enums;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;

public class CheckContains {
	
	@AllArgsConstructor
	public enum WEEKLY {
		MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7), SUNDAY(0);
		
		private int value;

		private static Set<String> _values = new HashSet<>();

		// O(n) - runs once
		static {
			for (WEEKLY choice : WEEKLY.values()) {
				_values.add(choice.name());
			}
		}

		// O(1) - runs several times
		public static boolean contains(String value) {
			return _values.contains(value);
		}
	}
	
	public static void test() {
		String MON = "MONDAY";
		System.out.println(WEEKLY.contains(MON));
	}
	
	public static void main(String[] args) {
		// test();
		for (WEEKLY choice : WEEKLY.values()) {
			System.out.println(choice.value);
		}
	}

}
