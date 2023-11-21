package com.v9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class TryWithResources {

	private static final String URL = "https://www.gutenberg.org/files/1661/1661-0.txt";

	public static void beforeJava9() {
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(URL))) {
			while (null != (line = br.readLine())) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void formJava9() throws IOException {
		String line;
		URL url = new URL(URL);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		try (br) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void newTryWithResource() throws FileNotFoundException {
		final Scanner scanner = new Scanner(new File("testRead.txt"));
		PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
		try (scanner; writer) {
			// omitted
		}
	}

	public static void main(String[] args) throws IOException {
		// beforeJava9();
		formJava9();
		newTryWithResource();
	}

}
