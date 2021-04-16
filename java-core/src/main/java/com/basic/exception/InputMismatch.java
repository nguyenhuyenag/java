package com.basic.exception;

import java.time.format.DecimalStyle;
import java.util.Locale;
import java.util.Scanner;

/*-
 * - Đây là lỗi do nhập sai dấu phân cách của kiểu thập phân (decimal separator)
 * 
 * - Nhập 1.1 (đúng) và 1,1 (exception)
 */
public class InputMismatch {

	public static void getDecimalSeparator() {
		// DecimalStyle.ofDefaultLocale();
		DecimalStyle ds = DecimalStyle.STANDARD;
		System.out.println("Decimal separator: " + ds.getDecimalSeparator());
		ds = DecimalStyle.of(Locale.FRENCH);
		System.out.println("Decimal separator: " + ds.getDecimalSeparator());
	}

	public static void showException() {
		// Locale.setDefault(Locale.FRANCE);
		try (Scanner reader = new Scanner(System.in)) {
			// reader.useLocale(Locale.FRENCH); => 1,1
			System.out.print("Enter number: ");
			double v = reader.nextDouble();
			System.out.println(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		showException();
		// getDecimalSeparator();
	}

}
