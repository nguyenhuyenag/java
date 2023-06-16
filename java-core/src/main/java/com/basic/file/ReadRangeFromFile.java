package com.basic.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import common.util.PathUtils;

public class ReadRangeFromFile {

	// read(0, 4) -> Đọc ra dữ liệu từ 0 -> 4 trong file 5MB
	public static void read(int from, int to) {
		String filePath = PathUtils.PROJECT_DIR +  "/file/vnedict.txt";
		long startPosition = from * 1024 * 1024; // x MB
		long endPosition = to * 1024 * 1024; // y MB

		/**
		 * Sử dụng FileChannel để mở tệp tin và tạo một MappedByteBuffer bằng cách sử
		 * dụng phương thức map(). MappedByteBuffer cho phép chúng ta trực tiếp truy cập
		 * dữ liệu trong tệp tin mà không cần đọc toàn bộ tệp vào bộ nhớ.
		 * 
		 * Chúng ta chỉ cần chỉ định vị trí bắt đầu và số byte cần đọc trong phương thức
		 * map(). Sau đó sử dụng get() để trích xuất dữ liệu từ MappedByteBuffer vào
		 * mảng byte data.
		 * 
		 * Lưu ý rằng MappedByteBuffer tiêu thụ một phần bộ nhớ ảo tương ứng với kích
		 * thước của tệp tin, do đó, nếu tệp tin quá lớn, việc sử dụng MappedByteBuffer
		 * có thể gây ra vấn đề về bộ nhớ
		 */
		byte[] data = null;
		try (FileChannel channel = FileChannel.open(Path.of(filePath), StandardOpenOption.READ)) {
			long bytesToRead = endPosition - startPosition;
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, startPosition, bytesToRead);
			data = new byte[(int) bytesToRead];
			buffer.get(data);
			// Use the 'data' byte array as needed
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * Sử dụng FileChannel để mở tệp tin và tạo một ByteBuffer với kích thước chính
		 * xác là số byte cần đọc (bytesToRead). Sau đó sử dụng channel.read()
		 * để đọc dữ liệu từ vị trí bắt đầu đến ByteBuffer. Để làm điều này, chúng ta
		 * truyền vị trí bắt đầu (startPosition) làm tham số cho phương thức read().
		 * 
		 * Sau khi đọc dữ liệu vào ByteBuffer, chúng ta gọi flip() để chuyển ByteBuffer
		 * sang chế độ đọc. Sau đó, chúng ta tạo một mảng byte data với kích thước chính
		 * xác là số byte đã đọc (bytesRead), và sử dụng get() để trích xuất dữ liệu từ
		 * ByteBuffer vào data.
		 * 
		 * Điều này cho phép chúng ta đọc dữ liệu từ vị trí x đến vị trí y trong tệp tin
		 * mà không cần đọc toàn bộ tệp vào bộ nhớ trước đó.
		 */
		byte[] data2 = null;
		try (FileChannel channel = FileChannel.open(Path.of(filePath), StandardOpenOption.READ)) {
			long bytesToRead = endPosition - startPosition;
			ByteBuffer buffer = ByteBuffer.allocate((int) bytesToRead);
			int bytesRead = channel.read(buffer, startPosition);
			buffer.flip();
			data2 = new byte[bytesRead];
			buffer.get(data2);
			// Use the 'data' byte array as needed
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(Arrays.equals(data, data2));
	}
	
	public static void main(String[] args) {
		read(0, 1);
	}

}
