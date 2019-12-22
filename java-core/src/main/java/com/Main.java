package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.FilesUtils;

public class Main {

	public static void main(String[] args) {
		Path dir = Paths.get("F:\\NHAC\\Nhac_Tre");
//		List<String> fileAccept = Arrays.asList("mp4", "mp3", "m4a");
//		FilesUtils.listAllFiles(dir).stream().forEach(file -> {
//			if (fileAccept.contains(FilesUtils.getFileExtension(file))) {
//				long size = FileUtils.sizeOf(file);
//				// System.out.println((float) size / 1000000);
//				if (size <= 5000000) {
//					System.out.println(file.getName());
//				}
//			}
//		});
		// System.out.println(FilesUtils.getAllExtension(Paths.get("F:\\NHAC\\Nhac_Tre")));
		FilesUtils.getAllExtension(dir).forEach(System.out::println);
	}

}
