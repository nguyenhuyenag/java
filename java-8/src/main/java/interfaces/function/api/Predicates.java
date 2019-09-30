package interfaces.function.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*-
 * - boolean test(T t): Kiểm tra một tham số đầu vào và trả về true hoặc false
 * - Thường dùng để kiểm tra phần tử
 */
public class Predicates {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(-1, 1, 0, -2, 3));

		// lệnh removeIf sẽ thực hiện duyệt từng phần tử,
		// nếu method test của Predicate trả về true thì sẽ remove phần tử đó khỏi list
		list.removeIf(new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t < 0;
			}
		});

		// Sử dụng Predicate với cú pháp Lambda Expression
		// loại bỏ các phần tử lớn hơn 1
		list.removeIf(t -> t < 0);

	}

}
