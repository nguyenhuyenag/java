package com.v9.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/*-
 * (1) CompletableFuture<T> orTimeout(long timeout, TimeUnit unit);
 * 
 * 		-> Throw exception nếu process time quá khoảng thời gian chỉ định
 * 
 * (2) CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit);
 * 
 * 		-> Thay vì throw exception sẽ trả về giá trị default value
 */
public class TimeoutExecutor {

	public static void main(String[] args) throws Exception {
		var task = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Finish";
		});

		BiConsumer<String, Throwable> onComplete = (result, error) -> {
			if (error == null) {
				System.out.println("The result is: " + result);
				return;
			}
			System.out.println("Time is over");
		};

		var future = task.orTimeout(3, TimeUnit.SECONDS).whenComplete(onComplete);
		var content = future.get();
		System.out.println("Result: " + content);
	}

}
