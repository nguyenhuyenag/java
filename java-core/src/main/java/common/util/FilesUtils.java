package common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

import common.exception.FileException;

public class FilesUtils {
	
	public static void validateFile(Path file) {
		if (!PathUtils.exists(file)) {
			throw new FileException("Directory does't exists!");
		}
	}
	
	/**
	 * Reads all the bytes from a file
	 * @param path file the path to the file
	 * @return a byte array from the file
	 */
	public static byte[] toByteArray(Path path) {
		validateFile(path);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ArrayUtils.EMPTY_BYTE_ARRAY;
	}
	
	/**
	 * Reads all the bytes from a file
	 * @param file the path to the file
	 * @return a byte array from the file
	 */
	public static byte[] toByteArray(File file) {
		return toByteArray(file.toPath());
	}
	
	/**
	 * Get DataHandler from File
	 * @param file the path to the file
	 * @return DataHandler
	 */
	public static DataHandler asDataHandler(File file) {
		DataSource source = new FileDataSource(file);
		return new DataHandler(source);
	}
	
	/**
	 * Get DataHandler from Path
	 * @param path the path to the file
	 * @return DataHandler
	 */
	public static DataHandler asDataHandler(Path path) {
		return asDataHandler(path.toFile());
	}
	
	/**
	 * Reads all the bytes from a DataHandler
	 * @param handler DataHandler
	 * @return a byte array from the file
	 */
	public static byte[] toByteArray(DataHandler handler) {
		try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
			handler.writeTo(os);
			return os.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ArrayUtils.EMPTY_BYTE_ARRAY;
	}
	
	/**
	 * Read all lines from a file
	 * @param path the path to the file
	 * @param cs the charset to use for decoding
	 * @return the lines from the file
	 */
	public static List<String> readAllLines(Path path, Charset cs) {
		validateFile(path);
		try {
			return Files.readAllLines(path, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Read all lines from a file
	 * @param file the path to the file
	 * @param cs the charset to use for decoding
	 * @return the lines from the file
	 */
	public static List<String> readAllLines(File file, Charset cs) {
		return readAllLines(file.toPath(), cs);
	}
	
	/**
	 * Read all lines from a file
	 * @param path the path to the file
	 * @return the lines from the file
	 */
	public static List<String> readAllLines(Path path) {
		return readAllLines(path, StandardCharsets.UTF_8);
	}
	
	/**
	 * Read all lines from a file
	 * @param file the path to the file
	 * @return the lines from the file
	 */
	public static List<String> readAllLines(File file) {
		return readAllLines(file.toPath(), StandardCharsets.UTF_8);
	}
	
	/**
	 * Reads the contents of a file into a String
	 * @param path the path to the file 
	 * @param the encoding to use
	 * @return the file contents
	 */
	public static String readFileToString(Path path, Charset cs) {
		byte[] bytes = toByteArray(path);
		return new String(bytes, cs);
	}
	
	/**
	 * Reads the contents of a file into a String
	 * @param path the path to the file 
	 * @param the encoding to use
	 * @return the file contents
	 */
	public static String readFileToString(File file, Charset cs) {
		byte[] bytes = toByteArray(file);
		return new String(bytes, cs);
	}
	
	/**
	 * Reads the contents of a file into a String
	 * @param path the path to the file
	 * @return the file contents
	 */
	public static String readFileToString(Path path) {
		return readFileToString(path, StandardCharsets.UTF_8);
	}

	/**
	 * Reads the contents of a file into a String
	 * @param path the path to the file
	 * @return the file contents
	 */
	public static String readFileToString(File file) {
		return readFileToString(file, StandardCharsets.UTF_8);
	}
	
	@Deprecated
	public static String[][] lines(Path path, String regex) {
		try (Stream<String> stream = Files.lines(path)) {
			return stream.map(s -> s.split(regex != null ? regex : "\\s+")) //
					.toArray(String[][]::new);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Create (if it does't exist) and writes byte array to a file
	 * @param path the path to the file
	 * @param bytes the byte array to write to the file
	 * @param append if {@code true} the bytes will be added to the end of the file. If
	 *            {@code false} remove all content and write to it
	 * @return boolean
	 */
	public static boolean writeByteArrayToFile(Path path, byte[] bytes, boolean append) {
		Path parent = path.getParent();
		if (!(Objects.isNull(parent) || PathUtils.exists(parent))) {
			throw new FileException("The path file doesn't exist");
		}
		try {
			if (!append) {
				Files.write(path, bytes);
				return true;
			}
			Files.write(path, bytes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Create and writes byte array to a file. If the file exists, remove all
	 * content and write to it
	 * @param path the path to the file
	 * @param bytes the byte array to write to the file
	 * @return boolean
	 */
	public static boolean writeByteArrayToFile(Path path, byte[] bytes) {
		return writeByteArrayToFile(path, bytes, false);
	}

	/**
	 * Create (if it does't exist) and writes a string to a file
	 * @param path the path to the file
	 * @param data string content to write to the file
	 * @param cs the encoding to use
	 * @param append if {@code true} the bytes will be added to the end of the file. If
	 *            {@code false} remove all content and write to it
	 * @return boolean
	 */
	public static boolean writeStringToFile(Path path, String data, Charset cs, boolean append) {
		byte[] bytes = data.getBytes(cs);
		return writeByteArrayToFile(path, bytes, append);
	}

	/**
	 * Create and writes a string to a file. If the file exists, remove all content
	 * and write to it
	 * @param path the path to the file
	 * @param data string content to write to the file
	 * @return boolean
	 */
	public static boolean writeStringToFile(Path path, String data) {
		return writeStringToFile(path, data, StandardCharsets.UTF_8, false);
	}
	
	/**
	 * Create and writes a string to a file. If the file exists, append content
	 * and write to it
	 * @param path the path to the file
	 * @param data string content to write to the file
	 * @return boolean
	 */
	public static boolean appendStringToFile(Path path, String data) {
		return writeStringToFile(path, data, StandardCharsets.UTF_8, true);
	}
	
	/**
	 * Create (if it does't exist) and writes a text to a file
	 * @param path the path to the file
	 * @param data content to write to the file
	 * @param cs the encoding to use
	 * @param append if {@code true} the bytes will be added to the end of the file. If
	 *            {@code false} remove all content and write to it
	 * @return boolean
	 */
	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> data, Charset cs, boolean append) {
		Path parent = path.getParent();
		if (!(Objects.isNull(parent) || PathUtils.exists(parent))) {
			throw new FileException("The path file doesn't exist");
		}
		try {
			if (!append) {
				Files.write(path, data, cs);
				return true;
			}
			Files.write(path, data, cs, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Create and writes a string to a file. If the file exists, remove all content
	 * and write to it
	 * @param path the path to the file
	 * @param data content to write to the file
	 * @param append if {@code true} the bytes will be added to the end of the file. If
	 *            {@code false} remove all content and write to it
	 * @return boolean
	 */
	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> data, boolean append) {
		return writeTextToFile(path, data, StandardCharsets.UTF_8, append);
	}
	
	/**
	 * Create and writes a string to a file. If the file exists, remove all content
	 * and write to it
	 * @param path the path to the file
	 * @param data content to write to the file
	 * @return boolean
	 */
	public static boolean writeTextToFile(Path path, Collection<? extends CharSequence> data) {
		return writeTextToFile(path, data, StandardCharsets.UTF_8, false);
	}
	
	/**
	 * Create and writes a string to a file. If the file exists, append content
	 * and write to it
	 * @param path the path to the file
	 * @param data content to write to the file
	 * @return boolean
	 */
	public static boolean appendTextToFile(Path path, Collection<? extends CharSequence> data) {
		return writeTextToFile(path, data, StandardCharsets.UTF_8, true);
	}
	
	/**
	 * Get all elements in the directory (without subdirectory)
	 * @param dir the path to the directory
	 * @return the content of the directory
	 */
	public static List<String> listFile(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) { // Get all elements in directory
			return list.filter(Predicates.not(Files::isDirectory)) // without directory
					.map(Path::toString) // path to string
					.collect(Collectors.toList()); // to list
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements in the directory (without subdirectory)
	 * @param dir the path to the directory
	 * @return the content of the directory
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
	 * @param dir the path to the directory
	 * @return the content of the directory & subdirectory
	 */
	public static List<String> listAllFile(Path dir) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			return walk.filter(Files::isRegularFile) //
					// .filter(PredicateUtils.not(Files::isDirectory))
					.map(Path::toString) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements in the directory & subdirectory
	 * @param dir the path to the directory
	 * @return the content of the directory & subdirectory
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
	 * @param dir the path to the directory
	 * @param extension the extension filter
	 * @return the content of the directory
	 */
	public static List<String> listFile(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			String ext = extension.toLowerCase().trim();
			return list.filter(Predicates.not(Files::isDirectory)) //
					.filter(p -> p.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toString) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements in the directory (without subdirectory)
	 * @param dir the path to the directory
	 * @param extension the extension filter
	 * @return the content of the directory
	 */
	public static List<File> listFiles(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			String ext = extension.toLowerCase().trim();
			return list.filter(Predicates.not(Files::isDirectory)) //
					.filter(p -> p.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toFile) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements in the directory & subdirectory by extention
	 * @param dir the path to the directory
	 * @param extension the extension filter
	 * @return the content of the directory & subdirectory
	 */
	public static List<String> listAllFile(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			String ext = extension.toLowerCase().trim();
			return walk.filter(Files::isRegularFile) //
					.filter(p -> p.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toString) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements in the directory & subdirectory by extention
	 * @param dir the path to the directory
	 * @param extension the extension filter
	 * @return the content of the directory & subdirectory
	 */
	public static List<File> listAllFiles(Path dir, String extension) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			String ext = extension.toLowerCase().trim();
			return walk.filter(Files::isRegularFile) //
					.filter(p -> p.toString().toLowerCase().endsWith(ext)) //
					.map(Path::toFile) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements filename in the directory (without subdirectory)
	 * @param dir the path to the directory
	 * @return list filename
	 */
	public static List<String> listFileName(Path dir) {
		validateFile(dir);
		try (Stream<Path> list = Files.list(dir)) {
			return list.filter(Predicates.not(Files::isDirectory)) //
					.map(p -> p.getFileName().toString()) //
					.collect(Collectors.toList()); //
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Get all elements filename in the directory & subdirectory
	 * @param dir the path to the directory
	 * @return the content of the directory & subdirectory
	 */
	public static List<String> listFileNames(Path dir) {
		validateFile(dir);
		try (Stream<Path> walk = Files.walk(dir)) {
			return walk.filter(Files::isRegularFile) //
					.map(p -> p.getFileName().toString()) //
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}
	
	/**
	 * Count the elements in directory
	 * @param directory the path to the directory
	 * @return the number of elements in this directory
	 */
	public static int count(Path directory) {
		return listFile(directory).size();
	}

	/**
	 * Count the elements in directory & subdirectory
	 * @param directory the path to the directory
	 * @return the number of elements in this directory & subdirectory
	 */
	public static int countAll(Path directory) {
		return listAllFile(directory).size();
	}
	
	/**
	 * File rename
	 * @param file current file
	 * @param newname is new name
	 * @return {@code boolean}
	 * @see File#renameTo
	 */
	public static boolean rename(Path file, String newname) {
		validateFile(file);
		try {
			Path newfile = Paths.get(file.getParent().toString(), newname + "." + getFileExtension(file.toFile()));
			System.out.println(newfile.toString());
			Files.move(file, file.resolveSibling(newfile));
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Get filename without extension
	 * @param path the path to the file
	 * @return filename
	 */
	public static String getFilename(Path path) {
		return FilenameUtils.getBaseName(path.toFile().toString());
	}
	
	public static String getFileExtension(File file) {
		return FilenameUtils.getExtension(file.getName());
	}
	
}
