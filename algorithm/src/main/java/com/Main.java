package com;

public class Main {

	public static int toDecimal(String str) {
		int n = 0, incr = 1;
		String[] arr = str.split("");
		int len = arr.length;
		for (int i = len - 1; i >= 0; i--) {
			n += Integer.parseInt(arr[i]) * incr;
			incr *= 2;
		}
		return n;
	}

//	public static String addBinary(String a, String b) {
//		int a1 = toDecimal(a);
//		int a2 = toDecimal(b);
//		return Integer.toBinaryString(a1 + a2);
//	}

	public static String addBinary(String a, String b) {
		int x = Integer.parseInt(a, 2);
		int y = Integer.parseInt(b, 2);
		return Integer.toBinaryString(x + y);
	}

	public static void main(String[] args) {
		String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
		// String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
		// System.out.println(addBinary(a, b));
		System.out.println(toDecimal(a));
		//System.out.println(Integer.parseInt(a, 2));
		System.out.println(Integer.toBinaryString(8));
	}

}
