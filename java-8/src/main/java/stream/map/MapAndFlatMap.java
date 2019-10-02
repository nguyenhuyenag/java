package stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

	public static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(t -> Arrays.deepToString(t)) //
				.collect(Collectors.joining(" + "));
	}

	// Xem thêm JoinArray.java
	public static void main(String[] args) {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

		// Join List
		List<Integer> listJoin = list.stream().flatMap(t -> t.stream()).collect(Collectors.toList());

		// [[1, 2, 3], [4, 5, 6]] => [1, 2, 3, 4, 5, 6]
		System.out.println(list + " => " + listJoin);

		String[] s1 = { "a", "b", "c" };
		String[] s2 = new String[] { "d", "e", "f" };
		String[][] array = new String[][] { s1, s2, { "g", "h" } };

		// Arrays.stream()
		String[] arrayJoin = Arrays.stream(array).flatMap(Arrays::stream).toArray(String[]::new);

		// [[a, b], [c, d], [e, f], [g, h]] => [a, b, c, d, e, f, g, h]
		System.out.println(Arrays.deepToString(array) + " => " + print(arrayJoin));

		// Stream.of()
		String result[] = Stream.of(s1, s2) //
				.flatMap(Stream::of) // s -> Stream.of(s)
				.toArray(String[]::new);

		System.out.println(print(s1, s2) + " = " + print(result));

	}

}
