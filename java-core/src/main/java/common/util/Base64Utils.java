package common.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;

import basic.io.file.FileUtils;

public class Base64Utils {

	public static byte[] encode(byte[] byteArr) {
		return Base64.getEncoder().encode(byteArr);
	}

	public static String encodeToString(byte[] byteArr) {
		byte[] arr = Base64.getEncoder().encode(byteArr);
		return new String(arr, StandardCharsets.UTF_8);
	}

	public static String encodeToString(String str) {
		byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
		return encodeToString(byteArr);
	}
	
	public static String encodeToString(Path path) {
		try {
			byte[] byteArr = Files.readAllBytes(path);
			byteArr = Base64.getEncoder().encode(byteArr);
			return new String(byteArr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static byte[] decodeToByte(String base64) {
		byte[] byteArr = base64.getBytes(StandardCharsets.UTF_8);
		return Base64.getDecoder().decode(byteArr);
	}

	public static String decodeToString(String base64) {
		byte[] byteArr = base64.getBytes(StandardCharsets.UTF_8);
		byteArr = Base64.getDecoder().decode(byteArr);
		return new String(byteArr);
	}
	
	public static Path base64ToFile(Path path, String base64) {
		byte[] byteArr = Base64Utils.decodeToByte(base64);
		if (byteArr == null) {
			throw new IllegalArgumentException("Illegal character in Base64 data");
		}
		return FileUtils.writeByteArrayToFile(path, byteArr, false);
	}
	
}
