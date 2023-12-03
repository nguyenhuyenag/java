package com.basic.io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
	public static void main(String[] args) throws IOException {
		Path start = Path.of("."); // Thư mục hiện tại
		// Duyệt qua tất cả các tệp và thư mục trong đường dẫn hiện tại
		Files.walk(start).forEach(System.out::println);
	}
}
