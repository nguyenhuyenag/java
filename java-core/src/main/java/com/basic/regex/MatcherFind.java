package com.basic.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherFind {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) {

		String data = "This 1 is 2 a 234 String";

		// Khoảng trắng xuất hiện 1 hoặc nhiều lần
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(data);

		while (matcher.find()) {
			System.out.println( //
					  "start: " + matcher.start() //
					+ ", end: " + matcher.end() //
					+ ", group: " + matcher.group());
		}

		System.out.println(data.substring(5, 6));
		System.out.println(data.substring(10, 11));

	}

}
