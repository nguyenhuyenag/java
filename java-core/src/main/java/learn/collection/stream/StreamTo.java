package learn.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTo {

	static Stream<Integer> initStream() {
		return Arrays.stream(new Integer[] { 0, 1, 2, 3, 4, 5 });
	}

	public static List<Integer> toList() {
		return initStream().collect(Collectors.toList());
	}

	public static Integer[] toArray() {
		return initStream().toArray(Integer[]::new);
	}

	public static void main(String[] args) {
		toList();
		toArray();
	}

}
