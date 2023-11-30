package com.collection.join;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListJoin {

	/*-
	 * - delimiter	: chuỗi ký tự phân tách các phần tử
	 * - prefix		: chuỗi ký tự được thêm vào đầu kết quả
	 * - suffix		: chuỗi ký tự được thêm vào cuối kết quả
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", "D");

		String result6 = list.stream().collect(Collectors.joining());
		System.out.println(result6);

		String result7 = list.stream().collect(Collectors.joining("*"));
		System.out.println(result7);

		String result8 = list.stream().collect(Collectors.joining("_", "PREFIX^", "^SUFFIX"));
		System.out.println(result8);
		
		System.out.println(String.join("_", list));
	}

}
