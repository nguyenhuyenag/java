package com.basic.file;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

/**
 * - contentEquals(file1, file2): So sánh nội dung 2 file
 * 
 * - copyDirectory(srcDir, destDir): Copy toàn bộ nội dung từ srcDir sang destDir
 * 
 * - readFileToByteArray(): Đọc file thành thành mảng byte
 * 
 * - readFileToString(): Đọc file thành thành string
 * 
 * - readLines(): Đọc file thành thành string
 * 
 * - sizeOfDirectory(): Tính toán kích thước của một thư mục
 * 
 * - writeStringToFile(file, data, charset, boolean append): Ghi chuỗi vào file
 * 
 * - writeByteArrayToFile(file, byte[] data): Ghi mảng byte vào file
 * 
 * - writeLines(file, Collection<?> lines, boolean): Ghi 1 collection vào file
 * 
 */
public class FileUtilsApache {

	/**
	 * Xóa toàn bộ nội dung trong thư mục (trừ chính nó) được chỉ định
	 */
	public static void cleanDirectory() {
		try {
			File directory = new File("/path/to/your/directory");
			FileUtils.cleanDirectory(directory);
			System.out.println("Directory has been cleaned successfully.");
		} catch (IOException e) {
			System.err.println("An error occurred: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// cleanDirectory();
	}

}
