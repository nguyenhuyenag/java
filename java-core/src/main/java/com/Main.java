package com;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;

import common.util.PathUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		String path = PathUtils.PROJECT_DIR + "/file/data.json";
		File file = new File(path);
		Tika tika = new Tika();
		System.out.println(tika.detect(file));
	}

}
