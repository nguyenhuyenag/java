package com.collection.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

/*-
 *  - Deque (double ended queue): Hàng đợi hai đầu
 * 
 *  - Deque có thể sử dụng như Queue (FIFO) hoặc Stack (LIFO)
 *  
 *  - Deque có thể chứa phần tử null. Tuy nhiên, không nên chèn các phần tử null vì nhiều phương
 *    thức trả về null để cho biết Deque là rỗng.
 *    
 *  - Dequeue có thể thêm hoặc xóa các phần tử từ cả hai đầu.
 *  
 *  - Các lớp cài đặt Dequeue là LinkedList và ArrayDeque.
 *  
 *  	+ ArrayDeque nhanh hơn lớp Stack khi được sử dụng như một ngăn xếp (Stack) và nhanh hơn lớp
 *        LinkedList khi được sử dụng như một hàng đợi (Queue).
 *    
 *  	+ Hiệu suất của ArrayDeque đôi khi được coi là tốt nhất trong Collection Framework. Nó cho
 *        phép thực hiện O(1) để chèn, loại bỏ và truy xuất
 * 
 * 		|----------------------|------|-------------------|-----------------------------------------|
 * 		|   Thao tác		   |	  |	Ném ra ngoại lệ	  |	Trả về giá trị cụ thể (null hoặc false) |
 * 		|----------------------|------|-------------------|-----------------------------------------|
 * 		|					   | Đầu  | 	addFirst()	  |	offerFirst()						    |
 * 		|   Thêm			   |------|-------------------|-----------------------------------------|
 * 		|					   | Cuối | 	addLast()	  |	offerLast()							    |
 * 		|----------------------|------|-------------------|-----------------------------------------|		
 *		|				  	   | Đầu  |	getFirst()		  |	peekFirst()							    |
 * 		|   Truy xuất		   |------|-------------------|-----------------------------------------|	
 * 		|					   | Cuối |	getLast()		  |	peekLast()							    |
 * 		|----------------------|------|-------------------|-----------------------------------------|				
 * 		|					   | Đầu  |	removeFirst()	  |	pollFirst()							    |
 * 		|  Truy xuất + xóa bỏ  |------|-------------------|-----------------------------------------|
 *		|					   | Cuối |	removeLast()	  |	pollLast()							    |
 * 		|----------------------|------|-------------------|-----------------------------------------|
 */
public class DequeApi {

	public static void ArrayDequeAsQueue() {
		// Creating an array deque
		Deque<String> arrayDeque = new ArrayDeque<>();
		// Adding elements at the tail of arrayDeque
		arrayDeque.offer("One");
		arrayDeque.offer("Two");
		arrayDeque.offer("Three");
		arrayDeque.offer("Four");
		arrayDeque.offer("Five");

		// Printing the elements of arrayDeque
		System.out.println(arrayDeque); // Output : [One, Two, Three, Four, Five]

		// Removing the elements from the head of arrayDeque
		System.out.println(arrayDeque.poll()); // Output : One
		System.out.println(arrayDeque.poll()); // Output : Two
	}

	public static void ArrayDequeAsStack() {
		// Creating an array deque
		Deque<String> arrayDeque = new ArrayDeque<String>();
		// pushing elements into arrayDeque
		arrayDeque.push("One");
		arrayDeque.push("Two");
		arrayDeque.push("Three");
		arrayDeque.push("Four");
		arrayDeque.push("Five");

		// Printing the elements of arrayDeque
		System.out.println(arrayDeque); // Output : [Five, Four, Three, Two, One]

		// popping up the elements from arrayDeque
		System.out.println(arrayDeque.pop()); // Output : Five
		System.out.println(arrayDeque.pop()); // Output : Four
	}

	/**
	 * Chúng ta cần lưu trữ lịch sử ghé thăm các trang sản phẩm, các URL được truy
	 * cập gần đây được thêm vào phía trước của Deque và URL ở phía sau của Deque sẽ
	 * bị xóa sau một số lần thêm được chỉ định ở phía trước. Tương tự với ứng dụng
	 * Undo, Redo thao tác người dùng.
	 */
	public static void main(String[] args) {
		ArrayDequeAsQueue();
		ArrayDequeAsStack();
	}

}
