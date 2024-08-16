package basic.io.file.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

	public static void main(String[] args) throws IOException {
		readFile();
	}

}
