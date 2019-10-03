package stream.map;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

	static List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));

	public static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(Arrays::deepToString) //
				.collect(Collectors.joining(" + "));
	}

	public static void main(String[] args) {

		List<Integer> listJoin = list.stream() 	// -> Stream<List<Integer>> 
				.flatMap(t -> t.stream()) 		// -> Stream<Integer>
				.collect(Collectors.toList()); 	// -> List<Integer>

		// [[1, 2, 3], [4, 5, 6]] => [1, 2, 3, 4, 5, 6]
		System.out.println(list + " => " + listJoin);

		String[] s1 = { "a", "b" };
		String[] s2 = { "c", "d" };
		String[][] array = { s1, s2, { "e", "f" } };

		String[] arrayJoin = Arrays.stream(array)	// -> Stream<String[]>
				.flatMap(Arrays::stream) 			// -> Stream<String>
				.toArray(String[]::new); 			// -> String[]

		// [[a, b], [c, d], [e, f]] => [a, b, c, d, e, f]
		System.out.println(Arrays.deepToString(array) + " => " + print(arrayJoin));

		String[] result = Stream.of(s1, s2)	// -> Stream<String[]>
				// .flatMap(s -> Stream.of(s))
				.flatMap(Stream::of) 		// -> Stream<String>
				.toArray(String[]::new); 	// -> String[]

		// [a, b] + [c, d] => [a, b, c, d]
		System.out.println(print(s1, s2) + " => " + print(result));

	}

}
