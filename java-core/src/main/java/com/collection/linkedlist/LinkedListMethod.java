package com.collection.linkedlist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Những điểm cần ghi nhớ về LinkedList:
 * 
 * - Duy trì thứ tự của phần tử được thêm vào.
 * 
 * - Không đồng bộ (non-synchronized).
 * 
 * - LinkedList có thể được sử dụng như danh sách (list), stack (ngăn xếp) hoặc
 * queue (hàng đợi).
 * 
 * - Các phần tử trong LinkedList có thể không nằm liên tục nhau trong bộ nhớ.
 * Nó là một liên kết có tính 2 chiều. Mỗi phần tử trong danh sách giữ một
 * tham chiếu đến phần tử đằng trước nó và tham chiếu đến phần tử ngay sau nó.
 */
@SuppressWarnings("unused")
public class LinkedListMethod {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

		list.add(3); // append
		list.add(0, -1); // Inserts the specified element at the specified position in this list
		list.addFirst(7);
		list.addLast(10);

		list.addAll(Arrays.asList(-1, -2));
		list.addAll(2, Arrays.asList(-1, -2));

		list.get(5);
		list.getFirst();
		list.getLast();

		list.set(0, -99); // replace

		list.indexOf(3);
		list.lastIndexOf(3);

		list.peek(); // Retrieves but does't remove the first element of this list
		list.peekFirst();
		list.peekLast();

		list.poll(); // Retrieves and removes the head element
		list.pollFirst();
		list.pollLast();

		list.push(9);
		list.pop();

		list.removeFirstOccurrence(3); // xóa số 3 đầu tiên
		list.removeLastOccurrence(3); // Xóa số 3 cuối cùng

		list.remove(3); // nếu có phần tử giống nhau thì sẽ có phần tử đầu tiên

		list.offer(6); // Adds the specified element as the tail (last element) of this list
		list.offerFirst(77);
		list.offerLast(88);

		list.removeFirst();
		list.removeLast();

		Iterator<Integer> itr = list.iterator();
		Iterator<Integer> descItr = list.descendingIterator();

		list.clear();
	}

}
