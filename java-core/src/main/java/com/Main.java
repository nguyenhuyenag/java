package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.basic.ClipboardUtils;

import common.util.Base64Utils;

public class Main {

	public static void test() {
		// public static void main (String[] args) throws java.lang.Exception
		{
			String errorMessage = null;
			try {
				throw (new Exception("Let's throw some exception message here"));
			} catch (Exception e) {
				System.out.println("In Exception block.");
				errorMessage = e.getMessage();
			} finally {
				System.out.println(errorMessage);
			}
		}
	}

	public static void main(String[] args) {
//		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/test.xlsx");
//		String base64 = Base64Utils.encodeToString(path);
//		System.out.println(base64.trim());
//		ClipboardUtils.copy(base64);
		test();
	}

}
