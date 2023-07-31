package com;

import java.io.IOException;

import org.apache.commons.io.FilenameUtils;

public class Main {

	public static void main(String[] args) throws IOException {
//		Path path = Paths.get("C:", "/temp", "test.txt");
//		System.out.println(path.normalize());
//		FileUtils.touch(path.toFile());
//		System.out.println("Pathhhhhhhhhhh: "+PathUtils.current());
//		File currentWorkingDir = FileUtils.getUserDirectory();
//        System.out.println("Current Working Directory: " + currentWorkingDir.getAbsolutePath());
		
		String basePath = "/path/to";
        String filenameToAdd = "file.txt";
        
        String concatenatedPath = FilenameUtils.concat(basePath, filenameToAdd);
        System.out.println("Concatenated Path: " + concatenatedPath);
	}
}
