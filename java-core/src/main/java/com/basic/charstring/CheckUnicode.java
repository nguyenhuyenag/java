package com.basic.charstring;

public class CheckUnicode {

	public static boolean isUnicode(char c) {
		return (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.BASIC_LATIN);
	}
	
	public static boolean isUnicode2(char c) {
		if ((int) c > 127) {
			return true;
		}
		return false;
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
		System.out.println(isUnicode2('ã'));
		// System.out.println(isUnicode("ä"));
		// System.out.println(isUnicode("☹"));
		// System.out.println(isUnicode("+"));
		// System.out.println(isUnicode("@"));
		// System.out.println(isUnicode("]"));
	}

}
