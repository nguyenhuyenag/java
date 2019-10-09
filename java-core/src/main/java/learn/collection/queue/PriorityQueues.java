package learn.collection.queue;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * PriorityQueue lưu trữ phần tử theo trật tự nhiên của phần tử (nếu các phần tử
 * đó so sánh được với nhau – implements Comparable) hoặc một bộ so sánh
 * Comparator được cung cấp cho PriorityQueue
 */
public class PriorityQueues {

	static void deleteQueue(Queue<String> names) throws InterruptedException {
		System.out.println(names + "\n");

		while (true) {
			// Lấy ra và loại bỏ phần tử đầu tiên ra khỏi hàng đợi.
			// Trả về null nếu không còn phần tử nào trong hàng đợi.
			String name = names.poll();
			if (Objects.isNull(name)) {
				break;
			}
			System.out.println("Get & remove " + name + " ...");
			System.out.println(names + "\n");
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// Lớp String implements Comparable nên hàng đợi tự động sắp xếp theo chữ cái
		Queue<String> names = new PriorityQueue<String>();

		// Trả về false nếu hàng đợi không còn chỗ
		names.offer("E");
		names.offer("A");
		names.offer("M");
		names.add("G");
		names.add("B");

		// Ném ra ngoại lệ nếu hàng đợi không còn chỗ IllegalStateException
		names.add("F");
		names.add("T");
		names.add("L");
		names.add("K");
		names.add("X");

		deleteQueue(names);

	}

}
