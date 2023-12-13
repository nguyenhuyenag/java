package com.v11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAPI {

	// Files.writeString(path, text, StandardCharsets.UTF_8);
	// Files.readString(path, StandardCharsets.UTF_8);
	public static void main(String[] args) throws IOException {
		Path file = File.createTempFile("tempFile", ".tmp").toPath();
		System.out.println(file.toString());
		try {
			String content = "Welcome to TutorialsPoint";
			Path tempFilePath = Files.writeString(file, content);
			String fileContent = Files.readString(tempFilePath);
			System.out.println(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
