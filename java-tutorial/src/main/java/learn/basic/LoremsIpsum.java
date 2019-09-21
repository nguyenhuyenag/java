package learn.basic;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

import common.util.FilesUtils;

public class LoremsIpsum {

	public static void main(String[] args) {

		Lorem lorem = LoremIpsum.getInstance();
		// String text = lorem.getParagraphs(1, 15);
		String text = lorem.getWords(10);
		Path path = Paths.get("file/data.txt");
		FilesUtils.appendStringToFile(path, text);
		// System.out.println(text);

	}

}
