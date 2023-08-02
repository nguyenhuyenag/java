package com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			File directory = new File("C:\\Users\\huyennv\\Desktop\\test");
			FileUtils.cleanDirectory(directory);
			System.out.println("Directory has been cleaned successfully.");
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}
}
