package com.basic.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class StringCollection {

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
	public static String deleteIndex(String s, int index) {
		if (index < 0 || index > s.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range");
		}
		return s.substring(0, index) + s.substring(index + 1);
	}

	/**
	 * Đảo chuỗi
	 */
	public static String reverse(String str) {
		char[] chars = str.toCharArray();
		ArrayUtils.reverse(chars);
		// return StringUtils.reverse(str);
		return new String(chars);
	}

	/**
	 * Chuyển mảng thành String
	 */
	public static void arrayToString() {
		String[] arr = { "Java", "C++", "C#", "Python" };
		System.out.println(Arrays.toString(arr));
		System.out.println(String.join(" ", arr));
		System.out.println(StringUtils.join(arr, " "));
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
	 * @see ASCII
	 */
	public static void toByteOrChar() {
		String str = "Java";
		byte[] byteArr = str.getBytes();
		char[] charArr = str.toCharArray();
		System.out.println(Arrays.toString(byteArr));
		System.out.println(Arrays.toString(charArr));
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
