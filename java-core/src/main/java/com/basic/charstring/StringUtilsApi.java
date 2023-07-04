package com.basic.charstring;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsApi {

	/**
	 * - isAnyEmpty(): Có ít nhất 1 phần tử là empty
	 * 
	 * - isNoneEmpty(): Có ít nhất 1 phần tử là NOT empty
	 * 
	 * - isAllEmpty():
	 * 
	 * - stripAccents(): Xóa dấu (vẫn còn xót "đ")
	 * 
	 * - equals():
	 * - equalsIgnoreCase():
	 * - equalsAny(): Kiểm tra giá trị có bằng với giá trị bất kỳ trong danh sách
	 * - equalsAnyIgnoreCase():
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
		// equalsAny
		String value = "apple";
		boolean isEqualsAny = StringUtils.equalsAny(value, "apple", "banana", "orange");
		System.out.println("EqualsAny: " + isEqualsAny); // Output: true
	}

	public static void main(String[] args) {
		method();
	}

}
