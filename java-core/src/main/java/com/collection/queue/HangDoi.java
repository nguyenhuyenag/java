package com.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/*-
 * - Queue (hàng đợi): Hoạt động theo cơ chế FIFO (firt in first out)
 * 
 * 		+ Cho phép chứa phần tử giống nhau.
 * 
 * 		+ Không chứa phần tử null.
 * 
 * 		+ Chỉ có thể truy cập phần tử ở đầu hàng.
 * 
 * 		+ Vị trí phần từ được chèn phụ thuộc vào loại hàng đợi và độ ưu tiên của phần tử đó.
 * 
 *  	+ Có 2 class cài đặt interface Queue là PriorityQueue (hàng đợi ưu tiên) và LinkedList.
 * 
 * - Các phương thức của Queue
 *
 *    ------------------------------------------|-------------------------------------------
 * 		- add(e)								|	- offer(e)
 * 												|
 * 			+ Exception nếu hàng đợi hết chỗ	|		+ Trả về false nếu hàng đợi hết chỗ
 * 	  ------------------------------------------|-------------------------------------------
 * 		- remove()								|	- poll()
 * 												|
 * 			+ Lấy ra và xóa phần tử đầu hàng	|		+ Lấy ra và xóa phần tử đầu hàng
 * 			+ Exception nếu hàng đợi rỗng		|		+ Trả về null nếu hàng đợi rỗng
 * 	  ------------------------------------------|-------------------------------------------
 * 		- element()								|	- peek()
 * 												|	
 * 			+ Lấy ra nhưng không xóa			|		+ Lấy ra nhưng không xóa
 *          + Exception nếu hàng đợi rỗng		|		+ Trả về null nếu hàng đợi rỗng
 *    ------------------------------------------|-------------------------------------------
 */
public class HangDoi {

	/**
	 * Ví dụ hàng đợi ưu tiên
	 */
	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		// new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> queue = new PriorityQueue<>(); // Hàng đợi ưu tiên kiểu INT nên phần tử nhỏ nhất luôn ở đầu
		// Thêm phần tử
		for (int e : nums) {
			queue.add(e);
			System.out.println(queue);
		}
		// Get phần tử
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}

}
