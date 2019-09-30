package interfaces.function.api;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*-
 * - void accept(T t): Phương thức chấp nhận một tham số đầu vào và không trả về gì cả
 * - Thường dùng để xử lý phần tử
 */
public class Consumers {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("stack", "java", "stackjava.com");

		// Sử dụng List.forEach(Consumer) để in ra giá trị của các phần tử trong list
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// Sử dụng List.forEach(Consumer) với cú pháp lambda expression
		// list.forEach(System.out::println);
		list.forEach(t -> System.out.println(t));
	}

}
