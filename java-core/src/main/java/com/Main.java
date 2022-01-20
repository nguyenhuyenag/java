package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FileUtils;

public class Main {

	public static void main(String[] args) {
		Path dir = Paths.get("C:\\ftp\\tctn\\2021");
		FileUtils.listAllFiles(dir, ".xml").forEach(t->System.out.println(t.toString()));
	}

}
