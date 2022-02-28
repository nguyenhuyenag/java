package com.basic.thread.executors.submit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Invoke {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// invokeAny();
		invokeAll();
	}
	
	public static void invokeAll() throws InterruptedException, ExecutionException {        
	    // Khai báo một Thread Pool thông qua newSingleThreadExecutor() của Executors
	    ExecutorService executorService = Executors.newSingleThreadExecutor();
	    List<Callable<String>> listCallable = new ArrayList<>(); // Khởi tạo danh sách các Callable
	         
	    for (int i = 1; i <= 5; i++) {
	        final int _i = i;
	        // Khởi tạo từng Callable
	        listCallable.add(new Callable<String>() {
	            @Override
	            public String call() throws Exception {
	                return "Callable " + _i; // Trả về kết quả ở mỗi Callable
	            }
	        });
	    }
	         
	    // Dùng Future để lấy về danh sách các kết quả trả về từ mỗi Callable
	    List<Future<String>> futures = executorService.invokeAll(listCallable);
	    for(Future<String> future : futures) {
	        System.out.println("Result: " + future.get());  
	    }
	         
	    executorService.shutdown();
	}

	public static void invokeAny() throws InterruptedException, ExecutionException {
		// Khai báo một Thread Pool thông qua newSingleThreadExecutor() của Executors
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		List<Callable<String>> listCallable = new ArrayList<>(); // Khởi tạo danh sách các Callable

		for (int i = 1; i <= 5; i++) {
			final int j = i;
			// Khởi tạo từng Callable
			listCallable.add(new Callable<String>() {
				@Override
				public String call() throws Exception {
					return "Callable " + j; // Trả về kết quả ở mỗi Callable
				}
			});
		}

		// Callable nào kết thúc ở đây cũng sẽ dừng luôn Thread Pool
		String result = executorService.invokeAny(listCallable);
		System.out.println("Result: " + result);

		executorService.shutdown();
	}

}
