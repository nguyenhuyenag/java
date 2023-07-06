package com.basic.charstring;

import static org.apache.commons.lang3.StringUtils.equalsAny;
import static org.apache.commons.lang3.StringUtils.isAllEmpty;
import static org.apache.commons.lang3.StringUtils.isAnyEmpty;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.apache.commons.lang3.StringUtils.rightPad;
import static org.apache.commons.lang3.StringUtils.splitByCharacterType;
import static org.apache.commons.lang3.StringUtils.splitByCharacterTypeCamelCase;
import static org.apache.commons.lang3.StringUtils.splitByWholeSeparator;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;
import static org.apache.commons.lang3.StringUtils.substringBetween;
import static org.apache.commons.lang3.StringUtils.substringsBetween;

import java.util.Arrays;

public class StringUtilsApi {

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
	public static void method() {
		// isAnyEmpty: Có ít nhất 1 phần tử là empty
		boolean isAnyEmpty = isAnyEmpty("", "AA", null);
		System.out.println("IsAnyEmpty: " + isAnyEmpty);

		// isNoneEmpty: Có ít nhất 1 phần tử là NOT empty
		boolean isNoneBlank = isNoneBlank("", "AA", null);
		System.out.println("IsNoneBlank: " + isNoneBlank);

		// isAllEmpty: Tất cả các phần tử đều empty
		boolean isAllEmpty = isAllEmpty(null, "", "", null);
		System.out.println("IsNoneBlank: " + isAllEmpty);

		// equalsAny: Kiểm tra giá trị có bằng với giá trị bất kỳ trong danh sách
		String key = "apple";
		boolean isEqualsAny = equalsAny(key, "apple", "banana", "orange");
		System.out.println("EqualsAny: " + isEqualsAny);

		// substringBefore:
		String str = "Hello, World";
		String substringBefore = substringBefore(str, ",");
		System.out.println("SubstringBefore: " + substringBefore); // Hello
		// substringAfter
		String substringAfter = substringAfter(str, ",");
		System.out.println("SubstringAfter: " + substringAfter); // World

		// substringBetween: Tìm chuỗi con (đầu tiên) nằm giữa 2 chuỗi
		str = "Hello [World]";
		String substringBetween = substringBetween(str, "[", "]");
		System.out.println("SubstringBetween: " + substringBetween);
		// substringsBetween: Tìm tất cả các chuỗi con nằm giữa 2 chuỗi
		String[] substringsBetween = substringsBetween("[a][b][c]", "[", "]"); // -> [a, b, c]
		System.out.println("SubstringsBetween: " + Arrays.toString(substringsBetween));

		// splitByWholeSeparator
		str = "Hello---World---Universe";
		String[] splitByWholeSeparator = splitByWholeSeparator(str, "---"); // Hello, World, Universe
		System.out.println("SplitByWholeSeparator: " + Arrays.toString(splitByWholeSeparator));

		// leftPad, rightPad: Thêm kí tự vào chuỗi cho đến khi bằng độ dài mong muốn
		String leftPad = leftPad("123456", 10, "0");
		System.out.println("LeftPad: " + leftPad);
		String rightPad = rightPad("123456", 10, "0");
		System.out.println("RightPad: " + rightPad);
	}

	public static void main(String[] args) {
		method();
		// splitByCharacter_Type();
	}

}
