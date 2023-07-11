package com.basic.charstring;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;

/**
 * SPECIFIER		APPLIES TO 								OUTPUT
 * 
 * %a			Floating point (except BigDecimal) 		Returns a Hex output of floating point number
 * 
 * 
 * %b 			Boolean 								True/False
 * 
 * %c 			Character 								Unicode character
 * 
 * %d 			Integer 								Decimal integer
 * 
 * %e 			Floating point 							a decimal number in scientific notation
 * 
 * %f 			Floating point 							decimal number
 * 
 * %g 			Floating point 							decimal number, possibly in scientific notation depending on the precision and value
 * 
 * %h 			Any type 								Hex String of value from hashCode() method
 * 	
 * %n 			None 									Platform-specific line separator
 * 
 * %o 			integer 								Octal number
 * 
 * %s 			Any type 								String value
 * 
 * %t 			Date/Time 								%t is the prefix for Date/Time conversions.
 * 
 * %x 			Integer 								Hex string
 */
public class StringFormat {

	/*-
	 - %d	 : In số nguyên như tham số đầu vào
	 - %6d	 : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) khoảng trắng vào bên TRÁI
	 - %-6d  : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) khoảng trắng vào bên PHẢI
	 - %06d  : In số nguyên, nếu số chữ số = n < 6, thì thêm (6 - n) số 0 vào bên TRÁI
	*/
	public static void formatInteger() {
		System.out.println(String.format("%d", 9));
		System.out.println(String.format("%6d", 12));
		System.out.println(String.format("%-6d", 12));
		System.out.println(String.format("%06d", 12));
		// System.out.println(String.format("%.2d", 123456));
	}

	/*-
	 * 	%.6s: In tối đa chuỗi 6 ký tự
	 */
	public static void formatString() {
		System.out.println(String.format("%s", "Java"));
		System.out.println(String.format("%.6s", "0123456789"));
	}

	/*-
	 - %f	 : In ra số thập phân
	 - %.6f  : Hiển thị tối đa 6 chữ số thập phân
	 - %9.4f : Hiển thị tối đa 4 chữ số thập phân. Đầu ra ít nhất 9 ký tự, nếu số chữ số không đủ,
	 		   thêm khoảng trắng vào bên trái (phần nguyên)
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
		formatString();
		// formatFloat();
		// formatMessage();
	}

}
