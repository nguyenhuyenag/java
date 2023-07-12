package com.basic.number;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FormatNumber {

	public static void test() {
//		double d = 2000000.1456;
//		String formattedNumberWithComma = String.format("Formatted number with commas: %,.2f", d);
//		System.out.println(formattedNumberWithComma);
//
//		DecimalFormat df = new DecimalFormat("#,###.00");
//		formattedNumberWithComma = df.format(d);
//		System.out.println("Formatted number with commas: " + formattedNumberWithComma);

//		var dfs = new DecimalFormatSymbols();
//		System.out.println("CurrencySymbol: " + dfs.getCurrencySymbol());
//		System.out.println("GroupingSeparator: " + dfs.getGroupingSeparator());
//		dfs.setGroupingSeparator(',');
//		
//		df = new DecimalFormat("###,##0", dfs);
//		System.out.println(df.format(d));
	}

	public static void customFormat(String pattern, Object input) {
		DecimalFormat format = new DecimalFormat(pattern);
		String output = format.format(input);
		System.out.printf("%s + '%s' -> %s\n", input, pattern, output);
	}

	public static void usingDecimalFormat() {
		var dfs = new DecimalFormatSymbols();
		// System.out.println("CurrencySymbol: " + dfs.getCurrencySymbol());
		System.out.println("GroupingSeparator: " + dfs.getGroupingSeparator());
		dfs.setGroupingSeparator(',');
		
		DecimalFormat df = new DecimalFormat("###,##0", dfs);
		System.out.println(df.format(1234567890));
		
		customFormat("#,###", 1234567890);
		customFormat("###.##", 1234.56789);		// Làm tròn nếu bên phải nhiều hơn 2 chữ số
		customFormat("000000.000", 123.78); 	// Tự thêm số 0 vào đầu và cuối cho giống với mẫu
		customFormat("$###,###.###", 12345.67);
	}
	
	public static void usingStringFormat() {
		int d = 1234567890;
		String format = String.format("%,d", d);
		System.out.printf("'%d' -> %s\n", d, format); // 1.234.567.890

		double x = 1124568.235;
		format = String.format("%,.2f", x);
		System.out.printf("'%f' -> %s\n", x, format); // 1.124.568,24
		
		DecimalFormat df = new DecimalFormat("#,###.00");
		format = df.format(d);
		System.out.println("Formatted number with commas: " + format);
	}

	public static void main(String[] args) {
		// test();
		// usingStringFormat();
		usingDecimalFormat();
	}

}
