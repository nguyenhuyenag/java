package com.basic.number;

public class NumberCollection {
	
	// Chuyển hệ thập phân sang hệ cơ số khác
	public static void doiHeCoSo() {
		int n = 13;
		System.out.println(Integer.toBinaryString(n));	// => nhị phân
		System.out.println(Integer.toString(n, 2)); 	// => nhị phân
		System.out.println(Integer.toString(n, 8));		// => bát phân
		System.out.println(Integer.toString(n, 16)); 	// => thập lục phân
	}

	public static void main(String[] args) {
		doiHeCoSo();
	}

}
