package com.basic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WithLambda {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		String message = "Hello from my parameterized lambda Runnable!";
		Runnable task = () -> {
			System.out.println(message);
		};
		executor.execute(task);
		executor.shutdown();
	}

}
