package learn.collection.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import common.util.PathUtils;

public class StreamClose {

	public static void main(String[] args) {

		String s = PathUtils.toUnixSeparator("D:\\Java\\soapui");
		Path path = Paths.get(s);

		// Stream<Path> list = Files.list(path).onClose(() ->
		// System.out.println("Closed"));
		// list.forEach(System.out::println);

		try (Stream<Path> list = Files.list(path).onClose(() -> System.out.println("Closed"))) {
			list.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
