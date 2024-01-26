package com.basic.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * String tempDir = System.getProperty("java.io.tmpdir");
 */
public class TempFile {

    public static void usingFile() throws Exception {
        File tempFile = File.createTempFile("test_", ".tmp");
        System.out.println("File = " + tempFile);

        // Ghi dữ liệu vào tệp tạm thời
        Files.write(tempFile.toPath(), "Hello, Temporary File!".getBytes());

        // Đọc dữ liệu từ tệp tạm thời
        byte[] content = Files.readAllBytes(tempFile.toPath());
        System.out.println(new String(content));

        // Tệp vẫn tồn tại khi chương trình chưa kết thúc
        tempFile.deleteOnExit();

        System.out.println("exists: " + tempFile.exists());
    }

    public static void main(String[] args) throws Exception {
        usingFile();
    }

}
