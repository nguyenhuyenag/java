package com.basic.enums;

import java.util.EnumSet;

public class EnumCollectionSet {

	enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public static void main(String[] args) {
		// Tạo một EnumSet chứa tất cả các mùa
        EnumSet<Days> allDays = EnumSet.allOf(Days.class);
        System.out.println("All days: " + allDays);
        
		// Tạo một EnumSet chứa các ngày làm việc (MONDAY đến FRIDAY)
		EnumSet<Days> workingDays = EnumSet.range(Days.MONDAY, Days.FRIDAY);
		System.out.println("Working days: " + workingDays);

		// Tạo một EnumSet rỗng của ngày nghỉ
		EnumSet<Days> daysOff = EnumSet.noneOf(Days.class);
		System.out.println("Days off: " + daysOff);
		
		// Tạo một EnumSet với một số ngày cụ thể
        EnumSet<Days> someDays = EnumSet.of(Days.MONDAY, Days.WEDNESDAY, Days.FRIDAY);
        System.out.println("Some days: " + someDays);

		// Thêm các ngày nghỉ vào EnumSet
		daysOff.add(Days.SATURDAY);
		daysOff.add(Days.SUNDAY);
		System.out.println("Updated days off: " + daysOff);

		// Kiểm tra một ngày nghỉ có thuộc EnumSet hay không
		if (daysOff.contains(Days.SATURDAY)) {
			System.out.println("Saturday is a day off");
		}

		// Xóa một ngày nghỉ khỏi EnumSet
		daysOff.remove(Days.SUNDAY);
		System.out.println("Updated days off: " + daysOff);
	}

}
