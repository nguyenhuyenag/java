package learn.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTo {

	static Stream<Integer> asStream() {
		return Arrays.stream(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
	}

	static <T> void getType(T object) {
		System.out.println(object.getClass().getSimpleName());
	}

	public static List<Integer> toList() {
		return asStream().collect(Collectors.toList());
	}

	public static Integer[] toArray() {
		return asStream().toArray(Integer[]::new);
	}

	public static void main(String[] args) {

		getType(toArray());

		getType(toList());

	}

}
