package common.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;

public class PathUtils {

	// File.separator => '\'
	
	private PathUtils() {}
	
	/**
	 * Creates a directory by creating all non-existent parent directories first
	 * @param dir the directory to create
	 * @return the directory
	 */
	public static boolean createDirectories(Path dir) {
		try {
			Files.createDirectories(dir);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * To UNIX separator
	 * @param filename the filename to normalize
	 * @return the normalized filename
	 * @see FilenameUtils#normalize
	 * @see FilenameUtils#separatorsToUnix
	 */
	public static String toUnixSeparator(String filename) {
		return FilenameUtils.normalize(filename, true);
	}

	/**
	 * Converts the given URI to a path
	 * @return the string path
	 */
	public static String get(String first, String... more) {
		String path = Paths.get(first, more).toString();
		return toUnixSeparator(path);
	}
	
	/**
	 * Test whether a file or directory exists
	 * @param path the path to the file to test
	 * @return {@code true} if the file exists, otherwise {@code false}
	 */
	public static boolean isExists(Path path) {
		return Files.exists(path);
	}

	/**
	 * Project directory
	 */
	public static String HOME = System.getProperty("user.dir");

}
