package com.basic.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class StringTools {

	/**
	 * Viết hoa chữ cái đầu tiên
	 */
	public static String firstUpperCase(String str) {
		if (StringUtils.isEmpty(str)) {
			return StringUtils.EMPTY;
		}
		// return StringUtils.capitalize(str);
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * Xóa ký tự tại vị trí index
	 */
	public static String deleteIndex(String input, int index) {
		if (index < 0 || index > input.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range");
		}
		return input.substring(0, index) + input.substring(index + 1);
	}

	/**
	 * Đảo chuỗi
	 */
	public static String reverse(String str) {
		// char[] chars = str.toCharArray();
		// ArrayUtils.reverse(chars);
		// return new String(chars); // hoặc StringUtils.reverse(str);
		StringBuilder sb = new StringBuilder(str);
		return sb.reverse().toString();
	}

	public String reverse2(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverse2(str.substring(1)) + str.charAt(0);
	}

	/**
	 * So sánh chuỗi
	 */
	public static void stringComparator() {
		String[] arr = { "Java", "C++", "C#", "Python" };
		Set<String> set = new TreeSet<>(Arrays.asList(arr));
		System.out.println(Collections.min(set));
		System.out.println(Collections.max(set, String.CASE_INSENSITIVE_ORDER));
	}

	/**
	 * String => char[], byte[]
	 */
	public static void toByteOrChar() {
		String str = "Java";
		byte[] byteArr = str.getBytes();
		char[] charArr = str.toCharArray();
		System.out.println(Arrays.toString(byteArr));
		System.out.println(Arrays.toString(charArr));
	}

	public void startsWith() {
		// StringUtils.startsWith("abcdef", "abc") = true
		// StringUtils.startsWith("ABCDEF", "abc") = false
		// StringUtils.startsWithIgnoreCase("ABCDEF", "abc") = true
	}

	public static void main(String[] args) {
		// String s = "Java";
		// reverse(s);
		// arrayToString();
		// firstUpperCase(s);
		// deleteIndex(s, 0);
		// stringComparator();
		toByteOrChar();
	}

}
