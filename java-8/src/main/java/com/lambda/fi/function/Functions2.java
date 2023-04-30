package com.lambda.fi.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/*-
 * - R apply(T t): Phương thức này nhận đầu vào là 1 tham số và trả về một giá trị
 * - Thường dùng khai thay đổi giá trị của phần tử
 */
public class Functions2 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Stack", "Java", "Demo", "Function");
		Stream<String> stream = list.stream();

		// chuyển tất cả các phần tử của stream thành chữ in hoa
		stream.map(new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.toUpperCase();
			}
		}).forEach(System.out::println);

		// chuyển tất cả các phần tử của stream thành chữ thường
		stream = list.stream();// lưu ý là stream ko thể dùng lại nên phải khởi tạo lại
		stream.map(String::toLowerCase).forEach(System.out::println);

	}

}
