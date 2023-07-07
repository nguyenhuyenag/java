package com.basic.charstring;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.chop;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.apache.commons.lang3.StringUtils.equalsAny;
import static org.apache.commons.lang3.StringUtils.isAllEmpty;
import static org.apache.commons.lang3.StringUtils.isAnyEmpty;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.overlay;
import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.removeStart;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.replace;
import static org.apache.commons.lang3.StringUtils.replaceEach;
import static org.apache.commons.lang3.StringUtils.replaceOnce;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.apache.commons.lang3.StringUtils.splitByCharacterType;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;
import static org.apache.commons.lang3.StringUtils.splitByWholeSeparator;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;
import static org.apache.commons.lang3.StringUtils.uncapitalize;

import java.util.Arrays;

public class StringUtilsApi {

	public static void splitByCharacter_Type() {
		String input = "Hello123! wo1412rld";

		// Không tính khoảng trắng
		// String regex =
		// "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)";

		// Kể cả khoảng trắng
		String regex = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)|(?<=\\s)(?=\\S)|(?<=\\S)(?=\\s)";
		String[] result = input.split(regex);
		System.out.println("SplitByRegex: " + Arrays.toString(result));

		// SplitByCharacterTypeCamelCase
		String[] splitByCharacterTypeCamelCase = splitByCharacterTypeCamelCase(input);
		System.out.println("SplitByCharacterTypeCamelCase: " + Arrays.toString(splitByCharacterTypeCamelCase));

		// splitByCharacterType: Tách chuỗi dựa trên loại ký tự, phân biệt hoa & thường
		String[] splitByCharacterType = splitByCharacterType(input);
		System.out.println("SplitByCharacterType: " + Arrays.toString(splitByCharacterType));
	}

	/*-
	 * - stripAccents(): Xóa dấu (vẫn còn xót "đ")
	 * 
	 * - firstNonEmpty, firstNonBlank: Trả về phần tử đầu tiên khác empty hoặc blank
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
	 */
	public static void method() {
		/**
		 * isAnyEmpty: Có ít nhất 1 phần tử là empty
		 */
		boolean isAnyEmpty = isAnyEmpty("", "AA", null);
		System.out.println("IsAnyEmpty: " + isAnyEmpty + "\n");

		/**
		 * isNoneEmpty: Có ít nhất 1 phần tử là NOT empty
		 */
		boolean isNoneBlank = isNoneBlank("", "AA", null);
		System.out.println("IsNoneBlank: " + isNoneBlank + "\n");

		/**
		 * isAllEmpty: Tất cả các phần tử đều empty
		 */
		boolean isAllEmpty = isAllEmpty(null, "", "", null);
		System.out.println("IsNoneBlank: " + isAllEmpty + "\n");

		/**
		 * equalsAny: Kiểm tra giá trị có bằng với giá trị bất kỳ trong danh sách
		 */
		String str = "apple";
		boolean isEqualsAny = equalsAny(str, "apple", "banana", "orange");
		System.out.println("EqualsAny: " + isEqualsAny + "\n");

		/**
		 * substringBefore:
		 */
		str = "Hello, World";
		String substringBefore = substringBefore(str, ",");
		System.out.println("SubstringBefore: " + str + " -> " + substringBefore); // Hello
		/**
		 * substringAfter
		 */
		String substringAfter = substringAfter(str, ",");
		System.out.println("SubstringAfter: " + str + " -> " + substringAfter + "\n"); // World

		/**
		 * substringBetween: Tìm chuỗi con (đầu tiên) nằm giữa 2 chuỗi
		 */
		str = "Hello [World]";
		String substringBetween = substringBetween(str, "[", "]");
		System.out.println("SubstringBetween: " + str + " -> " + substringBetween);
		/**
		 * substringsBetween: Tìm tất cả các chuỗi con nằm giữa 2 chuỗi
		 */
		str = "[a][b][c]";
		String[] substringsBetween = substringsBetween(str, "[", "]"); // -> [a, b, c]
		System.out.println("SubstringsBetween: " + str + " -> " + Arrays.toString(substringsBetween) + "\n");

		/**
		 * splitByWholeSeparator
		 */
		str = "Hello---World---Universe";
		String[] splitByWholeSeparator = splitByWholeSeparator(str, "---"); // Hello, World, Universe
		String output = Arrays.toString(splitByWholeSeparator);
		System.out.println("SplitByWholeSeparator: " + str + " -> " + output + "\n");

		/**
		 * leftPad, rightPad: Thêm kí tự vào chuỗi cho đến khi bằng độ dài mong muốn
		 */
		str = "12345";
		String leftPad = leftPad(str, 10, "0");
		System.out.println("LeftPad: " + str + " -> " + leftPad);
		String rightPad = rightPad(str, 10, "0");
		System.out.println("RightPad: " + str + " -> " + rightPad + "\n");

		/**
		 * join: Nối các phần tử thành chuỗi
		 */
		System.out.println("Join default: " + join("A", "B")); // default
		/**
		 * Nối các phần tử với dấu phân cách separator (kiểu char)
		 */
		int[] A1 = { 1, 2, 3, 4 };
		String[] A2 = { "apple", "banana", "orange" };
		char separator = '-';
		System.out.println("Join Primitive: " + join(A1, separator));
		System.out.println("Join Object: " + join(A2, separator) + "\n");

		/**
		 * deleteWhitespace: Xóa khoảng trắng
		 */
		str = "abc     d       e           ";
		System.out.println("DeleteWhitespace: " + deleteWhitespace(str) + "\n");

		/**
		 * remove: Loại bỏ chuỗi con khỏi chuỗi khác
		 * 
		 * - Tương tự có removeIgnoreCase
		 */
		str = "Hello World";
		System.out.println("Remove: " + remove(str, "o")); // Hell, Wrld
		/**
		 * removeStart, removeStartIgnoreCase: Xóa một chuỗi khỏi đầu một chuỗi nếu nó
		 * tồn tại
		 * 
		 * - Tương tự có removeEnd, removeEndIgnoreCase
		 */
		str = "Hello World";
		String prefix = "Hello ";
		System.out.println("RemoveStart: " + str + " -> " + removeStart(str, prefix) + "\n");

		/**
		 * replaceOnce: Thay thế lần đầu tiên xuất hiện của một chuỗi con trong chuỗi
		 * nguồn
		 * 
		 * - Tương tự có replaceOnceIgnoreCase
		 */
		str = "Hello, Hello, World!";
		String searchString = "Hello";
		String replacement = "Hi";
		System.out.println("ReplaceOnce: " + str + " -> " + replaceOnce(str, searchString, replacement));

		/**
		 * - replace: Thay thế tối đa n lần
		 */
		str = "org.apache.commons.lang3.StringUtils";
		String replace = replace(str, ".", "_", 3);
		System.out.println("Replace max: " + str + " -> " + replace);

		/**
		 * - replaceEach: Thay thế một mảng các chuỗi con tương ứng bằng một mảng các
		 * chuỗi khác
		 */
		str = "Hello World";
		String[] searchList = { "Hello", "World" };
		String[] replacementList = { "Hi", "Java" };
		String result = replaceEach(str, searchList, replacementList);
		System.out.println("ReplaceEach: " + str + " -> " + result + "\n"); // Hi, Java

		/**
		 * - overlay: Ghi đè 1 chuỗi lên chuỗi khác theo vị trí chỉ định
		 */
		str = "Hello World";
		String overlay = "Awesome";
		int start = 7;
		int end = 12;
		result = overlay(str, overlay, start, end);
		System.out.println("Overlay: " + str + " -> " + result + "\n"); // "Hello, Awesome"

		/**
		 * - chop: Remove the last character from a String
		 */
		str = "Hello, World";
		System.out.println("Chop: " + str + " -> " + chop(str) + "\n"); // "Hello, Worl"

		/**
		 * - repeat: Lặp lại chuỗi n lần
		 * 
		 * - repeat(String, String, int): Repeat với dấu phân cách
		 */
		System.out.println("Repeat: " + repeat("Hello", 3));
		System.out.println("Repeat with separator: " + repeat("Hello", ",", 3) + "\n"); // Hello,Hello,Hello

		/**
		 * - capitalize: Viết hoa chữ cái đầu tiên
		 * 
		 * - uncapitalize: Ngược lại
		 */
		str = "hello wOrld";
		String capitalize = capitalize(str);
		System.out.println("Capitalize: " + str + " -> " + capitalize);
		System.out.println("Uncapitalize: " + capitalize + " -> " + uncapitalize(capitalize));

		/**
		 * countMatches: Đếm số lần xuất hiện của một chuỗi
		 */
		str = "Hello, World, Hello abc Hello";
		String sub = "Hello";
		System.out.println("CountMatches: " + countMatches(str, sub) + "\n");

		/**
		 * defaultString: Trả về một chuỗi mặc định nếu chuỗi đầu vào là null
		 */
		String input = null;
		String defaultStr = "default value";
		String defaultString = defaultString(input, defaultStr);
		System.out.println("DefaultString 1: " + defaultString);
		System.out.println("DefaultString : " + defaultString(input) + "\n"); // -> ""
	}

	public static void main(String[] args) {
		method();
		// splitByCharacter_Type();
	}

}
