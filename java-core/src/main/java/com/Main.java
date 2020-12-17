package com;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import common.util.FilesUtils;

public class Main {

	public static void start(TimeUnit unit, int limit) {
		long time = unit.toMillis(limit);
		System.out.println(time);
	}

	public static void main(String[] args) {
		// start(TimeUnit.HOURS, 2);
		Path dir = Paths.get("D:\\GDrive\\ToCompany\\latex\\my-problems");
		System.out.println("Files: " + FilesUtils.count(dir));
		// FilesUtils.listAllFile(dir).forEach(t -> System.out.println(t));
		// FilesUtils.getAllExtension(dir).forEach(t -> System.out.println(t));
	}

}
