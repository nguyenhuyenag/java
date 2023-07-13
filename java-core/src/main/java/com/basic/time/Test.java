package com.basic.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

	public static String convertToVietnameseDayOfWeek(DayOfWeek dayOfWeek) {
		String[] daysOfWeekVietnamese = { "Chủ nhật", "Thứ hai", "Thứ ba", "Thứ tư", "Thứ năm", "Thứ sáu", "Thứ bảy" };
		int dayOfWeekValue = dayOfWeek.getValue() % 7; // Chuyển đổi giá trị thành phạm vi từ 0 đến 6
		return daysOfWeekVietnamese[dayOfWeekValue];
	}

	public static void main(String[] args) {
		String dateStr = "20-07-2023";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		String dayOfWeekVietnamese = convertToVietnameseDayOfWeek(dayOfWeek);
		System.out.println("Ngày " + dateStr + " là " + dayOfWeekVietnamese);
	}

}
