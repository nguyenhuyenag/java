package collection;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnmodifiableCollection {

	public static <T> boolean isUnmodifiable(Collection<T> list) {
		try {
			System.out.println(list.getClass().getName());
			list.addAll(Collections.emptyList());
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public static void main(String[] args) {
		// List<String> myList = Arrays.asList("one", "two", "three");
		List<Integer> myList = IntStream.rangeClosed(1, 10) //
				.map(t -> ThreadLocalRandom.current().nextInt(0, 30))//
				.boxed() //
				.collect(Collectors.toList());
		// List<Integer> myList = IntStream.rangeClosed(1, 10).boxed().toList();
		System.out.println(myList);
		System.out.println(isUnmodifiable(myList));
	}

}
