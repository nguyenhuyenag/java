package basic.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class NIOApi {

	/*-
		+ walk(): Duyệt qua tất cả các tệp và thư mục trong một đường dẫn
	  
			Kết quả của chương trình trên như sau:
				.
				./src
				./src/main
				./src/main/java
				./src/main/java/com
				./src/main/java/com/example
				./src/main/java/com/example/WalkExample.java
	 */
	public static void walk() throws IOException {
		Path start = Path.of("."); // Thư mục hiện tại
		// Duyệt qua tất cả các tệp và thư mục trong đường dẫn hiện tại
		Files.walk(start).forEach(System.out::println);
	}

	public static void find() throws IOException {
		// @formatter:off
		int depth = Integer.MAX_VALUE;
		try (Stream<Path> paths = Files.find(
				Path.of("folder_path"), 
				depth,
				(path, attr) -> {
					return attr.isRegularFile() && path.toString().endsWith(".pdf");
				}
			)
		) {
			paths.forEach(System.out::println);
		}
		// @formatter:on
	}
	
	public static void main(String[] args) throws Exception {
		// walk();
		// find();
	}
}
