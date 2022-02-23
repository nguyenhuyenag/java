package com.basic.thread.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Các phương thức của ExecutorService
 * 
 * - execute(Runnable): Thêm các Runnable vào Thread Pool và khởi chạy chúng
 * theo kiểu bất đồng bộ. Do đó ta sẽ không biết được khi nào các Runnable kết
 * thúc, và các kết quả mà chúng trả về là gì.
 * 
 * - submit(Runnable) và submit(Callable): Phương thức submit() cho phép truyền
 * vào hoặc là Runnable như cách bạn thực hành với execute() trên kia, hoặc là
 * Callable. Về cơ bản thì Callable cũng như Runnable, chúng cũng có khả năng
 * tạo ra một Thread. Nhưng Callable thì lại cho phép Thread này trả kết quả về
 * một cách đồng bộ, khi mà Runnable lại không làm được điều đó. Một lát nữa bạn
 * sẽ được trải nghiệm sử dụng Callable. Quay lại phương thức submit() khác với
 * execute() như thế nào? Đó kà submit() có trả về kết quả cuối cùng thông qua
 * lớp Future. Future này giúp bạn xác định xem Thread Pool này đã hoàn thành
 * xong hay chưa. Một lát nữa bạn cũng sẽ được trải nghiệm kết quả Future này.
 *
 */
public class ExeService {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		List<Future> listFuture = new ArrayList<>(); // Khởi tạo danh sách các Future
		ExecutorService exe = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 10; i++) {
			RunnableImpl r = new RunnableImpl("Thread " + i);
			Future f = exe.submit(r);
			listFuture.add(f); // Từng Future sẽ quản lý một Runnable
		}

		for (Future f : listFuture) {
			try {
				System.out.println(f.get()); // Khi Thread nào kết thúc, get() của Future tương ứng sẽ trả về null
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		exe.shutdown();
	}

}
