package basic.io.file.properties;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

@Slf4j
public class PropertiesReader {
	
	// private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);
	
	private static final Map<String, String> FIELD_REQUIRED = new HashMap<>();

    static {
        Resource resource = new ClassPathResource("field-required.properties");
        if (resource.exists()) {
            try (InputStream input = resource.getInputStream()) {
                Properties properties = new Properties();
                properties.load(input);
                for (String key : properties.stringPropertyNames()) {
                    FIELD_REQUIRED.put(key, properties.getProperty(key));
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Có thể thay bằng logging framework để ghi log thay vì sử dụng e.printStackTrace()
            }
        }
    }
	
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
		// System.out.println("HOME: " + HOME);
		Path path = Path.of(HOME, "src", "main", "resources", "config.properties");
		try (InputStream input = new FileInputStream(path.toString())) {
			Properties prop = new Properties();
            // load a properties file
            prop.load(input);
			prop.forEach((key, value) -> System.out.println(key + " <==> " + value));
		} catch (IOException e) {
			e.printStackTrace();
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
			log.info("File '{}' not found!", fileName);
		} else {
			// try (InputStream inputStream = resource.getInputStream()) { 		//	(1)
			try (InputStream inputStream = new FileInputStream(resource)) { 	// 	(2)
				Properties properties = new Properties();
				properties.load(inputStream);
				properties.forEach((key, value) -> fileContent.put((String) key, value));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return fileContent;
	}

	/*
		Read Properties for UTF8 encoding
	 */
	public static Map<String, String> loadProperties(final File file) {
		Map<String, String> propertiesMap = new HashMap<>();

		if (file == null) {
			log.error("File must be non-null");
			return propertiesMap;
		}

		if (!file.exists()) {
			log.error("File {} not found", file.getName());
			return propertiesMap;
		}

		Properties properties = new Properties();
		try (InputStreamReader in = new InputStreamReader(Files.newInputStream(file.toPath()), StandardCharsets.UTF_8)) {
			properties.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Set<String> keys = properties.stringPropertyNames();
		if (keys != null) {
			for (String key : keys) {
				propertiesMap.put(key, properties.getProperty(key));
			}
		}
		return propertiesMap;
	}

	public static void main(String[] args) throws IOException {
		readFile();
	}

}
