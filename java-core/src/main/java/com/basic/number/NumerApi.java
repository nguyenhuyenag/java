package com.basic.number;

public class NumerApi {

	// Chuyển hệ thập phân sang hệ cơ số khác
	public static void doiHeCoSo() {
		int n = 13;
		System.out.println(Integer.toBinaryString(n));    // => nhị phân
		System.out.println(Integer.toString(n, 2));     // => nhị phân
		System.out.println(Integer.toString(n, 8));        // => bát phân
		System.out.println(Integer.toString(n, 16));     // => thập lục phân
	}

	public static void base() {
		int a = 7, b = 3;// -> a = 2 * b + 1
		System.out.println((float) a / b); 	// Chia thông thường
		System.out.println(a / b); 			// Chia nguyên (quotient)
		System.out.println(a % b); 			// Chia dư (remainder)
	}

	public static void main(String[] args) {
		base();
		doiHeCoSo();
	}

}
