package com;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import common.util.FilesUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		// Path path = Paths.get("D:\\Dev\\Project\\Github\\java\\java-core\\src\\main\\java\\common\\util\\Colors.java");
		//List<String> list = FilesUtils.readAllLines(path);
		//System.out.println(list);
		Path path = Paths.get("C:\\Users\\nguye\\Desktop\\test\\data.txt");
		//byte[] arr = "Java 7".getBytes();
//		boolean append = true;
//		for (int i = 1; i < 16; i++) {
//			String s = "Java " + i;
//			FilesUtils.writeByteArrayToFile(path, s.getBytes(), append);
//		}
		List<String> list = new ArrayList<>();
		list.add("Nguyễn");
		list.add("Văn");
		list.add("Huyện");
		FilesUtils.writeTextToFile(path, list, false);
		System.out.println("OK");
	}

}
