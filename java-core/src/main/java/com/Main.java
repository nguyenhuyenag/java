package com;

public class Main {

	public static void main(String[] args) {
		Long a1 = 1L;
		Long a2 = 1L;
		System.out.println(a1 == a2); // true
		
		Long b1 = 1000L;
		Long b2 = 1000L;
		System.out.println(b1 == b2); // false
	}

}
