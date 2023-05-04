package com.basic.thread;

/**
 * - Khi một biến được đánh dấu là volatile, các giá trị gán vào nó được ghi vào
 * bộ nhớ chính trực tiếp, không thông qua bộ nhớ đệm của CPU. Điều này đảm bảo
 * rằng nếu một thread đọc giá trị của biến từ bộ nhớ chính, nó sẽ nhận được giá
 * trị mới nhất, thay vì giá trị trong bộ nhớ đệm của nó.
 * 
 * - Ngoài ra, khi một biến được đánh dấu là volatile, tất cả các lần đọc và ghi
 * của nó đều được đảm bảo là tuân thủ theo thứ tự mà chúng được thực hiện.
 * Nghĩa là nếu một thread ghi giá trị mới cho biến và một thread khác đọc giá
 * trị đó, giá trị mới nhất sẽ được đọc.
 * 
 * - Vì vậy, volatile được sử dụng để đảm bảo tính toàn vẹn của dữ liệu trong
 * một ứng dụng đa luồng, đặc biệt là trong các trường hợp khi các biến có thể
 * được truy cập và sửa đổi bởi nhiều thread cùng một lúc. Tuy nhiên, việc sử
 * dụng volatile không đảm bảo tính an toàn của các hoạt động đọc/ghi đa luồng
 * trong mọi trường hợp, do đó các khối lệnh nên được đồng bộ hóa bằng các cơ
 * chế khác như synchronized hoặc Lock khi cần thiết.
 */
public class VolatileExample {

	private static int count = 0;
	// private static volatile int count = 0;

	/**
	 * - Giá trị của biến `count` chỉ được lưu trong bộ nhớ đệm của CPU, và không
	 * được đồng bộ hóa giữa các thread. Do đó, khi một thread thay đổi giá trị của
	 * biến count, thread khác không thể nhận biết được sự thay đổi này, và do đó sẽ
	 * không bao giờ thoát khỏi vòng lặp while.
	 * 
	 * - Khi thêm lệnh in ra màn hình trong vòng lặp của thread Listener, chương
	 * trình sẽ dừng lại do hiện tượng "busy-waiting" (chờ đợi bằng cách lặp vô tận
	 * một phép kiểm tra). Tuy nhiên, việc in ra giá trị của biến count có thể khiến
	 * cho giá trị đó được đọc từ bộ nhớ chính thay vì bộ nhớ đệm của CPU, do đó giá
	 * trị được đọc sẽ là giá trị mới nhất được ghi vào bởi thread Maker
	 */
	public static void main(String[] args) {
		new Listener().start();
		new Maker().start();
	}

	public static class Maker extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (count < 5) {
				System.out.println("Maker count = " + (i + 1));
				count = ++i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class Listener extends Thread {
		@Override
		public void run() {
			int value = count;
			while (value < 5) {
				// System.out.println("Listener value = " + value + ", count = " + count);
				if (value != count) {
					// System.out.println("Listener count = " + count);
					value = count;
				}
			}
		}
	}
}
