package com.basic.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

import javax.swing.filechooser.FileSystemView;

public class FileService {

//	public static String readFileToStringCommonsIO(File file, Charset cs) throws IOException {
//		return FileUtils.readFileToString(file, cs);
//	}

//	public static List<String> readLinesCommonsIO(File file, Charset cs) throws IOException {
//		return FileUtils.readLines(file, cs);
//	}

//	public static List<File> listFiles(String path) {
//		List<File> list = new ArrayList<>();
//		File[] arrFiles = Paths.get(path).toFile().listFiles(); // Get all files from a directory
//		if (ArrayUtils.isNotEmpty(arrFiles)) {
//			for (File file : arrFiles) {
//				if (file.isFile()) {
//					list.add(file);
//				} else if (file.isDirectory()) {
//					list.addAll(listFiles(file.getAbsolutePath()));
//				}
//			}
//		}
//		return list;
//	}

//	public static List<File> listFiles(String pathname, String postfix) {
//		File directory = new File(pathname);
//		List<File> list = new ArrayList<>();
//		// File[] listFiles = directory.listFiles((dir, name) ->
//		// name.toLowerCase().endsWith(postfix));
//		File[] files = directory.listFiles(new FilenameFilter() {
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.toLowerCase().endsWith(postfix);
//			}
//		});
//		if (ArrayUtils.isNotEmpty(files)) {
//			for (File f : files) {
//				if (f.isFile()) {
//					list.add(f);
//				} else if (f.isDirectory()) {
//					list.addAll(listFiles(f.getAbsolutePath()));
//				}
//			}
//		}
//		return list;
//	}

//	public static void fileUsingFileOutputStream(String path, String data, Charset cs) throws IOException {
//		try (FileOutputStream fot = new FileOutputStream(path)) {
//			byte[] bytes = data.getBytes(cs);
//			fot.write(bytes);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

//	public static void createTextFileUsingBufferedWritter(String fileName, String data) {
//		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
//			writer.append(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void createTextFileUuingPrintWriter(String fileName, String data) {
//		try (FileWriter fileWriter = new FileWriter(fileName); //
//				PrintWriter printWriter = new PrintWriter(fileWriter)) {
//			printWriter.printf(data);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public static void readFileToMatrix(String filename) {
//		String[] arr;
//		String line = "";
//		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//			while ((line = br.readLine()) != null) {
//				arr = line.trim().split("\\s+");
//				System.out.println(Arrays.toString(arr));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

//	public static void readLineByLine(String file) {
//		try (BufferedReader br = Files.newBufferedReader(Paths.get(file))) {
//			br.lines().forEach(System.out::println);
//		} catch (IOException io) {
//			io.printStackTrace();
//		}
//	}

	public static void readFileUseScanner(String file) {
		try (Scanner scanner = new Scanner(new File(file))) {
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public static void setReadOnly() {
//		File file = new File("file/data.txt");
//		file.setReadOnly();
//		// file.canWrite();
//		System.out.println(Files.isWritable(file.toPath()));
//		//System.out.println(FileUtils.readFileToString(file.toPath()));
//		//FileUtils.writeStringToFile(file.toPath(), "2019".getBytes(), false);
//	}

	// file attributes
//	static void printAttributes(DosFileAttributes attr) {
//		System.out.println("isArchive()  = " + attr.isArchive());
//		System.out.println("isHidden()   = " + attr.isHidden());
//		System.out.println("isReadOnly() = " + attr.isReadOnly());
//		System.out.println("isSystem()   = " + attr.isSystem());
//		System.out.println("----------------------------------------");
//	}

//	public static void showAttributes() throws IOException {
//		Path file = Paths.get("file/data.txt");
//		// Get current Dos file attributes and print it.
//		DosFileAttributes attr = Files.readAttributes(file, DosFileAttributes.class);
//		printAttributes(attr);
//		// Set a new file attributes.
//		Files.setAttribute(file, "dos:archive", false);
//		Files.setAttribute(file, "dos:hidden", false);
//		Files.setAttribute(file, "dos:readonly", false);
//		Files.setAttribute(file, "dos:system", false);
//		// Read the newly set file attributes and print it.
//		attr = Files.readAttributes(file, DosFileAttributes.class);
//		printAttributes(attr);
//	}
	
	/**
	 * Tạo file, nếu đường dẫn (thư mục cha) không tồn tại thì tạo đường dẫn xong sẽ
	 * tạo file
	 */
	public static boolean createFile(Path path) {
		if (path == null) {
			System.out.println("Path `" + path + "` does't exists!");
			return false;
		}
		Path parent = path.getParent();
		try {
			if (PathUtils.isNotExist(parent)) {
				PathUtils.createDirectories(parent);
			}
			// Files.createFile(path);
			return path.toFile().createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void fileAttributes() {
		try {
			Path file = Paths.get(PathUtils.PROJECT_DIR, "file", "test.xml");
			BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
			System.out.println("Create time: " + attr.creationTime());
			System.out.println("Size: " + attr.size());
			System.out.println("Last access time: " + attr.lastAccessTime());
			System.out.println("Last modified time: " + attr.lastModifiedTime());
			System.out.println("Last modified time: " + file.toFile().lastModified());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void desktopPath() {
		String desktopPath = System.getProperty("user.home") + File.separator +"Desktop";
		System.out.println(desktopPath);
		System.out.println(Files.exists(Paths.get(desktopPath)));
		
		FileSystemView view = FileSystemView.getFileSystemView();
		File file = view.getHomeDirectory();
		desktopPath = file.getPath();
		System.out.println(desktopPath);
	}

	// File size
	public static void fileSize() {
		// https://fastest.fish/generate-file
		File file = new File("C:/Users/huyennv/Downloads/100MiB.bin");
		if (!file.exists()) {
			System.out.println("File doesn't exists!");
			return;
		}
		long bytes = file.length();
		double kilobytes = bytes / 1024;
		double megabytes = kilobytes / 1024;
		double gigabytes = megabytes / 1024;
		double terabytes = gigabytes / 1024;
		double petabytes = terabytes / 1024;
		double exabytes = petabytes / 1024;
		double zettabytes = exabytes / 1024;
		double yottabytes = zettabytes / 1024;
		// console
		System.out.println("bytes \t   : " + bytes);
		System.out.println("kilobytes  : " + kilobytes);
		System.out.println("megabytes  : " + megabytes);
		System.out.println("gigabytes  : " + gigabytes);
		System.out.println("terabytes  : " + terabytes);
		System.out.println("petabytes  : " + petabytes);
		System.out.println("exabytes   : " + exabytes);
		System.out.println("zettabytes : " + zettabytes);
		System.out.println("yottabytes : " + yottabytes);
	}

	public static void main(String[] args) {
		// fileSize();
		desktopPath();
	}

}
