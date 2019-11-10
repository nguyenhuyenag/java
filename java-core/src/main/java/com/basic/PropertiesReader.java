package com.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesReader {

	public static void main(String[] args) throws IOException {
		try (OutputStream output = new FileOutputStream("file/config.properties");) {
			// create properties object
			Properties prop = new Properties();
			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "java");
			prop.setProperty("dbpassword", "123456");
			// save properties to a file
			prop.store(output, "Config Database connection");
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
