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
 * theo kiểu bất đồng bộ. Do đó không biết được khi nào các Runnable kết thúc.
 * 
 * - submit(Callable): Tương tự execute() nhưng có trả về kết quả thông qua
 * Future và giúp kiểm tra. Phương thực future.get() được thực thi đồng bộ
 * (asynchronous - tức là sau khi callable hoàn thành nhiệm vụ kết quả được trả
 * về nó mới được thực thi).
 * 
 * - submit(Runnable): Tương tự submit(Callable) nhưng trả kết quả về một cách
 * đồng bộ. Tức là khi Thread kết thúc thì null mới được trả về thông qua
 * future.get(), nên dù được gọi rất sớm, nhưng chúng chỉ in ra null khi nào
 * Thread kết thúc.
 * 
 * - invokeAny(Runnable): Tương tự execute() hay submit() nhưng cho phép ta thể
 * truyền vào chúng danh sách các Callable. Nếu có bất kỳ Callable nào hoàn
 * thành trong danh sách các Callable truyền vào thì Thread Pool sẽ chấm dứt các
 * Thread còn lại, dù cho chúng đã được đưa vào Pool và đang chờ thực thi.
 * 
 * - invokeAll(Runnable): Thực thi tất cả các Callable và chờ nhận các kết quả
 * trả về của các Callable này thông qua danh sách các đối tượng Future.
 * 
 * - shutdown() và shutdownNow(): ExecutorService (ES) không tự động kết thúc
 * khi chúng thực thi hết các Thread nên khiến ứng dụng vẫn chạy mặc dù các
 * Thread trong Thread Pool đã hoàn thành. Lệnh shutdown() giúp đóng Thread Pool
 * lại, Thread Pool lúc này sẽ từ chối nhận thêm task nữa và giúp ES kết thúc
 * sau khi nó hoàn thành nhiệm vụ. Tương tự, shutdownNow() cũng có công năng như
 * vậy, chỉ khác phương thức này buộc ES kết thúc ngay khi được gọi, lúc này đây
 * các Thread chưa được thực thi sẽ bị buộc phải kết thúc theo ES.
 */
public class MethodExecutorService {

	public static void main(String[] args) {
		// execute();
		submitRunnable();
	}

	public static void execute() {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 10; i++) {
			RunnableImpl r = new RunnableImpl("Thread " + i);
			executorService.execute(r);
		}
		executorService.shutdown();
	}

	@SuppressWarnings("rawtypes")
	public static void submitRunnable() {
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