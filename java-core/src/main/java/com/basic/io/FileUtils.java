package com.basic.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import common.util.Base64Utils;
import common.util.Predicates;

class FileException extends RuntimeException {

	private static final long serialVersionUID = -791011360967376587L;

	public FileException(String message) {
		super(message);
	}

	public FileException(String message, Throwable cause) {
		super(message, cause);
	}

}

public class FileUtils {

	public static Path validateFile(Path path) {
		if (PathUtils.isNotExist(path)) {
			throw new FileException("Path does't exists!");
		}
		return path;
	}

	/**
	 * Create an empty file
	 */
	public static Path createFile(Path path) {
		if (PathUtils.exist(path)) {
			try {
				org.apache.commons.io.FileUtils.touch(path.toFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path;
	}

	public static Path createFileFromString(Path path, String contents) {
		if (PathUtils.exist(path)) {
			try {
				// FileUtils.write(file, "", "UTF-8", false);
				// writeByteArrayToFile(file, byte[] data, boolean append)
				org.apache.commons.io.FileUtils //
						.writeStringToFile(path.toFile(), contents, "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return path;
	}

	/**
	 * Read file to bytes array
	 */
	public static byte[] toByteArray(Path path) {
		validateFile(path);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Read file to bytes array
	 */
	public static byte[] toByteArray(File file) {
		if (file != null) {
			return toByteArray(file.toPath());
		}
		return null;
	}

	/**
	 * File to DataHandler
	 */
	// public static DataHandler asDataHandler(File file) {
	// DataSource source = new FileDataSource(file);
	// return new DataHandler(source);
	// }

	/**
	 * Read DataHandler to bytes array
	 */
	// public static byte[] toByteArray(DataHandler handler) {
	// try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
	// handler.writeTo(os);
	// return os.toByteArray();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	/**
	 * Read a file into a String
	 */
	public static String readFile(Path path) {
		if (path != null) {
			byte[] bytes = toByteArray(path);
			if (bytes != null) {
				return new String(bytes, StandardCharsets.UTF_8);
			}
		}
		return "";
	}

	/**
	 * Read file all lines from a file
	 */
	public static List<String> readAllLines(Path path) {
		validateFile(path);
		try {
			return Files.readAllLines(path, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

//	@Deprecated
//	public static String[][] lines(Path path, String regex) {
//		try (Stream<String> stream = Files.lines(path)) {
//			return stream.map(s -> s.split(regex != null ? regex : "\\s+")) //
//					.toArray(String[][]::new);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	/**
	 * Tạo (nếu file chưa có) và ghi nội dung cho file
	 * 
	 * @param append bằng {@code true} thì thêm nội dung vào cuối file, nếu bằng
	 *               {@code false} thì ghi đè lên nội dung cũ.
	 */
	public static Path writeByteArrayToFile(Path path, byte[] bytes, boolean append) {
		if (PathUtils.isNotExist(path)) {
			// FileUtils.createFile(path);
		}
		try {
			if (append) {
				return Files.write(path, bytes, StandardOpenOption.APPEND);
			}
			return Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Path base64ToFile(Path path, String base64) {
		byte[] byteArr = Base64Utils.decodeToByte(base64);
		return writeByteArrayToFile(path, byteArr, false);
	}

	/**
	 * Tạo (nếu file chưa có) và ghi nội dung cho file
	 * 
	 * @param append bằng {@code true} thì thêm nội dung vào cuối file, nếu bằng
	 *               {@code false} thì ghi đè lên nội dung cũ.
	 */
	public static Path writeStringToFile(Path path, String content, boolean append) {
		if (content == null) {
			throw new FileException("Content is NULL!");
		}
		return writeByteArrayToFile(path, content.getBytes(), append);
	}

//	/**
//	 * Create and writes byte array to a file. If the file exists, remove all
//	 * content and write to it
//	 * 
//	 * @param path  the path to the file
//	 * @param bytes the byte array to write to the file
//	 * @return boolean
//	 */
//	public static boolean writeByteArrayToFile(Path path, byte[] bytes) {
//		return writeByteArrayToFile(path, bytes, false);
//	}

//	/**
//	 * Create (if it does't exist) and writes a string to a file
//	 * 
//	 * @param path   the path to the file
//	 * @param data   string content to write to the file
//	 * @param cs     the encoding to use
//	 * @param append if {@code true} the bytes will be added to the end of the file.
//	 *               If {@code false} remove all content and write to it
//	 * @return boolean
//	 */
//	public static boolean writeStringToFile(Path path, String data, Charset cs, boolean append) {
//		byte[] bytes = data.getBytes(cs);
//		return writeByteArrayToFile(path, bytes, append);
//	}

//	/**
//	 * Create and writes a string to a file. If the file exists, remove all content
//	 * and write to it
//	 * 
//	 * @param path the path to the file
//	 * @param data string content to write to the file
//	 * @return boolean
//	 */
//	public static boolean writeStringToFile(Path path, String data) {
//		return writeStringToFile(path, data, StandardCharsets.UTF_8, false);
//	}

//	/**
//	 * Create and writes a string to a file. If the file exists, append content and
//	 * write to it
//	 * 
//	 * @param path the path to the file
//	 * @param data string content to write to the file
//	 * @return boolean
//	 */
//	public static boolean appendStringToFile(Path path, String data) {
//		return writeStringToFile(path, data, StandardCharsets.UTF_8, true);
//	}

	/**
	 * 
	 */
	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> contents, boolean append) {
		if (PathUtils.isNotExist(path)) {
			// FileUtils.createFile(path);
		}
		try {
			if (!append) {
				Files.write(path, contents, StandardCharsets.UTF_8);
			} else {
				Files.write(path, contents, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			}
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

//	/**
//	 * Create and writes a string to a file. If the file exists, remove all content
//	 * and write to it
//	 * 
//	 * @param path   the path to the file
//	 * @param data   content to write to the file
//	 * @param append if {@code true} the bytes will be added to the end of the file.
//	 *               If {@code false} remove all content and write to it
//	 * @return boolean
//	 */
//	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> data, boolean append) {
//		return writeTextToFile(path, data, StandardCharsets.UTF_8, append);
//	}

//	/**
//	 * Create and writes a string to a file. If the file exists, remove all content
//	 * and write to it
//	 * 
//	 * @param path the path to the file
//	 * @param data content to write to the file
//	 * @return boolean
//	 */
//	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> data) {
//		return writeTextToFile(path, data, StandardCharsets.UTF_8, false);
//	}

//	/**
//	 * Create and writes a string to a file. If the file exists, append content and
//	 * write to it
//	 * 
//	 * @param path the path to the file
//	 * @param data content to write to the file
//	 * @return boolean
//	 */
//	public static boolean appendTextToFile(Path path, Collection<? extends CharSequence> data) {
//		return writeTextToFile(path, data, StandardCharsets.UTF_8, true);
//	}

	/**
	 * Get all elements in the directory (without subdirectory)
	 */
	public static List<String> listFile(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) { // Get all elements in directory
			return list.filter(Predicates.not(Files::isDirectory)) // without directory
					.map(Path::toString).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory (without subdirectory)
	 */
	public static List<File> listFiles(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			return list.filter(Predicates.not(Files::isDirectory)) //
					.map(Path::toFile) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory & subdirectory
	 */
	public static List<String> listAllFile(Path dir) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			return walk.filter(Files::isRegularFile) //
					.map(Path::toString) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory & subdirectory
	 */
	public static List<File> listAllFiles(Path dir) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			return walk.filter(Files::isRegularFile) //
					.map(Path::toFile) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory (without subdirectory)
	 */
	public static List<String> listFile(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			String ext = extension.toLowerCase().trim();
			return list.filter(Predicates.not(Files::isDirectory)) //
					.filter(f -> f.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toString) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory (without subdirectory)
	 */
	public static List<File> listFiles(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			String ext = extension.toLowerCase().trim();
			return list.filter(Predicates.not(Files::isDirectory)) //
					.filter(f -> f.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toFile) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory & subdirectory by extention
	 */
	public static List<String> listAllFile(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			String ext = extension.toLowerCase().trim();
			return walk.filter(Files::isRegularFile) //
					.filter(f -> f.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toString) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements in the directory & subdirectory by extention
	 */
	public static List<File> listAllFiles(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			String ext = extension.toLowerCase().trim();
			return walk.filter(Files::isRegularFile) //
					.filter(f -> f.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toFile) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements filename in the directory (without subdirectory)
	 */
	public static List<String> listFileName(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			return list.filter(Predicates.not(Files::isDirectory)) //
					.map(f -> f.getFileName().toString()) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	/**
	 * Get all elements filename in the directory & subdirectory
	 */
	public static List<String> listFileNames(Path dir) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			return walk.filter(Files::isRegularFile) //
					.map(f -> f.getFileName().toString()) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

//	/**
//	 * Count the elements in directory
//	 * 
//	 * @param dir the path to the directory
//	 * @return the number of elements in this directory
//	 */
//	public static int count(Path dir) {
//		return listFile(dir).size();
//	}
//
//	/**
//	 * Count the elements in directory & subdirectory
//	 * 
//	 * @param dir the path to the directory
//	 * @return the number of elements in this directory & subdirectory
//	 */
//	public static int countAll(Path dir) {
//		return listAllFile(dir).size();
//	}

	/**
	 * File rename
	 * 
	 * @param newname is new filename (without extension)
	 */
	public static boolean rename(Path path, String newname) {
		validateFile(path);
		try {
			Path newfile = Paths.get(path.getParent().toString(), newname + "." + getFileExtension(path.toFile()));
			Files.move(path, path.resolveSibling(newfile));
			// Files.move(path, path.resolveSibling(newfile),
			// StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean rename(File file, String newname) {
		return rename(file.toPath(), newname);
	}

	public static void move(Path path, String toFolder) {

	}

	/**
	 * Get filename (without extension)
	 */
	public static String getFilename(Path path) {
		return FilenameUtils.getBaseName(path.toFile().toString());
	}

	/**
	 * Get file extension
	 * 
	 * @param filename
	 * @return extension (pdf, doc, ...)
	 */
	public static String getFileExtension(File file) {
		return FilenameUtils.getExtension(file.getName());
	}

	/**
	 * Get all file extension in folder
	 * 
	 * @param dir the path
	 * @return all file extension
	 */
	public static Set<String> getAllExtension(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			return list.map(f -> FilenameUtils.getExtension(f.toFile().getName())) //
					.filter(StringUtils::isNotEmpty).collect(Collectors.toSet()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptySet();
	}

	public static void copy(Path source, Path target) {
		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.err.format("I/O error when copying file");
		}
	}

	public static void main(String[] args) {

	}

}
