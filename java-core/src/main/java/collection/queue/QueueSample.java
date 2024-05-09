package collection.queue;

/*-
 * - Queue (hàng đợi): Hoạt động theo cơ chế FIFO (firt in first out)
 * 
 * 		+ Cho phép chứa phần tử giống nhau.
 * 		+ Không chứa phần tử null.
 * 		+ Chỉ có thể truy cập phần tử ở đầu hàng.
 * 		+ Vị trí phần từ được chèn phụ thuộc vào loại hàng đợi và độ ưu tiên của phần tử đó.
 *  	+ Có 2 class cài đặt interface Queue là PriorityQueue (hàng đợi ưu tiên) và LinkedList (hàng đợi 2 đầu)
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
public class QueueSample { }
