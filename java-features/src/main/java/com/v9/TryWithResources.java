package com.v9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void beforeJava9() {
		try (BufferedReader br = new BufferedReader(new FileReader("https://prod-acb5.kxcdn.com/input.txt"))) {
			String line;
			while (null != (line = br.readLine())) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void formJava9() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader("https://prod-acb5.kxcdn.com/input.txt"));
		try (br) {
			String line;
			while (null != (line = br.readLine())) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
