package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileAPI {

	public static void main(String[] args) throws IOException {
		Path file = Path.of(File.createTempFile("tempFile", ".tmp").toURI());
		System.out.println(file.toString());
		try {
			Path tempFilePath = Files.writeString(file, "Welcome to TutorialsPoint");
			// Path tempFilePath = Files.writeString(file, "Welcome to TutorialsPoint", Charset.defaultCharset(), StandardOpenOption.WRITE);
			String fileContent = Files.readString(tempFilePath);
			System.out.println(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}