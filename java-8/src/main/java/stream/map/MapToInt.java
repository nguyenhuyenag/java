package stream.map;

import java.util.Arrays;
import java.util.List;

public class MapToInt {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Geeks", "for", "gfg", "GeeksforGeeks", "GeeksQuiz");

		list.stream().mapToInt(String::length).boxed().toArray(Integer[]::new);

		int[] array = list.stream() 			// -> Stream<String>
				.mapToInt(String::length) 		// -> IntStream
				.boxed() 						// -> Stream<Integer>
				.mapToInt(Integer::intValue) 	// -> IntStream
				.toArray(); 					// -> int[]

		System.out.println(Arrays.toString(array));

	}

}
