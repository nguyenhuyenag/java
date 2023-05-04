package com.basic.thread;

/**
 * - volatile là một từ khóa trong Java, được sử dụng để đánh dấu một biến là
 * "volatile". Khi một biến được đánh dấu là volatile, nó sẽ được xử lý khác
 * biệt so với các biến thông thường.
 * 
 * - Cụ thể, khi một biến được đánh dấu là volatile, các giá trị gán vào biến sẽ
 * được ghi vào bộ nhớ chính trực tiếp, không thông qua bộ nhớ đệm của CPU. Điều
 * này đảm bảo rằng nếu một thread đọc giá trị của biến từ bộ nhớ chính, nó sẽ
 * nhận được giá trị mới nhất, thay vì giá trị trong bộ nhớ đệm của nó.
 * 
 * - Ngoài ra, khi một biến được đánh dấu là volatile, tất cả các lần đọc và ghi
 * của nó đều được đảm bảo là tuân thủ theo thứ tự mà chúng được thực hiện. Điều
 * này có nghĩa là nếu một thread ghi giá trị mới cho biến và một thread khác
 * đọc giá trị đó, giá trị mới nhất sẽ được đọc.
 * 
 * - Vì vậy, volatile được sử dụng để đảm bảo tính toàn vẹn của dữ liệu trong
 * một ứng dụng đa luồng, đặc biệt là trong các trường hợp khi các biến có thể
 * được truy cập và sửa đổi bởi nhiều thread cùng một lúc. Tuy nhiên, việc sử
 * dụng volatile không đảm bảo tính an toàn của các hoạt động đọc/ghi đa luồng
 * trong mọi trường hợp, do đó các khối lệnh nên được đồng bộ hóa bằng các cơ
 * chế khác như synchronized hoặc Lock khi cần thiết.
 */
public class VolatileExample {

	// private static int count = 0; // chay chuong trinh khi co va khong co volatile
	private static volatile int count = 0;

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	public static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (count < 5) {
				System.out.println("Increasing value of count variable to " + (i + 1));
				count = ++i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class ChangeListener extends Thread {
		@Override
		public void run() {
			int value = count;
			// Khi giá trị của biến COUNT nhỏ hơn 5, thread này sẽ lặp mãi mãi để kiểm tra
			// giá trị của biến này
			while (value < 5) {
				if (value != count) {
					System.out.println("Count variable changed to : " + count);
					value = count;
				}
			}
		}
	}
}
