package com.basic.thread.await;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ea.async.Async;

/**
 * Await 1 CompletableFuture
 */
public class AwaitCompleteFuture {
	
	public static int add(int a, int b) {
		int sum = a + b;
		System.out.println("Result: " + a + " + " + b + " = " + sum);
		return sum;
	}

	/**
	 * Mỗi lần chạy, thứ tự các dòng in ra sẽ khác nhau do chúng chạy trên các
	 * thread khác nhau.
	 */
	@SuppressWarnings("unused")
	public static void withoutAsync() {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1, 2), executor);
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(2, 3), executor);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(3, 4), executor);
		System.out.println("Done");
		executor.shutdown();
	}

	public static void withAsync() {
		Async.init(); // enable async/await, chỉ cần gọi hàm này 1 lần duy nhất trong project
		ExecutorService executor = Executors.newFixedThreadPool(10);
		CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> add(1, 2), executor);
		Async.await(future1); // Chờ CompletableFuture thực hiện xong mới chạy tới dòng code tiếp theo
		CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> add(2, 3), executor);
		Async.await(future2);
		CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> add(3, 4), executor);
		Async.await(future3);
		System.out.println("Done");
		executor.shutdown();
	}

	public static void main(String[] args) {
		// withoutAsync();
		withAsync();
	}

}