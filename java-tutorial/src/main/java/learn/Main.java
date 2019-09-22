package learn;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static boolean deleteDir(Path dir) {
//		if (dir.isDirectory()) {
//			String[] children = dir.list();
//			for (int i = 0; i < children.length; i++) {
//				boolean success = deleteDir(new File(dir, children[i]));
//				if (!success) {
//					return false;
//				}
//			}
//		}
//		return dir.delete();
		if (Files.isDirectory(dir)) {

		}
		return Files.isDirectory(dir);
	}

	public static void main(String[] args) throws IOException {

		String directories = "F:\\a\\b\\c\\d\\e\\f\\g\\h";
//		File file = new File(directories);
//		boolean result = file.mkdirs();
//		System.out.println("Status = " + result);
		// deleteDir(new File(directories));
		Path path = Paths.get(directories);
		System.out.println(deleteDir(path));
	}
}
