package com;

import java.io.File;

import common.util.FilesUtils;

public class Main {

	public static void main(String[] args) {
		File file = new File("file/data-csv.csv");
		FilesUtils.readAllLines(file).forEach(t -> System.out.println(t));
	}

}
