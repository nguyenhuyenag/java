package lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortAndComparator {

	// without lambda
	static void preJava8(List<String> list) {
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});
		System.out.println(Arrays.toString(list.toArray()));
	}

	// lambda
	static void sortLambda(List<Integer> list) {
		Collections.sort(list, (n1, n2) -> n1 - n2);
		// Hoặc Collections.sort(list, (n1, n2) -> n1.compareTo(n2));
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Java", "C#", "C++", "PHP", "Javascript");
		preJava8(list);

		List<Integer> listInt = Arrays.asList(1, -12, 0, 2, -11, 5);
		sortLambda(listInt);

	}

}
