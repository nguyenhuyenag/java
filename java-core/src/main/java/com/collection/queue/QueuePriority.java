package com.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * - PriorityQueue (hàng đợi ưu tiên) lưu trữ phần tử theo trật tự nhiên của nó
 * (kiểu dữ liệu của phần tử implements Comparable) hoặc một bộ so sánh
 * Comparator được cung cấp cho PriorityQueue.
 * 
 * - Mặc định capacity = 11.
 * 
 * - Lấy ra và xóa phần tử đầu tiên (lớn nhất, nhỏ nhất) trong hàng đợi.
 */
public class QueuePriority {

	public static void deleteQueue(Queue<Integer> queue) throws InterruptedException {
		System.out.println("From " + queue + "\n");
		while (queue.size() > 0) {
			int name = queue.poll(); // lấy và loại bỏ phần tử đầu hàng
			System.out.println("Get & remove " + name + " => " + queue + "\n");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println("Done!");
	}

	public static void main(String[] args) throws InterruptedException {
		// String implements Comparable nên Queue tự động sắp xếp theo bảng chữ cái
		// Queue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> queue = new PriorityQueue<>(5);
		// Trả về false nếu hàng đợi không còn chỗ
		queue.offer(3);
		queue.offer(3);
		queue.offer(0);
		queue.offer(-1);
		queue.add(12);
		queue.add(7);
		// Ném ra ngoại lệ (IllegalStateException) nếu hàng đợi không còn chỗ
		queue.add(9);
		queue.add(33);
		queue.add(22);
		queue.add(5);
		queue.add(1);
		// call delete
		deleteQueue(queue);
	}

}
