package com.executors.submit;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmitCallable<V> implements Callable<String> {

	private String threadname;

	public SubmitCallable(String name) {
		this.threadname = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println(threadname + " đang chạy...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return threadname;
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		List<Future<String>> listFuture = new ArrayList<Future<String>>();

		for (int i = 1; i <= 10; i++) {
			SubmitCallable<String> myCallable = new SubmitCallable<>("Callable " + i);
			Future<String> future = executorService.submit(myCallable);
			listFuture.add(future); // Từng Future sẽ quản lý một Callable
		}

		for (Future future : listFuture) {
			try {
				// Khi thread nào đó kết thúc, hàm get() tương ứng sẽ trả về kết quả của call()
				System.out.println(future.get() + " kết thúc");
			} catch (ExecutionException | InterruptedException e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();
	}

}
