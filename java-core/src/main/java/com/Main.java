package com;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		File tempDirectory = FileUtils.getUserDirectory();
		System.out.println(tempDirectory.toString());
	}
}
