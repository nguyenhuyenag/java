package interfaces.function.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*-
 * - boolean test(T t): Kiểm tra một tham số đầu vào và trả về true hoặc false
 * - Thường dùng để kiểm tra phần tử
 */
public class Predicates {

	// lệnh removeIf sẽ thực hiện duyệt từng phần tử,
	// nếu method test của Predicate trả về true thì sẽ remove phần tử đó khỏi list
	public static <T> void removeWithLambda(List<T> list, Predicate<T> p) {
		list.removeIf(t -> p.test(t));
		System.out.println(list);
	}

	public static <T> void removeWithoutLambda(List<T> list, Predicate<T> p) {
		list.removeIf(new Predicate<T>() {
			@Override
			public boolean test(T t) {
				return p.test(t);
			}
		});
		System.out.println(list);
	}

	public static <T> void eval(List<T> list, Predicate<T> p) {
		List<T> filter = list.stream() //
				.filter(t -> p.test(t)) //
				.collect(Collectors.toList());
		System.out.println(filter);
	}

	// filter() = !removeIf()
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(-1, 2, 0, 3, 8, 4 - 9, 11, -3, 10, -22, 27));

		Predicate<Integer> conditon;
		// conditon = t -> true; // pass all
		// conditon = t -> t % 2 == 0; // even numbers
		conditon = t -> t % 2 != 0; // odd number
		eval(list, conditon);

		// removeWithLambda(list, t -> true); // remove all
		// removeWithLambda(list, t -> t < 0); // remove negative numbers
		// removeWithLambda(list, t -> t > 0); // remove positive numbers
		// removeWithLambda(list, t -> t % 2 != 0); // remove odd numbers

	}

}
