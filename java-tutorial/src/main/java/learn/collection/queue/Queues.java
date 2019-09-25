package learn.collection.queue;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/*-
 * Có hai class implement interface Queue
 * - java.util.LinkedList
 * - java.util.PriorityQueue
 */
public class Queues {

	static void deleteQueue(Queue<String> names) throws InterruptedException {
		System.out.println(names + "\n");
		while (true) {
			// Lấy ra và loại bỏ phần tử đầu tiên
			String name = names.poll();			// Trả về null nếu không còn phần tử nào
			// String name = names.remove();	// Throws nếu hàng đợi không còn phần tử
			if (Objects.isNull(name)) {
				break;
			}
			System.out.println("Get & remove " + name + " ...");
			System.out.println(names + "\n");
			TimeUnit.SECONDS.sleep(1);
		}

	}

	public static void main(String[] args) throws InterruptedException {

		Queue<String> names = new LinkedList<>();

		// Trả về true nếu thêm thành công, ngược lại false
		names.offer("E");
		names.offer("A");
		names.offer("M");
		names.offer("G");
		names.offer("B");

		// Ném ra ngoại lệ (IllegalStateException) nếu hàng đợi không còn chỗ
		names.add("F");
		names.add("T");
		names.add("L");
		names.add("K");
		names.add("X");

		deleteQueue(names);
	}

}
