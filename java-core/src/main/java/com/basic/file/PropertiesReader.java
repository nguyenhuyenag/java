package com.basic.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesReader {
	
	private final static String HOME = System.getProperty("user.dir");
	
	public static void createFile() {
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
	
	public static void readFile() {
		System.out.println("HOME: " + HOME);
		try (InputStream input = new FileInputStream(HOME + "/config.properties");) {
			Properties prop = new Properties();
            // load a properties file
            prop.load(input);
            System.out.println(prop.getProperty("server.port"));
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
	}

}
