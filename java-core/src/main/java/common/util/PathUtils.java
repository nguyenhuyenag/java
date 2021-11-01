package common.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	 */
	public static boolean exist(Path path) {
		return (path != null && Files.exists(path));
	}
	
	public static boolean isNotExist(Path path) {
		return !exist(path);
	}
	
	public static String join(String... paths) {
		String joinPath = String.join("/", paths);
		joinPath = Paths.get(joinPath.toString()).toString();
		return FilenameUtils.normalize(joinPath, true);
	}

//	/**
//	 * Test whether a file or directory exists
//	 */
//	public static boolean exists(File file) {
//		return (file != null && file.exists());
//	}

	/**
	 * Tạo thư mục
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
	 * Chuyển {@code project\\github\\java} thành {@code project/github/java}
	 */
	public static String toUnixSeparator(String filename) {
		return FilenameUtils.normalize(filename, true);
	}

	/**
	 * Delete the supplied {@link File} - for directories, recursively delete any
	 * nested directories or files as well.
	 * 
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
	 * 
	 * @param dir the root {@code Path} to delete
	 * @return {@code true} if the {@code File} was deleted, otherwise {@code false}
	 */
	public static boolean deleteRecursively(Path path) {
		return deleteRecursively(path.toFile());
	}
	
	/**
	 * Kích thước thư mực
	 */
	public static long sizeOfDirectory(File dir) {
		return FileUtils.sizeOfDirectory(dir);
	}

	/**
	 * Hiển thị cây thư mục
	 */
	public static void showHierarchy(File file, int indent) {
		if (indent != 1) {
			for (int i = 0; i < indent; i++) {
				System.out.print("-");
			}
		}
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				showHierarchy(files[i], indent + 4);
			}
		}
	}

}
