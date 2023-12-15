package com.basic.charstring;

import static org.apache.commons.lang3.StringUtils.abbreviate;
import static org.apache.commons.lang3.StringUtils.abbreviateMiddle;
import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.chop;
import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.apache.commons.lang3.StringUtils.difference;
import static org.apache.commons.lang3.StringUtils.equalsAny;
import static org.apache.commons.lang3.StringUtils.getCommonPrefix;
import static org.apache.commons.lang3.StringUtils.indexOfDifference;
import static org.apache.commons.lang3.StringUtils.isAllEmpty;
import static org.apache.commons.lang3.StringUtils.isAnyEmpty;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.normalizeSpace;
import static org.apache.commons.lang3.StringUtils.overlay;
import static org.apache.commons.lang3.StringUtils.remove;
import static org.apache.commons.lang3.StringUtils.removeStart;
import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.replace;
import static org.apache.commons.lang3.StringUtils.replaceEach;
import static org.apache.commons.lang3.StringUtils.replaceOnce;
import static org.apache.commons.lang3.StringUtils.reverse;
import static org.apache.commons.lang3.StringUtils.reverseDelimited;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.apache.commons.lang3.StringUtils.rotate;
import static org.apache.commons.lang3.StringUtils.splitByCharacterType;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;
import static org.apache.commons.lang3.StringUtils.splitByWholeSeparator;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;
import static org.apache.commons.lang3.StringUtils.uncapitalize;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

/*-
 * - stripAccents(): Xóa dấu (vẫn còn xót "đ")
 * 
 * - firstNonEmpty, firstNonBlank: Trả về phần tử đầu tiên khác empty hoặc blank
 * 
 * - equals():
 * - equalsIgnoreCase():
 * 
 * - indexOf():
 * - indexOfAny():
 * - lastIndexOf():
 * 
 * - contains():
 * - containsAny():
 * - containsIgnoreCase(): 
 */
public class ApacheStringUtils {

	public static void splitByCharacter_Type() {
		String input = "Hello123! wo1412rld";

		// Không tính khoảng trắng
		// String regex = "(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)|(?<=\\W)(?=\\w)|(?<=\\w)(?=\\W)";

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

	public static void method() {
		// isAnyEmpty: Có ít nhất 1 phần tử là empty
		boolean isAnyEmpty = isAnyEmpty("", "AA", null);
		System.out.println("IsAnyEmpty: " + isAnyEmpty + "\n");

		// isNoneEmpty: Có ít nhất 1 phần tử là NOT empty
		boolean isNoneBlank = isNoneBlank("", "AA", null);
		System.out.println("IsNoneBlank: " + isNoneBlank + "\n");

		// isAllEmpty: Tất cả các phần tử đều empty
		boolean isAllEmpty = isAllEmpty(null, "", "", null);
		System.out.println("IsNoneBlank: " + isAllEmpty + "\n");

		// equalsAny: Kiểm tra giá trị có bằng với giá trị bất kỳ trong danh sách
		String input = "apple";
		boolean isEqualsAny = equalsAny(input, "apple", "banana", "orange");
		System.out.println("EqualsAny: " + isEqualsAny + "\n");

		/**
		 * substringBefore:
		 */
		input = "Hello, World";
		String substringBefore = substringBefore(input, ",");
		System.out.println("SubstringBefore: " + input + " -> " + substringBefore); // Hello
		/**
		 * substringAfter
		 */
		String substringAfter = substringAfter(input, ",");
		System.out.println("SubstringAfter: " + input + " -> " + substringAfter + "\n"); // World

		/**
		 * substringBetween: Tìm chuỗi con (đầu tiên) nằm giữa 2 chuỗi
		 */
		input = "Hello [World]";
		String substringBetween = substringBetween(input, "[", "]");
		System.out.println("SubstringBetween: " + input + " -> " + substringBetween);
		/**
		 * substringsBetween: Tìm tất cả các chuỗi con nằm giữa 2 chuỗi
		 */
		input = "[a][b][c]";
		String[] substringsBetween = substringsBetween(input, "[", "]"); // -> [a, b, c]
		System.out.println("SubstringsBetween: " + input + " -> " + Arrays.toString(substringsBetween) + "\n");

		/**
		 * splitByWholeSeparator
		 */
		input = "Hello---World---Universe";
		String[] splitByWholeSeparator = splitByWholeSeparator(input, "---"); // Hello, World, Universe
		String output = Arrays.toString(splitByWholeSeparator);
		System.out.println("SplitByWholeSeparator: " + input + " -> " + output + "\n");

		/**
		 * leftPad, rightPad: Thêm kí tự vào chuỗi cho đến khi bằng độ dài mong muốn
		 */
		input = "12345";
		String leftPad = leftPad(input, 10, "0");
		System.out.println("LeftPad: " + input + " -> " + leftPad);
		String rightPad = rightPad(input, 10, "0");
		System.out.println("RightPad: " + input + " -> " + rightPad + "\n");

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
		input = "abc     d       e           ";
		System.out.println("DeleteWhitespace: " + deleteWhitespace(input) + "\n");

		/**
		 * remove: Loại bỏ chuỗi con khỏi chuỗi khác
		 * 
		 * - Tương tự có removeIgnoreCase
		 */
		input = "Hello World";
		System.out.println("Remove: " + remove(input, "o")); // Hell, Wrld
		/**
		 * removeStart, removeStartIgnoreCase: Xóa một chuỗi khỏi đầu một chuỗi nếu nó
		 * tồn tại
		 * 
		 * - Tương tự có removeEnd, removeEndIgnoreCase
		 */
		input = "Hello World";
		String prefix = "Hello ";
		System.out.println("RemoveStart: " + input + " -> " + removeStart(input, prefix) + "\n");

		/**
		 * replaceOnce: Thay thế lần đầu tiên xuất hiện của một chuỗi con trong chuỗi
		 * nguồn
		 * 
		 * - Tương tự có replaceOnceIgnoreCase
		 */
		input = "Hello, Hello, World!";
		String searchString = "Hello";
		String replacement = "Hi";
		System.out.println("ReplaceOnce: " + input + " -> " + replaceOnce(input, searchString, replacement));

		/**
		 * - replace: Thay thế tối đa n lần
		 */
		input = "org.apache.commons.lang3.StringUtils";
		String replace = replace(input, ".", "_", 3);
		System.out.println("Replace max: " + input + " -> " + replace);

		/**
		 * - replaceEach: Thay thế một mảng các chuỗi con tương ứng bằng một mảng các
		 * chuỗi khác
		 */
		input = "Hello World";
		String[] searchList = { "Hello", "World" };
		String[] replacementList = { "Hi", "Java" };
		String result = replaceEach(input, searchList, replacementList);
		System.out.println("ReplaceEach: " + input + " -> " + result + "\n"); // Hi, Java

		/**
		 * - overlay: Ghi đè 1 chuỗi lên chuỗi khác theo vị trí chỉ định
		 */
		input = "Hello World";
		String overlay = "Awesome";
		int start = 7;
		int end = 12;
		result = overlay(input, overlay, start, end);
		System.out.println("Overlay: " + input + " -> " + result + "\n"); // "Hello, Awesome"

		/**
		 * - chop: Remove the last character from a String
		 */
		input = "Hello, World";
		System.out.println("Chop: " + input + " -> " + chop(input) + "\n"); // "Hello, Worl"

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
		input = "hello wOrld";
		String capitalize = capitalize(input);
		System.out.println("Capitalize: " + input + " -> " + capitalize);
		System.out.println("Uncapitalize: " + capitalize + " -> " + uncapitalize(capitalize));

		/**
		 * countMatches: Đếm số lần xuất hiện của một chuỗi
		 */
		input = "Hello, World, Hello abc Hello";
		String sub = "Hello";
		System.out.println("CountMatches: " + countMatches(input, sub) + "\n");

		/**
		 * - defaultString: Trả về một chuỗi mặc định nếu chuỗi đầu vào là null
		 * 
		 * - Tương tự có: defaultIfEmpty, defaultIfBlank
		 */
		input = null;
		String defaultStr = "default value";
		String defaultString = defaultString(input, defaultStr);
		System.out.println("DefaultString 1: " + defaultString);
		System.out.println("DefaultString 2: " + defaultString(input) + "\n"); // -> ""

		/**
		 * - rotate: Xoay chuỗi
		 */
		input = "ABCDE";
		int numberOfTimes = 2;
		System.out.println("Rotate 1: " + input + " -> " + rotate(input, numberOfTimes));
		System.out.println("Rotate 2: " + input + " -> " + rotate(input, -numberOfTimes) + "\n");

		/**
		 * - reverse: Đảo chuỗi
		 * 
		 * - reverseDelimited: Đảo chuỗi với dấu phân cách
		 */
		System.out.println("Reverse: " + input + " -> " + reverse(input));
		input = "AB;CD;EF";
		result = reverseDelimited(input, ';');
		System.out.printf("ReverseDelimited: %s -> %s \n\n", input, result);

		/**
		 * - abbreviate: Viết tắt 1 chuỗi dựa trên độ dài tối đa
		 * 
		 * - abbreviateMiddle: Viết tắt ở giữa 1 chuỗi dựa trên độ dài tối đa
		 */
		input = "This is a long sentence that needs to be abbreviated";
		int maxWidth = 20;
		result = abbreviate(input, maxWidth);
		System.out.printf("Abbreviate: %s -> %s \n", input, result);
		String middle = "...";
		result = abbreviateMiddle(input, middle, maxWidth);
		System.out.printf("AbbreviateMiddle: %s -> %s \n\n", input, result);

		/**
		 * - difference: Trả về phần tử khác nhau đầu tiên của hai chuỗi
		 * 
		 * - indexOfDifference(s1, s2): Vị trí đầu tiên mà 2 chuỗi đầu vào khác nhau
		 * 
		 * - indexOfDifference(s1, s2,...): Vị trí đầu tiên mà các chuỗi đầu vào khác
		 * nhau
		 */
		String s1 = "Hello World";
		String s2 = "Hello Java";
		String difference = difference(s1, s2);
		int index = indexOfDifference(s1, s2);
		System.out.printf("Difference: (%s, %s) -> %s, Diff index = %d \n\n", s1, s2, difference, index);

		/**
		 * - getCommonPrefix: Tìm tiền tố chung của một danh sách các chuỗi
		 */
		String[] strings = { "apple", "application", "applet", "app" };
		String commonPrefix = getCommonPrefix(strings);
		System.out.println("Common Prefix: " + commonPrefix + "\n");

		/**
		 * - normalizeSpace: Xóa n > 1 khoảng trắng về còn 1 khoảng trắng
		 */
		input = "   Hello    World   ";
		String normalized = normalizeSpace(input);
		System.out.printf("NormalizeSpace: '%s' -> '%s' \n\n", input, normalized);

		/**
		 * - appendIfMissing: Thêm chuỗi con vào cuối một chuỗi nếu chuỗi chưa kết thúc
		 * bằng chuỗi con đó.
		 * 
		 * - Tương tự có prependIfMissing
		 */
		input = "Hello World";
		String appended = StringUtils.appendIfMissing(input, "!");
		System.out.printf("AppendIfMissing: %s -> %s\n\n", input, appended);
		
		input = "123";
		System.out.printf("IsNumeric: %s -> %s\n", input, isNumeric(input));
		input = "123a";
		System.out.printf("IsNumeric: %s -> %s", input, isNumeric(input));
	}

	public static void main(String[] args) {
		method();
		// splitByCharacter_Type();
	}

}
