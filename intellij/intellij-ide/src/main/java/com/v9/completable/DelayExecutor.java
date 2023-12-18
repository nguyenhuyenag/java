package com.v9.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/*-
 * CompletableFuture đã xuất hiện từ Java 8. Tuy nhiên, Oracle bổ sung thêm 4
 * method trong Java 9 liên quan đến delay và timeout để support cho việc lập
 * trình bất đồng bộ dễ dàng hơn.
 * 
 * Với delay là 2 method:
 * 
 * 	(1)	static Executor delayedExecutor(long delay, TimeUnit unit);
 * 	
 * 		- Trả về executor sẽ thực thi task mà chúng ta submit sau một khoảng thời gian delay.
 * 
 * 	(2)	static Executor delayedExecutor(long delay, TimeUnit unit, Executor executor);
 * 
 * 		- Cần truyền thêm executor và chính executor đó sẽ thực thi task sau delay
 */
public class DelayExecutor {

	public static void main(String[] args) throws InterruptedException {
		var future = new CompletableFuture<>();
		var delayExecutor = CompletableFuture.delayedExecutor(3, TimeUnit.SECONDS);
		future.completeAsync(() -> {
			System.out.println("Processing data");
			return "process success";
		}, delayExecutor).thenAccept(r -> System.out.println("Result: " + r));
		for (int i = 1; i <= 5; i++) {
			Thread.sleep(1000);
			System.out.println("Running outside... " + i + " s");
		}

	}

}
