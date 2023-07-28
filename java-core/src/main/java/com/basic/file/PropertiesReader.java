package com.basic.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesReader {
	
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);
	
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
	
	/**
	 * Read file properties in resources as map
	 */
	public static Map<String, Object> readFileAsMap(String fileName) {
		Map<String, Object> fileContent = new HashMap<>();
		// Resource resource = new ClassPathResource(fileName); // (1)
		File resource = new File(fileName); // (2)
		if (!resource.exists()) {
			LOG.info("File '{}' not found!", fileName);
		} else {
			// try (InputStream inputStream = resource.getInputStream()) { // (1)
			try (InputStream inputStream = new FileInputStream(resource)) { // (2)
				Properties properties = new Properties();
				properties.load(inputStream);
				properties.forEach((key, value) -> fileContent.put((String) key, value));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContent;
	}

	public static void main(String[] args) throws IOException {
		
	}

}
