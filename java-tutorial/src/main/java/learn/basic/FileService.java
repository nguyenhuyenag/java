package learn.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;

import common.exception.FileException;
import common.util.FilesUtils;

public class FileService {

	public static String readFileToStringByCommonsIO(File file, Charset cs) {
		if (!file.exists()) {
			throw new FileException("File does't exist!");
		}
		try {
			return FileUtils.readFileToString(file, cs);
		} catch (IOException e) {
			throw new FileException("File exception!", e);
		}
	}

	public static List<String> readFileByCommonsIO(File file, Charset cs) {
		if (!file.exists()) {
			throw new FileException("File does't exist!");
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

	public static void setReadOnly() {
		File file = new File("file/data.txt");
		file.setReadOnly();
		// file.canWrite();
		System.out.println(Files.isWritable(file.toPath()));
		System.out.println(FilesUtils.readFileToString(file));
		FilesUtils.writeStringToFile(file.toPath(), "2019", StandardCharsets.UTF_8, false);
	}

	// file attributes
	static void printAttributes(DosFileAttributes attr) {
		System.out.println("isArchive()  = " + attr.isArchive());
		System.out.println("isHidden()   = " + attr.isHidden());
		System.out.println("isReadOnly() = " + attr.isReadOnly());
		System.out.println("isSystem()   = " + attr.isSystem());
		System.out.println("----------------------------------------");
	}

	public static void showAttributes() throws IOException {
		Path file = Paths.get("file/data.txt");
		// Get current Dos file attributes and print it.
		DosFileAttributes attr = Files.readAttributes(file, DosFileAttributes.class);
		printAttributes(attr);
		// Set a new file attributes.
		Files.setAttribute(file, "dos:archive", false);
		Files.setAttribute(file, "dos:hidden", false);
		Files.setAttribute(file, "dos:readonly", false);
		Files.setAttribute(file, "dos:system", false);
		// Read the newly set file attributes and print it.
		attr = Files.readAttributes(file, DosFileAttributes.class);
		printAttributes(attr);
	}

	// File size
	public static void filesize() {
		File file = new File("file/data.xml");
		if (file.exists()) {
			double bytes = file.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			double gigabytes = (megabytes / 1024);
			double terabytes = (gigabytes / 1024);
			double petabytes = (terabytes / 1024);
			double exabytes = (petabytes / 1024);
			double zettabytes = (exabytes / 1024);
			double yottabytes = (zettabytes / 1024);

			System.out.println("bytes : " + bytes);
			System.out.println("kilobytes : " + kilobytes);
			System.out.println("megabytes : " + megabytes);
			System.out.println("gigabytes : " + gigabytes);
			System.out.println("terabytes : " + terabytes);
			System.out.println("petabytes : " + petabytes);
			System.out.println("exabytes : " + exabytes);
			System.out.println("zettabytes : " + zettabytes);
			System.out.println("yottabytes : " + yottabytes);
		} else {
			System.out.println("File does not exists!");
		}
	}

}
