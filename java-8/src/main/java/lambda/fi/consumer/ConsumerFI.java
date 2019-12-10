package lambda.fi.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*-
 * - void accept(T t): Chấp nhận một tham số đầu vào và không trả về gì cả
 * - default andThen(): Giúp thực hiện nhiều thao tác cùng lúc
 * - Thường dùng để xử lý phần tử
 */
public class ConsumerFI {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("stack", "java", "stackjava");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		// hoặc
		// list.forEach(System.out::println);
	}

}
