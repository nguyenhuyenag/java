package learn.generic;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MethodGeneric {

	static <T> long count(Collection<T> collection, T key) {
		return collection.stream().filter(t -> t == key).count();
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 1, 2, 5, 6, 78, 1);
		System.out.println(count(list, 1)); // 4
	}

}
