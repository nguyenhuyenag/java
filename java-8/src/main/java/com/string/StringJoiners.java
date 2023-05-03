package com.string;

import java.util.StringJoiner;

public class StringJoiners {

	public static void example1() {
		StringJoiner joiner = new StringJoiner("-");
		joiner.add("1");
		joiner.add("2");
		System.out.println(joiner.toString());
	}

	// StringJoiner(delimiter, prefix, suffix)
	public static void example2() {
		StringJoiner joiner = new StringJoiner("-", "[", "]");
		joiner.add("A");
		joiner.add("B");
		joiner.add("C");
		System.out.println(joiner.toString());
	}

	public static void main(String[] args) {
		example1();
		example2();
	}

}
