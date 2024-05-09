package collection.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class StreamOnClose {

	static Path path = Paths.get("D:/TS24Corp");

	public static void notAutoClose() {
		try {
			Stream<Path> list = Files.list(path).onClose(() -> System.out.println("Stream closed"));
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void autoClose() {
		try (Stream<Path> list = Files.list(path).onClose(() -> System.out.println("Closed"))) {
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// autoClose();
		notAutoClose();
	}

}
