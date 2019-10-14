package learn.basic.string;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;

public class StringFormat {

	/*-
	 - %d	 : In số nguyên như tham số đầu vào
	 - %6d	 : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) khoảng trắng vào bên TRÁI
	 - %-6d : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) khoảng trắng vào bên PHẢI
	 - %06d : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) số 0 vào bên TRÁI
	*/
	public static void formatInteger() {
		System.out.printf("%d\n", 9);
		System.out.println(String.format("%6d", 12));
		System.out.println(String.format("%-6d", 12));
		System.out.println(String.format("%06d", 12));
		System.out.println(String.format("%.2d", 123456));
	}

	/**
	 * - %.6s: In tối đa chuỗi 6 ký tự
	 */
	public static void formatString() {
		System.out.println(String.format("%s", "Java"));
		System.out.println(String.format("%.6s", "0123456789"));
	}

	/*-
	 - %f	 : In ra số thập phân
	 - %.6f  : Hiển thị tối đa 6 chữ số thập phân
	 - %9.4f : Hiển thị tối đa 4 chữ số thập phân. Đầu ra ít nhất 9 ký tự, nếu số chữ số không đủ, thêm
	 		   khoảng trắng vào bên trái (phần nguyên)
	*/
	public static void formatFloat() {
		System.out.printf("%f", 1.2);
		System.out.println(String.format("%.6f", 0.123456789));
		System.out.println(String.format("%9.4f", 0.123456789));
		System.out.println(String.format("%9.4f", 1000000000000001.123456789));
	}

	public static void formatMessage() {
		MessageFormat mf = new MessageFormat("JDK {0} release on {1}");
		Object[] array = { 8, LocalDate.of(2014, Month.MARCH, 18) };
		System.out.println(mf.format(array));
	}

	public static void main(String[] args) {
		// formatInteger();
		// formatString();
		// formatFloat();
		formatMessage();
	}

}
