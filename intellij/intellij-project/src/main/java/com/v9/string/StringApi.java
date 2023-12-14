package com.v9.string;

public class StringApi {

	public static void chars() {
		String str = "Hello";
		str.chars().forEach(ch -> System.out.println(ch)); // 72 101 108 108 111
	}

	public static void main(String[] args) {
		chars();
	}

}
