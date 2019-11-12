package com.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesReader {

	public static void main(String[] args) throws IOException {
		try (OutputStream output = new FileOutputStream("file/config.properties");) {
			Properties prop = new Properties();
			prop.setProperty("database", "localhost");
			prop.setProperty("user", "java");
			prop.setProperty("password", "123456");
			// save properties to a file
			prop.store(output, "Config Database connection"); // comment
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
