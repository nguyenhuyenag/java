package com.basic.io.stream;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;

/**
 * - InputStream là một nguồn dữ liệu có thể đọc một lần (one-time use). Nếu cần
 * cần thực hiện nhiều lần đọc dữ liệu ta cần lưu trữ dữ liệu đọc được từ
 * ByteArrayOutputStream
 */
@SuppressWarnings({ "unused", "resource" })
public class InputStreamApi {

	private static String originalString = "Java 2023";

	public static void createInputStream() throws IOException {
		// From file
		InputStream inputStream = new FileInputStream("file.txt");

		// From byte array
		byte[] data = { 65, 66, 67, 68, 69 };
		InputStream inputStream2 = new ByteArrayInputStream(data);

		// From String
		InputStream inputStream3 = new ByteArrayInputStream(originalString.getBytes());

		// From network connection
		URL url = new URL("https://example.com/data.txt");
		InputStream inputStream4 = url.openStream();
	}
	
	public static void reUseInputStream() throws Exception {
		InputStream inputStream = new ByteArrayInputStream(originalString.getBytes());
		inputStream.mark(Integer.MAX_VALUE);
		System.out.println(IOUtils.toString(inputStream, "UTF-8"));
		inputStream.reset();
		System.out.println(IOUtils.toString(inputStream, "UTF-8"));
	}

	public static void inputStreamToString() throws IOException {
		// Using Apache IOUtils
		InputStream inputStream = new ByteArrayInputStream(originalString.getBytes());
		String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
		System.out.println("IOUtils: " + text);

		// Using Apache Java 8
		String text2 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)) //
				.lines() //
				.collect(Collectors.joining("\n"));
		System.out.println("Java 8: " + text2);
	}

	public static void main(String[] args) throws Exception {
		// createInputStream();
		// inputStreamToString();
		reUseInputStream();
	}

}
