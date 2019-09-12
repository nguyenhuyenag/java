package basic;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import util.file.FilesUtils;

public class AMain {

	public static void main(String[] args) throws InterruptedException {
		long i = 0;
		String str;
		Path file = Paths.get("file/data.txt");
		while (true) {
			// read file
			str = FilesUtils.readFileToString(file);
			System.out.println(str);
			i++;
			FilesUtils.writeStringToFile(file, String.valueOf(i));
			System.out.println("...zzz!");
			TimeUnit.SECONDS.sleep(1);
		}

	}

}
