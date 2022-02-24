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
 * - submit(Callable): Tương tự execute() nhưng có trả về kết quả thông qua
 * Future.
 * 
 * - submit(Runnable): Cho phép Thread này trả kết quả về một cách đồng bộ. Tức
 * là khi Thread kết thúc thì null mới được trả về thông qua future.get(), nên
 * dù được gọi rất sớm, nhưng chúng chỉ in ra null khi nào Thread kết thúc.
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
