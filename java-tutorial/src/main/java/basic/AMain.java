package basic;

import util.file.FileService;

public class AMain {

	public static void main(String[] args) {
		// Path file = Paths.get("file/data.txt");
		FileService.readLineByLine("file/data.txt");
	}

}
