package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class InitStream {

	// Stream.of()
	public static Stream<String> getByStreamOf() {
		String[] arr = { "program", "creek", "program", "creek", "java", "web", "program" };
		return Stream.of(arr);
	}

	// Arrays.stream()
	public static Stream<Integer> getByArraysStream() {
		return Arrays.stream(new Integer[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
	}

	// Collection.stream()
	public static Stream<String> getByCollection() {
		return Arrays.asList("Java", "8", "Stream").stream();
	}

	// Stream.generate()
	public static void streamUsingGenerate() {
		Stream<String> stream = Stream.generate(() -> "Java").limit(3);
		String[] testStrArr = stream.toArray(String[]::new);
		System.out.println(Arrays.toString(testStrArr)); // [Java, Java, Java]
	}

	public static void main(String[] args) {
		// InitializeStream.getByStreamOf().forEach(System.out::println);
		// InitializeStream.getByArraysStream().forEach(System.out::println);
		// InitializeStream.getByCollection().forEach(System.out::println);
		streamUsingGenerate();

	}

}
