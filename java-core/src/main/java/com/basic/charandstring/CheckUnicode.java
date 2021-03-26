package com.basic.charandstring;

public class CheckUnicode {

	public static boolean isUnicode(char c) {
		return (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN);
	}
	
	public static boolean isUnicode(String str) {
		for (char c : str.toCharArray()) {
			if (isUnicode(c)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isUnicode('ã'));
		System.out.println(isUnicode("nguyễn"));
	}

}
