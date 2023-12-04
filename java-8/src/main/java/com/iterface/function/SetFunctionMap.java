package com.iterface.function;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Set + Function = Map
 */
public class SetFunctionMap {

	// Nhận vào 1 Integer -> Xử lý -> Trả về kết quả kiểu String
	public static Function<Integer, String> function = (from) -> Integer.toBinaryString(from);

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);

		Map<Integer, String> immutableMap = set.stream() //
				.collect(Collectors.toMap(Function.identity(), function));

		System.out.println(immutableMap);
	}

}
