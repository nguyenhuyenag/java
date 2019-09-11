package basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertType {

	public static Stream<Integer> getByArraysStream() {
		return Arrays.stream(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
	}

	static <T> void getType(T object) {
		System.out.println(object.getClass().getSimpleName());
	}

	public static void main(String[] args) {

		// Stream => List
		List<Integer> streamToList = getByArraysStream().collect(Collectors.toList());
		getType(streamToList);

		// Stream => Array
		Integer[] streamToArray = getByArraysStream().toArray(Integer[]::new);
		getType(streamToArray);

		List<String> list = Arrays.asList("a", "b", "c");

		// List => Array
		String[] strings = list.stream().toArray(String[]::new);
		getType(strings);

		// List => Array
		String[] stockArr = list.toArray(new String[list.size()]);
		getType(stockArr);

		// List => Array
		String[] array = list.stream().toArray(s -> new String[s]);
		getType(array);

		// List => Array
		Object[] array1 = list.toArray();
		getType(array1);

	}

}
