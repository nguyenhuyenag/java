package basic.time.other;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class ApacheDateUtils {

	/*-
	 * - parseDate(): Trả về `null` nếu không tìm thấy một mẫu phù hợp
	 * 
	 * - parseDateStrictly(): Ném ra ParseException nếu không tìm thấy một mẫu phù hợp
	 * 
	 * - addYears, addMonths, addWeeks, addDays, addHours, addMinutes, addSeconds,
	 * addMilliseconds
	 * 
	 * - Tương tự có setYears, addMonths, ...
	 */
	private static void method() throws ParseException {
		Date date = new Date();
		System.out.println("Today: " + date);

		// addMonths -> Thêm 1 tháng
		date = DateUtils.addMonths(date, 1);
		System.out.println("AddMonths: " + date);

		// setDays -> Set ngày hiện tại thành 10
		date = DateUtils.setDays(date, 10);
		System.out.println("SetDays: " + date);
	}

	public static void main(String[] args) throws ParseException {
		method();
	}

}
