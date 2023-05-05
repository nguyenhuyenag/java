package com.basic.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * - newSingleThreadExecutor(): Tạo ra ThreadPool có khả năng thực thi 1 Thread.
 * 
 * - newFixedThreadPool(int nThreads): Tạo ra ThreadPool có thể chứa tối đa
 * nThreads. Khi Pool đạt đến giá trị tối đa nThreads, các Thread còn lại sẽ
 * được đưa vào hàng đợi và chờ đến khi có Thread trong Pool được xử lý xong mới
 * được thực thi tiếp.
 * 
 * - newCachedThreadPool(): Hệ thống sẽ tự quyết định số lượng Thread được thực
 * thi trong Pool và Pool sẽ cache và sử dụng lại cấu trúc của Thread cũ đã xử
 * lý xong để thực thi cho Thread mới. Ngoài ra nếu một Thread trong Pool này
 * không được sử dụng trong vòng 60 giây sẽ bị gỡ ra khỏi cache. Những tính năng
 * này giúp cho Pool được khởi tạo theo kiểu này tận dụng được hiệu năng của hệ
 * thống, đồng thời cũng giúp tránh bị tình trạng nắm giữ resource của hệ thống
 * quá lâu
 */
public class ExecutorsMethod implements Runnable {

	private String name;

	public ExecutorsMethod(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(name + " đang thực thi...");
		try {
			Thread.sleep(1000); // Giả lập thời gian chạy của Runnable mất 1 giây
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(name + " kết thúc.");
	}

	public static void main(String[] args) {
		// singleThreadExecutor();
		fixedThreadExecutor();
		// newCachedThreadPool();
	}

	public static void singleThreadExecutor() {
		// Khai báo ThreadPool thông qua newSingleThreadExecutor()
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		for (int i = 1; i <= 10; i++) {
			ExecutorsMethod myRunnable = new ExecutorsMethod("Runnable " + i);
			executorService.execute(myRunnable);
		}
		executorService.shutdown();
	}

	public static void fixedThreadExecutor() {
		// Pool này cho phép thực thi cùng một lúc 5 Thread
		// Đầu tiên 5 Thread được thực thi. Sau đó hễ Thread nào xong thì Thread khác
		// được start. Đảm bảo luôn luôn không quá 5 Thread được thực thi trong Pool.
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 10; i++) {
			ExecutorsMethod myRunnable = new ExecutorsMethod("Runnable " + i);
			executorService.execute(myRunnable);
		}
		executorService.shutdown();
	}

	public static void newCachedThreadPool() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 1; i <= 10; i++) {
			ExecutorsMethod myRunnable = new ExecutorsMethod("Runnable " + i);
			executorService.execute(myRunnable);
		}
		executorService.shutdown();
	}

}
