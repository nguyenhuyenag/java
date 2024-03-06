package com.basic.strings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * - Xem thêm StringJoiner Java 8
 */
public class CollectionToString {

	private static final String[] arr = { "Java", "C", "PHP", "Python" };

	/**
	 * Array -> String
	 */
	public static void arrayToString() {
		// System.out.println(Arrays.toString(arr));
		System.out.println(String.join("_", arr));
		System.out.println(StringUtils.join(arr, "_"));
	}

	public static void listToString() {
		List<String> list = Arrays.asList(arr);
		System.out.println(String.join("|", list));
		System.out.println(StringUtils.join(list, "-"));
	}

	public static void joinWithPrefixSuffix() {
		List<String> list = Arrays.asList(arr);
		String result = list.stream() //
				.collect(Collectors.joining("-", "{", "}"));
		System.out.println(result);
	}

	public static void main(String[] args) {
		// arrayToString();
		// listToString();
		joinWithPrefixSuffix();
	}

}
