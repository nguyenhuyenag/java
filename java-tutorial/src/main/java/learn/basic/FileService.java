package learn.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.activation.DataHandler;

import org.apache.commons.io.FileUtils;

import common.exception.FileException;
import common.util.FilesUtils;

public class FileService {

	private static String FILE_DOES_NOT_EXIST = "File does't exist!";

	/**
	 * Creates a directory by creating all non-existent parent directories first
	 * 
	 * @param dir the directory to create
	 * @return the directory
	 */

	public static Path createDirectories(Path dir) {
		try {
			return Files.createDirectories(dir);
		} catch (IOException e) {
			throw new FileException("Could not initialize storage", e);
		}
	}

	/**
	 * Test whether a file or directory exists
	 * 
	 * @param path the path to the file to test
	 * @return {@code true} if the file exists, otherwise {@code false}
	 */

	public static boolean isExists(Path path) {
		return Files.exists(path);
	}

	/**
	 * Test whether a file exists
	 * 
	 * @param filePath the path to the file to test
	 * @return {@code true} if the file exists, otherwise {@code false}
	 */

	public static boolean isExists(String filePath) {
		Path path = Paths.get(filePath);
		return isExists(path);
	}

	/**
	 * Reads all the bytes from a file
	 * 
	 * @param file the path to the file
	 * @return a byte array from the file
	 */

	public static byte[] readFileToBytes(File file) {
		if (!file.exists()) {
			throw new FileException(FILE_DOES_NOT_EXIST);
		}
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads all the bytes from a file
	 * 
	 * @param filePath the path to the file
	 * @return a byte array from the file
	 */

	public static byte[] fileToBytes(String filePath) {
		File file = new File(filePath);
		return readFileToBytes(file);
	}

	/**
	 * Reads all the bytes from a file
	 * 
	 * @param path of file
	 * @return byte array
	 * @throws IOException
	 */

	public static byte[] readFileToByteArray(String filePath) {
		try {
			Path path = Paths.get(filePath);
			if (!isExists(path)) {
				throw new FileException(FILE_DOES_NOT_EXIST);
			}
			return Files.readAllBytes(path);
		} catch (IOException e) {
			throw new FileException("File exception", e);
		}
	}

	/**
	 * Read file to string with Charset
	 * 
	 * @param path    of file
	 * @param Charset
	 * @return the file contents
	 */

	public static String readFileToString(String filePath, Charset cs) {
		byte[] bytes = readFileToByteArray(filePath);
		return new String(bytes, cs);
	}

	/**
	 * Read file to string with UTF-8
	 * 
	 * @param path of file
	 * @return the file contents
	 */

	public static String readFileToString(String filePath) {
		return readFileToString(filePath, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to list string with Charset
	 * 
	 * @param path    of file
	 * @param charset is Charset
	 * @return string content
	 */

	public static List<String> readFileLineByLine(String filePath, Charset cs) {
		try {
			Path path = Paths.get(filePath);
			if (!isExists(path)) {
				throw new FileException(FILE_DOES_NOT_EXIST);
			}
			return Files.readAllLines(path, cs);
		} catch (IOException e) {
			throw new FileException("File exception", e);
		}
	}

	/**
	 * Read file to list string with UTF-8
	 * 
	 * @param path of file
	 * @return string content
	 */

	public static List<String> readFileLineByLine(String filePath) {
		return readFileLineByLine(filePath, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to list string with Charset
	 * 
	 * @param path    of file
	 * @param charset is Charset
	 * @return string content
	 */

	public static List<String> readFileByBufferedReader(String filePath, Charset cs) {
		Path path = Paths.get(filePath);
		if (isExists(path)) {
			throw new FileException(FILE_DOES_NOT_EXIST);
		}
		List<String> data = new ArrayList<>();
		try {
			data = Files.newBufferedReader(path, cs).lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * Read file to list string with UTF-8
	 * 
	 * @param path the path to the file
	 * @return string content
	 */

	public static List<String> readFileByBufferedReader(String filePath) {
		return readFileByBufferedReader(filePath, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to string by Apache Commons IO
	 * 
	 * @param file the file to read
	 * @param cs   the encoding to use
	 * @return the file contents
	 * @throws IOException
	 */

	public static String readFileToStringByCommonsIO(File file, Charset cs) {
		if (!file.exists()) {
			throw new FileException(FILE_DOES_NOT_EXIST);
		}
		try {
			return FileUtils.readFileToString(file, cs);
		} catch (IOException e) {
			throw new FileException("File exception!", e);
		}
	}

	/**
	 * Read file to string by Apache Commons IO
	 * 
	 * @param file the file to read
	 * @return the file contents
	 * @throws IOException
	 */

	public static String readFileToStringByCommonsIO(File file) throws IOException {
		return readFileToStringByCommonsIO(file, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to string by Apache Commons IO
	 * 
	 * @param filePath the path to the file
	 * @param cs       is Charset
	 * @return the file contents
	 * @throws IOException
	 */

	public static String readFileToStringByCommonsIO(String filePath, Charset cs) throws IOException {
		File file = new File(filePath);
		return readFileToStringByCommonsIO(file, cs);
	}

	/**
	 * Read file to string by Apache Commons IO
	 * 
	 * @param filePath the path to the file
	 * @return the file contents
	 * @throws IOException
	 */

	public static String readFileToStringByCommonsIO(String filePath) throws IOException {
		return readFileToStringByCommonsIO(filePath, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to list string by Apache Commons IO
	 * 
	 * @param file the path to the file
	 * @param cs   the encoding to use
	 * @return the list of Strings representing each line in the file
	 */

	public static List<String> readFileByCommonsIO(File file, Charset cs) {
		if (!file.exists()) {
			throw new FileException(FILE_DOES_NOT_EXIST);
		}
		try {
			return FileUtils.readLines(file, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public static List<String> readFileByCommonsIO(File file) {
		return readFileByCommonsIO(file, StandardCharsets.UTF_8);
	}

	/**
	 * Read file to list string by Apache Commons IO
	 * 
	 * @param filePath
	 * @param cs       the path to the file
	 * @return the list of Strings representing each line in the file
	 */

	public static List<String> readFileByCommonsIO(String filePath, Charset cs) {
		File file = new File(filePath);
		return readFileByCommonsIO(file, StandardCharsets.UTF_8);
	}

	/**
	 * Create & write data to file If the file doesn't exists, create and write to
	 * it If the file exists, remove all content and write to it
	 * 
	 * @param filePath the path to the file
	 * @param lines    an object to iterate over the char sequences
	 * @param cs       the charset to use for encoding
	 */
	public static void createFile(Path path, List<String> data, Charset cs) {
		Path parent = path.getParent();
		if (!(Objects.isNull(parent) || isExists(parent))) {
			throw new FileException("The path file doesn't exist");
		}
		try {
			Files.write(path, data, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createFile(Path path, List<String> data) {
		createFile(path, data, StandardCharsets.UTF_8);
	}

	public static void createFile(Path path, String data, Charset cs) {
		Path parent = path.getParent();
		if (!(Objects.isNull(parent) || isExists(parent))) {
			throw new FileException("The path file doesn't exist");
		}
		try {
			Files.write(path, data.getBytes(cs));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createFile(Path path, String data) {
		createFile(path, data, StandardCharsets.UTF_8);
	}

	// If the file doesn't exists, create and write to it
	// If the file exists, append to it
	static void write(Path path, List<String> data, Charset cs) {
		Path parent = path.getParent();
		if (!(Objects.isNull(parent) || isExists(parent))) {
			throw new FileException("The path file doesn't exist");
		}
		try {
			Files.write(path, data, cs, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Deprecated
	public static List<String> getAllFile(Path dir) {
		if (!isExists(dir)) {
			throw new FileException("Directory does't exists!");
		}
		List<String> data = new ArrayList<>();
		try {
			Files.list(dir).forEach(p -> {
				if (Files.isDirectory(p)) {
					data.addAll(getAllFile(p));
				} else {
					data.add(p.toString());
				}
			});
			return data;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Deprecated
	public static File[] getAllFileInDirectory(String dir) {
		File file = new File(dir);
		return file.listFiles();
	}

	@Deprecated
	public static List<String> getFileName(Path path) {
		// File dir = new File(path.toString());
		// File dir = path.toFile();
		File[] listFiles = path.toFile().listFiles();
		return Stream.of(listFiles) //
				.filter(file -> !file.isDirectory()) //
				.map(File::getName) //
				.collect(Collectors.toList());
	}

	@Deprecated
	public static List<File> listFiles(String pathname) {
		File directory = new File(pathname);
		List<File> list = new ArrayList<File>();
		File[] listFiles = directory.listFiles(); // Get all files from a directory
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isFile()) {
					list.add(file);
				} else if (file.isDirectory()) {
					list.addAll(listFiles(file.getAbsolutePath()));
				}
			}
		}
		return list;
	}

	@Deprecated
	public static List<File> listFiles(String pathname, String postfix) {
		File directory = new File(pathname);
		List<File> list = new ArrayList<File>();
		File[] listFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(postfix));
		// File[] listFiles = directory.listFiles(new FilenameFilter() {
		// public boolean accept(File dir, String name) {
		// return name.toLowerCase().endsWith(postfix);
		// }
		// });
		if (listFiles != null) {
			for (File file : listFiles) {
				if (file.isFile()) {
					list.add(file);
				} else if (file.isDirectory()) {
					list.addAll(listFiles(file.getAbsolutePath()));
				}
			}
		}
		return list;
	}

	public static byte[] toBytes(DataHandler handler) throws IOException {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		handler.writeTo(output);
		return output.toByteArray();
	}

	public static void copy(Path source, Path target) {
		try {
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			System.err.format("I/O Error when copying file");
		}
	}

	public static void createBinaryFileUsingFileOutputStream(String filePath, String data, Charset cs)
			throws IOException {
		byte[] bytes = data.getBytes(cs);
		FileOutputStream out = new FileOutputStream(filePath);
		out.write(bytes);
		out.close();
	}

	public static void createTextFileUsingBufferedWritter(String fileName, String data) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
		writer.append(data);
		writer.close();
	}

	public void createTextFileUuingPrintWriter(String fileName, String data) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.printf(data);
		printWriter.close();
	}

	public static String[][] readFileToMatrix(String filename) {
		String line;
		String[] arr;
		List<String[]> list = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				arr = line.trim().split("\\s");
				list.add(arr);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void readLineByLine(String file) {
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(file));
			Stream<String> lines = br.lines();
			lines.forEach(System.out::println);
			lines.close();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void useScanner(String file) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(file));
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static void useStream(String file) {
		Stream<String> stream = null;
		try {
			stream = Files.lines(Paths.get(file));
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			stream.close();
		}
	}

	public static void setReadOnly() {
		File file = new File("file/data.txt");
		file.setReadOnly();
		// file.canWrite();
		System.out.println(Files.isWritable(file.toPath()));
		System.out.println(FilesUtils.readFileToString(file));
		FilesUtils.writeStringToFile(file.toPath(), "2019", StandardCharsets.UTF_8, false);
	}

}
