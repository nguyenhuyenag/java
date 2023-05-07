package com.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFuture1 {

	/**
	 * Chạy bất đồng bộ với runAsync() và không cần kết quả trả về
	 */
	public static void runAsync() throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("Thread: " + Thread.currentThread().getId());
			System.out.println("Code sẽ chạy trong một luồng riêng biệt so với luồng chính");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("Completed");
		});
		System.out.println("It is also running on main thread: " + Thread.currentThread().getId());
		future.get(5, TimeUnit.SECONDS); // Block and wait for the future to complete
		System.out.println("Done!!!");
	}

	/**
	 * Chạy bất đồng bộ với supplyAsync() và cần nhận kết quả trả về
	 */
	public static void supplyAsync() throws InterruptedException, ExecutionException {
		System.out.println("Run a task specified by a Runnable Object asynchronously.");
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("It is runnig in a separate thread than the main thread.");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Completed2022";
		});

		System.out.println("It is also running... ");
		System.out.println("Result: " + future.get()); // Block and wait for the future to complete
		System.out.println("Done!!!");
	}

//	public static String computeSomething1() {
//		try {
//			System.out.println("Computing ... ");
//			Thread.sleep(3000);
//			System.out.println("Compute completed ... ");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return "Future's Result";
//	}
//
//	public static void ex1() throws InterruptedException, ExecutionException {
//		CompletableFuture<String> completableFuture = new CompletableFuture<>();
//
//		System.out.println("Manually complete");
//		completableFuture.complete(computeSomething1());
//
//		System.out.print("Get the result: ");
//		String result = completableFuture.get();
//		System.out.println(result);
//	}

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// ex1();
		// runAsync();
		supplyAsync();
	}

}
