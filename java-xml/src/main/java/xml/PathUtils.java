package xml;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtils {

	// File.separator => '\'

	/**
	 * Project directory
	 */
	public static final String HOME = System.getProperty("user.dir");
	
	public static final String RESOURCES = Paths.get(HOME, "src/main/resources").toString();

	public static boolean exist(Path path) {
		return (path != null && Files.exists(path));
	}
	
	public static boolean isNotExist(Path path) {
		return !exist(path);
	}
	
	public static String join(String... paths) {
		String result = String.join("/", paths);
		return Paths.get(result.toString()).toString();
	}

}
