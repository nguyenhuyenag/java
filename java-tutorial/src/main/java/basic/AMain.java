package basic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.util.FilesUtils;
import common.util.PathUtils;

public class AMain {

	public static void main(String[] args) {
		
		// String s = PathUtils.toUnixPath("C:\\ftp\\tvan\\daky\\70100");
		String s = PathUtils.toUnixSeparator("C:/ftp\\tvan/daky\\70100");
		System.out.println(s);

		Path path = Paths.get("C:/ftp/tvan/daky/70100");
		List<String> list1 = FilesUtils.getAllFiles(path);
		// System.out.println(list1.size());
		// list1.forEach(System.out::println);

	}
}
