package com;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] agrs) throws IOException {
	        // Path path = Paths.get(".");
	        Path path = Paths.get("D:/WORK/Dev/Github/java/java-8/src/main/java");
	        System.out.println(path.toString());
	        // Duyệt qua tất cả các tệp và thư mục trong đường dẫn hiện tại
	        Files.walk(path).forEach(System.out::println);
	}

}
