package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		// Example 1
		String input = "hello;world;java";
        char sep = ';';
		String result = StringUtils.reverseDelimited(input, sep);
		System.out.printf("'%s' -> '%s'", input, result);
	}

}
