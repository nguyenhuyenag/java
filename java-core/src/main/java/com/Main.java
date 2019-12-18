package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FilesUtils;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("D:\\Note\\test\\1a.jpg");
		// System.out.println(Arrays.toString(FilesUtils.toByteArray(path)));
		// System.out.println(FilesUtils.getFileExtension(path.toFile()));
		System.out.println(FilesUtils.rename(path, "pic"));
	}

}
