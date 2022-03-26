package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.Base64Utils;
import common.util.FileUtils;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("C:/Users/nguye/OneDrive/Desktop/ayaka.png");
		String base64 = Base64Utils.encodeToString(path);
		// System.out.println(base64);
		Path decode = Paths.get("C:/Users/nguye/OneDrive/Desktop/ayaka_decode.png");
		FileUtils.base64ToFile(decode, base64);
	}

}
