package learn.basic;

import java.text.DecimalFormat;

public class NumberCollection {

	// Decimal Format
	static void customFormat(String pattern, double value) {
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String output = myFormatter.format(value);
		System.out.println(value + ": \t" + pattern + "	\t= " + output);
	}

	// Decimal Format
	static public void formatDecimal() {
		customFormat("###,###.###", 123456.789);
		customFormat("###.##", 123456.789); // làm tròn nếu bên phải nhiều hơn 2 chữ số
		customFormat("000000.000", 123.78); // tự thêm số 0 vào đầu và cuối
		customFormat("$###,###.###", 12345.67);
	}
	
	// Chuyển hệ thập phân sang hệ cơ số khác
	public static void doiHeCoSo() {
		int n = 13;
		System.out.println(Integer.toBinaryString(n));	// => nhị phân
		System.out.println(Integer.toString(n, 2)); 	// => nhị phân
		System.out.println(Integer.toString(n, 8));		// => bát phân
		System.out.println(Integer.toString(n, 16)); 	// => thập lục phân
	}

	public static void main(String[] args) {
		// formatDecimal();
		doiHeCoSo();
	}

}
