package basic.io.stream;

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
 * - available(): Trả về số byte có thể đọc trong InputStream (IS)
 * 
 * - mark(k): Đánh dấu vị trí hiện tại trong luồng đầu vào (input stream). Tham
 * số `k` xác định số byte tối đa có thể đọc sau khi đánh dấu mà không mất khả
 * năng reset lại vị trí. Nếu đọc quá số byte này, việc reset lại vị trí có thể
 * không thành công và bạn sẽ mất dấu
 * 
 * - reset: Quay lại vị trí được đánh dấu bằng mark()
 * 
 * - skip(n): Bỏ qua (skip) một số byte cụ thể
 * 
 * - InputStream là một nguồn dữ liệu có thể đọc một lần (one-time use)
 */
@SuppressWarnings({ "unused", "resource" })
public class InputStreamApi {

	private static String originalString = "Java 2023";

	private static InputStream isSample() {
		return new ByteArrayInputStream(originalString.getBytes());
	}

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
		InputStream inputStream = isSample();

		// Using Apache IOUtils
		String text = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
		System.out.println("IOUtils: " + text);

		// Using Apache Java 8
		String text2 = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)) //
				.lines() //
				.collect(Collectors.joining("\n"));
		System.out.println("Java 8: " + text2);
	}

	public static void readInputStreamLineByLine() throws IOException {
		InputStream is = isSample();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		boolean choose = false;
		if (choose) {
			// Using while loop
			while (reader.ready()) {
				System.out.println(reader.read());
			}
		} else {
			// Using for loop
			for (String line; (line = reader.readLine()) != null;) {
				System.out.println(line);
			}
		}
	}

	public static void inputStreamToByteArray() throws IOException {
		InputStream is = isSample();

		// Using Commons IO
		byte[] targetArray2 = IOUtils.toByteArray(is);

		// Using Plain Java
		byte[] targetArray = new byte[is.available()];
		is.read(targetArray);
	}

	public static void markAndReset() throws IOException {
		InputStream inputStream = isSample();

		// Đánh dấu vị trí hiện tại
		inputStream.mark(2); // Ví dụ, ghi nhớ 1024 byte

		// Đọc dữ liệu
		int data1 = inputStream.read();
		int data2 = inputStream.read();

		// Quay lại vị trí đã đánh dấu
		inputStream.reset();

		// Đọc lại dữ liệu từ vị trí đã đánh dấu
		int data3 = inputStream.read();
	}

	public static void main(String[] args) throws Exception {
		// createInputStream();
		// reUseInputStream();
		// inputStreamToString();
		// inputStreamToByteArray();
		// readInputStreamLineByLine();
		markAndReset();
	}

}
