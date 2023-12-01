package com.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Nối stream
public class Joining {

	/*-
	 * - Delimiter	: Chuỗi ký tự phân tách các phần tử
	 * - Prefix 	: Chuỗi ký tự được thêm vào đầu kết quả
	 * - Suffix		: Chuỗi ký tự được thêm vào cuối kết quả
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C", "D");
		System.out.println(list.stream().collect(Collectors.joining()));
		System.out.println(list.stream().collect(Collectors.joining("-")));
		System.out.println(list.stream().collect(Collectors.joining("*", "[", "]")));
	}

}
