package com.collection.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/*-
 * - PriorityQueue (hàng đợi ưu tiên): Lưu trữ phần tử theo trật tự nhiên của
 *   nó (implements Comparable) hoặc một bộ so sánh Comparator được cung cấp
 *   cho PriorityQueue.
 * - Phần tử nhỏ nhất/lớn nhất sẽ được đưa lên đầu hàng đợi.
 * - Lấy ra và xóa phần tử đầu tiên (lớn nhất, nhỏ nhất) trong hàng đợi ???
 * - Mặc định capacity = 11.
 */
public class PriorityQueueSample {

	/**
	 * contains():			Kiểm tra hàng đợi có chứa một phần tử nào đó không
	 * remove(E): 			Remove by value
	 * removeAll():			Xóa 1 tập hợp
	 * removeIf(Predicate):	Xóa những phần tử thỏa mãn điều kiện test
	 */
    public static void main(String[] args) throws InterruptedException {
		/*-
		 * - Hàng đợi ưu tiên theo tiêu chí nào đó
		 *
		 * 		Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(...));
		 */
		Queue<Integer> queue = new PriorityQueue<>();
        Collections.addAll(queue, 6, 3, 1, 0, 5, 6);
		queue.remove(6);
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
			TimeUnit.SECONDS.sleep(1);
        }
    }

}
