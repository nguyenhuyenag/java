package com.create;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingLambda {

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
