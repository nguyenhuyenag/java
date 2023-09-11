package com.collection;

import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.Sets;

/**
 * Set + Function = Map
 */
public class SetFunctionMap {

	// Nhận vào 1 Integer -> Xử lý -> Trả về kết quả kiểu String
	public static Function<Integer, String> function = (from) -> Integer.toBinaryString(from);

	public static void main(String[] args) {
		// Tạo một Set của các khóa
        Set<String> keySet = Sets.newHashSet("one", "two", "three");

        // Định nghĩa một hàm để ánh xạ từng khóa thành giá trị tương ứng
        Function<String, Integer> valueFunction = key -> key.length();

        // Sử dụng Maps.asMap để chuyển đổi Set thành Map
        // Map<String, Integer> keyToLengthMap = Maps.asMap(keySet, valueFunction);

        // In ra Map đã được tạo
        // System.out.println(keyToLengthMap);
	}

}
