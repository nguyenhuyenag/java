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
 * - Các phương thức của Queue
 * 												|
 * 		- add(e)								|	- offer(e)
 * 												|
 * 			+ Exception nếu hàng đợi hết chỗ	|		+ Trả về false nếu hàng đợi không còn chỗ
 * 												|
 * 		- remove()								|	- poll()
 * 												|
 * 			+ Lấy ra và xóa phần tử đầu hàng	|		+ //
 * 												|			
 * 			+ Exception nếu hàng đợi rỗng		|		+ Trả về null nếu hàng đợi rỗng
 * 												|
 * 		- element()								|	- peek()
 * 												|	
 * 			+ Lấy ra nhưng không xóa phần tử	|		+ //
 *            đầu hàng							|
												|
 *          + Exception nếu hàng đợi rỗng		|		+ Trả về null nếu hàng đợi rỗng
 *   											|
 *   
 *   - Có hai class cài đặt interface Queue là LinkedList và PriorityQueue (hàng đợi ưu tiên).
 */
public class QueueApi {

	public static void main(String[] args) {
		int[] A = {3, 2, 1, 5, 6, 4};
		Queue<Integer> queue = new PriorityQueue<>();
		for (int el : A) {
			queue.add(el);
			// queue.offer(el);
			System.out.println(queue);
		}
		System.out.println(queue.element());
		// System.out.println(queue.peek());
	}

}
