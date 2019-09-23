package learn.algorithm.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;

public class Permute {
	
	private Permute() {
		
	}

	/*-
	 * Apache commons
	 * @param list
	 */
	public static void commonsPermute(List<?> list) {
		CollectionUtils.permutations(list) //
				.stream() //
				.forEachOrdered(System.out::println);
	}

	private static void permute(List<?> list, int left, int right) {
		int j;
		if (left == right) {
			System.out.println(Arrays.toString(list.toArray()));
			return;
		}
		for (j = left; j <= right; j++) {
			Collections.swap(list, left, j);
			permute(list, left + 1, right);
			Collections.swap(list, left, j); // backtrack
		}
	}

	public static void showAllPermute(List<?> list) {
		int size = list.size();
		permute(list, 0, size - 1);
		System.out.println("Total: " + CombinatoricsUtils.factorial(size));
	}

}
