package com;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) throws Exception {
		String s = "Java 2023";
		InputStream is = new ByteArrayInputStream(s.getBytes());
//		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
//			for (String line; (line = reader.readLine()) != null;) {
//				System.out.println(line);
//			}
//		}
		is.mark(0);
	}

}
