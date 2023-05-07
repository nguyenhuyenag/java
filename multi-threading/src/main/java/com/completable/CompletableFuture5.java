package com.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

class MathUtil {
	public static int times(int number, int times) {
		return number * times;
	}

	public static int squared(int number) {
		return number * number;
	}

	public static boolean isEven(int number) {
		return number % 2 == 0;
	}
}

public class CompletableFuture5 {

	public static void thenApply() throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> times2 = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return MathUtil.times(5, 2);
		});

		CompletableFuture<Boolean> greetingFuture = times2.thenApply(n -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return MathUtil.squared(n);
		}).thenApply(n -> { // Chaining multiple callbacks
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return MathUtil.isEven(n);
		});
		// Block and get the result of the future.
		System.out.println(greetingFuture.get()); // true
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		thenApply();
	}

}
