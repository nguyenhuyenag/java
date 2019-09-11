package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Map {

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("1", "2", "2", "3", "3", "4", "5");

		List<Integer> listOfInteger = listOfStrings.stream() //
				.map(Integer::valueOf) // to Integer
				.map(t -> 2 * t) 	// x 2
				.distinct() 		// remove duplicate
				.collect(Collectors.toList());

		System.out.println(listOfInteger);
	}

}
