package basic.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * - Kiểm tra ngày '13-07-2023' là thứ mấy
 * 
 * - Có thể tham khảo thêm thuật toán Sakamoto
 */
public class DayOfWeekChecker {

	public static String convertToVietnameseDayOfWeek(DayOfWeek dayOfWeek) {
		String[] daysOfWeekVietnamese = { "Chủ Nhật", "Thứ Hai", "Thứ Ba", "Thứ Tư", //
				"Thứ Năm", "Thứ Sáu", "Thứ Bảy" };
		// Chuyển đổi giá trị thành phạm vi từ 0 đến 6
		int dayOfWeekValue = dayOfWeek.getValue(); // % 7;
		System.out.println("DayOfWeekValue: " + dayOfWeekValue);
		return daysOfWeekVietnamese[dayOfWeekValue];
	}

	public static void main(String[] args) {
		String dateStr = "13-07-2023";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.parse(dateStr, formatter);
		DayOfWeek dayOfWeek = date.getDayOfWeek();

		String dayOfWeekVietnamese = convertToVietnameseDayOfWeek(dayOfWeek);

		System.out.println("Ngày " + dateStr + " là " + dayOfWeek);
		System.out.println("Ngày " + dateStr + " là " + dayOfWeekVietnamese);
	}

}
