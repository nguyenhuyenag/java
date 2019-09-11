package function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void eval(List<Integer> list, Predicate<Integer> pre) {
		List<Integer> result = new ArrayList<>();
		for (Integer n : list) {
			if (pre.test(n)) {
				result.add(n);
			}
		}
		System.out.println(Arrays.toString(result.toArray()));
	}

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(-1, 2, 5, 10, 8, 9, 0, 1);

		// pass n as parameter
		eval(list, t -> true);

		// even numbers
		eval(list, t -> t % 2 == 0);

		// numbers > 3
		eval(list, t -> t > 3);

	}

}
