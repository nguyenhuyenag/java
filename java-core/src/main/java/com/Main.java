package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FileUtils;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("C:\\Users\\huyennv\\Desktop\\test\\kbyt.png");
		FileUtils.rename(path, "abc");
	}

}
