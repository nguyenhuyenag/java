package com.basic.charstring;

import java.util.StringTokenizer;

public class StringToken {

	public static void main(String[] args) {
		String property = "C:/WINDOWS/System32/OpenSSH/";
		StringTokenizer parser = new StringTokenizer(property, "/"); // delim = " " is default
		while (parser.hasMoreTokens()) {
			System.err.println(parser.nextToken());
		}
	}
}
