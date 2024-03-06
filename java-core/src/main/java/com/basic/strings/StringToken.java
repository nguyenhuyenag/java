package com.basic.strings;

import java.util.StringTokenizer;

public class StringToken {

	public static void main(String[] args) {
		String property = "C:/WINDOWS/System32/OpenSSH/";
		String delim = "/"; // delim = " " is default
		StringTokenizer parser = new StringTokenizer(property, delim); 
		while (parser.hasMoreTokens()) {
			System.err.println(parser.nextToken());
		}
	}
}
