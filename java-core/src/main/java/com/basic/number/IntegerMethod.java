package com.basic.number;

public class IntegerMethod {

	public static void main(String[] args) {
		int n = 25;
		
		System.out.println("Nhị phân: " + Integer.toBinaryString(n));
		System.out.println("Bát phân: " + Integer.toHexString(n));
		System.out.println("Thập lục phân: " + Integer.toOctalString(n));
		
		// Chuyển số nguyên không dấu sang cơ số bât kỳ
		String radix = Integer.toUnsignedString(n, 2);
		System.out.println("Cơ số bất kỳ: " + radix);
		// Cơ số bất kỳ về số nguyên không dấu
		System.out.println("Ngược lại: " + Integer.parseUnsignedInt(radix, 2));

		System.out.println("Đếm bit số '1': " + Integer.bitCount(n));
		System.out.println("Đảo nhị phân: " + Integer.reverse(n));
	}

}
