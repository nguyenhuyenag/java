package com.synchronize;

import lombok.Getter;
import lombok.Setter;

/**
 * - Mutual Exclusive (synchronized) -> Loại trừ lẫn nhau. Cách này hệ thống sẽ
 * ưu tiên một thread và ngăn chặn các thread khác khỏi nguy cơ xung đột với
 * nhau.
 * 
 * - Cooperation -> Cộng tác với nhau. Cách này bản thân các thread sẽ bắt tay
 * với nhau, cùng nhau điều tiết thứ tự ưu tiên để có thể tự bản thân chúng
 * tránh sự xung đột.
 */
@Getter
@Setter
public class Synchronized {

	/**
	 * synchronized method -> Khóa toàn bộ phương thức của một instance của object
	 * (this)
	 */
	public synchronized void printData(String threadName) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(threadName + ": " + i);
		}
	}

	/**
	 * synchronized statements -> Khóa một phần của code trong một phương thức. Giảm
	 * phạm vi khóa, cãi thiện performance (các luồng khác không phải chờ nếu truy
	 * cập vào các tài nguyên khác)
	 */
	public void printData2(String threadName) {
		// Do Something before synchronized ...
		synchronized (this) {
			for (int i = 1; i <= 5; i++) {
				System.out.println(threadName + ": " + i);
			}
		}
	}

	/**
	 * static synchronized method -> Khóa toàn bộ phương thức của một lớp (class)
	 */
	public static synchronized void printData3(String threadName) {
		for (int i = 1; i <= 5; i++) {
			System.out.println(threadName + ": " + i);
		}
	}

}
