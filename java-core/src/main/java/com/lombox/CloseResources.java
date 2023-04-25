package com.lombox;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import lombok.Cleanup;

public class CloseResources {

	public static void main(String[] args) throws FileNotFoundException {
		@Cleanup Scanner scanner = new Scanner(new File("file/department.xml"));
		while (scanner.hasNext()) {
			System.out.println(scanner.nextLine());
		}
	}

}
