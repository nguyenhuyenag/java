package com.basic.awt;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class RunExternalFile {

	public static void runExternalFile() throws InterruptedException {
		String filePath = "D:/Dev/Projects/Github/dev/git/git_pull_all.bat";
		filePath = "D:\\Dev\\Projects\\Github\\java/README.md";
		try {
			File file = new File(filePath);
			if (Desktop.isDesktopSupported()) {
				Desktop desktop = Desktop.getDesktop();
				if (desktop.isSupported(Desktop.Action.OPEN)) {
					desktop.open(file);
				} else {
					System.out.println("Opening files is not supported on this platform.");
				}
			} else {
				System.out.println("Desktop is not supported on this platform.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		runExternalFile();
	}

}
