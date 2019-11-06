package learn.collection.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/*-
 * Có hai class triển khai interface Queue
 * 	- LinkedList
 * 	- PriorityQueue
 */
public class QueueLinkedList {

	public static void deleteQueue(Queue<String> queue) throws InterruptedException {
		System.out.println("From " + queue + "\n");
		while (queue.size() > 0) {
			// Lấy ra và loại bỏ phần tử đầu tiên
			String name = queue.poll(); 		// Trả về null nếu không còn phần tử nào
			// String name = queue.remove(); 	// Throws nếu hàng đợi không còn phần tử
			System.out.println("Get & remove " + name + " => " + queue + "\n");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("Done!");
	}

	public static void main(String[] args) throws InterruptedException {
		Queue<String> queue = new LinkedList<>();
		// Trả về true nếu thêm thành công, ngược lại false
		queue.offer("E");
		queue.offer("A");
		queue.offer("M");
		queue.offer("G");
		queue.offer("B");
		// IllegalStateException nếu hàng đợi không còn chỗ
		queue.add("F");
		queue.add("T");
		queue.add("L");
		queue.add("K");
		queue.add("X");
		// call delete
		deleteQueue(queue);
	}

}
