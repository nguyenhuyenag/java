package com.basic.charstring;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;

public class LoremIpsums {

	public static void main(String[] args) {
		Lorem lorem = LoremIpsum.getInstance();
		String text = lorem.getWords(10);
		// String text = lorem.getParagraphs(1, 15);
		// Path path = Paths.get("file/lorem.txt");
		//FilesUtils.appendStringToFile(path, text);
		System.out.println(text);
	}

}
