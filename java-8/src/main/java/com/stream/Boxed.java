package com.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Chuyển đổi các kiểu dữ liệu nguyên thủy thành các đối tượng tương ứng của
 * kiểu dữ liệu đó
 */
@SuppressWarnings("unused")
public class Boxed {

	public static void main(String[] args) {
		IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
		Stream<Integer> integerStream = intStream.boxed();
	}

}
