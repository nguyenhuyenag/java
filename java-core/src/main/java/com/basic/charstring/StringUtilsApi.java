package com.basic.charstring;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsApi {

	/*-
	 * - stripAccents(): Xóa dấu (vẫn còn xót "đ")
	 * 
	 * - equals():
	 * - equalsIgnoreCase():
	 * 
	 * - indexOf():
	 * - lastIndexOf():
	 * - indexOfAny():
	 * 
	 * - contains():
	 * - containsIgnoreCase(): 
	 * - containsAny():
	 * 
	 */
	private static void method() {
		// isAnyEmpty: Có ít nhất 1 phần tử là empty
		boolean isAnyEmpty = StringUtils.isAnyEmpty("", "AA", null);
		System.out.println("IsAnyEmpty: " + isAnyEmpty);

		// isNoneEmpty: Có ít nhất 1 phần tử là NOT empty
		boolean isNoneBlank = StringUtils.isNoneBlank("", "AA", null);
		System.out.println("IsNoneBlank: " + isNoneBlank);

		// isAllEmpty: Tất cả các phần tử đều empty
		boolean isAllEmpty = StringUtils.isAllEmpty(null, "", "", null);
		System.out.println("IsNoneBlank: " + isAllEmpty);

		// equalsAny: Kiểm tra giá trị có bằng với giá trị bất kỳ trong danh sách
		String key = "apple";
		boolean isEqualsAny = StringUtils.equalsAny(key, "apple", "banana", "orange");
		System.out.println("EqualsAny: " + isEqualsAny);

		// substringBefore, substringAfter:
		String str = "Hello, World";
		String substringBefore = StringUtils.substringBefore(str, ",");
		String substringAfter = StringUtils.substringAfter(str, ",");
		System.out.println("SubstringBefore: " + substringBefore); // Hello
		System.out.println("SubstringAfter: " + substringAfter); // World

		// substringBetween:
		str = "Hello [World]";
		String substringBetween = StringUtils.substringBetween(str, "[", "]");
		System.out.println("SubstringBetween: " + substringBetween);
		String[] substringsBetween = StringUtils.substringsBetween("[a][b][c]", "[", "]"); // -> [a, b, c]
		System.out.println("SubstringsBetween: " + Arrays.toString(substringsBetween));

		// splitByWholeSeparator:
		str = "Hello---World---Universe";
		String[] splitByWholeSeparator = StringUtils.splitByWholeSeparator(str, "---"); // Hello, World, Universe
		System.out.println("SplitByWholeSeparator: " + Arrays.toString(splitByWholeSeparator));
	}

	public static void main(String[] args) {
		method();
	}

}
