package common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class PathUtils {
	
	// File.separator => '\'

	/**
	 * Project directory
	 */
	public static final String HOME = System.getProperty("user.dir");
	
	/**
	 * Test whether a file or directory exists
	 * @param path the path to the file to test
	 * @return {@code true} if the file exists, otherwise {@code false}
	 */
	public static boolean exists(File file) {
		return (file != null && file.exists());
	}
	
	/**
	 * Test whether a file or directory exists
	 * @param path the path to the file to test
	 * @return {@code true} if the file exists, otherwise {@code false}
	 */
	public static boolean exists(Path path) {
		return (path != null && Files.exists(path));
	}

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
	 * Delete the supplied {@link File} - for directories, recursively delete any
	 * nested directories or files as well.
	 * @param dir the root {@code File} to delete
	 * @return {@code true} if the {@code File} was deleted, otherwise {@code false}
	 */
	public static boolean deleteRecursively(File dir) {
		if (dir != null && dir.exists()) {
			if (dir.isDirectory()) {
				File[] listFiles = dir.listFiles();
				if (listFiles != null) {
					for (File child : listFiles) {
						deleteRecursively(child);
					}
				}
			}
			return dir.delete();
		}
		return false;
	}
	
	/**
	 * Delete the supplied {@link File} - for directories, recursively delete any
	 * nested directories or files as well.
	 * @param dir the root {@code Path} to delete
	 * @return {@code true} if the {@code File} was deleted, otherwise {@code false}
	 */
	public static boolean deleteRecursively(Path path) {
		return deleteRecursively(path.toFile());
	}
	
	/**
	 * Show hierarchy
	 * @param indent is tab
	 * @param file the path to the file
	 * @throws IOException
	 */
	public static void showHierarchy(int indent, File file) throws IOException {
		if (indent != 1) {
			for (int i = 0; i < indent; i++) {
				System.out.print("-");
			}
		}
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				showHierarchy(indent + 4, files[i]);
			}
		}
	}
	
	/**
	 * Counts the size of a directory recursively (sum of the length of all files).
	 * @param dir the path to the directory
	 * @return size of directory in bytes
	 */
	public static long sizeOfDirectory(File dir) {
		return FileUtils.sizeOfDirectory(dir);
	}

}
