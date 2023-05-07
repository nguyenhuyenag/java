package com.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * - CompletableFuture.supplyAsync: Thực hiện chạy bất đồng bộ (nó sẽ tạo một
 * thread mới và chạy method trong thread đó). Đầu vào của nó sẽ là 1 Supplier
 * và 1 Executor (thread mới sẽ được đưa vào Executor để quản lý).
 * 
 * - CompletableFuture.runAsync: Trường hợp kết quả trả về kiểu void
 *
 */
@SuppressWarnings("unused")
public class Calculator {

	public static int add(int a, int b) {
		int sum = a + b;
		System.out.println(String.format("%d + %d = %d", a, b, sum));
		return sum;
	}

	public static void ex1() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1, 2), executor);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(1, 3), executor);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(2, 3), executor);
		System.out.println("Done");
		executor.shutdown();
	}

	/**
	 * Xử lý kết quả trả về
	 * 
	 * - thenRun: Thực hiện làm gì đó khi CompletableFuture hoàn thành (không cần
	 * quan tâm kết quả trả về).
	 * 
	 * - thenAccept: Xử lý kết quả khi CompletableFuture hoàn thành.
	 * 
	 * - handle: Dùng xử lý kết quả hoặc lỗi khi CompletableFuture hoàn thành.
	 */
	public static void ex2() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1, 2), executor);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(1, 3), executor);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(2, 3), executor);

		System.out.println("Done");
		executor.shutdown();

		future1.thenRun(() -> {
			System.out.println("future1 completed!");
		});

		future2.thenAccept(result -> {
			System.out.println("future2 completed, result = " + result);
		});

		future3.handle((data, error) -> {
			if (error != null) {
				System.out.println("future3 error, error: " + error);
				return null;
			} else {
				System.out.println("future3 completed, result = " + data);
				return data;
			}
		});
	}

	/**
	 * Nếu muốn dùng lại kết quả của CompletableFuture thì ta dùng method thenApply
	 */
	public static void ex3() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> Calculator.add(1, 2), executor);
		future.thenApply(data -> {
			System.out.println("CompletableFuture 1 done, data = " + data);
			return Calculator.add(2, 3); // (1)
		}).thenApply(data -> { 			 // (1) return value
			System.out.println("CompletableFuture 2 done, data = " + data);
			return Calculator.add(3, 4); // CompletableFuture 3
		}).thenAccept(data -> {
			System.out.println("CompletableFuture 3 done, data = " + data);
		}).thenRun(() -> {
			System.out.println("Finished!");
		});
		executor.shutdown();
	}

	/**
	 * CompletableFuture.allOf: Bắt sự kiện tất cả các CompletableFuture hoàn thành
	 * 
	 * CompletableFuture.anyOf: Bắt sự kiện có 1 CompletableFuture hoàn thành
	 */
	public static void ex4() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> Calculator.add(1, 2), executor);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> Calculator.add(2, 3), executor);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> Calculator.add(3, 4), executor);
		CompletableFuture<Void> futureAll = CompletableFuture.allOf(future1, future2, future3);
		futureAll.thenRunAsync(() -> {
			System.out.println("All future is Done!");
		});
		executor.shutdown();
	}

	/**
	 * Với các method thenRunAsync, thenAcceptAsync, runAsync hay supplyAsync nếu ta
	 * không truyền tham số Executor thì nó sẽ mặc định sử dụng pool mặc định là
	 * ForkJoinPool.commonPool() với size là số CPU của máy tính).
	 */
	public static void commonPool() {
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> Calculator.add(1, 2));
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> Calculator.add(1, 3));
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> Calculator.add(2, 3));
		System.out.println("Done");
		while (ForkJoinPool.commonPool().getActiveThreadCount() > 0) {

		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// ex1();
		// ex2();
		ex3();
		// ex4();
		// commonPool();
	}

}
