package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		int depth = Integer.MAX_VALUE;
		String folderPath = "";
		try (Stream<Path> paths = Files.find(Path.of(folderPath), depth, (path, attr) -> {
			return attr.isRegularFile() && path.toString().endsWith(".pdf");
		})) {
			paths.forEach(System.out::println);
		}
	}

}
