package function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IPredicate {

	public static <T> void eval(List<T> list, Predicate<T> conditon) {
		List<T> filter = list.stream() //
				.filter(t -> conditon.test(t)) //
				.collect(Collectors.toList());
		System.out.println("Filter: " + Arrays.toString(filter.toArray()));
	}

	public static void main(String[] args) {

		Predicate<Integer> conditon;
		
		List<Integer> list = Arrays.asList(1, 2, 5, 10, 8, 9, 0, 11);
		
		conditon = t -> true; // pass all
		eval(list, conditon); // eval(list, t -> true);
		conditon = t -> t % 2 == 0; // even numbers
		eval(list, conditon); // eval(list, t -> t % 2 == 0);
		conditon = t -> t % 2 != 0; // odd number
		eval(list, conditon); // eval(list, t -> t % 2 != 0);
		
		List<String> strList = Arrays.asList("a", "b", "c");
		eval(strList, s -> true);
	}

}
