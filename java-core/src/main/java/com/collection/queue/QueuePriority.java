package com.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/*-
 * PriorityQueue lưu trữ phần tử theo trật tự nhiên của nó (nếu các phần tử đó
 * so sánh được với nhau – implements Comparable) hoặc một bộ so sánh Comparator
 * được cung cấp cho PriorityQueue
 */
public class QueuePriority {

	public static void deleteQueue(Queue<String> queue) throws InterruptedException {
		System.out.println("From " + queue + "\n");
		while (queue.size() > 0) {
			String name = queue.poll();
			System.out.println("Get & remove " + name + " => " + queue + "\n");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("Done!");
	}

	public static void main(String[] args) throws InterruptedException {
		// String implements Comparable nên Queue tự động sắp xếp theo bảng chữ cái
		Queue<String> queue = new PriorityQueue<>();
		// Trả về false nếu hàng đợi không còn chỗ
		queue.offer("E");
		queue.offer("A");
		queue.offer("M");
		queue.add("G");
		queue.add("B");
		// Ném ra ngoại lệ nếu hàng đợi không còn chỗ IllegalStateException
		queue.add("F");
		queue.add("T");
		queue.add("L");
		queue.add("K");
		queue.add("X");
		// call delete
		deleteQueue(queue);

	}

}
