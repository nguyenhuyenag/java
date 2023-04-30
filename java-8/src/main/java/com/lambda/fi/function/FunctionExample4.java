package com.lambda.fi.function;

import java.util.function.Function;

public class FunctionExample4 {

	/**
	 * andThen() : phương thức này trả về một Function thực hiện hai hành động theo
	 * thứ tự, trước tiên là hành động của Function mà phương thức được gọi và theo
	 * sau bởi hành động của Function được truyền vào đối số.
	 * 
	 * compose() : phương thức này trả về một Function thực hiện hai hành động theo
	 * thứ tự, trước tiên là hành động của Function mà được truyền vào đối số và
	 * theo sau bởi hành động của Function gọi phương thức.
	 * 
	 * identity() : phương thức này trả về một Function thực hiện trả về kết quả
	 * đúng bằng với đối số được truyền vào.
	 */

	public static void main(String[] args) {

		Function<Integer, Integer> times2 = n -> n * 2;
		Function<Integer, Integer> squared = n -> n * n;

		Function<Integer, Integer> andThen = times2.andThen(squared);
		System.out.println("Using andThen: " + andThen.apply(5)); // 100

		Function<Integer, Integer> compose = times2.compose(squared);
		System.out.println("Using compose: " + compose.apply(5)); // 50
	}

}
