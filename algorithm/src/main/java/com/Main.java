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

	public static String addBinary(String a, String b) {
		int x = Integer.parseInt(a, 2);
		int y = Integer.parseInt(b, 2);
		return Integer.toBinaryString(x + y);
	}

	public static void main(String[] args) {
		
	}

}
