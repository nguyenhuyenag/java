package com;

import java.io.IOException;
import java.io.StringReader;

public class Main {

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 100; i++) {
			String srg = "Hello Java! \nWelcome to java.";
	        StringReader reader = new StringReader(srg);
	        int k = 0;
	        while ((k = reader.read()) != -1) {
	            System.out.print((char) k);
	        }
		}
	}

}
